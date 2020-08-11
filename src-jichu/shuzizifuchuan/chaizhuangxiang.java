package shuzizifuchuan;

public class chaizhuangxiang {

	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int i = 5;
		  
        Integer it = new Integer(i);
        //封装类型转换成基本类型
        int i2 = it.intValue();
        //自动转换就叫拆箱
        int i3 = it;
        System.out.println(Byte.MAX_VALUE);
        byte b=10;
        Byte bt=new Byte(b);
        byte b1=bt.byteValue();
        byte b2=bt;
        System.out.println(b1+"  "+b2);
        //字符串转换
        double d=3.1415;
        //方法1
        String d2=String.valueOf(d);
        System.out.println(d2);
        //方法2
        Double dd=new Double(d);
        String d3=dd.toString();
        System.out.println(d2);
        //字符串转数字
        String str="12333";
        int stri=Integer.parseInt(str);
        System.out.println(stri-1);
        
        d3="3.14";
        double ddd=Double.parseDouble(d3);
        System.out.println(ddd-1);
        
	}

}
