package shuzizifuchuan;
import java.util.Scanner;
public class printf {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//��ʽ�����
		Scanner tmp=new Scanner(System.in);
		System.out.println("������ص㣺");
		String diming=tmp.next();
		System.out.println("���������ͣ�");
		String leixing=tmp.next();
		System.out.println("�����빫˾��");
		String gongsi=tmp.next();
		System.out.println("�������ϰ壺");
		String laoban=tmp.next();
		System.out.println("�������");
		int jine=tmp.nextInt();
		System.out.println("�������Ʒ��");
		String chanpin=tmp.next();
		System.out.println("�������Ʒ��λ��");
		String danwei=tmp.next();
		
		System.out.printf("%s���%s%s�����ˣ����˵��ϰ�%s�Ժ��ζģ�%n"
				+ "Ƿ����%d���ڣ���������С��������!����û�а취������%s�ֹ���!%n"
				+ "ԭ�۶���һ%s�ࡢ��%s�ࡢ��%s���Ǯ��������ȫ��ֻ����ʮ%n"
				+ "�飬ͳͳֻҪ��ʮ��!%s���˵����㲻����!����������������˴���꣬%n"
				+ "�㲻�����ʣ��㻹��Ѫ��Ǯ������Ѫ��Ǯ!%n",diming,leixing,gongsi,
				laoban,jine,chanpin,danwei,danwei,danwei,laoban);
	}

}
