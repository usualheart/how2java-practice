package io;
import java.io.File;
import java.io.IOException;
import java.util.Date;
  
public class TestFile {
  
    public static void main(String[] args) {
        // ����·�������·��
        File f1 = new File("d:/LOLFolder");
        System.out.println("f1�ľ���·����" + f1.getAbsolutePath());
        // ���·��,����ڹ���Ŀ¼�������eclipse�У�������ĿĿ¼
        File f2 = new File("LOL.exe");
        System.out.println("f2�ľ���·����" + f2.getAbsolutePath());
        // ��f1��Ϊ��Ŀ¼�����ļ�����
        File f3 = new File(f1, "LOL.exe");
        System.out.println("f3�ľ���·����" + f3.getAbsolutePath());
       
        
        File f = new File("d:/DOTA.exe");
        System.out.println("��ǰ�ļ��ǣ�" +f);
        //�ļ��Ƿ����
        System.out.println("�ж��Ƿ���ڣ�"+f.exists());
        //�Ƿ����ļ���
        System.out.println("�ж��Ƿ����ļ��У�"+f.isDirectory());
        //�Ƿ����ļ������ļ��У�
        System.out.println("�ж��Ƿ����ļ���"+f.isFile());
        //�ļ�����
        System.out.println("��ȡ�ļ��ĳ��ȣ�"+f.length());
        //�ļ�����޸�ʱ��
        long time = f.lastModified();
        Date d = new Date(time);
        System.out.println("��ȡ�ļ�������޸�ʱ�䣺"+d);
        //�����ļ��޸�ʱ��Ϊ1970.1.1 08:00:00
        f.setLastModified(0);
        //�ļ�������
        File f21 =new File("d:/DOTA.txt");
        f.renameTo(f21);//renameTo�������ڶ������ļ����ƽ����޸ģ����ǲ������޸�File�����name���ԡ�
        System.out.println("��"+f.getName()+"��������DOTA.txt");
        System.out.println("ע�⣺ ��Ҫ��D:\\LOLFolderȷʵ����һ��LOL.exe,\r\n�ſ��Կ�����Ӧ���ļ����ȡ��޸�ʱ�����Ϣ");
       
        File f11 = new File("d:/LOLFolder/skin/garen.ski");
        
        // ���ַ����������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
        f11.list();
        // ���ļ��������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
        File[]fs= f11.listFiles();
        // ���ַ�����ʽ���ػ�ȡ�����ļ���
        f11.getParent();
        // ���ļ���ʽ���ػ�ȡ�����ļ���
        f11.getParentFile();
        
        // �����ļ��У�������ļ���skin�����ڣ���������Ч
        f11.mkdir();
        // �����ļ��У�������ļ���skin�����ڣ��ͻᴴ�����ļ���
        f11.mkdirs();
        
        // ����һ�����ļ�,������ļ���skin�����ڣ��ͻ��׳��쳣
        try {
			f11.createNewFile();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
        // ���Դ���һ�����ļ�֮ǰ��ͨ�����ᴴ����Ŀ¼
        f11.getParentFile().mkdirs();
        // �г����е��̷�c: d: e: �ȵ�
        f11.listRoots();
        // �h���ļ�
        f11.delete();
        // JVM������ʱ�򣬄h���ļ�����������ʱ�ļ���ɾ��
        f11.deleteOnExit();
                
            
        
    }
}