package io;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;


public class imageRenameAndYasuo {
	
	public static void yasuo(File[] fs) throws IOException {
		for(File f:fs) {
			//使用thumbnailator对图像进行等比例缩放和压缩
			Thumbnails.of(f)
				.scale(0.8)
				.outputQuality(0.5f) 
		    	.outputFormat("jpg")
		    	.toFile(f);
			System.out.println(f.getName()+"压缩成功！");
		}

		System.out.println("任务完成！");
	}
	
	//重命名某文件夹所有文件
	public static void rename(File[] fs) throws IOException {
		for(int i=0;i<fs.length;i++) {
			if(!fs[i].exists())
			  {
			   fs[i].createNewFile();
			  }
			  System.out.println("修改前文件名称是："+fs[i].getName());
			  String rootPath = fs[i].getParent();
			  System.out.println("根路径是："+rootPath);
			  File newFile = new File(rootPath + File.separator + i+".jpg");
			  System.out.println("修改后文件名称是："+newFile.getName());
			  if (fs[i].renameTo(newFile)) 
			  {
			   System.out.println("修改成功!");
			  } 
			  else 
			  {
			   System.out.println("修改失败");
			  }
		}
	}
	

	public static void main(String[] args) throws IOException {

		File f=new File("D:\\社会实践照片-余永博拍摄\\社会实践照片-余永博拍摄");
		File fs[]=f.listFiles();
		//rename(fs);
		yasuo(fs);
	}

}
