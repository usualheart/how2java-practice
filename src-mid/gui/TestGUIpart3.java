package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

//GUI�˵��� �������� ����
public class TestGUIpart3 {
	//�˵�����
	public static void testCaidan() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
 
        // �˵���
        JMenuBar mb = new JMenuBar();
 
        // �˵�
        JMenu mHero = new JMenu("Ӣ��");
        JMenu mItem = new JMenu("����");
        JMenu mWord = new JMenu("����");
        JMenu mSummon = new JMenu("�ٻ�ʦ");
        JMenu mTalent = new JMenu("�츳��");
 
        // �˵���
        mHero.add(new JMenuItem("��ս-Warriar"));
        mHero.add(new JMenuItem("Զ��-Range"));
        mHero.add(new JMenuItem("����-physical"));
        mHero.add(new JMenuItem("̹��-Tank"));
        mHero.add(new JMenuItem("��ϵ-Mage"));
        mHero.add(new JMenuItem("����-Support"));
        mHero.add(new JMenuItem("��Ұ-Jungle"));
        mHero.add(new JMenuItem("ͻ��-Charge"));
        mHero.add(new JMenuItem("����-Boy"));
        mHero.add(new JMenuItem("Ů��-Girl"));
        // �ָ���
        mHero.addSeparator();
        mHero.add(new JMenuItem("����-All"));
        
        // �Ѳ˵����뵽�˵���
        mb.add(mHero);
        mb.add(mItem);
        mb.add(mWord);
        mb.add(mSummon);
        mb.add(mTalent);
 
