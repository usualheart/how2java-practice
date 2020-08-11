package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Shu162Zhongwen {
	
	
	//��16�����ַ�ת��Ϊ��Ӧ������ʮ��������
	public static int char2Int(char x) {
		int ans=0;
        if(x>='0'&&x<='9') ans=(int)(x-'0');
        else if(x>='a'&&x<='f') ans=(int)(x-'a'+10);
        else if(x>='A'&&x<='F') ans=(int)(x-'A'+10);
		return ans;
    }
	//����ʾ16���Ƶ��ַ�����ת��Ϊ��Ӧ�����byte����
	public static byte[] chars2Bytes(char[]chars) {
		byte[]ans=new byte[chars.length/2];
		int tmp;//tmp�洢������16�����ַ�����Ӧ��ʮ����
		for(int i=0;i<chars.length;i+=2) {
			tmp=16*char2Int(chars[i])+char2Int(chars[i+1]);
			ans[i/2]=(byte)tmp;//תΪ��byte������װ������
		}
		return ans;
	}
	//���ļ�f111��16�����ַ���ʾΪ��Ӧ������ַ�
	public static void showZifu(File f111,String encode) {
		// TODO �Զ����ɵķ������
		 
	        try (InputStreamReader fis = new InputStreamReader(new FileInputStream(f111),Charset.forName("GBK"))) {
	            char[] all = new char[(int) f111.length()];
	            fis.read(all);
	            //��ʾ�ļ��ж�����������
	            System.out.println("�ļ��ж��������ַ��ǣ�");
	            for (int i=0;i<all.length;i++)
	            { 	System.out.print(all[i]);
	            }
            	System.out.println();
            	//תΪbyte����
	            byte[] ans=chars2Bytes(all);
	            //��ʾΪ��Ӧ���ַ������
	            System.out.printf("��ʾ���ַ��ǣ�%n%s%n",new String(ans,encode));
	            
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	public static void main(String[] args) {
		File f111 = new File("D:/java-test/lian.txt");
		showZifu(f111,"UTF-8");
	}
	

}
