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
//GUI 窗体大小可调节、显示隐藏JLabel、模态对话框、4种布局器测试：null,FlowLayout、BorderLayout、GridLayout()
public class TestGUIpart2 {
	public static void testsetResizable() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
        JButton b = new JButton("一键秒对方基地挂");
        b.setBounds(50, 50, 280, 30);
 
        f.add(b);
        // 窗体大小不可变化
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	public static void qiehuanXianshi() {
		JFrame j=new JFrame("切换显示测试");
		j.setBounds(200, 200, 400, 400);
		j.setLayout(null);
		final JLabel l=new JLabel();
		ImageIcon i=new ImageIcon("D:/java-test/Swing/shana.png");
		l.setIcon(i);
		l.setBounds(140,50,i.getIconWidth(), i.getIconHeight());
		j.add(l);
		
		JButton b=new JButton();
		b.setText("隐藏图片");
		b.setBounds(50, 200, 300, 40);
		j.add(b);
		MouseListener ml=new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				String str=b.getText();
				
				if(str.equals("隐藏图片")) {
					b.setText("显示图片");
					l.setVisible(false);
				}
				else {
					b.setText("隐藏图片");
					l.setVisible(true);
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
		};
		b.addMouseListener(ml);
		
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
	}
	
	//练习：模态与大小变化点击该按钮后，随即打开一个模态窗口。

//在这个模态窗口中有一个按钮，文本是 "锁定大小", 点击后，这个模态窗口的大小就被锁定住，不能改变。 再次点击，就回复能够改变大
	public static void modalSize() {
		JFrame f = new JFrame("LoL");
        f.setSize(600, 500);
        f.setLocation(200, 200);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        JButton fb=new JButton();
        fb.setText("打开一个模态窗口");
        fb.setBounds(50, 50, 500, 40);
        f.add(fb);
        
        JDialog d=new JDialog(f);
        d.setTitle("模态对话框");
        d.setBounds(560, 380, 400, 300);
        d.setLayout(null);
        d.setModal(true);
        d.setResizable(false);
        JButton db=new JButton();
        db.setText("解锁大小");
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
	
	//布局器测试
	//绝对定位就是指不使用布局器，组件的位置和大小需要单独指定
	public static void testsetLayout() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // 设置布局器为null，即进行绝对定位，容器上的组件都需要指定位置和大小
        f.setLayout(null);
        JButton b1 = new JButton("英雄1");
        // 指定位置和大小
        b1.setBounds(50, 50, 80, 30);
        JButton b2 = new JButton("英雄2");
        b2.setBounds(150, 50, 80, 30);
        JButton b3 = new JButton("英雄3");
        b3.setBounds(250, 50, 80, 30);
        // 没有指定位置和大小，不会出现在容器上
        JButton b4 = new JButton("英雄3");
 
        f.add(b1);
        f.add(b2);
        f.add(b3);
        // b4没有指定位置和大小，不会出现在容器上
        f.add(b4);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	
	//设置布局器为FlowLayout,顺序布局器,容器上的组件水平摆放
	//加入到容器即可，无需单独指定大小和位置
	public static void testFlowLayout() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // 设置布局器为FlowLayerout
        // 容器上的组件水平摆放
        f.setLayout(new FlowLayout());
 
        JButton b1 = new JButton("英雄1");
        JButton b2 = new JButton("英雄2");
        JButton b3 = new JButton("英雄3");
 
        // 加入到容器即可，无需单独指定大小和位置
        f.add(b1);
        f.add(b2);
        f.add(b3);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	
	//设置布局器为BorderLayout
	//容器上的组件按照上北 下南 左西 右东 中的顺序摆放
	public static void testBorderLayout() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // 设置布局器为BorderLayerout
        // 容器上的组件按照上北下南左西右东中的顺序摆放
        f.setLayout(new BorderLayout());
 
        JButton b1 = new JButton("洪七");
        JButton b2 = new JButton("段智兴");
        JButton b3 = new JButton("欧阳锋");
        JButton b4 = new JButton("黄药师");
        JButton b5 = new JButton("周伯通");
 
        // 加入到容器的时候，需要指定位置
        f.add(b1, BorderLayout.NORTH);
        f.add(b2, BorderLayout.SOUTH);
        f.add(b3, BorderLayout.WEST);
        f.add(b4, BorderLayout.EAST);
        f.add(b5, BorderLayout.CENTER);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	
	//GridLayout，即网格布局器
	public static void testGridLayout() {
		
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // 设置布局器为GridLayerout，即网格布局器
        // 该GridLayerout的构造方法表示该网格是2行3列
        f.setLayout(new GridLayout(2, 3));
 
        JButton b1 = new JButton("洪七");
        JButton b2 = new JButton("段智兴");
        JButton b3 = new JButton("欧阳锋");
        JButton b4 = new JButton("黄药师");
        JButton b5 = new JButton("周伯通");
 
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	
	//即便 使用 布局器 ，也可以 通过setPreferredSize，向布局器建议该组件显示的大小.
	//注 只对部分布局器起作用，比如FlowLayout可以起作用。 比如GridLayout就不起作用，因为网格布局器必须对齐
	
	public static void testsetPreferredSize() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());
 
        JButton b1 = new JButton("英雄1");
        JButton b2 = new JButton("英雄2");
        JButton b3 = new JButton("英雄3");
 
        // 即便 使用 布局器 ，也可以 通过setPreferredSize，向布局器建议该组件显示的大小
        b3.setPreferredSize(new Dimension(180, 40));
 
        f.add(b1);
        f.add(b2);
        f.add(b3);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//testsetResizable();
		//qiehuanXianshi();
		//modalSize();
		
		//布局器测试
		//testsetLayout();
		//testFlowLayout();
		//testBorderLayout();
		//testGridLayout();
		testsetPreferredSize();
	}

}
