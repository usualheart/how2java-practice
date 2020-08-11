package kongzhi;

public class huangjin {
	int a,b;
	double juli(double i,double j) {
		double zhi=i/j;
		zhi=zhi-0.618;
		if(zhi<0)zhi=-zhi;
		return zhi;
	}
	void bianli() {
		double i,j;
		double min=20,zhi=20;
		for(i=1;i<=20;i++) {
			for(j=1;j<=20;j++) {
				zhi=juli(i,j);
				if(zhi<min) {min=zhi;a=(int)i;b=(int) j;}
			}
		}
	}
	
	public static void main(String[] args) {
		huangjin s=new huangjin();
		s.bianli();
		System.out.println(s.a+"/"+s.b);
	}
}
