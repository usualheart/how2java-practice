package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JisuanqiGUI {
	
	//设计计算器界面
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		JFrame j=new JFrame();
		j.setTitle("计算器");
		j.setSize(550,560);
		j.setLocation(500, 250);
		j.setLayout(new FlowLayout());
		
		JButton xianshi=new JButton("显示屏");
		
		xianshi.setPreferredSize(new Dimension(520,100));
		j.add(xianshi);
		Dimension d=new Dimension(100,100);
		ArrayList<JButton>l=new ArrayList<JButton>();
		
		l.add(new JButton("7"));
		l.add(new JButton("8"));
		l.add(new JButton("9"));
		l.add(new JButton("/"));
		l.add(new JButton("sq"));
		l.add(new JButton("4"));
		l.add(new JButton("5"));
		l.add(new JButton("6"));
		l.add(new JButton("*"));
		l.add(new JButton("%"));
		l.add(new JButton("1"));
		l.add(new JButton("2"));
		l.add(new JButton("3"));
		l.add(new JButton("-"));
		l.add(new JButton("1/x"));
		l.add(new JButton("0"));
		l.add(new JButton("+/-"));
		l.add(new JButton("."));
		l.add(new JButton("+"));
		l.add(new JButton("="));
		for(JButton tmp:l) {
			tmp.setPreferredSize(d);
			j.add(tmp);
		}
		
		j.setResizable(false);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
		
	}

}
