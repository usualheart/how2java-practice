package collection;
import shuzizifuchuan.PojieMima;
public class TestHashcode {
	
	//�����Զ����Hashcode
	public static int hashcode(String str) {
		int tmp=0;
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			tmp+=c;
		}
		tmp*=23;
		if(tmp>1999)tmp%=2000;
		if(tmp<0)tmp=-tmp;
		return tmp;
	}
	//�����������2-10���ַ���100������ӡ�Զ����Hashcode
	public static void showHashcode() {
		for(int i=0;i<100;i++) {
			int len=(int) (Math.random()*9+2);
			String str=PojieMima.suistr(len);
			System.out.print(str+"\t"+hashcode(str)+"\t");
			if((i+1)%10==0)System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		showHashcode();
	}

}
