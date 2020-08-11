package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Shu162Zhongwen {
	
	
	//将16进制字符转换为对应的整型十进制数字
	public static int char2Int(char x) {
		int ans=0;
        if(x>='0'&&x<='9') ans=(int)(x-'0');
        else if(x>='a'&&x<='f') ans=(int)(x-'a'+10);
        else if(x>='A'&&x<='F') ans=(int)(x-'A'+10);
		return ans;
    }
	//将表示16进制的字符数组转化为对应含义的byte数组
	public static byte[] chars2Bytes(char[]chars) {
		byte[]ans=new byte[chars.length/2];
		int tmp;//tmp存储美两个16进制字符所对应的十进制
		for(int i=0;i<chars.length;i+=2) {
			tmp=16*char2Int(chars[i])+char2Int(chars[i+1]);
			ans[i/2]=(byte)tmp;//转为（byte），并装进数组
		}
		return ans;
	}
	//将文件f111的16进制字符表示为对应编码的字符
	public static void showZifu(File f111,String encode) {
		// TODO 自动生成的方法存根
		 
	        try (InputStreamReader fis = new InputStreamReader(new FileInputStream(f111),Charset.forName("GBK"))) {
	            char[] all = new char[(int) f111.length()];
	            fis.read(all);
	            //显示文件中读出来的数据
	            System.out.println("文件中读出来的字符是：");
	            for (int i=0;i<all.length;i++)
	            { 	System.out.print(all[i]);
	            }
            	System.out.println();
            	//转为byte数组
	            byte[] ans=chars2Bytes(all);
	            //表示为对应的字符并输出
	            System.out.printf("表示的字符是：%n%s%n",new String(ans,encode));
	            
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
