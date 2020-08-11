package io;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
//System.out 是常用的在控制台输出数据的 
//System.in 可以从控制台输入数据

public class TestSystemin {

    public static void main(String[] args) {
    	//scannerIn();
    	//readIn();
    	autoClass();
    }
    //通过Scanner和System.in输入数据
    public static void scannerIn() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入整数：");
        int a = s.nextInt();
        System.out.println("第一个整数："+a);
        int b = s.nextInt();
        System.out.println("第二个整数："+b);
    }
    
    //通过System.in的read方法读入数据
    public static void readIn() {
        // 控制台输入
        try (InputStream is = System.in;) {

            System.out.println("请输入数据：");
            while (true) {
                // 敲入a,然后敲回车可以看到
                // 97 13 10
                // 97是a的ASCII码
                // 13 10分别对应回车换行
                int i = is.read();//i为所输入数据对应的ASCI码
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  //根据模板自动创建类
    public static void autoClass() {
    	String classNew,typeNew,propertyNew;
    	Scanner in=new Scanner(System.in);
    	System.out.println("请输入类名：");
    	classNew=in.nextLine();
    	System.out.println("请输入属性类型：");
    	typeNew=in.nextLine();
    	System.out.println("请输出属性名称：");
    	propertyNew=in.nextLine();
    	
    	File f=new File("D:/java-test/autoclass.txt");
    	File classFile=new File("D:/java-test/autoclass.java");
    	try (	FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);   
                FileWriter fw = new FileWriter(classFile);
                PrintWriter pw = new PrintWriter(fw);
        ) {
            /*for(char s:cbuf) {
            	System.out.println(s);
            }*/
    		String str;
            do {
            
            str=br.readLine();
        	//System.out.println(str);
            String ss[]=null;
            if(null!=str) {
                ss=str.split("@");
                String tmp=tihuan(ss,classNew,typeNew,propertyNew);//得到替换结果

            	System.out.print(tmp);
                pw.println(tmp);
                }
            }while(null!=str);
                pw.flush();
            	System.out.println("自动创建类成功！");
                
    	}
            
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //对模板中相应的字符串进行替换,并返回连接成的字符串
    public static String tihuan( String[] ss,String classNew,String typeNew,String propertyNew) {
    	StringBuffer sb=new StringBuffer();
    	for(int i=0;i<ss.length;i++) {
    		if(ss[i].equals("class"))ss[i]=classNew;
    		if(ss[i].equals("property")||ss[i].equals("Uproperty"))ss[i]=propertyNew;
    		if(ss[i].equals("type"))ss[i]=typeNew;
    		sb.append(ss[i]);
    	}
    	System.out.println();
    	return sb.toString();
    }
    
    //根据模板自动创建类,方法1 char[] toString方法似乎有问题 无法使用
    public static void autoClass1() {
    	File f=new File("D:/java-test/autoclass.txt");
    	File classFile=new File("D:/java-test/autoclass.java");
    	try (	FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);   
                FileWriter fw = new FileWriter(classFile);
                PrintWriter pw = new PrintWriter(fw);
        ) {	char[] cbuf = new char[(int) f.length()];;
            br.read(cbuf);
            /*for(char s:cbuf) {
            	System.out.println(s);
            }*/
            String str=cbuf.toString();
        	System.out.println(str);
            String ss[]=str.split("@");
            for(String s:ss) {
            	System.out.println(s);
            }
           // ss=tihuan(ss);//得到替换结果
            pw.write(ss.toString());
            pw.flush();
        	System.out.println("自动创建类成功！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
}