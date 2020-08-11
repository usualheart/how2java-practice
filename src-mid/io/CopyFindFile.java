package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyFindFile {
	//�����ļ��ķ���
	public static void copyFile(String srcFile, String destFile){
		File sFile=new File(srcFile);
		File dFile=new File(destFile);
		try(
				FileInputStream fis=new FileInputStream(sFile);
				//BufferedReader br=new BufferedReader(fr);
				FileOutputStream fos=new FileOutputStream(dFile);
				//PrintWriter pw= new PrintWriter(fw);
			){	byte tmp[]=new byte[(int) sFile.length()];
				fis.read(tmp);
				fos.write(tmp);
				System.out.println("�����ɹ���");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		
	}
	
	
	//�����ļ��У���Դ�ļ��������е��ļ� ���Ƶ�Ŀ���ļ�����(�������ļ���)
	public static void copyFolder(String srcFolder, String destFolder){
		File sFolder=new File(srcFolder);
		File dFolder=new File(destFolder);
		
		//��Ŀ���ļ���Ϊ�գ����д���
		if(!dFolder.exists()) dFolder.mkdirs();
		File sFiles[]=sFolder.listFiles();
		for(int i=0;i<sFiles.length;i++) {
			System.out.println(sFiles[i].getAbsolutePath());
			if(sFiles[i].isFile())copyFile(sFiles[i].getAbsolutePath(),destFolder+sFiles[i].getName());
			else copyFolder(sFiles[i].getAbsolutePath(),destFolder+sFiles[i].getName()+"/");
		}
	}
	
	
	//�ж��ļ����Ƿ���search�ַ���
	public static boolean existSearch(File f,String search) {
		boolean flag=false;
		try(
				FileReader fr=new FileReader(f);
		){
			char[] cubf=new char[(int) f.length()];
			fr.read(cubf);
			//String strf=cubf.toString();�����ַ�����ת�ַ����ķ����Ǵ����
			String strf=new String(cubf);
			if(strf.indexOf(search)!=-1) flag=true;
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//���������ĿĿ¼�ǣ��������Ŀ¼�����е�java�ļ����������ļ��У����ҳ��ļ����ݰ���search( Magic)����Щ�ļ�������ӡ������
	public static void search(File folder, String search) {
		if(folder.isFile()) 
			System.out.println("��������Ӧ�����ļ��ж����ļ���");
        // ���ļ��������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
        File[]fs= folder.listFiles();
        //���������ļ��оͷ��أ���ֹ����
        if(null==fs)return;
        //if(fs.length==0)return;
        for(int i=0;i<fs.length;i++) {
        	//�����������
        	//System.out.println(fs[i].getName());
        	if(fs[i].isFile()) {
        		//����Ƿ���java�ļ�
        		String tmp=fs[i].getName();
        		if(tmp.indexOf(".java")==(tmp.length()-5)) {
        			//����ļ����Ƿ���seach�ַ���
        			if(existSearch(fs[i],search))
        				System.out.println("�ҵ���Ŀ���ַ���"+search+",���ļ�"+fs[i].getAbsolutePath());
        		}
        	}
        	else if(fs[i].isDirectory()){
        		search(fs[i],search);
        	}
        }
        return;
	}
	
	// �Զ��̵߳ķ�ʽ�������Ŀ¼�����е�java�ļ����������ļ��У����ҳ��ļ����ݰ���search( Magic)����Щ�ļ�������ӡ������
	//������java�ļ�ʱ�򴴽�һ���µ��߳̽���ɸѡ
		public static void searchMultiplethead(File folder, String search) {
			if(folder.isFile()) 
				System.out.println("��������Ӧ�����ļ��ж����ļ���");
	        // ���ļ��������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
	        File[]fs= folder.listFiles();
	        //���������ļ��оͷ��أ���ֹ����
	        if(null==fs)return;
	        //if(fs.length==0)return;
	        for(int i=0;i<fs.length;i++) {
	        	//�����������
	        	//System.out.println(fs[i].getName());
	        	if(fs[i].isFile()) {
	        		//����Ƿ���java�ļ�
	        		String tmp=fs[i].getName();
	        		if(tmp.indexOf(".java")==(tmp.length()-5)) {
	        			File ftmp=fs[i];
	        			//����ļ����Ƿ���seach�ַ����������µ��߳�
	        			Thread t=new Thread() {
	        				public void run() {
	        					if(existSearch(ftmp,search))
	    	        				System.out.println("�ҵ���Ŀ���ַ���"+search+",���ļ�"+ftmp.getAbsolutePath());
	        				}
	        			};
	        			t.start();
	        		}
	        	}
	        	else if(fs[i].isDirectory()){
	        		searchMultiplethead(fs[i],search);
	        	}
	        }
	        return;
		}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//copyFile("D:/java-test/whoareyou.exe","D:\\win10 Download\\lol2.exe");
		//copyFolder("D:\\my document\\�о���ѧϰ\\�ܱ����\\","D:/java-test/down/2/1/");
		
		//Ѱ�Ҵ����ض��ַ�����java�ļ�
		File f=new File("D:\\my document\\�о���ѧϰ\\JAVAѧϰ\\java�����ŵ���ͨ����\\TM����Ƶ���⼰ʵ��Դ����");
		long start=System.currentTimeMillis();
		search(f,"����");
		long mid=System.currentTimeMillis();
		searchMultiplethead(f,"����");
		long end=System.currentTimeMillis();
		System.out.println("���̲߳���ʱ����"+(mid-start)+"����");
		System.out.println("���̲߳���ʱ����"+(end-mid)+"����");
	}

}
