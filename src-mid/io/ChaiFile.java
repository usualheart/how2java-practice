package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import io.XieruStream;
public class ChaiFile {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//���ֽ�������ʽ��ȡ�ļ�
		//���������ļ���������,������ͨ��finally��ʽ�ر�
        FileInputStream fis =null;
        try {
        	String str="D:/xyz/st.zip";
            //׼��һ������100k���ļ���ͨ���������ļ���byte����
            File f =new File(str);
            //���������ļ���������
           // FileInputStream fis =new FileInputStream(f);
            fis =new FileInputStream(f);
            //�����ֽ����飬�䳤�Ⱦ����ļ��ĳ���
            byte[] all =new byte[(int) f.length()];
            //���ֽ�������ʽ��ȡ�ļ���������
            fis.read(all);
            //ÿ��ʹ����������Ӧ�ý��йرգ�����try�йر�
            //fis.close();
            
            //���д���ļ�
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
            System.out.println("�ļ���ֳɹ���"); 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
        	if(null!=fis) {
        		//finally��ʽ�ر���
        		try {
					fis.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
        	}
        }
	}

}
