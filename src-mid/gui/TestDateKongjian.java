package gui;
   
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.Locale;
   
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jdesktop.swingx.JXDatePicker;

import com.eltima.components.ui.DatePicker;
   
public class TestDateKongjian {
	
	//本例使用 datepicker.jar 包，有一个缺点，不能设置时间，只能在创建控件的时候传入指定日期。
	//需要设置日期，请使用JXDatePicker
    public static void testDatepicker() {
   
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
   
        final DatePicker datepick;
        datepick = getDatePicker();
   
        f.add(datepick);
   
        JButton b = new JButton("获取时间");
        b.setBounds(137, 183, 100, 30);
        f.add(b);
   
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "获取控件中的日期：" + datepick.getValue());
                System.out.println(datepick.getValue());
            }
        });
   
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        f.setVisible(true);
    }
 
    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);
   
        Dimension dimension = new Dimension(177, 24);
   
        int[] hilightDays = { 1, 3, 5, 7 };
   
        int[] disabledDays = { 4, 6, 5, 9 };
   
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
   
        datepick.setLocation(137, 83);
        datepick.setBounds(137, 83, 177, 24);
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }
    
    
    //本例使用 包swingx-core-1.6.2.jar，界面比较简约，可以设置日期
    public static void testJXDatePicker() {
    	 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
 
        Date date = new Date();
        final JXDatePicker datepick = new JXDatePicker();
        // 设置 date日期
        datepick.setDate(date);
        datepick.setBounds(150, 80, 200, 24);
        f.add(datepick);
 
        JButton b = new JButton("获取时间");
        b.setBounds(137, 183, 100, 30);
        f.add(b);
 
        b.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取 日期
                Date d = datepick.getDate();
                JOptionPane.showMessageDialog(f, "获取控件中的日期 :" + d);
 
            }
        });
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
    
    //借助时间控件，选中一个时间，然后根据这个时间，统计e:\project 修改时间大于这个时间的文件，一共有多少
    public static void tongjiTimeFile() {
    	JFrame f = new JFrame("LoL");
        f.setSize(500, 300);
        f.setLocation(500, 300);
        f.setLayout(null);
 
        Date date = new Date();
 

        
        final DatePicker datepick;
        datepick = getDatePicker();
        datepick.setBounds(137, 83, 177, 24);
        f.add(datepick);
 
        JButton b = new JButton("统计在D:\\java-test目录下，修改日期大于控件日期的文件总数");
        b.setBounds(50, 160, 400, 30);
        f.add(b);
 
        b.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取 日期
            	//Date d=(Date)(datepick.getValue());
                //JOptionPane.showMessageDialog(f, "获取控件中的日期 :" + d.getTime());//经测试可以转型
                File file=new File("D:\\java-test");
                JOptionPane.showMessageDialog(f, "满足条件的文件的数量为：" + countFile(file,(Date) datepick.getValue()));
            }
        });
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
    //查找指定文件夹内指定时间之后的文件的数量
    public static int countFile(File file,Date time) {
    	File fs[]=file.listFiles();
    	if(fs.length==0)return 0;
    	
    	int sum=0;
    	for(int i=0;i<fs.length;i++) {
    		if(fs[i].isDirectory())
    			sum+=countFile(fs[i],time);
    		else if(fs[i].lastModified()>time.getTime()) 
    			sum++;	
    	}
    	return sum;
    	
    }
    public static void main(String[] args) {
    	//testDatepicker();
    	//testJXDatePicker();
    	tongjiTimeFile();
    }
}