package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestException {
	private static void method1() {
        try {
            method2();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
 
    private static void method2() throws FileNotFoundException {
 
        File f = new File("d:/LOL.txt");
 
        System.out.println("��ͼ�� d:/LOL.txt");
        new FileInputStream(f);
        System.out.println("�ɹ���");
 
    }

	public static void main(String[] args) {

		File f = new File("d:/LOL.txt");

		try {
			System.out.println("��ͼ�� d:/LOL.txt");
			new FileInputStream(f);
			System.out.println("�ɹ���");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse("2016-06-03");
		} catch (FileNotFoundException | ParseException e) {
            if (e instanceof FileNotFoundException)
                System.out.println("d:/LOL.exe������");
            if (e instanceof ParseException)
                System.out.println("���ڸ�ʽ��������");
 
            e.printStackTrace();
        } 
		finally{
            System.out.println("�����ļ��Ƿ���ڣ� ����ִ�еĴ���");
        }
		method1();
	}
}
