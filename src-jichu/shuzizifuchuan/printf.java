package shuzizifuchuan;
import java.util.Scanner;
public class printf {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//格式化输出
		Scanner tmp=new Scanner(System.in);
		System.out.println("请输入地点：");
		String diming=tmp.next();
		System.out.println("请输入类型：");
		String leixing=tmp.next();
		System.out.println("请输入公司：");
		String gongsi=tmp.next();
		System.out.println("请输入老板：");
		String laoban=tmp.next();
		System.out.println("请输入金额：");
		int jine=tmp.nextInt();
		System.out.println("请输入产品：");
		String chanpin=tmp.next();
		System.out.println("请输入产品单位：");
		String danwei=tmp.next();
		
		System.out.printf("%s最大%s%s倒闭了，王八蛋老板%s吃喝嫖赌，%n"
				+ "欠下了%d个亿，带着他的小姨子跑了!我们没有办法，拿着%s抵工资!%n"
				+ "原价都是一%s多、两%s多、三%s多的钱包，现在全部只卖二十%n"
				+ "块，统统只要二十块!%s王八蛋，你不是人!我们辛辛苦苦给你干了大半年，%n"
				+ "你不发工资，你还我血汗钱，还我血汗钱!%n",diming,leixing,gongsi,
				laoban,jine,chanpin,danwei,danwei,danwei,laoban);
	}

}
