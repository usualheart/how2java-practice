package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
public class TestStream {
 
    public static void main(String[] args) {
       
    	try {
            File f = new File("d:/java-test/lol1.txt");
            // 创建基于文件的输入流
            FileInputStream fis = new FileInputStream(f);
            // 通过这个输入流，就可以把数据从硬盘，读取到Java的虚拟机中来，也就是读取到内存中
 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //基于文件的输出流
        try {
            File f = new File("d:/lol.txt");
            // 创建基于文件的输出流
            FileOutputStream fos = new FileOutputStream(f);
            // 通过这个输出流，就可以把数据从内存，输出到硬盘的文件上
  
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //以字节流的形式读取文件
        try {
            //准备文件lol.txt其中的内容是AB，对应的ASCII分别是65 66
            File f =new File("d:/java-test/lol.txt");
            //创建基于文件的输入流
            FileInputStream fis =new FileInputStream(f);
            //创建字节数组，其长度就是文件的长度
            byte[] all =new byte[(int) f.length()];
            //以字节流的形式读取文件所有内容
            fis.read(all);
            for (byte b : all) {
                //打印出来是65 66
                System.out.println(b);
            }
             
            //每次使用完流，都应该进行关闭
            fis.close();
              
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //以字节流形式写入文件
        try {
            // 准备文件lol2.txt其中的内容是空的
            File f = new File("d:/java-test/lol2.txt");
            // 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
            byte data[] = { 88, 89 };
 
            // 创建基于文件的输出流
            FileOutputStream fos = new FileOutputStream(f);
            // 把数据写入到输出流
            fos.write(data);
            // 关闭输出流
            fos.close();
             
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
       
        
     // 创建基于文件的Reader,fr以try()方式自动关闭
     // 准备文件lol.txt其中的内容是AB
        File f = new File("d:/java-test/lol.txt");
        try (FileReader fr = new FileReader(f)) {
            // 创建字符数组，其长度就是文件的长度
            char[] all = new char[(int) f.length()];
            // 以字符流的形式读取文件所有内容
            fr.read(all);
            for (char b : all) {
                // 打印出来是A B
                System.out.println(b);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        // 准备文件lol2.txt
        File f1 = new File("d:/java-test/lolzifu.txt");
        // 创建基于文件的Writer
        try (FileWriter fr = new FileWriter(f1)) {
            // 以字符流的形式把数据写入到文件中
            String data="我abcdefg1234567890";
            char[] cs = data.toCharArray();
            fr.write(cs);
  
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
        //通过FileInputStream来读取字节流，并映射为中文
        File f11 = new File("D:/java-test/lian.txt");
        try (FileInputStream fis = new FileInputStream(f11);) {
            byte[] all = new byte[(int) f11.length()];
            fis.read(all);
   
            //显示文件中读出来的数据
            System.out.println("文件中读出来的数据是：");
            for (byte b : all)
            {
                int i = b&0x000000ff;  //通过该操作保持byte二进制数据的一致性
            	//int i=b;
                System.out.println(Integer.toHexString(i));//以16进制形式输出
            }
            
            //字节映射为字符
            System.out.println("编码映射为UTF-8所表示的字符：");
            String str = new String(all,"UTF-8");//UTF-8读取时候有时候第一个字符多了个“？”百度解决
          
            System.out.println(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
        //FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替
        //并且使用new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); 这样的形式
        //通过InputStreamReader读取字符 这比Reader的优势在于可以自定义编码方式
        System.out.println("默认编码方式:"+Charset.defaultCharset());
        //FileReader得到的是字符，所以一定是已经把字节根据某种编码识别成了字符了
        //而FileReader使用的编码方式是Charset.defaultCharset()的返回值，如果是中文的操作系统，就是GBK
        File f111 = new File("D:/java-test/lol.txt");
        try (InputStreamReader fis = new InputStreamReader(new FileInputStream(f111),Charset.forName("UTF-8"))) {
            char[] all = new char[(int) f111.length()];
            fis.read(all);
   
            //显示文件中读出来的数据
            System.out.println("文件中读出来的字符是：");
            for (char b : all)
            {
                System.out.print(b);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
        //缓存输入流
        // 准备文件lol.txt其中的内容是
        // garen kill teemo
        // teemo revive after 1 minutes
        // teemo try to garen, but killed again
        File f1111 = new File("d:/java-test/lolbuffer.txt");
        // 创建文件字符流
        // 缓存流必须建立在一个存在的流的基础上
        try (
                FileReader fr = new FileReader(f1111);
                BufferedReader br = new BufferedReader(fr);
            )
        {
            while (true) {
                // 一次读一行
                String line = br.readLine();
                if (null == line)
                    break;
                System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
     // 使用缓存流写入数据，向文件lol2.txt中写入三行语句
        File f22 = f1111;
         //try()方式自动关闭流
        try (
                // 创建文件字符流
                FileWriter fw = new FileWriter(f22);
                // 缓存流必须建立在一个存在的流的基础上              
                PrintWriter pw = new PrintWriter(fw);              
        ) {
            pw.println("?garen kill teemo");
            //强制把缓存中的数据写入硬盘，无论缓存是否已满
            pw.flush();     
            pw.println("!teemo revive after 1 minutes");
            //强制把缓存中的数据写入硬盘，无论缓存是否已满
            pw.flush();     
            pw.println("!teemo try to garen, but killed again");
            //强制把缓存中的数据写入硬盘，无论缓存是否已满
            pw.flush();     
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}