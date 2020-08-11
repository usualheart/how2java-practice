package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import io.XieruStream;
public class ChaiFile {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//以字节流的形式读取文件
		//创建基于文件的输入流,可用于通过finally方式关闭
        FileInputStream fis =null;
        try {
        	String str="D:/xyz/st.zip";
            //准备一个大于100k的文件，通过流读入文件到byte数组
            File f =new File(str);
            //创建基于文件的输入流
           // FileInputStream fis =new FileInputStream(f);
            fis =new FileInputStream(f);
            //创建字节数组，其长度就是文件的长度
            byte[] all =new byte[(int) f.length()];
            //以字节流的形式读取文件所有内容
            fis.read(all);
            //每次使用完流，都应该进行关闭，这是try中关闭
            //fis.close();
            
            //拆分写入文件
            str=f.getParentFile().getAbsolutePath();
            int i=0,len;
            while(i<all.length) {
            	if(i+102400<=all.length)len=102400;
            	else len=all.length-i;
            	byte[] tmp=new byte[len];
            	System.arraycopy(all, i, tmp, 0, len);
            	XieruStream.xieruFile(str+"/"+i/102400,tmp);
            	i+=102400;
            }
            System.out.println("文件拆分成功！"); 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
        	if(null!=fis) {
        		//finally方式关闭流
        		try {
					fis.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
        	}
        }
	}

}
