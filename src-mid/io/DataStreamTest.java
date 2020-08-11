package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//Ҫ��DataInputStream ��ȡһ���ļ�������ļ���������DataOutputStream д���ģ�
//��������EOFException����ΪDataOutputStream ��д����ʱ�����һЩ�����ǣ�ֻ��DataInputStream ���ܳɹ��Ķ�ȡ��
public class DataStreamTest {
      
    public static void main(String[] args) {
        write();
        read();
        
        System.out.println("ͨ����������ȡ����������");
        File f =new File("d:/java-test/lol2.txt");
        writebyBuffer(f,1000111000,250);
        readbyBuffer(f);
    }
    //ͨ�����������ļ��е����ݣ����ļ�������������д���
    private static void read() {
        File f =new File("d:/java-test/lol.txt");
        try (
                FileInputStream fis  = new FileInputStream(f);
                DataInputStream dis =new DataInputStream(fis);
        ){
            boolean b= dis.readBoolean();
            System.out.println("��ȡ������ֵ:"+b);
            int i = dis.readInt();            
            System.out.println("��ȡ������:"+i);
            int j = dis.readInt();
            System.out.println("��ȡ������:"+j);
            String str = dis.readUTF();
            System.out.println("��ȡ���ַ���:"+str);
 
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    }
    //ͨ�����������ļ�д����
    private static void write() {
        File f =new File("d:/java-test/lol.txt");
        try (
                FileOutputStream fos  = new FileOutputStream(f);
                DataOutputStream dos =new DataOutputStream(fos);
        ){	
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeInt(900);
            dos.writeUTF("123 this is gareen");
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    }
    //ͨ�����������ļ�д��������������Ҫ����������֣�����@
    public static void writebyBuffer(File file,int x,int y) {
    	try (
                // �����ļ��ַ���
                FileWriter fw = new FileWriter(file);
                // ���������뽨����һ�����ڵ����Ļ����� 
    			//BufferedWriter bw=new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(fw);              
        ) {
            pw.println(x);
           // pw.println('@');
            pw.println(y);
            //ǿ�ưѻ����е�����д��Ӳ�̣����ۻ����Ƿ�����
            pw.flush();     
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
  //ͨ�����������ļ�������������,�����
    public static void readbyBuffer(File file) {
    	try(
    			FileReader fr=new FileReader(file);
    			BufferedReader br=new BufferedReader(fr);
    			){
    		int x,y;
    		String tmp;
    		tmp=br.readLine();
    		x=Integer.parseInt(tmp);
    		tmp=br.readLine();
    		y=Integer.parseInt(tmp);
    		
    		System.out.printf("%d %d%n�ͣ�%d%n",x,y,x+y);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }

  //ͨ�����������ļ�д�벢��ȡ��������,������ĵڶ��ַ���
private static void method1(File f,int x,int y) {
    try (
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);                
             
    ) {
        pw.print(x+"@"+y);
        pw.flush();
        String str = br.readLine();
        String[] ss =str.split("@");
        int a = Integer.parseInt(ss[0]);
        int b = Integer.parseInt(ss[1]);
        System.out.printf("ʹ�û�������ȡ����x�� %d y�� %d%n",a,b);
         
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}
}