package io;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class XieruStream {
	public static void diguiMkdir(File fp) {
		if(!fp.exists())diguiMkdir(fp.getParentFile());
		fp.mkdir();
	}
	//��data���������д�뵽str·����Ӧ���ļ�
	public static void xieruFile(String str,byte[]data) {
		// ׼��������2���ֽ����飬��88,89��ʼ�������Ӧ���ַ��ֱ���X,Y
        //byte data[] = { 88, 89 };
		
		// TODO �Զ����ɵķ������
		File f=new File(str);
		//���ļ�����ʽ���ظ��ļ���
		//File fp=f.getParentFile();
		//�����ļ��в����ڣ��򴴽�
		diguiMkdir(f.getParentFile());
		//System.out.println(fp.getName()+fp.exists());
		try {
			// ���������ļ��������
			FileOutputStream fos=new FileOutputStream(f);
			fos = new FileOutputStream(f);
			// ������д�뵽�����
			fos.write(data);
	        // �ر������
	        fos.close();
			} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			}
	}
	public static void main(String[] arg) {
		byte data[] = { 88, 89 };
		xieruFile("D:/xyz/def/ccc/lol.txt",data);
	}

}
