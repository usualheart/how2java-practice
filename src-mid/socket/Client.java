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
		//test();//��������
		//shuzi();//�շ����ֵķ�������
		//zifuchuan();//ʹ����������������
		//scanner();//ʹ��scanner��ȡ���� ͨ�����������͵������� Ȼ��
		huliao();//��������  
	}
    public static void test()  {
           
        try {
            //���ӵ�������8888�˿�
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
 
            // �������
            OutputStream os = s.getOutputStream();
 
            // ��������110�������
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
 
            //���������װ��DataOutputStream��
            DataOutputStream dos = new DataOutputStream(os);
            //ʹ��writeUTF�����ַ���
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
    
    //�ͻ���ʹ��scanner��ʽ��ȡ���� ���͵���������
    public static void scanner() {
    	 
        try {
            Socket s = new Socket("127.0.0.1", 8888);
 
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
             
            //ʹ��Scanner��ȡ����̨�����룬�����͵������
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
    
    //��ϰ �ͻ��˺ͷ����� �������� ���ܹ�������ȥ
    public static void huliao() {
        try {
        	
        	Socket s= new Socket("127.0.0.1", 8888);
            OutputStream os = s.getOutputStream();
            DataOutputStream  dos = new DataOutputStream(os);//�ͻ�����������������ݵ�������
            //�ͻ��˶�ȡ���������ݵ�������
            DataInputStream dis=new DataInputStream(s.getInputStream());
            System.out.println("���쿪ʼ...");
            new Thread() {
            	public void run() {
		            while(true) {
		            	//ʹ��Scanner��ȡ����̨�����룬�����͵������
			            Scanner sc = new Scanner(System.in);
			            String str = sc.next();
			            try {
							dos.writeUTF(str);
						} catch (IOException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
		            }
            	}
            }.start();
            //�½�һ���߳� ������ʾ�ͻ����յ��ķ���������Ϣ
            new Thread() {
            	public void run() {
            		while(true) {
						try {
							String msg = dis.readUTF();
		                	System.out.println("��������Ϣ��"+msg);//�����Ϊ�������Ϣ���
						} catch (IOException e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}//�ȼ���Ƿ��з���������Ϣ
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