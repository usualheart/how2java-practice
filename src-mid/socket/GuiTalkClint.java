package socket;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiTalkClint {
	
    
    //客户端部分
    static Socket s;
    static String ip;
    static Thread socket;
    public static void gui() {
    	
    	
    	
	   	/*
	   	  * GUI部分
	   	*/
    	JFrame f=new JFrame();
    	f.setTitle("客户机");
    	f.setBounds(800,200,400,400);
    	f.setLayout(new BorderLayout());
    	
    	//左边竖栏
    	JPanel p=new JPanel();
    	p.setLayout(null);
    	p.setPreferredSize(new Dimension(150,300));
    	JTextField tf=new JTextField();
    	tf.setSize(120, 30);
    	tf.setLocation(15, 40);
    	tf.setText("127.0.0.1");
    	
    	JTextArea ta=new JTextArea();
    	ta.setSize(120, 100);
    	ta.setLocation(15, 80);
    	ta.setLineWrap(true);//设置自动换行
    	JButton b=new JButton("发送");
    	b.setSize(120, 30);
    	b.setLocation(15, 200);
    	p.add(tf);
    	p.add(b);
    	p.add(ta);
    	


    	//右边显示区域
    	JTextArea taPingmu=new JTextArea();
    	taPingmu.setText("\t\n请按回车键，确认ip地址...");
    	taPingmu.setLineWrap(true);//设置自动换行
    	JScrollPane sp=new JScrollPane(taPingmu);
    	
    	f.add(p, BorderLayout.WEST);
    	f.add(sp, BorderLayout.CENTER);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setVisible(true);
    	 
    	
    	/*
    	 * 客户端功能部分
    	 */
    	
    	//建立一个新的线程 用于接收服务器消息 需要在设置完成ip地址后启动该线程
        Thread receive=new Thread() {
        	public void run() {
	            while(true) {
	            	try {
	            		InputStream is = s.getInputStream();
	            		DataInputStream dis = new DataInputStream(is);//把输入流封装在DataInputStream
			            //使用readUTF读取字符串
	            		String msg= dis.readUTF();
			            taPingmu.append("\r\n服务器："+msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	            } 
        	}
        };
    	
    	tf.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO 自动生成的方法存根
				if(e.getKeyCode()==10)
				{
					ip=tf.getText();
			        taPingmu.setText("\t\n正在连接服务器...");
					socket=new Thread() {
			        	public void run() {
					    	try {
					    		s= new Socket(ip, 8888);
					       } catch (IOException e) {
					           e.printStackTrace();
					       } 
			          	}
			        };
			        try {//图形界面加载完毕后再把服务器初始化加入主线程
			        	socket.start();
			        	socket.join();
					} catch (InterruptedException e2) {
						// TODO 自动生成的 catch 块
						e2.printStackTrace();
					}
			        taPingmu.setText("\t\n聊天已经开始...");
			        receive.start();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO 自动生成的方法存根
				
			}
    		
    	});
    	
    	//为发送按钮添加事件
    	b.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
				String response=ta.getText();
				taPingmu.append("\r\n客户端："+response);
				try {
					OutputStream os=s.getOutputStream();
					DataOutputStream dos = new DataOutputStream(os);//服务器向客户端发送数据的数据流
	            	dos.writeUTF(response);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				ta.setText(null);
    		}
    	});
    	
    	
    	
    	
    	
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		gui();
		//ServerInit();
	}

}
