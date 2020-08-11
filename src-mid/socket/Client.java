package socket;
  
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
   
public class Client {
	public static void main(String[] args)  {
		//test();//基本测试
		//shuzi();//收发数字的服务器端
		//zifuchuan();//使用数据流传送数据
		//scanner();//使用scanner读取数据 通关数据流传送到服务器 然后
		huliao();//互相聊天  
	}
    public static void test()  {
           
        try {
            //连接到本机的8888端口
            Socket s = new Socket("127.0.0.1",8888);
            System.out.println(s);
            s.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void shuzi() {
    	 
        try {
            Socket s = new Socket("127.0.0.1", 8888);
 
            // 打开输出流
            OutputStream os = s.getOutputStream();
 
            // 发送数字110到服务端
            os.close();
            s.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void zifuchuan() {
    	 
        try {
            Socket s = new Socket("127.0.0.1", 8888);
 
            OutputStream os = s.getOutputStream();
 
            //把输出流封装在DataOutputStream中
            DataOutputStream dos = new DataOutputStream(os);
            //使用writeUTF发送字符串
            dos.writeUTF("Legendary!");
            dos.close();
            s.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //客户端使用scanner方式读取数据 发送到服务器端
    public static void scanner() {
    	 
        try {
            Socket s = new Socket("127.0.0.1", 8888);
 
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
             
            //使用Scanner读取控制台的输入，并发送到服务端
            Scanner sc = new Scanner(System.in);
             
            String str = sc.next();
            dos.writeUTF(str);
             
            dos.close();
            s.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //练习 客户端和服务器 互相聊天 并能够持续下去
    public static void huliao() {
        try {
        	
        	Socket s= new Socket("127.0.0.1", 8888);
            OutputStream os = s.getOutputStream();
            DataOutputStream  dos = new DataOutputStream(os);//客户端向服务器发送数据的数据流
            //客户端读取服务器数据的数据流
            DataInputStream dis=new DataInputStream(s.getInputStream());
            System.out.println("聊天开始...");
            new Thread() {
            	public void run() {
		            while(true) {
		            	//使用Scanner读取控制台的输入，并发送到服务端
			            Scanner sc = new Scanner(System.in);
			            String str = sc.next();
			            try {
							dos.writeUTF(str);
						} catch (IOException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
		            }
            	}
            }.start();
            //新建一个线程 用于显示客户端收到的服务器的消息
            new Thread() {
            	public void run() {
            		while(true) {
						try {
							String msg = dis.readUTF();
		                	System.out.println("服务器消息："+msg);//如果不为空则把消息输出
						} catch (IOException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}//先检查是否有服务器的消息
            		}
            	}
            }.start();
	            
            
            //dos.close();
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