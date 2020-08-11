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

//GUI菜单栏 、工具栏 测试
public class TestGUIpart3 {
	//菜单测试
	public static void testCaidan() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
 
        // 菜单栏
        JMenuBar mb = new JMenuBar();
 
        // 菜单
        JMenu mHero = new JMenu("英雄");
        JMenu mItem = new JMenu("道具");
        JMenu mWord = new JMenu("符文");
        JMenu mSummon = new JMenu("召唤师");
        JMenu mTalent = new JMenu("天赋树");
 
        // 菜单项
        mHero.add(new JMenuItem("近战-Warriar"));
        mHero.add(new JMenuItem("远程-Range"));
        mHero.add(new JMenuItem("物理-physical"));
        mHero.add(new JMenuItem("坦克-Tank"));
        mHero.add(new JMenuItem("法系-Mage"));
        mHero.add(new JMenuItem("辅助-Support"));
        mHero.add(new JMenuItem("打野-Jungle"));
        mHero.add(new JMenuItem("突进-Charge"));
        mHero.add(new JMenuItem("男性-Boy"));
        mHero.add(new JMenuItem("女性-Girl"));
        // 分隔符
        mHero.addSeparator();
        mHero.add(new JMenuItem("所有-All"));
        
        // 把菜单加入到菜单栏
        mb.add(mHero);
        mb.add(mItem);
        mb.add(mWord);
        mb.add(mSummon);
        mb.add(mTalent);
 
        // 把菜单栏加入到frame，这里用的是set而非add
        f.setJMenuBar(mb);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	public static void jishibenGUI() {
		JFrame f = new JFrame("记事本");
        f.setSize(600, 500);
        f.setLocation(200, 200);
 
        // 菜单栏
        JMenuBar mb = new JMenuBar();
        // 菜单
        JMenu mFile = new JMenu("文件(F)");

        mFile.setFont(new Font("宋体",0,12));
        JMenu mEdit = new JMenu("编辑(E)");
        mEdit.setFont(new Font("宋体",0,12));
        JMenu mGeshi = new JMenu("格式(O)");
        mGeshi.setFont(new Font("宋体",0,12));
        JMenu mView = new JMenu("查看(V)");
        mView.setFont(new Font("宋体",0,12));
        JMenu mHelp = new JMenu("帮助(H)");
        mHelp.setFont(new Font("宋体",0,12));
 
        //文件的菜单项
        ArrayList<String> al=new ArrayList<String>();
        al.add("新建(N)          \tCtrl+N");
        al.add("打开(O)...       \tCtrl+O");
        al.add("保存(S)          \tCtrl+S");
        al.add("另存为(A)... ");
        al.add("页面设置(U)...");
        al.add("打印(P)...       \tCtrl+P");
        al.add("退出(X)");
        
        
        JMenuItem[] fileMI=new JMenuItem[al.size()];
        for(int i=0;i<al.size();i++) {
        	JMenuItem tmp=new JMenuItem(al.get(i));
        	tmp.setPreferredSize(new Dimension(180,20));
        	tmp.setFont(new Font("宋体",0,12));
        	mFile.add(tmp);
        	fileMI[i]=tmp;
        	if(i==2||i==4)mFile.addSeparator(); // 分隔符
        }
        
        //编辑的菜单项
        String [] bianji= {"撤销(U)    	        \tCtrl+Z","剪切(T)    	        \tCtrl+T","复制(C)    	        \tCtrl+C","粘贴(P)    	        \tCtrl+V",
        		"删除(L)	               \tDel",
        		"查找(F)    	        \tCtrl+F","查找下一个(N)	          \tF3","替换(R)	            \tCtrl+H","转到(G)    	        \tCtrl+G",
        		"全选(A)    	        \tCtrl+A","时间/日期(D)	           \tF5",
        };
        for(int i=0;i<11;i++) {
        	JMenuItem tmp=new JMenuItem(bianji[i]);
        	tmp.setPreferredSize(new Dimension(180,20));
        	tmp.setFont(new Font("宋体",0,12));
        	mEdit.add(tmp);
        	if(i==0||i==4||i==8)mEdit.addSeparator();
        }
        
        // 把菜单加入到菜单栏
        mb.add(mFile);
        mb.add(mEdit);
        mb.add(mGeshi);
        mb.add(mView);
        mb.add(mHelp);
        
        //文本区域
        JTextArea ta=new JTextArea();
        ta.setLineWrap(true);//设置自动换行
        ta.setFont(new Font("宋体", 0, 16));
        JScrollPane sp=new JScrollPane(ta);
        f.add(sp);
        
        //文件选择器
        JFileChooser fc = new JFileChooser();
        //使用FileFilter用于仅选择.txt文件,以及文件夹（新增）
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
        //为打开菜单项添加事件
        fileMI[1].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int returnVal =  fc.showOpenDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    //JOptionPane.showMessageDialog(f, "计划打开文件:" + file.getAbsolutePath());
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
        //为保存菜单项添加事件
        fileMI[2].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int returnVal =  fc.showSaveDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    //JOptionPane.showMessageDialog(f, "计划保存文件:" + file.getAbsolutePath());
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
        
        // 把菜单栏加入到frame，这里用的是set而非add
        f.setJMenuBar(mb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
	}
	
	//工具栏测试 工具栏用于存放常用的按钮
	public static void testGongjulan() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // 菜单
        addMenu(f);
 
        // 工具栏
        JToolBar tb = new JToolBar();
        //默认情况下 工具栏可以通过鼠标拖动  该方法可以禁止工具栏拖动	
        tb.setFloatable(false);

        
        // 为工具栏增加按钮
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
        
        // 给按钮设置提示信息  当鼠标放在按钮上的时候会出现提示
        b1.setToolTipText("坑爹英雄");
 
        
        // 把工具栏放在north的位置
        f.setLayout(new BorderLayout());
        f.add(tb, BorderLayout.NORTH);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
 
    private static void addMenu(JFrame f) {
        JMenuBar mb = new JMenuBar();
 
        JMenu mHero = new JMenu("英雄");
        JMenu mItem = new JMenu("道具");
        JMenu mWord = new JMenu("符文");
        JMenu mSummon = new JMenu("召唤师");
        JMenu mTalent = new JMenu("天赋树");
 
        // 菜单项
        mHero.add(new JMenuItem("近战-Warriar"));
        mHero.add(new JMenuItem("远程-Range"));
        mHero.add(new JMenuItem("物理-physical"));
        mHero.add(new JMenuItem("坦克-Tank"));
        mHero.add(new JMenuItem("法系-Mage"));
        mHero.add(new JMenuItem("辅助-Support"));
        mHero.add(new JMenuItem("打野-Jungle"));
        mHero.add(new JMenuItem("突进-Charge"));
        mHero.add(new JMenuItem("男性-Boy"));
        mHero.add(new JMenuItem("女性-Girl"));
 
        mb.add(mHero);
        mb.add(mItem);
        mb.add(mWord);
        mb.add(mSummon);
        mb.add(mTalent);
 
        f.setJMenuBar(mb);
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//testCaidan();
		//jishibenGUI();//一个记事本的GUI和简单功能实现 可以打开文件 保存文件
		testGongjulan();//工具栏测试
	}

}
