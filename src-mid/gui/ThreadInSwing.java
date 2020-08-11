package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UnsupportedLookAndFeelException;

import io.CopyFindFile;
public class ThreadInSwing {
    public static void main(String[] args) {
        //相当于在主线程中执行创建和显示界面的工作 当程序较复杂时 可能会出现问题 因为这时 1. 主线程 2. 事件调度线程。同时在访问组件 容易引起同步问题
    	//new TestFrame().setVisible(true);
      
       /*
      //创建和显示界面的工作，最好也交给事件调度线程，这样就保证了只有一个线程在访问这些组件
      SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              new TestFrame().setVisible(true);
          }
      });*/
      //testLongTimeTask();//长耗时任务的处理的测试
      testFindjava();
    }
    
    //判断是否是事件调度线程的测试
    static class TestFrame extends JFrame {
        public TestFrame() {
            setTitle("LoL");
 
            setSize(400, 300);
 
            setLocation(200, 200);
 
            setLayout(null);
 
            JButton b = new JButton("一键秒对方基地挂");
 
            b.setBounds(50, 50, 280, 30);
 
            add(b);
 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
            setVisible(true);
             
            System.out.println("当前线程是否是 事件调度线程: " + SwingUtilities.isEventDispatchThread());
 
        }
    }
    //长耗时任务的处理：SwingWorker的 doInBackground方法 execute进行运行
    public static void testLongTimeTask() {
    	 
        JFrame f = new JFrame("LoL");
        f.setSize(300, 300);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());
 
        JButton b1 = new JButton("在事件调度线程中执行长耗时任务");
        JButton b2 = new JButton("使用SwingWorker执行长耗时任务");
        JLabel l = new JLabel("任务执行结果");
        f.add(b1);
        f.add(b2);
        f.add(l);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        b1.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setText("开始执行完毕");
                try {
                    Thread.sleep(5000);//在事件调度线程中执行长耗时任务 会让界面在一定时间内无响应
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                l.setText("任务执行完毕");
            }
        });
        //按钮2 使用SwingWorker类对长耗时任务进行专门的处理
        b2.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
 
                    @Override
                    protected Void doInBackground() throws Exception {
                        System.out.println("执行这个SwingWorder的线程是：" + Thread.currentThread().getName());
                        l.setText("开始执行完毕");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        l.setText("任务执行完毕");
                        return null;
                    }
                };
                worker.execute();
 
            }
        });
 
        f.setVisible(true);
    }
    
    //长耗时任务处理练习 查找文件内容
    public static void testFindjava() {
    	
    	JFrame f = new JFrame("LoL");
        f.setSize(300, 300);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());
        
        JLabel l1 = new JLabel("文件夹：");
        JTextField tf1 = new JTextField();
        tf1.setPreferredSize(new Dimension(200,30));
        JLabel l2 = new JLabel("字符串：");
        JTextField tf2 = new JTextField();
        tf2.setPreferredSize(new Dimension(200,30));
        JButton b = new JButton("开始搜索");
        JLabel lshow = new JLabel("准备就绪");
        lshow.setVerticalTextPosition(SwingConstants.CENTER);
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        p.add(b,BorderLayout.NORTH);
        p.add(lshow,BorderLayout.SOUTH);
        b.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		//长耗时任务 使用专门的SwingWorker类进行处理
        		SwingWorker<Void , Void> sw=new SwingWorker<Void ,Void>() {

					@Override
					protected Void doInBackground() throws Exception {
						// TODO 自动生成的方法存根
						lshow.setText("正在搜索...");
		        		File file=new File(tf1.getText());
		        		CopyFindFile.searchMultiplethead(file, tf2.getText());
						lshow.setText("搜索完成！");
						//lshow.setText("准备就绪");
		        		return null;
					}
        			
        		};
        		sw.execute();
        	}
        });
        
        f.add(l1);
        f.add(tf1);
        f.add(l2);
        f.add(tf2);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
