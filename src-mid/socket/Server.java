package socket;
  
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
import java.util.Scanner;
   
public class Server {
	public static void main(String[] args)  {
		//test();//基本测试
		//shuzi();//收发数字的服务器端
		//zifuchuan();
		//huliao();//客户端和服务器 互相聊天 不停止
		jiqirenServer();//简单机器人回复，同时服务器和客户端也可以互相聊天
	}
	//基本测试
    public static void test()  {
        try {
            //服务端打开端口8888
            ServerSocket ss = new ServerSocket(8888);
               
            //在8888端口上监听，看是否有连接请求过来
            System.out.println("监听在端口号:8888");
            Socket s =  ss.accept();
               
            System.out.println("有连接过来" + s);
             
            s.close();
            ss.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
    }
    
    //收发数字的服务器端
    public static void shuzi() {
        try {
 
            ServerSocket ss = new ServerSocket(8888);
 
            System.out.println("监听在端口号:8888");
            Socket s = ss.accept();
            
           
            //打开输入流
            InputStream is = s.getInputStream();
            //读取客户端发送的数据
            int msg = is.read();
            //打印出来
            System.out.println(msg);
            is.close();
            s.close();
            ss.close();
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
    
    //收发字符串 使用数据流
    public static void zifuchuan() {
        try {
 
            ServerSocket ss = new ServerSocket(8888);
 
            System.out.println("监听在端口号:8888");
            Socket s = ss.accept();
 
            InputStream is = s.getInputStream();
 
            //把输入流封装在DataInputStream
            DataInputStream dis = new DataInputStream(is);
            //使用readUTF读取字符串
            String msg = dis.readUTF();
            System.out.println(msg);
            dis.close();
            s.close();
            ss.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
    
    //互相聊天 不停止
    public static void huliao() {
        try {
 
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("监听在端口号:8888");
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);//把输入流封装在DataInputStream
            OutputStream os = s.getOutputStream();
            DataOutputStream  dos = new DataOutputStream(os);//服务器向客户端发送数据的数据流
           
            
            while(true) {
	            //使用readUTF读取字符串 只要数据流中有数据 就要把数据流中数据不断输出出来
	            String msg = dis.readUTF();
	            System.out.println("客户端消息："+msg);
            	
	            //建立一个新的线程 用于从服务器向客户端发送消息
	            new Thread() {
	            	public void run() {
	            		
			            try {
			            	//使用Scanner读取控制台的输入，并发送到客户端
				            Scanner sc = new Scanner(System.in);
				            String str = sc.next();
							dos.writeUTF(str);
						} catch (IOException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
	            	}
	            }.start();
            }
            //dis.close();
            //s.close();
            //ss.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
    
    
    
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
    //练习 简单的聊天机器人 服务器端
    public static void jiqirenServer() {
        try {
        	
        	 ServerSocket ss = new ServerSocket(8888);
             System.out.println("监听在端口号:8888");
             Socket s = ss.accept();
             InputStream is = s.getInputStream();
             DataInputStream dis = new DataInputStream(is);//把输入流封装在DataInputStream
             OutputStream os = s.getOutputStream();
             DataOutputStream  dos = new DataOutputStream(os);//服务器向客户端发送数据的数据流
            
            init();//对数据库进行初始化操作
            //建立一个新的线程 用于接收客户端消息 并做相应的处理
            new Thread() {
	        	public void run() {
		            while(true) {
		            	try {
				            //使用readUTF读取字符串 只要数据流中有数据 就要把数据流中数据不断输出出来
				            String msg = dis.readUTF();
				            System.out.println("客户端消息："+msg);
				            //得到数据库相应回复消息 若存在则进行输出
				            String response=response(msg);
				            if(null!=response)
				            	dos.writeUTF(response);
						} catch (IOException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
		            }
	        	}
            }.start();
            	
	        //建立一个新的线程 用于从服务器向客户端发送消息
	        new Thread() {
	        	public void run() {
	        		while(true) {
		        		try {
			            	//使用Scanner读取控制台的输入，并发送到客户端
				            Scanner sc = new Scanner(System.in);
				            String str = sc.next();
							dos.writeUTF(str);
						} catch (IOException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
	        		}
	        	}
	        }.start();
            
            //dos.close();//暂时先不关闭
           // s.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}