package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UnsupportedLookAndFeelException;

import io.CopyFindFile;
public class ThreadInSwing {
    public static void main(String[] args) {
        //�൱�������߳���ִ�д�������ʾ����Ĺ��� ������ϸ���ʱ ���ܻ�������� ��Ϊ��ʱ 1. ���߳� 2. �¼������̡߳�ͬʱ�ڷ������ ��������ͬ������
    	//new TestFrame().setVisible(true);
      
       /*
      //��������ʾ����Ĺ��������Ҳ�����¼������̣߳������ͱ�֤��ֻ��һ���߳��ڷ�����Щ���
      SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              new TestFrame().setVisible(true);
          }
      });*/
      //testLongTimeTask();//����ʱ����Ĵ���Ĳ���
      testFindjava();
    }
    
    //�ж��Ƿ����¼������̵߳Ĳ���
    static class TestFrame extends JFrame {
        public TestFrame() {
            setTitle("LoL");
 
            setSize(400, 300);
 
            setLocation(200, 200);
 
            setLayout(null);
 
            JButton b = new JButton("һ����Է����ع�");
 
            b.setBounds(50, 50, 280, 30);
 
            add(b);
 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
            setVisible(true);
             
            System.out.println("��ǰ�߳��Ƿ��� �¼������߳�: " + SwingUtilities.isEventDispatchThread());
 
        }
    }
    //����ʱ����Ĵ���SwingWorker�� doInBackground���� execute��������
    public static void testLongTimeTask() {
    	 
        JFrame f = new JFrame("LoL");
        f.setSize(300, 300);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());
 
        JButton b1 = new JButton("���¼������߳���ִ�г���ʱ����");
        JButton b2 = new JButton("ʹ��SwingWorkerִ�г���ʱ����");
        JLabel l = new JLabel("����ִ�н��");
        f.add(b1);
        f.add(b2);
        f.add(l);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        b1.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setText("��ʼִ�����");
                try {
                    Thread.sleep(5000);//���¼������߳���ִ�г���ʱ���� ���ý�����һ��ʱ��������Ӧ
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                l.setText("����ִ�����");
            }
        });
        //��ť2 ʹ��SwingWorker��Գ���ʱ�������ר�ŵĴ���
        b2.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
 
                    @Override
                    protected Void doInBackground() throws Exception {
                        System.out.println("ִ�����SwingWorder���߳��ǣ�" + Thread.currentThread().getName());
                        l.setText("��ʼִ�����");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        l.setText("����ִ�����");
                        return null;
                    }
                };
                worker.execute();
 
            }
        });
 
        f.setVisible(true);
    }
    
    //����ʱ��������ϰ �����ļ�����
    public static void testFindjava() {
    	
    	JFrame f = new JFrame("LoL");
        f.setSize(300, 300);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());
        
        JLabel l1 = new JLabel("�ļ��У�");
        JTextField tf1 = new JTextField();
        tf1.setPreferredSize(new Dimension(200,30));
        JLabel l2 = new JLabel("�ַ�����");
        JTextField tf2 = new JTextField();
        tf2.setPreferredSize(new Dimension(200,30));
        JButton b = new JButton("��ʼ����");
        JLabel lshow = new JLabel("׼������");
        lshow.setVerticalTextPosition(SwingConstants.CENTER);
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        p.add(b,BorderLayout.NORTH);
        p.add(lshow,BorderLayout.SOUTH);
        b.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		//����ʱ���� ʹ��ר�ŵ�SwingWorker����д���
        		SwingWorker<Void , Void> sw=new SwingWorker<Void ,Void>() {

					@Override
					protected Void doInBackground() throws Exception {
						// TODO �Զ����ɵķ������
						lshow.setText("��������...");
		        		File file=new File(tf1.getText());
		        		CopyFindFile.searchMultiplethead(file, tf2.getText());
						lshow.setText("������ɣ�");
						//lshow.setText("׼������");
		        		return null;
					}
        			
        		};
        		sw.execute();
        	}
        });
        
        f.add(l1);
        f.add(tf1);
        f.add(l2);
        f.add(tf2);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
