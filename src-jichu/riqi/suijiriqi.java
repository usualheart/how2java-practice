package riqi;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Arrays;
public class suijiriqi {
	//日期转字符串
	public String riqi2str(Date d) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str=sdf.format(d);
		return str;
	}
	//字符串转日期
	public Date str2riqi(String str) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date d=new Date();
		try {
            d = sdf.parse(str);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return d;
	}
	//生成随机数
	public long suijiNum(long start,long end) {
		return start+(long)(Math.random()*(end-start));
	}
	
	//生成长度为9的数组 存储1995随机毫秒日期，并进行排序
	public long[] haomiaozu() {
		long riqi95[]=new long[9];
		long start=str2riqi("1995/01/01 00:00:00").getTime();
		long end=str2riqi("1995/12/31 23:59:59").getTime();
		for(int i=0;i<9;i++) {
			riqi95[i]=suijiNum(start,end);
		}
		Arrays.sort(riqi95);
		return riqi95;
	}
	//对毫秒数组生成日期数组
	public Date[] haomiaozu2riqizu(long haomiaozu[]) {
		Date riqizu[]=new Date[9];
		for(int i=0;i<haomiaozu.length;i++) {
			riqizu[i]=new Date(haomiaozu[i]);
		}
		return riqizu;
	}
	//以字符串形式输出日期数组
	public void riqizu2strzu(Date riqizu[]) {
		String strzu[]=new String[9];
		for(int i=0;i<riqizu.length;i++) {
			strzu[i]=riqi2str(riqizu[i]);
			System.out.print(strzu[i]+" ");
			if((i+1)%3==0)System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str1="1995/01/01 00:00:00";
		String str2="1995/12/31 23:59:59";
		suijiriqi suiji=new suijiriqi();
		//产生1995年的随机毫秒数
		long suilong=suiji.suijiNum(suiji.str2riqi(str1).getTime(),suiji.str2riqi(str2).getTime());
		//毫秒数转化为日期并输出
		Date suidate=new Date(suilong);
		System.out.println("1995年间的一个随机日期："
				+ ""+suidate);
		
		//生成长度为9的数组 存储1995随机毫秒日期
		suiji.riqizu2strzu(suiji.haomiaozu2riqizu(suiji.haomiaozu()));
	}

}
