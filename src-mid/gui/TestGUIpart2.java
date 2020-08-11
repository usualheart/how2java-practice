package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
//GUI �����С�ɵ��ڡ���ʾ����JLabel��ģ̬�Ի���4�ֲ��������ԣ�null,FlowLayout��BorderLayout��GridLayout()
public class TestGUIpart2 {
	public static void testsetResizable() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
        JButton b = new JButton("һ����Է����ع�");
        b.setBounds(50, 50, 280, 30);
 
        f.add(b);
        // �����С���ɱ仯
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	public static void qiehuanXianshi() {
		JFrame j=new JFrame("�л���ʾ����");
		j.setBounds(200, 200, 400, 400);
		j.setLayout(null);
		final JLabel l=new JLabel();
		ImageIcon i=new ImageIcon("D:/java-test/Swing/shana.png");
		l.setIcon(i);
		l.setBounds(140,50,i.getIconWidth(), i.getIconHeight());
		j.add(l);
		
		JButton b=new JButton();
		b.setText("����ͼƬ");
		b.setBounds(50, 200, 300, 40);
		j.add(b);
		MouseListener ml=new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO �Զ����ɵķ������
				String str=b.getText();
				
				if(str.equals("����ͼƬ")) {
					b.setText("��ʾͼƬ");
					l.setVisible(false);
				}
				else {
					b.setText("����ͼƬ");
					l.setVisible(true);
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
		};
		b.addMouseListener(ml);
		
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
	}
	
	//��ϰ��ģ̬���С�仯����ð�ť���漴��һ��ģ̬���ڡ�

//�����ģ̬��������һ����ť���ı��� "������С", ��������ģ̬���ڵĴ�С�ͱ�����ס�����ܸı䡣 �ٴε�����ͻظ��ܹ��ı��
	public static void modalSize() {
		JFrame f = new JFrame("LoL");
        f.setSize(600, 500);
        f.setLocation(200, 200);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        JButton fb=new JButton();
        fb.setText("��һ��ģ̬����");
        fb.setBounds(50, 50, 500, 40);
        f.add(fb);
        
        JDialog d=new JDialog(f);
        d.setTitle("ģ̬�Ի���");
        d.setBounds(560, 380, 400, 300);
        d.setLayout(null);
        d.setModal(true);
        d.setResizable(false);
        JButton db=new JButton();
        db.setText("������С");
        db.setBounds(80, 100, 200, 80);
        d.add(db);
        fb.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		
                d.setVisible(true);
                
        	}
        });
        db.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
             
        		d.setResizable(true);
        	}
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        
	}
	
	//����������
	//���Զ�λ����ָ��ʹ�ò������������λ�úʹ�С��Ҫ����ָ��
	public static void testsetLayout() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // ���ò�����Ϊnull�������о��Զ�λ�������ϵ��������Ҫָ��λ�úʹ�С
        f.setLayout(null);
        JButton b1 = new JButton("Ӣ��1");
        // ָ��λ�úʹ�С
        b1.setBounds(50, 50, 80, 30);
        JButton b2 = new JButton("Ӣ��2");
        b2.setBounds(150, 50, 80, 30);
        JButton b3 = new JButton("Ӣ��3");
        b3.setBounds(250, 50, 80, 30);
        // û��ָ��λ�úʹ�С�����������������
        JButton b4 = new JButton("Ӣ��3");
 
        f.add(b1);
        f.add(b2);
        f.add(b3);
        // b4û��ָ��λ�úʹ�С�����������������
        f.add(b4);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	
	//���ò�����ΪFlowLayout,˳�򲼾���,�����ϵ����ˮƽ�ڷ�
	//���뵽�������ɣ����赥��ָ����С��λ��
	public static void testFlowLayout() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // ���ò�����ΪFlowLayerout
        // �����ϵ����ˮƽ�ڷ�
        f.setLayout(new FlowLayout());
 
        JButton b1 = new JButton("Ӣ��1");
        JButton b2 = new JButton("Ӣ��2");
        JButton b3 = new JButton("Ӣ��3");
 
        // ���뵽�������ɣ����赥��ָ����С��λ��
        f.add(b1);
        f.add(b2);
        f.add(b3);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	
	//���ò�����ΪBorderLayout
	//�����ϵ���������ϱ� ���� ���� �Ҷ� �е�˳��ڷ�
	public static void testBorderLayout() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // ���ò�����ΪBorderLayerout
        // �����ϵ���������ϱ����������Ҷ��е�˳��ڷ�
        f.setLayout(new BorderLayout());
 
        JButton b1 = new JButton("����");
        JButton b2 = new JButton("������");
        JButton b3 = new JButton("ŷ����");
        JButton b4 = new JButton("��ҩʦ");
        JButton b5 = new JButton("�ܲ�ͨ");
 
        // ���뵽������ʱ����Ҫָ��λ��
        f.add(b1, BorderLayout.NORTH);
        f.add(b2, BorderLayout.SOUTH);
        f.add(b3, BorderLayout.WEST);
        f.add(b4, BorderLayout.EAST);
        f.add(b5, BorderLayout.CENTER);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	
	//GridLayout�������񲼾���
	public static void testGridLayout() {
		
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // ���ò�����ΪGridLayerout�������񲼾���
        // ��GridLayerout�Ĺ��췽����ʾ��������2��3��
        f.setLayout(new GridLayout(2, 3));
 
        JButton b1 = new JButton("����");
        JButton b2 = new JButton("������");
        JButton b3 = new JButton("ŷ����");
        JButton b4 = new JButton("��ҩʦ");
        JButton b5 = new JButton("�ܲ�ͨ");
 
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	
	//���� ʹ�� ������ ��Ҳ���� ͨ��setPreferredSize���򲼾�������������ʾ�Ĵ�С.
	//ע ֻ�Բ��ֲ����������ã�����FlowLayout���������á� ����GridLayout�Ͳ������ã���Ϊ���񲼾����������
	
	public static void testsetPreferredSize() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());
 
        JButton b1 = new JButton("Ӣ��1");
        JButton b2 = new JButton("Ӣ��2");
        JButton b3 = new JButton("Ӣ��3");
 
        // ���� ʹ�� ������ ��Ҳ���� ͨ��setPreferredSize���򲼾�������������ʾ�Ĵ�С
        b3.setPreferredSize(new Dimension(180, 40));
 
        f.add(b1);
        f.add(b2);
        f.add(b3);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//testsetResizable();
		//qiehuanXianshi();
		//modalSize();
		
		//����������
		//testsetLayout();
		//testFlowLayout();
		//testBorderLayout();
		//testGridLayout();
		testsetPreferredSize();
	}

}
