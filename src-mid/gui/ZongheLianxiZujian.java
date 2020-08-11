package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import io.CopyFindFile;


public class ZongheLianxiZujian {
	//组件的为空判断或数字校验
	//在JTextField中输入数据，在旁边加一个按钮JButton,当点击按钮的时候，判断JTextFiled中有没有数据，并使用JOptionPane进行提示
	public static void isKongOrIsShuzi() {
		JFrame f=new JFrame();
		f.setTitle("LOL");
		f.setSize(500, 500);
		f.setLocation(500, 200);
		f.setLayout(new FlowLayout());
		
		JTextField tf=new JTextField();
		tf.setPreferredSize(new Dimension(100, 30));
		JButton b=new JButton("检测");
		f.add(tf);
		f.add(b);
		
		//判断是否为空的事件
		ActionListener isKong=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//判断文本框是否为空
				if(tf.getText().length()==0) {
					JOptionPane.showMessageDialog(f, "文本框是空的！", "警告",2);
				}else {
					JOptionPane.showMessageDialog(f, "很好，文本框不是空的", "重要提示",1);
				}
			}
		};
		//判断是否数字的事件
		ActionListener isShuzi=new ActionListener() {
			//判断字符串中是否全部为数字所组成
			public boolean shuziStr(String str) {
				boolean flag=true;
				for(int i=0;i<str.length();i++) {
					if(str.charAt(i)<='9'&&str.charAt(i)>='0')continue;
					else {
						flag=false;
						break;
					}
				}
				return flag;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的 方法存根
				//判断文本框中字符串是否全部是数字构成的
				if(shuziStr(tf.getText())) {
					JOptionPane.showMessageDialog(f, "文本框内容是由数字组成的！", "消息",1);
				}else {
					JOptionPane.showMessageDialog(f, "文本框内容不是数字！", "重要提示",2);
				}
			}
		};
		
		//添加监听事件
		b.addActionListener(isShuzi);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	//实现账号密码登陆的验证界面（和数据库连接）
	public static void zhanghaoMimaYanzheng() {
		JFrame f=new JFrame();
		f.setTitle("LOL");
		f.setSize(500, 500);
		f.setLocation(500, 200);
		f.setLayout(new FlowLayout());
		
		JLabel lzhanghao=new JLabel();
		lzhanghao.setText("账号：");
		
		JTextField tfuser=new JTextField();
		tfuser.setPreferredSize(new Dimension(100, 30));
		JLabel lmima=new JLabel();
		lmima.setText("密码：");
		JPasswordField pf=new JPasswordField();
		pf.setPreferredSize(new Dimension(100, 30));
		JButton b=new JButton("登陆");
		
		//设置监听事件
		ActionListener denglu=new ActionListener() {
			
			public  boolean panduanPasswd(String name,String password) {
		        boolean flag=false;
				try {
		            Class.forName("com.mysql.jdbc.Driver");
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		 
		        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
		                "root", "admin");
		                Statement s = c.createStatement();
		              ) {
		            
		            String sql = "select * from user where name = '" + name +"' and password = '" + password+"'";
		            // 执行查询语句，并把结果集返回给ResultSet
		            ResultSet rs = s.executeQuery(sql);
		              
		            if(rs.next())
		                flag= true;
		            
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        return flag;
		   
		    }
			public void actionPerformed(ActionEvent e) {
				String user=tfuser.getText();
				char[]passwd=pf.getPassword();
				if(panduanPasswd(user,String.valueOf(passwd)))
					JOptionPane.showMessageDialog(f, "登陆成功！", "消息",1);
				else 
					JOptionPane.showMessageDialog(f, "用户名或密码错误！", "警告",2);
			}
		};
		b.addActionListener(denglu);
		
		
		//添加组件
		f.add(lzhanghao);
		f.add(tfuser);
		f.add(lmima);
		f.add(pf);
		f.add(b);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);//设置界面是否可以调节大小，false不可以调节界面大小
		f.setVisible(true);
	}
	
	//实现界面生成类似黄鹤的段子
	public static void huanghe() {
		JFrame f=new JFrame();
		f.setTitle("黄鹤段子生成器");
		f.setSize(600, 500);
		f.setLocation(500, 200);
		f.setLayout(new FlowLayout());
		
		String labelming[]= {
				"地名：","公司类型：","公司名称：","老板名称：","金额：","产品：","价格计量单位"
		};
		JTextField tfs[]=new JTextField[7];
		for(int i=0;i<7;i++) {
			JLabel ltmp=new JLabel(labelming[i]);
			ltmp.setPreferredSize(new Dimension(130,30));
			ltmp.setFont(new Font("宋体",Font.PLAIN,16));//设置字体参数
			f.add(ltmp);
			
			JTextField tftmp=new JTextField();
			tftmp.setPreferredSize(new Dimension(120,30));
			tftmp.setFont(new Font("宋体",Font.PLAIN,16));
			tfs[i]=tftmp;
			f.add(tftmp);
		}
		//添加空白标签 便于排版
		JLabel none=new JLabel();
		none.setPreferredSize(new Dimension(255,30));
		f.add(none);
		
		//添加生成按钮
		JButton shengcheng=new JButton("生成");
		shengcheng.setFont(new Font("宋体",Font.BOLD,16));
		shengcheng.setPreferredSize(new Dimension(100,30));
		f.add(shengcheng);
		
		//添加带滚动的文本框
		JTextArea ta=new JTextArea();
		ta.setFont(new Font("宋体",Font.PLAIN,16));
		//ta.setPreferredSize(new Dimension(500,400));添加滚动不能对文本框设置偏好长度！
		ta.setLineWrap(true);//设置自动换行
		
		//创建滚动
		JScrollPane sp=new JScrollPane(ta);
		sp.setPreferredSize(new Dimension(500,200));
		f.add(sp);
		
		ActionListener duanzi=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String diming=tfs[0].getText();
				String leixing=tfs[1].getText();
				String gongsi=tfs[2].getText();
				String laoban=tfs[3].getText();
				int jine=Integer.parseInt(tfs[4].getText());
				String chanpin=tfs[5].getText();
				String danwei=tfs[6].getText();
				String str=String.format("%s最大%s%s倒闭了，王八蛋老板%s吃喝嫖赌，"
						+ "欠下了%d个亿，带着他的小姨子跑了!我们没有办法，拿着%s抵工资!"
						+ "原价都是一%s多、两%s多、三%s多的钱包，现在全部只卖二十"
						+ "块，统统只要二十块!%s王八蛋，你不是人!我们辛辛苦苦给你干了大半年，"
						+ "你不发工资，你还我血汗钱，还我血汗钱!",diming,leixing,gongsi,
						laoban,jine,chanpin,danwei,danwei,danwei,laoban);
				ta.setText(str);
			}
		};
		shengcheng.addActionListener(duanzi);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}
	
	public static void fulijisuanqi() {
		JFrame f=new JFrame();
		f.setTitle("复利计算器");
		f.setSize(400, 400);
		f.setLocation(500, 200);
		f.setLayout(new FlowLayout());
		
		//初始化需要用到的数组
		String labelming[]= {
				"起始资金","每年收益","复利年数","每年追加资金","本金和","利息和","本息和"
		};
		String danwei[]= {"￥","%","年","￥","￥","￥","￥",};
		JTextField tfs[]=new JTextField[7];
		//计算动作
		ActionListener jisuan=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int benjin=Integer.parseInt(tfs[0].getText());
				double rate=Integer.parseInt(tfs[1].getText());
				int year=Integer.parseInt(tfs[2].getText());
				int addMoneyYear=Integer.parseInt(tfs[3].getText());
				
				int benjinhe=benjin+(year-1)*addMoneyYear;
				/*//正向算法
				double lixi=0;
				double benxihe=benjin;//记录每一年计算利息前的本息和
				for(int i=0;i<year;i++) {
					lixi=benxihe*(rate/100);//计算每年的利息
					benxihe=benxihe+addMoneyYear+lixi;//以后每年的应计算利息的本金为前一年的本息和加上每年加入的本金以及前一年生成的利息
				}
				//本息和多加了最后一年增加的资金（这个应该进去）
				benxihe-=addMoneyYear;
				*/
				///*
				//第二种算法
				double benxihe=0;
				//计算每年加入的资金的利息
				for(int i=1;i<year;i++) {
					benxihe+=addMoneyYear*(Math.pow(1+rate/100, i));
				}
				benxihe+=benjin*(Math.pow(1+rate/100, year));
				//*/
				
				//显示结果
				tfs[4].setText(String.valueOf(benjinhe));
				tfs[5].setText(String.valueOf(benxihe-benjinhe));
				tfs[6].setText(String.valueOf(benxihe));
			}
		};
		//生成并添加组件、文本框等
		for(int i=0;i<7;i++) {
			JLabel ltmp=new JLabel(labelming[i]);
			ltmp.setPreferredSize(new Dimension(130,30));
			ltmp.setFont(new Font("宋体",Font.BOLD,16));//设置字体参数
			f.add(ltmp);
			
			JTextField tftmp=new JTextField();
			tftmp.setPreferredSize(new Dimension(120,30));
			tftmp.setFont(new Font("宋体",Font.PLAIN,16));
			tfs[i]=tftmp;
			f.add(tftmp);
			
			JLabel ldanwei=new JLabel(danwei[i]);
			ldanwei.setPreferredSize(new Dimension(30,30));
			ldanwei.setFont(new Font("宋体",Font.BOLD,16));//设置字体参数
			f.add(ldanwei);
			
			if(i==3) {
				//添加计算按钮
				JPanel bl=new JPanel();
				JButton shengcheng=new JButton("计算");
				shengcheng.setFont(new Font("宋体",Font.BOLD,16));
				shengcheng.setPreferredSize(new Dimension(200,35));
				shengcheng.addActionListener(jisuan);
				bl.add(shengcheng);//按钮套在面板上边
				bl.setPreferredSize(new Dimension(300,60));
				f.add(bl);
			}
		}
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setResizable(false);
		f.setVisible(true);
	}
	
	public static void jindutiao() {
		JFrame f=new JFrame();
		f.setTitle("Dangerous!");
		f.setBounds(300, 300, 500, 350);
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
		pb.setForeground(Color.RED);//设置颜色
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
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}
	
	public static void copyFileGUI() {
		JFrame f=new JFrame();
		f.setTitle("带进度条的文件夹复制");
		f.setBounds(300, 300, 500, 250);
		f.setLayout(new FlowLayout());
		
		JLabel lsrc=new JLabel("源文件地址：");
		JTextField tfsrc=new JTextField();
		tfsrc.setText("D:\\picture");
		tfsrc.setPreferredSize(new Dimension(150,30));
		JLabel ldes=new JLabel("复制到：");
		JTextField tfdes=new JTextField();
		tfdes.setPreferredSize(new Dimension(150,30));
		tfdes.setText("D:\\java-test\\new\\");
		JButton start=new JButton("开始复制");
		JLabel ljindu=new JLabel("文件复制进度：");
		
		JProgressBar pb=new JProgressBar();
		pb.setPreferredSize(new Dimension(250,30));
		pb.setMaximum(100);
		pb.setStringPainted(true);
		//将组件添加到面板
		f.add(lsrc);
		f.add(tfsrc);
		f.add(ldes);
		f.add(tfdes);
		f.add(start);
		f.add(ljindu);
		f.add(pb);
		
		//为按键添加事件监听
		start.addActionListener(new ActionListener() {
			
			//统计文件夹的大小
			public long wenjianjiaSize(String str) {
				File[] fs=(new File(str)).listFiles();
				long sum=0;
				for(int i=0;i<fs.length;i++) {
					if(fs[i].isFile())
						sum+=fs[i].length();
					else
						sum+=wenjianjiaSize(fs[i].getAbsolutePath());
				}
				return sum;
			}
			//拷贝文件
			public void copyFile(String srcFile, String destFile){
				File sFile=new File(srcFile);
				File dFile=new File(destFile);
				try(
						FileInputStream fis=new FileInputStream(sFile);
						//BufferedReader br=new BufferedReader(fr);
						FileOutputStream fos=new FileOutputStream(dFile);
						//PrintWriter pw= new PrintWriter(fw);
					){	byte tmp[]=new byte[(int) sFile.length()];
						fis.read(tmp);
						fos.write(tmp);
						//file
						fileCopyed+=sFile.length();//每次复制文件之后   对已经复制的文件大小进行更新 
						//System.out.println("拷贝成功！"+fileCopyed);//实时显示已经复制的文件的总大小
					}
					catch(IOException e) {
						e.printStackTrace();
					}
				
			}
			
			//复制文件夹，把源文件夹下所有的文件 复制到目标文件夹下(包括子文件夹)
			public void copyFolder(String srcFolder, String destFolder){
				File sFolder=new File(srcFolder);
				File dFolder=new File(destFolder);
				
				//若目标文件夹为空，进行创建
				if(!dFolder.exists()) dFolder.mkdirs();
				File sFiles[]=sFolder.listFiles();
				for(int i=0;i<sFiles.length;i++) {
					System.out.println(sFiles[i].getAbsolutePath());
					if(sFiles[i].isFile())copyFile(sFiles[i].getAbsolutePath(),destFolder+sFiles[i].getName());
					else copyFolder(sFiles[i].getAbsolutePath(),destFolder+sFiles[i].getName()+"/");
				}  
			}
			long  fileCopyed=0;//记录已经拷贝的文件的大小，copyFile函数需要用到这个变量
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String src=tfsrc.getText();
				String des=tfdes.getText();
				
				long Max=wenjianjiaSize(src);//计算源文件夹的文件大小
				//System.out.println(Max+"   "+(int)Max);//输出源文件夹的总大小 以及强制转换为int的值 发现强制转换后的int无法满足要求
				fileCopyed=0;//每次已经复制的文件要清零
				
				
				new Thread() {
					public void run() {
						while(fileCopyed!=Max) {
							int fileCopyedInt=(int) (fileCopyed*100/Max);//避免int位数不够引发错误
							System.out.println(fileCopyedInt);
							pb.setValue(fileCopyedInt);
							/*
							 * 当 应用程序在事件线程中执行长时间的操作时，会阻塞正常的AWT事件处理，因此阻止了重绘操作的发生。
							 * 这同常会在下列情况下发生：应用程序响应一个来自用户 界面的请求时，在连接到一个按钮或其他GUI组件的事件处理程序中执行任务，
							 * 任务的内容可能会需要较长时间，使事件线程挂起，直至远程系统发出答复为止。 
							 * 当应用程序调用JProgressBar的setValue方法时，进度条可能更新期内部状态并调用repaint，这样做会把一个事件放置到AWT事件 队列中。
							 * 不幸的是，直至应用程序的事件处理程序完成其处理并把控制权返回到线程的事件处理循环，才能处理该事件。
							 * 
							 * 下边的两行是第一种解决办法
							 * 调用JComponent的paintImmediately方法来解决
							 */
							//Dimension d=f.getSize();
							//pb.paintImmediately(0, 0, d.width, d.height);
							
							try {
								Thread.sleep(100);//休息100ms
							} catch (InterruptedException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						};
						pb.setValue(100);
					}
				}.start();
				//开始拷贝文件
				//解决进度条不刷新的第二种解决办法 把复制文件夹的方法放进一个新的线程里边！
				new Thread() {
					public void run() {
						copyFolder(src,des);
					}
				}.start();
			}
			
		});
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//isKongOrIsShuzi();
		//zhanghaoMimaYanzheng();//账号密码登陆的实现
		//huanghe();//黄鹤段子生成器
		fulijisuanqi();//复利计算器
		//jindutiao();//折磨人的进度条
		//copyFileGUI();拷贝文件夹
		
	}

}