        // �Ѳ˵������뵽frame�������õ���set����add
        f.setJMenuBar(mb);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	public static void jishibenGUI() {
		JFrame f = new JFrame("���±�");
        f.setSize(600, 500);
        f.setLocation(200, 200);
 
        // �˵���
        JMenuBar mb = new JMenuBar();
        // �˵�
        JMenu mFile = new JMenu("�ļ�(F)");

        mFile.setFont(new Font("����",0,12));
        JMenu mEdit = new JMenu("�༭(E)");
        mEdit.setFont(new Font("����",0,12));
        JMenu mGeshi = new JMenu("��ʽ(O)");
        mGeshi.setFont(new Font("����",0,12));
        JMenu mView = new JMenu("�鿴(V)");
        mView.setFont(new Font("����",0,12));
        JMenu mHelp = new JMenu("����(H)");
        mHelp.setFont(new Font("����",0,12));
 
        //�ļ��Ĳ˵���
        ArrayList<String> al=new ArrayList<String>();
        al.add("�½�(N)          \tCtrl+N");
        al.add("��(O)...       \tCtrl+O");
        al.add("����(S)          \tCtrl+S");
        al.add("���Ϊ(A)... ");
        al.add("ҳ������(U)...");
        al.add("��ӡ(P)...       \tCtrl+P");
        al.add("�˳�(X)");
        
        
        JMenuItem[] fileMI=new JMenuItem[al.size()];
        for(int i=0;i<al.size();i++) {
        	JMenuItem tmp=new JMenuItem(al.get(i));
        	tmp.setPreferredSize(new Dimension(180,20));
        	tmp.setFont(new Font("����",0,12));
        	mFile.add(tmp);
        	fileMI[i]=tmp;
        	if(i==2||i==4)mFile.addSeparator(); // �ָ���
        }
        
        //�༭�Ĳ˵���
        String [] bianji= {"����(U)    	        \tCtrl+Z","����(T)    	        \tCtrl+T","����(C)    	        \tCtrl+C","ճ��(P)    	        \tCtrl+V",
        		"ɾ��(L)	               \tDel",
        		"����(F)    	        \tCtrl+F","������һ��(N)	          \tF3","�滻(R)	            \tCtrl+H","ת��(G)    	        \tCtrl+G",
        		"ȫѡ(A)    	        \tCtrl+A","ʱ��/����(D)	           \tF5",
        };
        for(int i=0;i<11;i++) {
        	JMenuItem tmp=new JMenuItem(bianji[i]);
        	tmp.setPreferredSize(new Dimension(180,20));
        	tmp.setFont(new Font("����",0,12));
        	mEdit.add(tmp);
        	if(i==0||i==4||i==8)mEdit.addSeparator();
        }
        
        // �Ѳ˵����뵽�˵���
        mb.add(mFile);
        mb.add(mEdit);
        mb.add(mGeshi);
        mb.add(mView);
        mb.add(mHelp);
        
        //�ı�����
        JTextArea ta=new JTextArea();
        ta.setLineWrap(true);//�����Զ�����
        ta.setFont(new Font("����", 0, 16));
        JScrollPane sp=new JScrollPane(ta);
        f.add(sp);
        
        //�ļ�ѡ����
        JFileChooser fc = new JFileChooser();
        //ʹ��FileFilter���ڽ�ѡ��.txt�ļ�,�Լ��ļ��У�������
        fc.setFileFilter(new FileFilter() {
             
            @Override
            public String getDescription() {
                // TODO Auto-generated method stub
                return ".txt";
            }
            @Override
            public boolean accept(File f) {
                return f.isDirectory() ||f.getName().toLowerCase().endsWith(".txt");
            }
        });
        //Ϊ�򿪲˵�������¼�
        fileMI[1].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int returnVal =  fc.showOpenDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    //JOptionPane.showMessageDialog(f, "�ƻ����ļ�:" + file.getAbsolutePath());
                    try(FileReader fr=new FileReader(file);){
                    	char[]cbuf=new char[(int) file.length()] ;
                    	fr.read(cbuf);
                    	ta.setText(String.valueOf(cbuf));	
                    }
                    catch(IOException e1){
                    	e1.printStackTrace();
                    }
                    
                    
                }
        	}
        	
        });
        //Ϊ����˵�������¼�
        fileMI[2].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int returnVal =  fc.showSaveDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    //JOptionPane.showMessageDialog(f, "�ƻ������ļ�:" + file.getAbsolutePath());
                    try(FileWriter fw=new FileWriter(file);){
                    	fw.write(ta.getText());
                    	fw.flush();
                    }
                    catch(IOException e1){
                    	e1.printStackTrace();
                    }
                    
                    
                }
        	}
        	
        });
        
        // �Ѳ˵������뵽frame�������õ���set����add
        f.setJMenuBar(mb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
	
	//���������� ���������ڴ�ų��õİ�ť
	public static void testGongjulan() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // �˵�
        addMenu(f);
 
        // ������
        JToolBar tb = new JToolBar();
        //Ĭ������� ����������ͨ������϶�  �÷������Խ�ֹ�������϶�	
        tb.setFloatable(false);

        
        // Ϊ���������Ӱ�ť
        JButton b1 = new JButton(new ImageIcon("D:\\java-test\\Swing\\images\\1.jpg"));
        JButton b2 = new JButton(new ImageIcon("D:/java-test/Swing/images/2.jpg"));
        JButton b3 = new JButton(new ImageIcon("D:/java-test/Swing/images/3.jpg"));
        JButton b4 = new JButton(new ImageIcon("D:/java-test/Swing/images/4.jpg"));
        JButton b5 = new JButton(new ImageIcon("D:/java-test/Swing/images/5.jpg"));
        JButton b6 = new JButton(new ImageIcon("D:/java-test/Swing/images/6.jpg"));
        tb.add(b1);
        tb.add(b2);
        tb.add(b3);
        tb.add(b4);
        tb.add(b5);
        tb.add(b6);
        
        // ����ť������ʾ��Ϣ  �������ڰ�ť�ϵ�ʱ��������ʾ
        b1.setToolTipText("�ӵ�Ӣ��");
 
        
        // �ѹ���������north��λ��
        f.setLayout(new BorderLayout());
        f.add(tb, BorderLayout.NORTH);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
 
    private static void addMenu(JFrame f) {
        JMenuBar mb = new JMenuBar();
 
        JMenu mHero = new JMenu("Ӣ��");
        JMenu mItem = new JMenu("����");
        JMenu mWord = new JMenu("����");
        JMenu mSummon = new JMenu("�ٻ�ʦ");
        JMenu mTalent = new JMenu("�츳��");
 
        // �˵���
        mHero.add(new JMenuItem("��ս-Warriar"));
        mHero.add(new JMenuItem("Զ��-Range"));
        mHero.add(new JMenuItem("����-physical"));
        mHero.add(new JMenuItem("̹��-Tank"));
        mHero.add(new JMenuItem("��ϵ-Mage"));
        mHero.add(new JMenuItem("����-Support"));
        mHero.add(new JMenuItem("��Ұ-Jungle"));
        mHero.add(new JMenuItem("ͻ��-Charge"));
        mHero.add(new JMenuItem("����-Boy"));
        mHero.add(new JMenuItem("Ů��-Girl"));
 
        mb.add(mHero);
        mb.add(mItem);
        mb.add(mWord);
        mb.add(mSummon);
        mb.add(mTalent);
 
        f.setJMenuBar(mb);
    }
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//testCaidan();
		//jishibenGUI();//һ�����±���GUI�ͼ򵥹���ʵ�� ���Դ��ļ� �����ļ�
		testGongjulan();//����������
	}

}
