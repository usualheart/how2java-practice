package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Ezuoju {
	public static void jindutiao(int x,int y) {
		JFrame f=new JFrame();
		f.setTitle("Dangerous!");
		f.setBounds(x, y, 500, 350);
		//f.setBackground(Color.blue);

        f.getContentPane().setBackground(Color.BLACK);
		f.setLayout(null);
		
		JLabel l=new JLabel("电脑准备爆炸...");
		l.setSize(new Dimension(450,60));
		l.setLocation(50,50);
		l.setFont(new Font("黑体",Font.BOLD,50));
		l.setForeground(Color.RED);
		f.add(l);
		
		JProgressBar pb=new JProgressBar();
		pb.setMaximum(100);//总共20秒时间 4秒 6秒 10秒 3个阶段 速度分别
		pb.setValue(0);
		pb.setStringPainted(true);
		pb.setSize(new Dimension(400,50));
		pb.setLocation(50, 120);
		pb.setForeground(Color.RED);
		f.add(pb);
		
		new Thread() {
			public void run() {
				long startTime=System.currentTimeMillis();
				long endTime=startTime+26000;
				long tmp=startTime;
				while(tmp!=endTime) {
					if((tmp-startTime)<8000&&(tmp-startTime)%100==0)pb.setValue((int) ((tmp-startTime)/100));
					else if ((tmp-startTime)>8000&&(tmp-startTime)<10000&&(tmp-startTime)%200==0) pb.setValue((int) (80+(tmp-8000-startTime)/200));
					else if ((tmp-startTime)>10000&&(tmp-startTime)%1600==0)pb.setValue((int) (90+(tmp-10000-startTime)/1600));
					tmp=System.currentTimeMillis();
				}
				pb.setValue((int) (tmp-startTime));
			}
		}.start();
		
		
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		for(int i=0;i<12;i++) {
			if(i<=3)
				jindutiao(10+i*400,10);
			else if(i<=7)
				jindutiao(10+(i-4)*400,250);
			else 
				jindutiao(10+(i-8)*400,550);
		}
	}

}
