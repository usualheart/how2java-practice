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
		//test();//��������
		//shuzi();//�շ����ֵķ�������
		//zifuchuan();
		//huliao();//�ͻ��˺ͷ����� �������� ��ֹͣ
		jiqirenServer();//�򵥻����˻ظ���ͬʱ�������Ϳͻ���Ҳ���Ի�������
	}
	//��������
    public static void test()  {
        try {
            //����˴򿪶˿�8888
            ServerSocket ss = new ServerSocket(8888);
               
            //��8888�˿��ϼ��������Ƿ��������������
            System.out.println("�����ڶ˿ں�:8888");
            Socket s =  ss.accept();
               
            System.out.println("�����ӹ���" + s);
             
            s.close();
            ss.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
    }
    
    //�շ����ֵķ�������
    public static void shuzi() {
        try {
 
            ServerSocket ss = new ServerSocket(8888);
 
            System.out.println("�����ڶ˿ں�:8888");
            Socket s = ss.accept();
            
           
            //��������
            InputStream is = s.getInputStream();
            //��ȡ�ͻ��˷��͵�����
            int msg = is.read();
            //��ӡ����
            System.out.println(msg);
            is.close();
            s.close();
            ss.close();
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
    
    //�շ��ַ��� ʹ��������
    public static void zifuchuan() {
        try {
 
            ServerSocket ss = new ServerSocket(8888);
 
            System.out.println("�����ڶ˿ں�:8888");
            Socket s = ss.accept();
 
            InputStream is = s.getInputStream();
 
            //����������װ��DataInputStream
            DataInputStream dis = new DataInputStream(is);
            //ʹ��readUTF��ȡ�ַ���
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
    
    //�������� ��ֹͣ
    public static void huliao() {
        try {
 
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("�����ڶ˿ں�:8888");
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);//����������װ��DataInputStream
            OutputStream os = s.getOutputStream();
            DataOutputStream  dos = new DataOutputStream(os);//��������ͻ��˷������ݵ�������
           
            
            while(true) {
	            //ʹ��readUTF��ȡ�ַ��� ֻҪ�������������� ��Ҫ�������������ݲ����������
	            String msg = dis.readUTF();
	            System.out.println("�ͻ�����Ϣ��"+msg);
            	
	            //����һ���µ��߳� ���ڴӷ�������ͻ��˷�����Ϣ
	            new Thread() {
	            	public void run() {
	            		
			            try {
			            	//ʹ��Scanner��ȡ����̨�����룬�����͵��ͻ���
				            Scanner sc = new Scanner(System.in);
				            String str = sc.next();
							dos.writeUTF(str);
						} catch (IOException e) {
							// TODO �Զ����ɵ� catch ��
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
     * ������������˴���
     */
    //���ݿⲿ��
    static Connection c=null;//Ϊ�˶��ʹ��
    static PreparedStatement ps=null;//ps��ʽִ��sql���
    static Statement s1=null;
    //���ݿ�ĳ�ʼ������
    public static void init(){
        try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e1) {
    		// TODO �Զ����ɵ� catch ��
    		e1.printStackTrace();
    	}
        try {
        	//�˴���cû�йر� ��������� ���ݿ�����Ҫ��ʱ�ر�
    		c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
    		String sql="select * from dictionary where receive=?";
    		ps=c.prepareStatement(sql);
    		//s1=c.createStatement();
    	}catch (SQLException e1) {
    		e1.printStackTrace();
    	}
    }
    //���ݻظ���ѯ���ݿ����Ƿ��ж�Ӧ�Ļظ� �������Ӧ��Ӧ�Ļظ����򷵻�null
    public static String response(String receive){
    	String huifu=null;
		try {
			//��һ��ִ��sql�ķ�ʽ
			//ResultSet rs = s1.executeQuery("select * from dictionary where receive='"+receive+"'");
			//�ڶ���ִ�з�ʽ
			ps.setString(1, receive);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				huifu=rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return huifu;
    }
    //����������
    //��ϰ �򵥵���������� ��������
    public static void jiqirenServer() {
        try {
        	
        	 ServerSocket ss = new ServerSocket(8888);
             System.out.println("�����ڶ˿ں�:8888");
             Socket s = ss.accept();
             InputStream is = s.getInputStream();
             DataInputStream dis = new DataInputStream(is);//����������װ��DataInputStream
             OutputStream os = s.getOutputStream();
             DataOutputStream  dos = new DataOutputStream(os);//��������ͻ��˷������ݵ�������
            
            init();//�����ݿ���г�ʼ������
            //����һ���µ��߳� ���ڽ��տͻ�����Ϣ ������Ӧ�Ĵ���
            new Thread() {
	        	public void run() {
		            while(true) {
		            	try {
				            //ʹ��readUTF��ȡ�ַ��� ֻҪ�������������� ��Ҫ�������������ݲ����������
				            String msg = dis.readUTF();
				            System.out.println("�ͻ�����Ϣ��"+msg);
				            //�õ����ݿ���Ӧ�ظ���Ϣ ��������������
				            String response=response(msg);
				            if(null!=response)
				            	dos.writeUTF(response);
						} catch (IOException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
		            }
	        	}
            }.start();
            	
	        //����һ���µ��߳� ���ڴӷ�������ͻ��˷�����Ϣ
	        new Thread() {
	        	public void run() {
	        		while(true) {
		        		try {
			            	//ʹ��Scanner��ȡ����̨�����룬�����͵��ͻ���
				            Scanner sc = new Scanner(System.in);
				            String str = sc.next();
							dos.writeUTF(str);
						} catch (IOException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
	        		}
	        	}
	        }.start();
            
            //dos.close();//��ʱ�Ȳ��ر�
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