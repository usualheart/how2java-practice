package io;
import java.io.File;
public class MaxMinSingle {
	
	public static void find(String url) {
		// TODO 自动生成的方法存根
		File f=new File(url);
        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
        File[]fs= f.listFiles();
        int max=0,min=0;
        for(int i=0;i<fs.length;i++) {
        	if(fs[i].length()>fs[max].length())max=i;
        	if(fs[i].length()<fs[min].length()&&fs[i].length()!=0)min=i;
        	/*//输出文件夹内容
        	System.out.printf("%s\t",fs[i].getName());
        	if((i+1)%3==0)System.out.println();
        	*/
        }
        System.out.printf("最大的文件为%s,长度为%d%n",fs[max].getName(),fs[max].length());
        System.out.printf("最小的文件为%s,长度为%d%n",fs[min].getName(),fs[min].length());
	}
	public static void main(String[] args) {
		MaxMinSingle.find("D:\\迅雷下载");
	}

}
