package io;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class XieruStream {
	public static void diguiMkdir(File fp) {
		if(!fp.exists())diguiMkdir(fp.getParentFile());
		fp.mkdir();
	}
	//把data数组的数据写入到str路径对应的文件
	public static void xieruFile(String str,byte[]data) {
		// 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
        //byte data[] = { 88, 89 };
		
		// TODO 自动生成的方法存根
		File f=new File(str);
		//以文件的形式返回父文件夹
		//File fp=f.getParentFile();
		//若父文件夹不存在，则创建
		diguiMkdir(f.getParentFile());
		//System.out.println(fp.getName()+fp.exists());
		try {
			// 创建基于文件的输出流
			FileOutputStream fos=new FileOutputStream(f);
			fos = new FileOutputStream(f);
			// 把数据写入到输出流
			fos.write(data);
	        // 关闭输出流
	        fos.close();
			} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			}
	}
	public static void main(String[] arg) {
		byte data[] = { 88, 89 };
		xieruFile("D:/xyz/def/ccc/lol.txt",data);
	}

}
