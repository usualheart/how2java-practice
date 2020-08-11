package shuzu;

public class ShuzuYiwei {
	public int length;
	public int a[];
	//初始化一定长度数组
	public  ShuzuYiwei() {
	}
	public  ShuzuYiwei(int len) {
		length=len;
		a=new int[len];
	}
	//初始化一定长度数组
	public void init(int len) {
			length=len;
			a=new int[len];
		}
	//输出数组
	public void shuchu() {
		for(int i=0;i<length;i++) {
			System.out.println(i+"的值:"+a[i]);
		}
	}
	//随机生成数组,
	public void suiji() {
		for(int i=0;i<length;i++) {
			a[i]=(int)(Math.random()*10000);
		}
	}
	//常规for找最小值,返回数组下标
	public int min() {
		int min=0;
		for(int i=0;i<length;i++) {
			if(a[i]<a[min])min=i;
		}
		return min;
	}
	//增强for找最小值，返回最小值
	public int minx() {
		int min=a[0];
		for(int zhi:a) {
			if(zhi<min)min=zhi;
		}
		return min;
	}
	//反转数组的值
	public void fanzhuan() {
		int tmp;
		for(int i=0;i<length/2;i++){
			tmp=a[i];
			a[i]=a[length-1-i];
			a[length-1-i]=tmp;
		}
	}
	//选择法排序 由小到大
	public void xuanze() {
		int tmp;
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++) {
				if(a[j]<a[i]) {
					tmp=a[i];
					a[i]=a[j];
					a[j]=tmp;
				}
			}
		}
	}
	//冒泡法排序 由小到大
	public void maopao() {
		int i,j,tmp;
		for(i=0;i<length;i++) {
			for(j=1;j<length-i;j++) {
				if(a[j]<a[j-1]) {
					tmp=a[j-1];
					a[j-1]=a[j];
					a[j]=tmp;				
				}
			}
		}
	}
	public static void main(String[] args) {
		/*
		ShuzuYiwei m =new ShuzuYiwei();
		m.suiji(10);
		m.shuchu();
		//两种方法输出最小值
		System.out.println(m.min()+" "+m.a[m.min()]);
		System.out.println(m.minx());
		m.fanzhuan();
		m.shuchu();
		*/
		ShuzuYiwei n1=new ShuzuYiwei();
		n1.init(5+(int)(Math.random()*5));
		n1.suiji();
		System.out.println("n1");
		n1.shuchu();
		ShuzuYiwei n2=new ShuzuYiwei();
		n2.init(5+(int)(Math.random()*5));
		n2.suiji();
		System.out.println("n2");
		n2.shuchu();
		
		ShuzuYiwei ans=new ShuzuYiwei();
		ans.init(n1.length+n2.length);
		System.arraycopy(n1.a, 0, ans.a, 0, n1.length);
		System.arraycopy(n2.a, 0, ans.a, n1.length, n2.length);
		System.out.println("n3");
		ans.shuchu();	
	}
}