package shuzizifuchuan;
import java.util.Scanner;

import collection.MyStringBufferCollection;
public class PojieMima {
	char ans[];
	int j=0;
	//找出大写或数字组成字符数组
	public void shai(char[] x) {
		j=0;
		ans=new char[x.length];
		for(int i=0;i<x.length;i++) {
			if(Character.isUpperCase(x[i])||Character.isDigit(x[i]))ans[j++]=x[i];
		}
	}
	//随机生成大小写或数字字符
	public static char suichar() {
		int x=(int)(Math.random()*62);
		if(x<=9)x+=48;
		else if(x<=35)x+=55;
		else x+=61;
		return (char)x;
	}
	//随机生成大小写字符
		public char suiZimu() {
			int x=(int)(Math.random()*52);
			x+=10;//x直接变为10-61
			if(x<=35)x+=55;
			else x+=61;
			return (char)x;
		}
	//生成若干位的字符串
	public static String suistr(int n) {
		char x;
		char[] charzu=new char[n];
		for(int i=0;i<n;i++) {
			x=suichar();//可选字母还是含数字
			charzu[i]=x;
		}
		String str=String.copyValueOf(charzu);
		return str;
	}
	//生成m位 长度为n的字符串 数组
	public static String[] suiStrArray(int m,int n) {
		String strs[]=new String[m];
		for(int i=0;i<m;i++) {
			strs[i]=suistr(n);
		}
		strShuchu(strs);
		return strs;
	}
	//字符比较算法，忽略大小写 A=a,m<n输出true
	public boolean charBijiao(char m,char n) {
		if(m>='a'&&m<='z')m-=32;
		if(n>='a'&&n<='z')n-=32;
		if(m<n)return true;
		else return false;
	}
	//对字符串数组进行排序，直接排序
	public String[] strArrayPaixu(String[] strarray) {
		String tmp;
		for(int i=0;i<strarray.length;i++) {
			int min=i;
			for(int j=i+1;j<strarray.length;j++) {
				if(charBijiao(strarray[j].charAt(0),strarray[min].charAt(0)))min=j;
			}
			tmp=strarray[i];
			strarray[i]=strarray[min];
			strarray[min]=tmp;
		}
		return strarray;
	}
	
	//将0-61数字映射为数字或大小写字母
	public static char yingshe(int x) {
		if(x<=9)x+=48;
		else if(x<=35)x+=55;
		else x+=61;
		return (char) x;
	}
	//穷举生成长度是3的字符串，破解密码并返回尝试次数
	public char[] qiongju(String mima) {
		char[] charzu=new char[3];
		boolean flag=false;
		for(int i=0;i<62;i++) {
			if(flag)break;
			charzu[0]=yingshe(i);
			for(int j=0;j<62;j++) {
				if(flag)break;
				charzu[1]=yingshe(j);
				for(int k=0;k<62;k++) {
					if(flag)break;
					charzu[2]=yingshe(k);
					String str=String.copyValueOf(charzu);
					//System.out.printf("%c %c %c %s %n",charzu[0],charzu[1],charzu[2],str);//输出匹配过程
					if(str.equals(mima))flag=true;
					
				}
			}
		}
		return charzu;
	}
	//递归穷举破解n位密码

	char[] diguians;
	boolean flag;
	public void qiongn(int n,String mima) {
		if(n==mima.length()) {diguians=new char[n];flag=false;}
		if(n==0) {
			String str=String.copyValueOf(diguians);
			if(str.equals(mima))flag=true;
		}
		else {
			for(int i=0;i<62;i++) {
				if(flag)break;
				diguians[mima.length()-n]=yingshe(i);
				qiongn(n-1,mima);
				//输出当前已经穷举的程度
				if(n==mima.length())System.out.printf("已穷举：%d%% %n",i*100/62);
			}
		}
	}
	//输出字符串数组
	public static void strShuchu(String[]strs) {
		System.out.println("输出字符串数组：");
		for(int i=0;i<strs.length;i++) {
			System.out.print(strs[i]+" ");
			if((i+1)%12==0)System.out.println();
		}
	}
	public static void main(String[] args) {
		/*
		System.out.println("请输入字符串：");
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		char[] cs=str.toCharArray();
		*/
		PojieMima zi=new PojieMima();
		//zi.shai(cs);
		//System.out.println(zi.ans);
		//随机生成5位字符串并输出
		String str=zi.suistr(10);
		System.out.println(str);
		
		//string 和stringbuffer连接10000次字符串并计算时间
		String str1 = "the";
        StringBuffer sb = new StringBuffer(str1);
        MyStringBuffer msb=new MyStringBuffer(str1);
        MyStringBufferCollection msbc=new MyStringBufferCollection(str1);
        
        //直接连接测试时间
        long begin1=System.currentTimeMillis();
        for(int i=0;i<10000;i++) {
        	str1+=str;
        }
        
        //StringBuffer测试时间
        long begin2=System.currentTimeMillis();
        for(int i=0;i<1000000;i++) {
        	sb.append(str);
        }
        
        //MyStringBuffer测试时间
        long begin3=System.currentTimeMillis();
        for(int i=0;i<10000;i++) {
        	msb.append(str);
        }
        
        //MyStringBufferCollection测试时间
        long begin4=System.currentTimeMillis();
        for(int i=0;i<1000000;i++) {
        	msbc.append(str);
        }
        long begin5=System.currentTimeMillis();
        //System.out.println(sb);
        System.out.printf("使用+"
        		+ "的方式1万次消耗%d毫秒%n",begin2-begin1);
        System.out.printf("使用StringBuffer"
        		+ "的方式100万次消耗%d毫秒%n",begin3-begin2);
        System.out.printf("使用MyStringBuffer"
        		+ "的方式1万次消耗%d毫秒%n",begin4-begin3);
        System.out.printf("使用MyStringBufferCollection"
        		+ "的方式100万次消耗%d毫秒%n",begin5-begin4);
		//随机生成8位长度为5的字符串并排序输出
		//zi.strShuchu(zi.strArrayPaixu(zi.suiStrArray(8, 5)));
	
		//穷举3位长度的密码
		/*for(int i=0;i<62;i++)
		System.out.println(zi.yingshe(i));*/
		//System.out.println(zi.qiongju(str));
		//System.out.println(str);//验证是否匹配正确
		
		//穷举n位长度的密码
		/*
		zi.qiongn(5,str);
		System.out.println(zi.diguians);
		System.out.println("正确答案："+str);//验证是否匹配正确
		*/
		
	}
}
