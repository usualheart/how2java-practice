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
	//拷贝文件的方法
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
				System.out.println("拷贝成功！");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		
	}
	
	
	//复制文件夹，把源文件夹下所有的文件 复制到目标文件夹下(包括子文件夹)
	public static void copyFolder(String srcFolder, String destFolder){
		File sFolder=new File(srcFolder);
		File dFolder=new File(destFolder);
		
		//若目标文件夹为空，进行创建
		if(!dFolder.exists()) dFolder.mkdirs();
		File sFiles[]=sFolder.listFiles();
		for(int i=0;i<sFiles.length;i++) {
			System.out.println(sFiles[i].getAbsolutePath());
			if(sFiles[i].isFile())copyFile(sFiles[i].getAbsolutePath(),destFolder+sFiles[i].getName());
			else copyFolder(sFiles[i].getAbsolutePath(),destFolder+sFiles[i].getName()+"/");
		}
	}
	
	
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
		public static void searchMultiplethead(File folder, String search) {
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
	        			//检查文件中是否含有seach字符串，创建新的线程
	        			Thread t=new Thread() {
	        				public void run() {
	        					if(existSearch(ftmp,search))
	    	        				System.out.println("找到子目标字符串"+search+",在文件"+ftmp.getAbsolutePath());
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
		// TODO 自动生成的方法存根
		//copyFile("D:/java-test/whoareyou.exe","D:\\win10 Download\\lol2.exe");
		//copyFolder("D:\\my document\\研究生学习\\周报相关\\","D:/java-test/down/2/1/");
		
		//寻找存在特定字符串的java文件
		File f=new File("D:\\my document\\研究生学习\\JAVA学习\\java从入门到精通光盘\\TM（视频讲解及实例源程序）");
		long start=System.currentTimeMillis();
		search(f,"密码");
		long mid=System.currentTimeMillis();
		searchMultiplethead(f,"密码");
		long end=System.currentTimeMillis();
		System.out.println("单线程查找时间是"+(mid-start)+"毫秒");
		System.out.println("多线程查找时间是"+(end-mid)+"毫秒");
	}

}
