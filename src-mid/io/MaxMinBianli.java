package io;

import java.io.File;

public class MaxMinBianli {
	public static File findMax(File Dir) {
		if(Dir.isFile()) {
			System.out.println("参数错误，应查找文件夹而非文件！");
			return Dir;
		}
        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        File[]fs= Dir.listFiles();
      //遍历到空文件夹就返回，防止出错
        if(fs==null)return Dir;
        if(fs.length==0)return Dir;
        File max=fs[0];
        for(int i=0;i<fs.length;i++) {
        	//输出遍历过程
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
			System.out.println("参数错误，应查找文件夹而非文件！");
			return Dir;
		}
        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        File[]fs= Dir.listFiles();
        //遍历到空文件夹就返回，防止出错

        if(fs==null)return Dir;
        if(fs.length==0)return Dir;
        
        /*
        //输出每次得到的文件数组
        for (File f : fs){  
            System.out.println(f);  
        }
        System.out.println();
        */
        
        //min可能被指向了文件夹，在下边if中添加||min.isDirectory()判断来更新min指向文件
        File min=fs[0];
        for(int i=0;i<fs.length;i++) {
        	//输出遍历过程
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
		// TODO 自动生成的方法存根
		String url="D:\\迅雷下载";
		File f=new File(url);
		f=MaxMinBianli.findMax(f);
		System.out.printf("最大文件：%n"+f.getName()+
				"%n大小：%.2fMB\t是否为文件夹：%s%n",(double)(f.length())/1024/1024,f.isDirectory());
		f=new File(url);
		f=MaxMinBianli.findMin(f);
		System.out.printf("最小文件：%n"+f.getName()+
				"%n大小：%d字节\t是否为文件：%s%n",f.length(),f.isFile());
	}

}
