package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class TestZujian {
	public static void testJLabel() {
        
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
        JLabel l = new JLabel("LOL����");
        //������ɫ
        l.setForeground(Color.red);
        l.setBounds(50, 50, 280, 30);
  
        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
	
	//JCheckBox ��ѡ��  ʹ��isSelected����ȡ�Ƿ�ѡ����
	public static void testJCheckBox() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);
        JCheckBox bCheckBox = new JCheckBox("����Ӣ��");
        //���� Ϊ Ĭ�ϱ�ѡ��
        bCheckBox.setSelected(true);
        bCheckBox.setBounds(50, 50, 130, 30);
        JCheckBox bCheckBox2 = new JCheckBox("ħ�� Ӣ��");
        bCheckBox2.setBounds(50, 100, 130, 30);
        //�ж� �Ƿ� �� ѡ��
        System.out.println(bCheckBox2.isSelected());
 
        f.add(bCheckBox);
        f.add(bCheckBox2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	
	//��ѡ��
	public static void testJRadioButton() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);
        JRadioButton b1 = new JRadioButton("����Ӣ��");
        // ���� Ϊ Ĭ�ϱ�ѡ��
        b1.setSelected(true);
        b1.setBounds(50, 50, 130, 30);
        JRadioButton b2 = new JRadioButton("ħ�� Ӣ��");
        b2.setBounds(50, 100, 130, 30);
 
       // System.out.println(b2.isSelected());
        // ��ť����
        // ��b1��b2���� ͬһ�� ��ť��������� ������ͬһʱ�䣬ֻ��һ�� ��ť �ᱻѡ��
        //û����εĻ� ������ť����ͬʱ��ѡ��
        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        
        
        f.add(b1);
        f.add(b2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	//JComboBox ������
	//ʹ��getSelectedItem����ȡ��ѡ����
	//ʹ��setSelectedItem() ��ָ��Ҫѡ����
	public static void JComboBox() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 240);
        f.setLayout(null);
 
        //��������ֵ���Ŀ
        String[] heros = new String[] { "��������", "����" };
        JComboBox<String> cb = new JComboBox<String>(heros);
 
        cb.setBounds(50, 50, 80, 30);
        f.add(cb);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
	}
	
	//JOptionPane ���ڵ����Ի���
	public static void testJOptionPane() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 240);
        f.setLayout(null);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
 
        int option = JOptionPane.showConfirmDialog(f, "�Ƿ� ʹ����� ��");
        if (JOptionPane.OK_OPTION == option) {
            String answer = JOptionPane.showInputDialog(f, "������yes������ʹ����Һ���Ը�");
            if ("yes".equals(answer))
                JOptionPane.showMessageDialog(f, "��ʹ����ұ�ץס�� �������3�Σ�");
        }
 
    }
	
	//JTextField �����
	public static void testJTextField() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
 
        f.setLayout(new FlowLayout());
 
        JLabel lName = new JLabel("�˺ţ�");
        // �����
        JTextField tfName = new JTextField("");
        tfName.setText("�������˺�");
        tfName.setPreferredSize(new Dimension(80, 30));
 
        JLabel lPassword = new JLabel("���룺");
        // �����
        JTextField tfPassword = new JTextField("");
        tfPassword.setText("����������");
        tfPassword.setPreferredSize(new Dimension(80, 30));
 
        f.add(lName);
        f.add(tfName);
        f.add(lPassword);
        f.add(tfPassword);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
        tfPassword.grabFocus();//tfPassword.grabFocus(); ��ʾ������������ȡ����
    }
	//JPasswordField ����� 
	public static void testJPasswordField() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
 
        f.setLayout(new FlowLayout());
 
        JLabel l = new JLabel("���룺");
        // �����
        JPasswordField pf = new JPasswordField("");
        pf.setText("&48kdh4@#");
        pf.setPreferredSize(new Dimension(80, 30));
 
        // ���ı���ͬ����ȡ�����������ݣ��Ƽ�ʹ��getPassword���÷����᷵��һ���ַ����飬�����ַ���
        char[] password = pf.getPassword();
        String p = String.valueOf(password);
        System.out.println(p);
 
        f.add(l);
        f.add(pf);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	//JTextArea���ı���
	public static void testJTextArea() {
		  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
  
        f.setLayout(new FlowLayout());
  
        JLabel l = new JLabel("�ı���");
  
        JTextArea ta = new JTextArea();
        ta.setPreferredSize(new Dimension(200, 150));
        //\n���з�
        ta.setText("����ͷ��\n�����ð�����\n");
        //׷������
        ta.append("��ȥ��������������������������������������������������");
        //�����Զ�����
        ta.setLineWrap(true);
       
        f.add(l);
        f.add(ta);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
	
	//������
	public static void testJProgressBar() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
 
        f.setLayout(new FlowLayout());
 
        JProgressBar pb = new JProgressBar();
 
        //���������100
        pb.setMaximum(100);
        //��ǰ������50
        pb.setValue(50);
        //��ʾ��ǰ����
        pb.setStringPainted(true);
 
        f.add(pb);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	//JFileChooser ��ʾ�ļ�ѡ����
	public static void testJFileChooser() {
		  
        JFrame f = new JFrame("LOL");
        f.setLayout(new FlowLayout());
        JFileChooser fc = new JFileChooser();
        //ʹ��FileFilter���ڽ�ѡ��.txt�ļ�
        fc.setFileFilter(new FileFilter() {
             
            @Override
            public String getDescription() {
                // TODO Auto-generated method stub
                return ".txt";
            }
             
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".txt");
            }
        });
  
        JButton bOpen = new JButton("���ļ�");
  
        JButton bSave = new JButton("�����ļ�");
  
        f.add(bOpen);
        f.add(bSave);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 150);
        f.setLocationRelativeTo(null);
  
        f.setVisible(true);
          
        bOpen.addActionListener(new ActionListener() {
              
            @Override
            public void actionPerformed(ActionEvent e) {
                 int returnVal =  fc.showOpenDialog(f);
                 File file = fc.getSelectedFile();
                 if (returnVal == JFileChooser.APPROVE_OPTION) {
                     JOptionPane.showMessageDialog(f, "�ƻ����ļ�:" + file.getAbsolutePath());
                 }
                  
            }
        });
        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal =  fc.showSaveDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(f, "�ƻ����浽�ļ�:" + file.getAbsolutePath());
                }
            }
        });
  
    }
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//���
		//testJLabel();
		//testJCheckBox();
		//testJRadioButton();
		//JComboBox();
		//testJOptionPane();
		//testJTextField();
		//testJPasswordField();
		//testJTextArea();
		//testJProgressBar();
		testJFileChooser();
	}

}
