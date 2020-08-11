package io;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;


public class imageRenameAndYasuo {
	
	public static void yasuo(File[] fs) throws IOException {
		for(File f:fs) {
			//ʹ��thumbnailator��ͼ����еȱ������ź�ѹ��
			Thumbnails.of(f)
				.scale(0.8)
				.outputQuality(0.5f) 
		    	.outputFormat("jpg")
		    	.toFile(f);
			System.out.println(f.getName()+"ѹ���ɹ���");
		}

		System.out.println("������ɣ�");
	}
	
	//������ĳ�ļ��������ļ�
	public static void rename(File[] fs) throws IOException {
		for(int i=0;i<fs.length;i++) {
			if(!fs[i].exists())
			  {
			   fs[i].createNewFile();
			  }
			  System.out.println("�޸�ǰ�ļ������ǣ�"+fs[i].getName());
			  String rootPath = fs[i].getParent();
			  System.out.println("��·���ǣ�"+rootPath);
			  File newFile = new File(rootPath + File.separator + i+".jpg");
			  System.out.println("�޸ĺ��ļ������ǣ�"+newFile.getName());
			  if (fs[i].renameTo(newFile)) 
			  {
			   System.out.println("�޸ĳɹ�!");
			  } 
			  else 
			  {
			   System.out.println("�޸�ʧ��");
			  }
		}
	}
	

	public static void main(String[] args) throws IOException {

		File f=new File("D:\\���ʵ����Ƭ-����������\\���ʵ����Ƭ-����������");
		File fs[]=f.listFiles();
		//rename(fs);
		yasuo(fs);
	}

}
