package shuzizifuchuan;

public class math {
	double ans=0;
	//计算与e的绝对差值
	public double jueduicha(double x) {
		x=x-Math.E;
		if(x<0)x=-x;
		return x;
	}
	//计算e
	public void ee(double n) {
		double tt=0;
		//tt=Math.pow(Math.pow((double)(1+1/n), n/10),10);
		do{
		ans=tt;
		tt=Math.pow((double)(1+1/n), n);
		n++;
		}while(jueduicha(tt)<jueduicha(ans));
	}
	//判断是否为质数
	public boolean  zhi(int x) {
		boolean flag=true;
		int sqrt5=(int) Math.sqrt(x)+5;
		for(int i=2;i<sqrt5&&i<x;i++) {//i<Math.sqrt(x)+2&&
			if(x%i==0) {flag=false;break;}
		}
		//if(x==2)flag=true;
		return flag;
	}
	//找出小于某数的质数 并统计个数
	public int zhishunum(int x) {
		int sum=0;
		for(int i=2;i<=x;i++) {
			if(zhi(i)==true) {sum++;System.out.println(i);}
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		float f1 = 5.4f;
	    float f2 = 5.5f;
	    //5.4四舍五入即5
	    System.out.println(Math.round(f1));
	    //5.5四舍五入即6
	    System.out.println(Math.round(f2));
	     
	    //得到一个0-1之间的随机浮点数（取不到1）
	    System.out.println(Math.random());
	     
	    //得到一个0-10之间的随机整数 （取不到10）
	    System.out.println((int)( Math.random()*10));
	    //开方
	    System.out.println(Math.sqrt(9));
	    //次方（2的4次方）
	    System.out.println(Math.pow(2,4));
	     
	    //π
	    System.out.println(Math.PI);
	     
	    //自然常数
	    System.out.println(Math.E);	
	    
	    
	    //练习 数学方法
	    math ee=new math();
	    ee.ee(Integer.MAX_VALUE);
	    System.out.println(ee.ans);
	    
	    //输出1000万以内的质数个数
	    System.out.println(ee.zhishunum(100));
	}

}
