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
	
	//����ʹ�� datepicker.jar ������һ��ȱ�㣬��������ʱ�䣬ֻ���ڴ����ؼ���ʱ����ָ�����ڡ�
	//��Ҫ�������ڣ���ʹ��JXDatePicker
    public static void testDatepicker() {
   
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
   
        final DatePicker datepick;
        datepick = getDatePicker();
   
        f.add(datepick);
   
        JButton b = new JButton("��ȡʱ��");
        b.setBounds(137, 183, 100, 30);
        f.add(b);
   
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "��ȡ�ؼ��е����ڣ�" + datepick.getValue());
                System.out.println(datepick.getValue());
            }
        });
   
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        f.setVisible(true);
    }
 
    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // ��ʽ
        String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
        // ��ǰʱ��
        Date date = new Date();
        // ����
        Font font = new Font("Times New Roman", Font.BOLD, 14);
   
        Dimension dimension = new Dimension(177, 24);
   
        int[] hilightDays = { 1, 3, 5, 7 };
   
        int[] disabledDays = { 4, 6, 5, 9 };
   
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
   
        datepick.setLocation(137, 83);
        datepick.setBounds(137, 83, 177, 24);
        // ����һ���·�����Ҫ������ʾ������
        datepick.setHightlightdays(hilightDays, Color.red);
        // ����һ���·��в���Ҫ�����ӣ��ʻ�ɫ��ʾ
        datepick.setDisableddays(disabledDays);
        // ���ù���
        datepick.setLocale(Locale.CHINA);
        // ����ʱ�����ɼ�
        datepick.setTimePanleVisible(true);
        return datepick;
    }
    
    
    //����ʹ�� ��swingx-core-1.6.2.jar������Ƚϼ�Լ��������������
    public static void testJXDatePicker() {
    	 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);
 
        Date date = new Date();
        final JXDatePicker datepick = new JXDatePicker();
        // ���� date����
        datepick.setDate(date);
        datepick.setBounds(150, 80, 200, 24);
        f.add(datepick);
 
        JButton b = new JButton("��ȡʱ��");
        b.setBounds(137, 183, 100, 30);
        f.add(b);
 
        b.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                // ��ȡ ����
                Date d = datepick.getDate();
                JOptionPane.showMessageDialog(f, "��ȡ�ؼ��е����� :" + d);
 
            }
        });
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
    
    //����ʱ��ؼ���ѡ��һ��ʱ�䣬Ȼ��������ʱ�䣬ͳ��e:\project �޸�ʱ��������ʱ����ļ���һ���ж���
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
 
        JButton b = new JButton("ͳ����D:\\java-testĿ¼�£��޸����ڴ��ڿؼ����ڵ��ļ�����");
        b.setBounds(50, 160, 400, 30);
        f.add(b);
 
        b.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                // ��ȡ ����
            	//Date d=(Date)(datepick.getValue());
                //JOptionPane.showMessageDialog(f, "��ȡ�ؼ��е����� :" + d.getTime());//�����Կ���ת��
                File file=new File("D:\\java-test");
                JOptionPane.showMessageDialog(f, "�����������ļ�������Ϊ��" + countFile(file,(Date) datepick.getValue()));
            }
        });
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
    //����ָ���ļ�����ָ��ʱ��֮����ļ�������
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