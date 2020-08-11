package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class TestGUI {
	//����JFrame����
    public static void testJFrame() {
        // ������
        JFrame f = new JFrame("LoL");
 
        // ���������ô�С
        f.setSize(400, 300);
 
        // ����������λ��
        f.setLocation(200, 200);
 
        // �������е��������Ϊ���Զ�λ
        f.setLayout(null);
 
        // ��ť���
        JButton b = new JButton("һ����Է����ع�");
 
        // ͬʱ��������Ĵ�С��λ��
        b.setBounds(50, 50, 280, 30);
 
        // �Ѱ�ť���뵽��������
        f.add(b);
 
        // �رմ����ʱ���˳�����
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // �ô����ÿɼ�
        f.setVisible(true);
 
    }
    //������JDialog����
    public static void testJDialog() {
        
        //��ͨ�Ĵ��壬��������С����ť�����Ի���ȴ����
        JDialog d = new JDialog();
        d.setTitle("LOL");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("һ����Է����ع�");
        b.setBounds(50, 50, 280, 30);
 
        d.add(b);
 
        d.setVisible(true);
    }
    
    //ģ̬JDialog  ��һ���Ի�������Ϊģ̬��ʱ���䱳��ĸ����壬�ǲ��ܱ�����ģ����ǸöԻ��򱻹ر�
    public static void testModalJDialog() {
        JFrame f = new JFrame("�ⲿ����");
        f.setSize(800, 600);
        f.setLocation(100, 100);
 
        // �����ⲿ����ʵ����JDialog
        JDialog d = new JDialog(f);
        // ����Ϊģ̬
        d.setModal(true);
 
        d.setTitle("ģ̬�ĶԻ���");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("һ����Է����ع�");
        b.setBounds(50, 50, 280, 30);
        d.add(b);
 
        f.setVisible(true);
        d.setVisible(true);
 
    }
    
    //���̼߳�¼�����ϴιرյ�λ��
	public static void lastWeizhi() {
		File file=new File("D:\\java-test\\gui.txt");
		JFrame f=new JFrame("�ϴ�λ�ò���");
		f.setSize(500,500);
		if(file.length()==0) {
			f.setLocation(400, 400);
		}else {
			try(FileInputStream fis=new FileInputStream(file);
					DataInputStream dis=new DataInputStream(fis);){
				int x=dis.readInt();
				int y=dis.readInt();
				f.setLocation(x, y);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		f.setLayout(null);
		// �رմ����ʱ���˳�����
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // �ô����ÿɼ�
        f.setVisible(true);
		
		//���߳� ʱ�̼�¼λ��
		new Thread() {
			public void run() {
				while(true) {
				//ÿ100ms��¼һ��λ��
					try {
						Thread.sleep(100);
						int x=f.getX();
						int y=f.getY();
						//������������� д���ļ�
						FileOutputStream fos=new FileOutputStream(file);
						DataOutputStream dos=new DataOutputStream(fos);
						dos.writeInt(x);
						dos.writeInt(y);
						dos.close();
						fos.close();
					} catch (InterruptedException | IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
    
	//ActionListener��������
    public static void testActionListener() {
    	  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);
  
        final JLabel l = new JLabel();
  
        ImageIcon i = new ImageIcon("D:\\java-test\\Swing\\shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
  
        JButton b = new JButton("����ͼƬ");
        b.setBounds(150, 200, 100, 30);
  
        // ����ť ���� ����
        b.addActionListener(new ActionListener() {
  
            // ����ť�����ʱ���ͻᴥ�� ActionEvent�¼�
            // actionPerformed �����ͻᱻִ��
            public void actionPerformed(ActionEvent e) {
                l.setVisible(false);
            }
        });
  
        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    //KeyListener����
    public static void testKeyListener() {
    	  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);
  
        final JLabel l = new JLabel();
  
        ImageIcon i = new ImageIcon("D:\\java-test\\Swing\\shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
  
        // ���Ӽ��̼���
        f.addKeyListener(new KeyListener() {
  
            // ��������
            public void keyReleased(KeyEvent e) {
  
                // 37�������� �������
                if (e.getKeyCode() == 37) {
                    // ͼƬ�����ƶ� ��y���겻�䣬x������٣�
                    l.setLocation(l.getX() - 10, l.getY());
                }
             // 38�������� ���ϼ���
                if (e.getKeyCode() == 38) {
                    // ͼƬ�����ƶ� ��x���겻�䣬y������٣�
                    l.setLocation(l.getX(), l.getY()-10);
                }
             // 39�������� ���Ҽ���
                if (e.getKeyCode() == 39) {
                    // ͼƬ�����ƶ� ��y���겻�䣬x�������ӣ�
                    l.setLocation(l.getX() + 10, l.getY());
                }
             // 40�������� ���¼���
                if (e.getKeyCode() == 40) {
                    // ͼƬ�����ƶ� ��x���겻�䣬y�������ӣ�
                    l.setLocation(l.getX(), l.getY() + 10);
                }
            }
  
            //��������
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
            	   // 37�������� �������
                if (e.getKeyCode() == 37) {
                    // ͼƬ�����ƶ� ��y���겻�䣬x������٣�
                    l.setLocation(l.getX() - 10, l.getY());
                }
             // 38�������� ���ϼ���
                if (e.getKeyCode() == 38) {
                    // ͼƬ�����ƶ� ��x���겻�䣬y������٣�
                    l.setLocation(l.getX(), l.getY()-10);
                }
             // 39�������� ���Ҽ���
                if (e.getKeyCode() == 39) {
                    // ͼƬ�����ƶ� ��y���겻�䣬x�������ӣ�
                    l.setLocation(l.getX() + 10, l.getY());
                }
             // 40�������� ���¼���
                if (e.getKeyCode() == 40) {
                    // ͼƬ�����ƶ� ��x���겻�䣬y�������ӣ�
                    l.setLocation(l.getX(), l.getY() + 10);
                }
            }
  
            // һ�����µ������϶���
            public void keyTyped(KeyEvent e) {
            	
            }
        });
  
        f.add(l);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
    
    //MouseActionListener
    public static void testMouseListener() {
    	  
        final JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
  
        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("D:\\java-test\\Swing\\shana_heiheihei.png");
        l.setIcon(i);
        l.setBounds(375, 275, i.getIconWidth(), i.getIconHeight());
  
        f.add(l);
  
        l.addMouseListener(new MouseListener() {
  
            // �ͷ����
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
  
            }
  
            // �������
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
  
            }
  
            // ����˳�
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
  
            }
  
            // ������
            public void mouseEntered(MouseEvent e) {
  
                Random r = new Random();
                int x = r.nextInt(f.getWidth() - l.getWidth());
                int y = r.nextInt(f.getHeight() - l.getHeight());
                l.setLocation(x, y);
  
            }
  
            // �����ͷ���϶���Ϊ������
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
  
            }
        });
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
    
    //MouseAdapter����
    public static void MouseAdapter() {
    	  
        final JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
  
        final JLabel l = new JLabel("");

        ImageIcon i = new ImageIcon("D:\\java-test\\Swing\\shana_heiheihei.png");
        l.setIcon(i);
        l.setBounds(375, 275, i.getIconWidth(), i.getIconHeight());
  
        f.add(l);
  
        // MouseAdapter ��������ֻ��Ҫ��д�õ��ķ�����û���õ��ľͲ���д��
        l.addMouseListener(new MouseAdapter() {
  
            // ֻ��mouseEntered�õ���
            public void mouseEntered(MouseEvent e) {
  
                Random r = new Random();
  
                int x = r.nextInt(f.getWidth() - l.getWidth());
                int y = r.nextInt(f.getHeight() - l.getHeight());
  
                l.setLocation(x, y);
  
            }
        });
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
    public static void main(String[] args) {
    	//testJDialog();
    	testModalJDialog();//ģ̬JDialog
    	//lastWeizhi();//��¼�ϴδ��ڹر�λ�õĲ���
    	//testActionListener();
    	//testKeyListener();
    	//testMouseListener();
    	//MouseAdapter();
    	
    }
    
}