package shuzizifuchuan;

public class chaizhuangxiang {

	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int i = 5;
		  
        Integer it = new Integer(i);
        //��װ����ת���ɻ�������
        int i2 = it.intValue();
        //�Զ�ת���ͽв���
        int i3 = it;
        System.out.println(Byte.MAX_VALUE);
        byte b=10;
        Byte bt=new Byte(b);
        byte b1=bt.byteValue();
        byte b2=bt;
        System.out.println(b1+"  "+b2);
        //�ַ���ת��
        double d=3.1415;
        //����1
        String d2=String.valueOf(d);
        System.out.println(d2);
        //����2
        Double dd=new Double(d);
        String d3=dd.toString();
        System.out.println(d2);
        //�ַ���ת����
        String str="12333";
        int stri=Integer.parseInt(str);
        System.out.println(stri-1);
        
        d3="3.14";
        double ddd=Double.parseDouble(d3);
        System.out.println(ddd-1);
        
	}

}
