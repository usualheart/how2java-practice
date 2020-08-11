package multiplethread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FindFileThreadPool {
	

	public static ThreadPoolExecutor threadPool=new ThreadPoolExecutor(10,20,0,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
	

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
		public static void searchThreadPool(File folder, String search) {
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
	        			//����ļ����Ƿ���seach�ַ����������µ���������̳߳�
	        			Runnable r=new Runnable() {
	        				public void run() {
	        					if(existSearch(ftmp,search))
	    	        				System.out.println("�ҵ���Ŀ���ַ���"+search+",���ļ�"+ftmp.getAbsolutePath());
	        				}
	        			};
	        			threadPool.execute(r);
	        		}
	        	}
	        	else if(fs[i].isDirectory()){
	        		File tmpfsi=fs[i];
	        		threadPool.execute(new Runnable() {
	        			public void run() {
	        				searchThreadPool(tmpfsi,search);
	        			}
	        		});
	        	}
	        }
	        return;
		}
	public static void main(String[] args) {
		//Ѱ�Ҵ����ض��ַ�����java�ļ�
		File f=new File("D:\\my document\\�о���ѧϰ\\JAVAѧϰ\\java�����ŵ���ͨ����\\TM����Ƶ���⼰ʵ��Դ����");
		
		long start=System.currentTimeMillis();
		search(f,"����");
		long mid=System.currentTimeMillis();
		searchThreadPool(f,"����");
		long end=System.currentTimeMillis();
		System.out.println("���̲߳���ʱ����"+(mid-start)+"����");
		//System.out.println("�̳߳ز���ʱ����"+(end-mid)+"����");
	}

}
