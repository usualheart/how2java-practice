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
	

	//判断文件中是否含有search字符串
	public static boolean existSearch(File f,String search) {
		boolean flag=false;
		try(
				FileReader fr=new FileReader(f);
		){
			char[] cubf=new char[(int) f.length()];
			fr.read(cubf);
			//String strf=cubf.toString();这种字符数组转字符串的方法是错误的
			String strf=new String(cubf);
			if(strf.indexOf(search)!=-1) flag=true;
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//假设你的项目目录是，遍历这个目录下所有的java文件（包括子文件夹），找出文件内容包括search( Magic)的那些文件，并打印出来。
	public static void search(File folder, String search) {
		if(folder.isFile()) 
			System.out.println("参数错误，应查找文件夹而非文件！");
        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        File[]fs= folder.listFiles();
        //遍历到空文件夹就返回，防止出错
        if(null==fs)return;
        //if(fs.length==0)return;
        for(int i=0;i<fs.length;i++) {
        	//输出遍历过程
        	//System.out.println(fs[i].getName());
        	if(fs[i].isFile()) {
        		//检查是否是java文件
        		String tmp=fs[i].getName();
        		if(tmp.indexOf(".java")==(tmp.length()-5)) {
        			//检查文件中是否含有seach字符串
        			if(existSearch(fs[i],search))
        				System.out.println("找到子目标字符串"+search+",在文件"+fs[i].getAbsolutePath());
        		}
        	}
        	else if(fs[i].isDirectory()){
        		search(fs[i],search);
        	}
        }
        return;
	}
	
	// 以多线程的方式遍历这个目录下所有的java文件（包括子文件夹），找出文件内容包括search( Magic)的那些文件，并打印出来。
	//当发现java文件时候创建一个新的线程进行筛选
		public static void searchThreadPool(File folder, String search) {
			if(folder.isFile()) 
				System.out.println("参数错误，应查找文件夹而非文件！");
	        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
	        File[]fs= folder.listFiles();
	        //遍历到空文件夹就返回，防止出错
	        if(null==fs)return;
	        //if(fs.length==0)return;
	        for(int i=0;i<fs.length;i++) {
	        	//输出遍历过程
	        	//System.out.println(fs[i].getName());
	        	if(fs[i].isFile()) {
	        		//检查是否是java文件
	        		String tmp=fs[i].getName();
	        		if(tmp.indexOf(".java")==(tmp.length()-5)) {
	        			File ftmp=fs[i];
	        			//检查文件中是否含有seach字符串，创建新的任务加入线程池
	        			Runnable r=new Runnable() {
	        				public void run() {
	        					if(existSearch(ftmp,search))
	    	        				System.out.println("找到子目标字符串"+search+",在文件"+ftmp.getAbsolutePath());
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
		//寻找存在特定字符串的java文件
		File f=new File("D:\\my document\\研究生学习\\JAVA学习\\java从入门到精通光盘\\TM（视频讲解及实例源程序）");
		
		long start=System.currentTimeMillis();
		search(f,"密码");
		long mid=System.currentTimeMillis();
		searchThreadPool(f,"密码");
		long end=System.currentTimeMillis();
		System.out.println("单线程查找时间是"+(mid-start)+"毫秒");
		//System.out.println("线程池查找时间是"+(end-mid)+"毫秒");
	}

}
