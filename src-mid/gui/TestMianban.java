package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestMianban {
 //һ���ƶ�һ����壬�������������ͻ�ȫ��ͳһ�����ƶ����������ַ�ʽ�����ڽ��������������
 public static void testJPannel() {
	 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
 
        
        JPanel p1 = new JPanel();
        // ��������С
        p1.setBounds(50, 50, 300, 60);
        // ������屳����ɫ
        p1.setBackground(Color.RED);
        // ��һ�����û�У���ΪJPanelĬ�Ͼ��ǲ��õ�FlowLayout
        p1.setLayout(new FlowLayout());
        
        JButton b1 = new JButton("Ӣ��1");
        JButton b2 = new JButton("Ӣ��2");
        JButton b3 = new JButton("Ӣ��3");
        // �Ѱ�ť�������
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
 
        JPanel p2 = new JPanel();
        JButton b4 = new JButton("Ӣ��4");
        JButton b5 = new JButton("Ӣ��5");
        JButton b6 = new JButton("Ӣ��6");
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.setBackground(Color.BLUE);
        p2.setBounds(40, 150, 300, 60);
 
        // �������봰��
        f.add(p1);
        f.add(p2);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
 
 	public static void testContentPane() {
		 
	     JFrame f = new JFrame("LoL");
	     f.setSize(400, 300);
	     f.setLocation(200, 200);
	     f.setLayout(null);
	     JButton b = new JButton("һ����Է����ع�");
	     b.setBounds(50, 50, 280, 30);
	
	     //f.add(b);
	     // JFrame����һ����壬����ContentPane
	     // ƽʱͨ��f.add()��JFrame�����������ʵ����JFrame�ϵ� ContentPane�Ӷ���
	     // f.add��ͬ��f.getContentPane().add(b);
	     f.getContentPane().add(b);
	
	     // b.getParent()��ȡ��ťb�����ڵ�����
	     // ��ӡ�������Կ�����ʵ������ContentPane����JFrame
	     System.out.println(b.getParent());
	
	     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	     f.setVisible(true);
	 }
 	//����һ��ˮƽJSplitPane�������pLeft,�ұ���pRight
 	public static void testJSplitPane() {
 		  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
  
        JPanel pLeft = new JPanel();
        pLeft.setBounds(50, 50, 300, 60);
        pLeft.setBackground(Color.RED);
        pLeft.setLayout(new FlowLayout());//JPanmelĬ�Ͼ���FlowLayout
        JButton b1 = new JButton("����");
        JButton b2 = new JButton("��Ī");
        JButton b3 = new JButton("����");
        pLeft.add(b1);
        pLeft.add(b2);
        pLeft.add(b3);
  
        JPanel pRight = new JPanel();
        JButton b4 = new JButton("Ӣ��4");
        JButton b5 = new JButton("Ӣ��5");
        JButton b6 = new JButton("Ӣ��6");
        pRight.add(b4);
        pRight.add(b5);
        pRight.add(b6);
        pRight.setBackground(Color.BLUE);
        pRight.setBounds(10, 150, 300, 60);
  
        // ����һ��ˮƽJSplitPane�������p1,�ұ���p2
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pLeft, pRight);
        // ���÷ָ�����λ��
        sp.setDividerLocation(180);
        
        // ��sp����ContentPane
        f.setContentPane(sp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
 	/*
 	 * ʹ�ô�����������������ַ�ʽ
	1. �ڴ���JScrollPane���������Ϊ��������ȥ
	JScrollPane sp = new JScrollPane(ta);
	2. ϣ�����������������ʾ���������ʱ�򣬵���setViewportView
	sp.setViewportView(ta);
 	 */
 	public static void testJScrollPane() {
 		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
        
        //׼��һ���ı���������źܶ�����
        JTextArea ta = new JTextArea();
        for (int i = 0; i < 1000; i++) {
            ta.append(String.valueOf(i));
        }
        //�Զ�����
        ta.setLineWrap(true);
        
        //JScrollPane sp = new JScrollPane(ta);//��������ķ�ʽ
        JScrollPane sp = new JScrollPane();//��ʽ2
        sp.setViewportView(ta);
        
        f.setContentPane(sp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
 	
 	//TabbedPanel
 	public static void testTabbedPanel() {
 		  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
  
        JPanel p1 = new JPanel();
        p1.setBounds(50, 50, 300, 60);
        p1.setBackground(Color.RED);
        p1.setLayout(new FlowLayout());
        JButton b1 = new JButton("Ӣ��1");
        JButton b2 = new JButton("Ӣ��2");
        JButton b3 = new JButton("Ӣ��3");
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        JPanel p2 = new JPanel();
        JButton b4 = new JButton("Ӣ��4");
        JButton b5 = new JButton("Ӣ��5");
        JButton b6 = new JButton("Ӣ��6");
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.setBackground(Color.BLUE);
        p2.setBounds(10, 150, 300, 60);
      
        JTabbedPane tp = new JTabbedPane();
        tp.add(p1);
        tp.add(p2);
        // ����tab�ı���
        tp.setTitleAt(0, "��ɫtab");
        tp.setTitleAt(1, "��ɫtab");
        //����tab�ϱߵ�ͼƬ
        ImageIcon i = new ImageIcon("D:\\java-test\\Swing\\shana.png");
        tp.setIconAt(0,i );
        tp.setIconAt(1,i );
        
        f.setContentPane(tp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
 	//CardLayerout ������ ����TabbedPanel ���ڱ�������������һ��������������һ��CardLayerout ��JPanel
 	//���JPanel����������壬����ͨ��CardLayerout������л�
 	public static void testCardLayerout() {
        JFrame f = new JFrame("CardLayerout");
        
        //�������
        JPanel comboBoxPane = new JPanel();
        //������
        String buttonPanel = "��ť���";
        String inputPanel = "��������";
        String comboBoxItems[] = { buttonPanel, inputPanel };
        JComboBox<String> cb = new JComboBox<>(comboBoxItems);
        comboBoxPane.add(cb);
 
        // ����Panel�䵱��Ƭ
        JPanel card1 = new JPanel();
        card1.add(new JButton("��ť 1"));
        card1.add(new JButton("��ť 2"));
        card1.add(new JButton("��ť 3"));
        JPanel card2 = new JPanel();
        card2.add(new JTextField("�����", 20));
        
        JPanel cards; // a panel that uses CardLayout
        cards = new JPanel(new CardLayout());
        cards.add(card1, buttonPanel);
        cards.add(card2, inputPanel);
 
        f.add(comboBoxPane, BorderLayout.NORTH);
        f.add(cards, BorderLayout.CENTER);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 150);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
 
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards,(String) evt.getItem() );//s
            }
        });    
    }
 	
 	//��ϰsplitPanel
 	public static void lianxiSplitPanel() {
 		JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
  
        JPanel pLeft = new JPanel();
        pLeft.setBounds(50, 50, 300, 60);
        //pLeft.setBackground(Color.RED);
        pLeft.setLayout(new FlowLayout());//JPanmelĬ�Ͼ���FlowLayout
        JButton b1 = new JButton("����");
        JButton b2 = new JButton("��Ī");
        JButton b3 = new JButton("����");
        pLeft.add(b1);
        pLeft.add(b2);
        pLeft.add(b3);
  
        JPanel pRight = new JPanel();
        JLabel lico=new JLabel();
        String heroname="gareen";
        ImageIcon hero=new ImageIcon("D:\\java-test\\Swing\\pics\\"+heroname+".jpg");
        lico.setIcon(hero);
        pRight.add(lico);
       // pRight.setBackground(Color.BLUE);
        pRight.setBounds(10, 150, 300, 60);
        
        
        // ����һ��ˮƽJSplitPane�������p1,�ұ���p2
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pLeft, pRight);
        // ���÷ָ�����λ��
        sp.setDividerLocation(80);
        
        // ��sp����ContentPane
        f.setContentPane(sp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        //��ʾ����ͼƬ
        b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String heroname="gareen";
		        ImageIcon hero=new ImageIcon("D:\\java-test\\Swing\\pics\\"+heroname+".jpg");
		        lico.setIcon(hero);
			}
        	
        });
        //��ʾ��ĪͼƬ
        b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String heroname="teemo";
		        ImageIcon hero=new ImageIcon("D:\\java-test\\Swing\\pics\\"+heroname+".jpg");
		        lico.setIcon(hero);
			}
        	
        });
        //��ʾ����ͼƬ
        b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String heroname="annie";
		        ImageIcon hero=new ImageIcon("D:\\java-test\\Swing\\pics\\"+heroname+".jpg");
		        lico.setIcon(hero);
			}
        	
        });
       
 	}
 	
 	//����eclipse�ķ����ʾ���java�ļ�
 	public static void likeEclipseShowJava() {
 		JFrame f = new JFrame("LoL");
        f.setSize(800, 700);
        f.setLocation(300, 100);
        f.setLayout(null);
  
        
        
        //��ȡ�ļ���·��
        File filedir=new File("D:\\java-test\\JAVA-CODE\\jichu-lianxi\\src-jichu\\property");
        File []fs=filedir.listFiles();
        
        JTabbedPane tp = new JTabbedPane();
        for(int i=0;i<fs.length;i++) {
        	
        
	        JTextArea javaFile=new JTextArea();
	       // javaFile.setPreferredSize(new Dimension(770,1000));����ƫ�ô�С��Ӱ��������
	        
	        
	        //��ȡ�ļ�����
	        String str = null;
	        try {
	        	char[] cbuf=new char[(int) fs[i].length()];
	        	FileReader fr=new FileReader(fs[i]);
	        	fr.read(cbuf);
	        	str=String.valueOf(cbuf);
			} catch ( IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
	        
	        //��ʾ�ļ�����
	        javaFile.setText(str);
	        
	        javaFile.setLineWrap(true);

	        //���ı������ӹ����� 
	        JScrollPane sp = new JScrollPane(javaFile);
	        //sp.setViewportView(javaFile);
	        
	        //����������tab���
	        tp.add(sp);
	        // ����tab�ı���
	        tp.setTitleAt(i, fs[i].getName());
	        
	        //JScrollPane spfortp = new JScrollPane(tp);
	        f.setContentPane(tp);
        }
      
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
 	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//testJPannel();
		//testContentPane();
		//testJSplitPane();
		//testJScrollPane();
		//testTabbedPanel();
		//testCardLayerout();
		
		//��ϰ
		//��ϰsplitPanel
		//lianxiSplitPanel();
		likeEclipseShowJava();
	}

}
