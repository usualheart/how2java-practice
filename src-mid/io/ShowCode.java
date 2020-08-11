package io;
 
import java.io.UnsupportedEncodingException;
 
public class ShowCode {
 
    public static void main(String[] args) {
        String str = "��UTF-8����";
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
            byte[] bs = str.getBytes(encode);//�õ��ַ�����ĳ�ֱ��뷽ʽ�µ��ֽ�����

            System.out.printf("�ַ�: \"%s\" ��%s��ʮ������ֵ:%n", str, encode);
            for (byte b : bs) {
                int i = b&0xff;
                System.out.print(Integer.toHexString(i) +" ");
            }
            System.out.println();
            
            //��ԭ���Բ���
            //byte��ԭΪ�ַ���
            // System.out.printf("%n��ԭ��%s%n",new String(bs,encode));
            byte[] ni=new byte[bs.length];//����ת���õ���int��ת��Ϊbyte����
            System.out.println("��16��");
            for (int j=0;j<bs.length;j++) {
                int i = bs[j]&0xff;
                ni[j]=(byte)i;
                int tmp=ni[j]&0xff;
                System.out.printf(Integer.toHexString(tmp) + " ");
            }
            System.out.printf("%n�滹ԭ��%s%n",new String(bs,encode));
            //˵��ֻҪ��ĳ�ַ���16���Ʊ��밴˳��ԭΪbyte��������鼴����ȷ��ԭ
            
        } catch (UnsupportedEncodingException e) {
            System.out.printf("UnsupportedEncodingException: %s���뷽ʽ�޷������ַ�%s\n", encode, str);
        }
    }
}