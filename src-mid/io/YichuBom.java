package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class YichuBom {
	//�жϴ��ļ���ȡ���ַ������Ƿ����BOM��־
	public static boolean bomExist(byte[] x) {
		if(x[0]==(byte)0xef&&x[1]==(byte)0xbb&&x[2]==(byte)0xbf)
			return true;
		else return false;
	}
	//ȥ��byte�����BOM��־
		public static byte[] quBom(byte[] x) {
			byte[] ans=new byte[x.length-3];
			System.arraycopy(x, 3, ans, 0, ans.length);
			return ans;
		}

	//ͨ���Ƚϲ��Կɷ���BOM��3��byte��16���Ʊ�ʾ�ֱ�Ϊ��ef bb bf
	public static void yichu() {
		//ͨ��FileInputStream����ȡ�ֽ�������ӳ��Ϊ����
        File f11 = new File("D:/java-test/utf-8.txt");
        try (FileInputStream fis = new FileInputStream(f11);) {
            byte[] all = new byte[(int) f11.length()];
            fis.read(all);
   
            //��ʾ�ļ��ж�����������
            System.out.println("�ļ��ж������������ǣ�");
            for (byte b : all)
            {	int i = b&0x000000ff;  //ͨ���ò�������byte���������ݵ�һ����
                System.out.printf("%s ",Integer.toHexString(i));//��16������ʽ���
            }
            System.out.printf("%n");
            
            //����Ƿ����bom��־������ȥ��
            if(bomExist(all))all=quBom(all);
            
            //�ֽ�ӳ��Ϊ�ַ�
            System.out.printf("����ӳ��ΪUTF-8����ʾ���ַ���%n");
            String str = new String(all,"UTF-8");
          
            System.out.println(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	public static void  main(String[] args) {
		yichu();
	}
}
