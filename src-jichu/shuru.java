import java.util.Scanner;
public class shuru{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		double b=s.nextDouble();
		String rn=s.nextLine();//第一次取走回车换行
		String cc=s.nextLine();//第二次取字符串
		System.out.println(a+"\n"+b+"\n"+cc);
	}
}