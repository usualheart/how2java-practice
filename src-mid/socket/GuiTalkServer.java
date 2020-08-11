package socket;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class GuiTalkServer {
	
	/*
     * 简易聊天机器人代码
     */
    //数据库部分
    static Connection c=null;//为了多次使用
    static PreparedStatement ps=null;//ps方式执行sql语句
    static Statement s1=null;
    //数据库的初始化操作
    public static void init(){
        try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e1) {
    		// TODO 自动生成的 catch 块
    		e1.printStackTrace();
    	}
        try {
        	//此处的c没有关闭 正常情况下 数据库用完要及时关闭
    		c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
    		String sql="select * from dictionary where receive=?";
    		ps=c.prepareStatement(sql);
    		//s1=c.createStatement();
    	}catch (SQLException e1) {
    		e1.printStackTrace();
    	}
    }
    //根据回复查询数据库中是否有对应的回复 如果有则反应相应的回复否则返回null
    public static String response(String receive){
    	String huifu=null;
		try {
			//第一种执行sql的方式
			//ResultSet rs = s1.executeQuery("select * from dictionary where receive='"+receive+"'");
			//第二种执行方式
			ps.setString(1, receive);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				huifu=rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return huifu;
    }
    
    
    //服务器部分
    static Socket s;
    public static void gui() {
    	
    	 /*
    	 * 服务器初始化
    	 */
    	Thread socket=new Thread() {
        	public void run() {
		    	try {
		       	 	ServerSocket ss = new ServerSocket(8888);
		       	 	s = ss.accept();
		            init();//对数据库进行初始化操作
		       } catch (UnknownHostException e) {
		           e.printStackTrace();
		       } catch (IOException e) {
		           e.printStackTrace();
		       }
          	}
        };
        socket.start();
	   	/*
	   	  * GUI部分
	   	*/
    	JFrame f=new JFrame();
    	f.setTitle("服务器");
    	f.setBounds(400,200,400,400);
    	f.setLayout(new BorderLayout());
    	
    	//左边竖栏
    	JPanel p=new JPanel();
    	p.setLayout(null);
    	p.setPreferredSize(new Dimension(150,300));
    	
    	JTextArea ta=new JTextArea();
    	ta.setSize(120, 100);
    	ta.setLocation(15, 80);
    	ta.setLineWrap(true);//设置自动换行
    	JButton b=new JButton("发送");
    	b.setSize(120, 30);
    	b.setLocation(15, 200);
    	p.add(b);
    	p.add(ta);
    	
    	
    	//右边显示区域
    	JTextArea taPingmu=new JTextArea();
    	taPingmu.setText("聊天已经开始...监听在端口号:8888");
    	taPingmu.setLineWrap(true);//设置自动换行
    	JScrollPane sp=new JScrollPane(taPingmu);
    	
    	f.add(p, BorderLayout.WEST);
    	f.add(sp, BorderLayout.CENTER);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setVisible(true);
    	
    	try {//图形界面加载完毕后再把服务器初始化加入主线程
			socket.join();
		} catch (InterruptedException e2) {
			// TODO 自动生成的 catch 块
			e2.printStackTrace();
		}
    	
    	//为发送按钮添加事件
    	b.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
				String response=ta.getText();
				taPingmu.append("\r\n服务器："+response);
				ta.setText(null);
				
				try {
					OutputStream os=s.getOutputStream();
					DataOutputStream dos = new DataOutputStream(os);//服务器向客户端发送数据的数据流
	            	if(null!=response) {
		            	synchronized (this) {//对response进行同步
							dos.writeUTF(response);
							response=null;
			            }
	            	}
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
    			
    		}
    	});
    	
    	
    	
    	//建立一个新的线程 用于接收客户端消息 并做相应的处理
        new Thread() {
        	public void run() {
	            while(true) {
	            	try {
	            		InputStream is = s.getInputStream();
	            		DataInputStream dis = new DataInputStream(is);//把输入流封装在DataInputStream
			            //使用readUTF读取字符串 只要数据流中有数据 就要把数据流中数据不断输出出来
	            		String msg= dis.readUTF();
			            //System.out.println("客户端消息："+msg);
			            taPingmu.append("\r\n客户端："+msg);
			            //得到数据库相应回复消息 若存在则进行输出
			            String tmp=response(msg);
			            if(null!=tmp) {
			            	//taPingmu.append("\r\n服务器："+tmp);
			            	//dos.writeUTF(tmp);
			            	ta.setText(tmp);
			            	b.doClick();
			            }
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	            } 
        	}
        }.start();
    	
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		gui();
		//ServerInit();
	}

}
