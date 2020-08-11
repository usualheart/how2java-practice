package riqi;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Arrays;
public class suijiriqi {
	//����ת�ַ���
	public String riqi2str(Date d) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str=sdf.format(d);
		return str;
	}
	//�ַ���ת����
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
	//���������
	public long suijiNum(long start,long end) {
		return start+(long)(Math.random()*(end-start));
	}
	
	//���ɳ���Ϊ9������ �洢1995����������ڣ�����������
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
	//�Ժ�������������������
	public Date[] haomiaozu2riqizu(long haomiaozu[]) {
		Date riqizu[]=new Date[9];
		for(int i=0;i<haomiaozu.length;i++) {
			riqizu[i]=new Date(haomiaozu[i]);
		}
		return riqizu;
	}
	//���ַ�����ʽ�����������
	public void riqizu2strzu(Date riqizu[]) {
		String strzu[]=new String[9];
		for(int i=0;i<riqizu.length;i++) {
			strzu[i]=riqi2str(riqizu[i]);
			System.out.print(strzu[i]+" ");
			if((i+1)%3==0)System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String str1="1995/01/01 00:00:00";
		String str2="1995/12/31 23:59:59";
		suijiriqi suiji=new suijiriqi();
		//����1995������������
		long suilong=suiji.suijiNum(suiji.str2riqi(str1).getTime(),suiji.str2riqi(str2).getTime());
		//������ת��Ϊ���ڲ����
		Date suidate=new Date(suilong);
		System.out.println("1995����һ��������ڣ�"
				+ ""+suidate);
		
		//���ɳ���Ϊ9������ �洢1995�����������
		suiji.riqizu2strzu(suiji.haomiaozu2riqizu(suiji.haomiaozu()));
	}

}
