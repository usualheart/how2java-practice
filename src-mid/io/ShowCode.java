package io;
 
import java.io.UnsupportedEncodingException;
 
public class ShowCode {
 
    public static void main(String[] args) {
        String str = "中UTF-8编码";
        showCode(str);
    }
 
    private static void showCode(String str) {
        String[] encodes = { "BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32" };
        for (String encode : encodes) {
            showCode(str, encode);
        }
 
    }
 
    private static void showCode(String str, String encode) {
        try {
            byte[] bs = str.getBytes(encode);//得到字符串在某种编码方式下的字节数组

            System.out.printf("字符: \"%s\" 在%s下十六进制值:%n", str, encode);
            for (byte b : bs) {
                int i = b&0xff;
                System.out.print(Integer.toHexString(i) +" ");
            }
            System.out.println();
            
            //还原测试部分
            //byte还原为字符串
            // System.out.printf("%n还原后：%s%n",new String(bs,encode));
            byte[] ni=new byte[bs.length];//根据转化得到的int逆转化为byte数组
            System.out.println("逆16：");
            for (int j=0;j<bs.length;j++) {
                int i = bs[j]&0xff;
                ni[j]=(byte)i;
                int tmp=ni[j]&0xff;
                System.out.printf(Integer.toHexString(tmp) + " ");
            }
            System.out.printf("%n逆还原后：%s%n",new String(bs,encode));
            //说明只要将某字符的16进制编码按顺序还原为byte并组成数组即可正确还原
            
        } catch (UnsupportedEncodingException e) {
            System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n", encode, str);
        }
    }
}