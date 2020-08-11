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
		// �����ļ��ַ���
        // ���������뽨����һ�����ڵ����Ļ�����
        try (
                FileReader fr = new FileReader(javaFile);
                BufferedReader br = new BufferedReader(fr);
        		FileWriter fw=new FileWriter(javaFileAns);
        		PrintWriter pw=new PrintWriter(fw);
            )
        {
            while (true) {
                // һ�ζ�һ��
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
		// TODO �Զ����ɵķ������
		File java=new File("D:/java-test/ApHero.java");
		File javaans=new File("D:/java-test/ApHeroAns.java");
		removeComments(java,javaans);
	}

}
