package shuzizifuchuan;
import java.util.Scanner;

import collection.MyStringBufferCollection;
public class PojieMima {
	char ans[];
	int j=0;
	//�ҳ���д����������ַ�����
	public void shai(char[] x) {
		j=0;
		ans=new char[x.length];
		for(int i=0;i<x.length;i++) {
			if(Character.isUpperCase(x[i])||Character.isDigit(x[i]))ans[j++]=x[i];
		}
	}
	//������ɴ�Сд�������ַ�
	public static char suichar() {
		int x=(int)(Math.random()*62);
		if(x<=9)x+=48;
		else if(x<=35)x+=55;
		else x+=61;
		return (char)x;
	}
	//������ɴ�Сд�ַ�
		public char suiZimu() {
			int x=(int)(Math.random()*52);
			x+=10;//xֱ�ӱ�Ϊ10-61
			if(x<=35)x+=55;
			else x+=61;
			return (char)x;
		}
	//��������λ���ַ���
	public static String suistr(int n) {
		char x;
		char[] charzu=new char[n];
		for(int i=0;i<n;i++) {
			x=suichar();//��ѡ��ĸ���Ǻ�����
			charzu[i]=x;
		}
		String str=String.copyValueOf(charzu);
		return str;
	}
	//����mλ ����Ϊn���ַ��� ����
	public static String[] suiStrArray(int m,int n) {
		String strs[]=new String[m];
		for(int i=0;i<m;i++) {
			strs[i]=suistr(n);
		}
		strShuchu(strs);
		return strs;
	}
	//�ַ��Ƚ��㷨�����Դ�Сд A=a,m<n���true
	public boolean charBijiao(char m,char n) {
		if(m>='a'&&m<='z')m-=32;
		if(n>='a'&&n<='z')n-=32;
		if(m<n)return true;
		else return false;
	}
	//���ַ��������������ֱ������
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
	
	//��0-61����ӳ��Ϊ���ֻ��Сд��ĸ
	public static char yingshe(int x) {
		if(x<=9)x+=48;
		else if(x<=35)x+=55;
		else x+=61;
		return (char) x;
	}
	//������ɳ�����3���ַ������ƽ����벢���س��Դ���
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
					//System.out.printf("%c %c %c %s %n",charzu[0],charzu[1],charzu[2],str);//���ƥ�����
					if(str.equals(mima))flag=true;
					
				}
			}
		}
		return charzu;
	}
	//�ݹ�����ƽ�nλ����

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
				//�����ǰ�Ѿ���ٵĳ̶�
				if(n==mima.length())System.out.printf("����٣�%d%% %n",i*100/62);
			}
		}
	}
	//����ַ�������
	public static void strShuchu(String[]strs) {
		System.out.println("����ַ������飺");
		for(int i=0;i<strs.length;i++) {
			System.out.print(strs[i]+" ");
			if((i+1)%12==0)System.out.println();
		}
	}
	public static void main(String[] args) {
		/*
		System.out.println("�������ַ�����");
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		char[] cs=str.toCharArray();
		*/
		PojieMima zi=new PojieMima();
		//zi.shai(cs);
		//System.out.println(zi.ans);
		//�������5λ�ַ��������
		String str=zi.suistr(10);
		System.out.println(str);
		
		//string ��stringbuffer����10000���ַ���������ʱ��
		String str1 = "the";
        StringBuffer sb = new StringBuffer(str1);
        MyStringBuffer msb=new MyStringBuffer(str1);
        MyStringBufferCollection msbc=new MyStringBufferCollection(str1);
        
        //ֱ�����Ӳ���ʱ��
        long begin1=System.currentTimeMillis();
        for(int i=0;i<10000;i++) {
        	str1+=str;
        }
        
        //StringBuffer����ʱ��
        long begin2=System.currentTimeMillis();
        for(int i=0;i<1000000;i++) {
        	sb.append(str);
        }
        
        //MyStringBuffer����ʱ��
        long begin3=System.currentTimeMillis();
        for(int i=0;i<10000;i++) {
        	msb.append(str);
        }
        
        //MyStringBufferCollection����ʱ��
        long begin4=System.currentTimeMillis();
        for(int i=0;i<1000000;i++) {
        	msbc.append(str);
        }
        long begin5=System.currentTimeMillis();
        //System.out.println(sb);
        System.out.printf("ʹ��+"
        		+ "�ķ�ʽ1�������%d����%n",begin2-begin1);
        System.out.printf("ʹ��StringBuffer"
        		+ "�ķ�ʽ100�������%d����%n",begin3-begin2);
        System.out.printf("ʹ��MyStringBuffer"
        		+ "�ķ�ʽ1�������%d����%n",begin4-begin3);
        System.out.printf("ʹ��MyStringBufferCollection"
        		+ "�ķ�ʽ100�������%d����%n",begin5-begin4);
		//�������8λ����Ϊ5���ַ������������
		//zi.strShuchu(zi.strArrayPaixu(zi.suiStrArray(8, 5)));
	
		//���3λ���ȵ�����
		/*for(int i=0;i<62;i++)
		System.out.println(zi.yingshe(i));*/
		//System.out.println(zi.qiongju(str));
		//System.out.println(str);//��֤�Ƿ�ƥ����ȷ
		
		//���nλ���ȵ�����
		/*
		zi.qiongn(5,str);
		System.out.println(zi.diguians);
		System.out.println("��ȷ�𰸣�"+str);//��֤�Ƿ�ƥ����ȷ
		*/
		
	}
}
