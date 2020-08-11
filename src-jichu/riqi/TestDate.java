package riqi;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
public class TestDate {
 
    public static void main(String[] args) {
        //采用单例模式获取日历对象Calendar.getInstance();
        Calendar c = Calendar.getInstance();
         
        //通过日历对象得到日期对象
        Date d = c.getTime();
        System.out.println(c.getTime());
        Date d2 = new Date(0);
        c.setTime(d2); //把这个日历，调成日期 : 1970.1.1 08:00:00
        System.out.println(c.getTime());
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        c.setTime(d);
        System.out.println("当前的时间：\t"+sdf.format(c.getTime()));
        c.add(Calendar.MONTH,2);//加两个月
        c.set(Calendar.DATE,1);//设置日期为1号
        c.add(Calendar.DATE,-3);//倒数三天
        System.out.println("下月倒数第三天：\t"+sdf.format(c.getTime()));
    }
}
