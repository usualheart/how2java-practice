package riqi;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
public class TestDate {
 
    public static void main(String[] args) {
        //���õ���ģʽ��ȡ��������Calendar.getInstance();
        Calendar c = Calendar.getInstance();
         
        //ͨ����������õ����ڶ���
        Date d = c.getTime();
        System.out.println(c.getTime());
        Date d2 = new Date(0);
        c.setTime(d2); //������������������� : 1970.1.1 08:00:00
        System.out.println(c.getTime());
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        c.setTime(d);
        System.out.println("��ǰ��ʱ�䣺\t"+sdf.format(c.getTime()));
        c.add(Calendar.MONTH,2);//��������
        c.set(Calendar.DATE,1);//��������Ϊ1��
        c.add(Calendar.DATE,-3);//��������
        System.out.println("���µ��������죺\t"+sdf.format(c.getTime()));
    }
}
