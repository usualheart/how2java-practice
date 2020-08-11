package io;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QuchuZhushi {
	public static boolean isZhushi(String str) {
		boolean flag=false;

		if(null==str) return flag;
		char[] chars=str.toCharArray();
		for(int i=0;i<chars.length-1;i++) {
			if(chars[i]=='/'&&chars[i+1]=='/') {
				flag=true;
				break;
			}
			if((chars[i]>='a'&&chars[i+1]<='z')||(chars[i]>='A'&&chars[i+1]<='Z')) {
				flag=false;
				break;
			}
		}
		return flag;
	}
	public static void removeComments(File javaFile,File javaFileAns) {
		// 创建文件字符流
        // 缓存流必须建立在一个存在的流的基础上
        try (
                FileReader fr = new FileReader(javaFile);
                BufferedReader br = new BufferedReader(fr);
        		FileWriter fw=new FileWriter(javaFileAns);
        		PrintWriter pw=new PrintWriter(fw);
            )
        {
            while (true) {
                // 一次读一行
                String line = br.readLine();
                if (null == line)break;
                if(isZhushi(line)) System.out.println(line);
                else pw.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		File java=new File("D:/java-test/ApHero.java");
		File javaans=new File("D:/java-test/ApHeroAns.java");
		removeComments(java,javaans);
	}

}
