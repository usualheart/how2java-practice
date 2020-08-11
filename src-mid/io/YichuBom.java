package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class YichuBom {
	//判断从文件读取的字符数组是否存在BOM标志
	public static boolean bomExist(byte[] x) {
		if(x[0]==(byte)0xef&&x[1]==(byte)0xbb&&x[2]==(byte)0xbf)
			return true;
		else return false;
	}
	//去除byte数组的BOM标志
		public static byte[] quBom(byte[] x) {
			byte[] ans=new byte[x.length-3];
			System.arraycopy(x, 3, ans, 0, ans.length);
			return ans;
		}

	//通过比较测试可发现BOM的3个byte的16进制表示分表为：ef bb bf
	public static void yichu() {
		//通过FileInputStream来读取字节流，并映射为中文
        File f11 = new File("D:/java-test/utf-8.txt");
        try (FileInputStream fis = new FileInputStream(f11);) {
            byte[] all = new byte[(int) f11.length()];
            fis.read(all);
   
            //显示文件中读出来的数据
            System.out.println("文件中读出来的数据是：");
            for (byte b : all)
            {	int i = b&0x000000ff;  //通过该操作保持byte二进制数据的一致性
                System.out.printf("%s ",Integer.toHexString(i));//以16进制形式输出
            }
            System.out.printf("%n");
            
            //检查是否存在bom标志，有则去除
            if(bomExist(all))all=quBom(all);
            
            //字节映射为字符
            System.out.printf("编码映射为UTF-8所表示的字符：%n");
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
