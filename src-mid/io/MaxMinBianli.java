package io;

import java.io.File;

public class MaxMinBianli {
	public static File findMax(File Dir) {
		if(Dir.isFile()) {
			System.out.println("��������Ӧ�����ļ��ж����ļ���");
			return Dir;
		}
        // ���ļ��������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
        File[]fs= Dir.listFiles();
      //���������ļ��оͷ��أ���ֹ����
        if(fs==null)return Dir;
        if(fs.length==0)return Dir;
        File max=fs[0];
        for(int i=0;i<fs.length;i++) {
        	//�����������
        	//System.out.println(fs[i].getName());
        	if(fs[i].isFile()) {
        		if(fs[i].length()>max.length())max=fs[i];
        	}
        	else if(fs[i].isDirectory()){
        		File tmp=findMax(fs[i]);
        		if(tmp.length()>max.length()&&tmp.isFile())max=tmp;
        	}
        }
        return max;
	}
	public static File findMin(File Dir) {
		if(Dir.isFile()) {
			System.out.println("��������Ӧ�����ļ��ж����ļ���");
			return Dir;
		}
        // ���ļ��������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
        File[]fs= Dir.listFiles();
        //���������ļ��оͷ��أ���ֹ����

        if(fs==null)return Dir;
        if(fs.length==0)return Dir;
        
        /*
        //���ÿ�εõ����ļ�����
        for (File f : fs){  
            System.out.println(f);  
        }
        System.out.println();
        */
        
        //min���ܱ�ָ�����ļ��У����±�if�����||min.isDirectory()�ж�������minָ���ļ�
        File min=fs[0];
        for(int i=0;i<fs.length;i++) {
        	//�����������
        	//System.out.println(fs[i].getName());
        	if(fs[i].isFile()) {
        		
        		if(fs[i].length()<min.length()&&fs[i].length()!=0||min.isDirectory())min=fs[i];
        	}
        	else if(fs[i].isDirectory()){
        		File tmp=findMin(fs[i]);
        		if(tmp.length()<min.length()&&tmp.isFile()&&tmp.length()!=0||min.isDirectory())min=tmp;
        	}
        }
        return min;
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String url="D:\\Ѹ������";
		File f=new File(url);
		f=MaxMinBianli.findMax(f);
		System.out.printf("����ļ���%n"+f.getName()+
				"%n��С��%.2fMB\t�Ƿ�Ϊ�ļ��У�%s%n",(double)(f.length())/1024/1024,f.isDirectory());
		f=new File(url);
		f=MaxMinBianli.findMin(f);
		System.out.printf("��С�ļ���%n"+f.getName()+
				"%n��С��%d�ֽ�\t�Ƿ�Ϊ�ļ���%s%n",f.length(),f.isFile());
	}

}
