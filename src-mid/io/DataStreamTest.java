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
//要用DataInputStream 读取一个文件，这个文件必须是由DataOutputStream 写出的，
//否则会出现EOFException，因为DataOutputStream 在写出的时候会做一些特殊标记，只有DataInputStream 才能成功的读取。
public class DataStreamTest {
      
    public static void main(String[] args) {
        write();
        read();
        
        System.out.println("通过缓存流存取两个整数：");
        File f =new File("d:/java-test/lol2.txt");
        writebyBuffer(f,1000111000,250);
        readbyBuffer(f);
    }
    //通过数据流读文件中的数据，该文件必须是数据流写入的
    private static void read() {
        File f =new File("d:/java-test/lol.txt");
        try (
                FileInputStream fis  = new FileInputStream(f);
                DataInputStream dis =new DataInputStream(fis);
        ){
            boolean b= dis.readBoolean();
            System.out.println("读取到布尔值:"+b);
            int i = dis.readInt();            
            System.out.println("读取到整数:"+i);
            int j = dis.readInt();
            System.out.println("读取到整数:"+j);
            String str = dis.readUTF();
            System.out.println("读取到字符串:"+str);
 
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    }
    //通过数据流向文件写数据
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
    //通过缓存流向文件写入两个整数，需要做标记来区分，比如@
    public static void writebyBuffer(File file,int x,int y) {
    	try (
                // 创建文件字符流
                FileWriter fw = new FileWriter(file);
                // 缓存流必须建立在一个存在的流的基础上 
    			//BufferedWriter bw=new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(fw);              
        ) {
            pw.println(x);
           // pw.println('@');
            pw.println(y);
            //强制把缓存中的数据写入硬盘，无论缓存是否已满
            pw.flush();     
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
  //通过缓存流向文件读入两个整数,并输出
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
    		
    		System.out.printf("%d %d%n和：%d%n",x,y,x+y);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }

  //通过缓存流向文件写入并读取两个整数,并输出的第二种方法
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
        System.out.printf("使用缓存流读取出的x是 %d y是 %d%n",a,b);
         
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}
}