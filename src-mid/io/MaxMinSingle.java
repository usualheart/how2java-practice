package io;
import java.io.File;
public class MaxMinSingle {
	
	public static void find(String url) {
		// TODO �Զ����ɵķ������
		File f=new File(url);
        // ���ļ��������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
        File[]fs= f.listFiles();
        int max=0,min=0;
        for(int i=0;i<fs.length;i++) {
        	if(fs[i].length()>fs[max].length())max=i;
        	if(fs[i].length()<fs[min].length()&&fs[i].length()!=0)min=i;
        	/*//����ļ�������
        	System.out.printf("%s\t",fs[i].getName());
        	if((i+1)%3==0)System.out.println();
        	*/
        }
        System.out.printf("�����ļ�Ϊ%s,����Ϊ%d%n",fs[max].getName(),fs[max].length());
        System.out.printf("��С���ļ�Ϊ%s,����Ϊ%d%n",fs[min].getName(),fs[min].length());
	}
	public static void main(String[] args) {
		MaxMinSingle.find("D:\\Ѹ������");
	}

}
