package shuzizifuchuan;

public class math {
	double ans=0;
	//������e�ľ��Բ�ֵ
	public double jueduicha(double x) {
		x=x-Math.E;
		if(x<0)x=-x;
		return x;
	}
	//����e
	public void ee(double n) {
		double tt=0;
		//tt=Math.pow(Math.pow((double)(1+1/n), n/10),10);
		do{
		ans=tt;
		tt=Math.pow((double)(1+1/n), n);
		n++;
		}while(jueduicha(tt)<jueduicha(ans));
	}
	//�ж��Ƿ�Ϊ����
	public boolean  zhi(int x) {
		boolean flag=true;
		int sqrt5=(int) Math.sqrt(x)+5;
		for(int i=2;i<sqrt5&&i<x;i++) {//i<Math.sqrt(x)+2&&
			if(x%i==0) {flag=false;break;}
		}
		//if(x==2)flag=true;
		return flag;
	}
	//�ҳ�С��ĳ�������� ��ͳ�Ƹ���
	public int zhishunum(int x) {
		int sum=0;
		for(int i=2;i<=x;i++) {
			if(zhi(i)==true) {sum++;System.out.println(i);}
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		float f1 = 5.4f;
	    float f2 = 5.5f;
	    //5.4�������뼴5
	    System.out.println(Math.round(f1));
	    //5.5�������뼴6
	    System.out.println(Math.round(f2));
	     
	    //�õ�һ��0-1֮��������������ȡ����1��
	    System.out.println(Math.random());
	     
	    //�õ�һ��0-10֮���������� ��ȡ����10��
	    System.out.println((int)( Math.random()*10));
	    //����
	    System.out.println(Math.sqrt(9));
	    //�η���2��4�η���
	    System.out.println(Math.pow(2,4));
	     
	    //��
	    System.out.println(Math.PI);
	     
	    //��Ȼ����
	    System.out.println(Math.E);	
	    
	    
	    //��ϰ ��ѧ����
	    math ee=new math();
	    ee.ee(Integer.MAX_VALUE);
	    System.out.println(ee.ans);
	    
	    //���1000�����ڵ���������
	    System.out.println(ee.zhishunum(100));
	}

}
