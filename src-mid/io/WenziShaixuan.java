package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class WenziShaixuan {
	//��txt�ı��ж�ȡ�ı���Ϣ  ʹ��hashSet�����ֽ���ȥ�� ÿ������ֻ����һ�� �����ս��������ʾ
	public static void main(String[] args) {
		File f=new File("D:\\java-test\\WenziShaixuan.txt");
		//HashSet ����ɸѡ���ظ����ַ�
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
			System.out.printf("%nԭ��������%d%nȥ�غ�%d  ������%.2f",all.length,wenzi.size(),(double)((double)all.length/(double)wenzi.size()));
			
		}  catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}

}
