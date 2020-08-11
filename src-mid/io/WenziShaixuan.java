package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class WenziShaixuan {
	//从txt文本中读取文本信息  使用hashSet对文字进行去重 每个文字只保留一个 对最终结果进行显示
	public static void main(String[] args) {
		File f=new File("D:\\java-test\\WenziShaixuan.txt");
		//HashSet 用于筛选掉重复的字符
		HashSet<Character>wenzi=new HashSet<Character>();
		try(FileReader fr=new FileReader(f)){
			char all[]=new char[(int) f.length()];
			fr.read(all);
			for(int i=0;i<all.length;i++) {
				wenzi.add(all[i]);
			}
			int i=0;
			for(char tmp:wenzi) {
				System.out.print(tmp);
				i++;
				if(i%20==0)System.out.println();
			}
			System.out.printf("%n原有字数：%d%n去重后：%d  比例：%.2f",all.length,wenzi.size(),(double)((double)all.length/(double)wenzi.size()));
			
		}  catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
