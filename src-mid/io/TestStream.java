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
            // ���������ļ���������
            FileInputStream fis = new FileInputStream(f);
            // ͨ��������������Ϳ��԰����ݴ�Ӳ�̣���ȡ��Java�������������Ҳ���Ƕ�ȡ���ڴ���
 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //�����ļ��������
        try {
            File f = new File("d:/lol.txt");
            // ���������ļ��������
            FileOutputStream fos = new FileOutputStream(f);
            // ͨ�������������Ϳ��԰����ݴ��ڴ棬�����Ӳ�̵��ļ���
  
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //���ֽ�������ʽ��ȡ�ļ�
        try {
            //׼���ļ�lol.txt���е�������AB����Ӧ��ASCII�ֱ���65 66
            File f =new File("d:/java-test/lol.txt");
            //���������ļ���������
            FileInputStream fis =new FileInputStream(f);
            //�����ֽ����飬�䳤�Ⱦ����ļ��ĳ���
            byte[] all =new byte[(int) f.length()];
            //���ֽ�������ʽ��ȡ�ļ���������
            fis.read(all);
            for (byte b : all) {
                //��ӡ������65 66
                System.out.println(b);
            }
             
            //ÿ��ʹ����������Ӧ�ý��йر�
            fis.close();
              
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //���ֽ�����ʽд���ļ�
        try {
            // ׼���ļ�lol2.txt���е������ǿյ�
            File f = new File("d:/java-test/lol2.txt");
            // ׼��������2���ֽ����飬��88,89��ʼ�������Ӧ���ַ��ֱ���X,Y
            byte data[] = { 88, 89 };
 
            // ���������ļ��������
            FileOutputStream fos = new FileOutputStream(f);
            // ������д�뵽�����
            fos.write(data);
            // �ر������
            fos.close();
             
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
       
        
     // ���������ļ���Reader,fr��try()��ʽ�Զ��ر�
     // ׼���ļ�lol.txt���е�������AB
        File f = new File("d:/java-test/lol.txt");
        try (FileReader fr = new FileReader(f)) {
            // �����ַ����飬�䳤�Ⱦ����ļ��ĳ���
            char[] all = new char[(int) f.length()];
            // ���ַ�������ʽ��ȡ�ļ���������
            fr.read(all);
            for (char b : all) {
                // ��ӡ������A B
                System.out.println(b);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        // ׼���ļ�lol2.txt
        File f1 = new File("d:/java-test/lolzifu.txt");
        // ���������ļ���Writer
        try (FileWriter fr = new FileWriter(f1)) {
            // ���ַ�������ʽ������д�뵽�ļ���
            String data="��abcdefg1234567890";
            char[] cs = data.toCharArray();
            fr.write(cs);
  
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
        //ͨ��FileInputStream����ȡ�ֽ�������ӳ��Ϊ����
        File f11 = new File("D:/java-test/lian.txt");
        try (FileInputStream fis = new FileInputStream(f11);) {
            byte[] all = new byte[(int) f11.length()];
            fis.read(all);
   
            //��ʾ�ļ��ж�����������
            System.out.println("�ļ��ж������������ǣ�");
            for (byte b : all)
            {
                int i = b&0x000000ff;  //ͨ���ò�������byte���������ݵ�һ����
            	//int i=b;
                System.out.println(Integer.toHexString(i));//��16������ʽ���
            }
            
            //�ֽ�ӳ��Ϊ�ַ�
            System.out.println("����ӳ��ΪUTF-8����ʾ���ַ���");
            String str = new String(all,"UTF-8");//UTF-8��ȡʱ����ʱ���һ���ַ����˸��������ٶȽ��
          
            System.out.println(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
        //FileReader�ǲ����ֶ����ñ��뷽ʽ�ģ�Ϊ��ʹ�������ı��뷽ʽ��ֻ��ʹ��InputStreamReader������
        //����ʹ��new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); ��������ʽ
        //ͨ��InputStreamReader��ȡ�ַ� ���Reader���������ڿ����Զ�����뷽ʽ
        System.out.println("Ĭ�ϱ��뷽ʽ:"+Charset.defaultCharset());
        //FileReader�õ������ַ�������һ�����Ѿ����ֽڸ���ĳ�ֱ���ʶ������ַ���
        //��FileReaderʹ�õı��뷽ʽ��Charset.defaultCharset()�ķ���ֵ����������ĵĲ���ϵͳ������GBK
        File f111 = new File("D:/java-test/lol.txt");
        try (InputStreamReader fis = new InputStreamReader(new FileInputStream(f111),Charset.forName("UTF-8"))) {
            char[] all = new char[(int) f111.length()];
            fis.read(all);
   
            //��ʾ�ļ��ж�����������
            System.out.println("�ļ��ж��������ַ��ǣ�");
            for (char b : all)
            {
                System.out.print(b);
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
        //����������
        // ׼���ļ�lol.txt���е�������
        // garen kill teemo
        // teemo revive after 1 minutes
        // teemo try to garen, but killed again
        File f1111 = new File("d:/java-test/lolbuffer.txt");
        // �����ļ��ַ���
        // ���������뽨����һ�����ڵ����Ļ�����
        try (
                FileReader fr = new FileReader(f1111);
                BufferedReader br = new BufferedReader(fr);
            )
        {
            while (true) {
                // һ�ζ�һ��
                String line = br.readLine();
                if (null == line)
                    break;
                System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
     // ʹ�û�����д�����ݣ����ļ�lol2.txt��д���������
        File f22 = f1111;
         //try()��ʽ�Զ��ر���
        try (
                // �����ļ��ַ���
                FileWriter fw = new FileWriter(f22);
                // ���������뽨����һ�����ڵ����Ļ�����              
                PrintWriter pw = new PrintWriter(fw);              
        ) {
            pw.println("?garen kill teemo");
            //ǿ�ưѻ����е�����д��Ӳ�̣����ۻ����Ƿ�����
            pw.flush();     
            pw.println("!teemo revive after 1 minutes");
            //ǿ�ưѻ����е�����д��Ӳ�̣����ۻ����Ƿ�����
            pw.flush();     
            pw.println("!teemo try to garen, but killed again");
            //ǿ�ưѻ����е�����д��Ӳ�̣����ۻ����Ƿ�����
            pw.flush();     
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}