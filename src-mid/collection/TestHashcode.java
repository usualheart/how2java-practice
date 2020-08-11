package collection;
import shuzizifuchuan.PojieMima;
public class TestHashcode {
	
	//生成自定义的Hashcode
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
	//生成随机长度2-10的字符串100个，打印自定义的Hashcode
	public static void showHashcode() {
		for(int i=0;i<100;i++) {
			int len=(int) (Math.random()*9+2);
			String str=PojieMima.suistr(len);
			System.out.print(str+"\t"+hashcode(str)+"\t");
			if((i+1)%10==0)System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		showHashcode();
	}

}
