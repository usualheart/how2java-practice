package io;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
//System.out �ǳ��õ��ڿ���̨������ݵ� 
//System.in ���Դӿ���̨��������

public class TestSystemin {

    public static void main(String[] args) {
    	//scannerIn();
    	//readIn();
    	autoClass();
    }
    //ͨ��Scanner��System.in��������
    public static void scannerIn() {
        Scanner s = new Scanner(System.in);
        System.out.println("������������");
        int a = s.nextInt();
        System.out.println("��һ��������"+a);
        int b = s.nextInt();
        System.out.println("�ڶ���������"+b);
    }
    
    //ͨ��System.in��read������������
    public static void readIn() {
        // ����̨����
        try (InputStream is = System.in;) {

            System.out.println("���������ݣ�");
            while (true) {
                // ����a,Ȼ���ûس����Կ���
                // 97 13 10
                // 97��a��ASCII��
                // 13 10�ֱ��Ӧ�س�����
                int i = is.read();//iΪ���������ݶ�Ӧ��ASCI��
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  //����ģ���Զ�������
    public static void autoClass() {
    	String classNew,typeNew,propertyNew;
    	Scanner in=new Scanner(System.in);
    	System.out.println("������������");
    	classNew=in.nextLine();
    	System.out.println("�������������ͣ�");
    	typeNew=in.nextLine();
    	System.out.println("������������ƣ�");
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
                String tmp=tihuan(ss,classNew,typeNew,propertyNew);//�õ��滻���

            	System.out.print(tmp);
                pw.println(tmp);
                }
            }while(null!=str);
                pw.flush();
            	System.out.println("�Զ�������ɹ���");
                
    	}
            
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //��ģ������Ӧ���ַ��������滻,���������ӳɵ��ַ���
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
    
    //����ģ���Զ�������,����1 char[] toString�����ƺ������� �޷�ʹ��
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
           // ss=tihuan(ss);//�õ��滻���
            pw.write(ss.toString());
            pw.flush();
        	System.out.println("�Զ�������ɹ���");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
}