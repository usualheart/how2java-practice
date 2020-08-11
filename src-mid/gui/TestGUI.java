package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class TestGUI {
	//基本JFrame测试
    public static void testJFrame() {
        // 主窗体
        JFrame f = new JFrame("LoL");
 
        // 主窗体设置大小
        f.setSize(400, 300);
 
        // 主窗体设置位置
        f.setLocation(200, 200);
 
        // 主窗体中的组件设置为绝对定位
        f.setLayout(null);
 
        // 按钮组件
        JButton b = new JButton("一键秒对方基地挂");
 
        // 同时设置组件的大小和位置
        b.setBounds(50, 50, 280, 30);
 
        // 把按钮加入到主窗体中
        f.add(b);
 
        // 关闭窗体的时候，退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        f.setVisible(true);
 
    }
    //基本的JDialog测试
    public static void testJDialog() {
        
        //普通的窗体，带最大和最小化按钮，而对话框却不带
        JDialog d = new JDialog();
        d.setTitle("LOL");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("一键秒对方基地挂");
        b.setBounds(50, 50, 280, 30);
 
        d.add(b);
 
        d.setVisible(true);
    }
    
    //模态JDialog  当一个对话框被设置为模态的时候，其背后的父窗体，是不能被激活的，除非该对话框被关闭
    public static void testModalJDialog() {
        JFrame f = new JFrame("外部窗体");
        f.setSize(800, 600);
        f.setLocation(100, 100);
 
        // 根据外部窗体实例化JDialog
        JDialog d = new JDialog(f);
        // 设置为模态
        d.setModal(true);
 
        d.setTitle("模态的对话框");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("一键秒对方基地挂");
        b.setBounds(50, 50, 280, 30);
        d.add(b);
 
        f.setVisible(true);
        d.setVisible(true);
 
    }
    
    //多线程记录程序上次关闭的位置
	public static void lastWeizhi() {
		File file=new File("D:\\java-test\\gui.txt");
		JFrame f=new JFrame("上次位置测试");
		f.setSize(500,500);
		if(file.length()==0) {
			f.setLocation(400, 400);
		}else {
			try(FileInputStream fis=new FileInputStream(file);
					DataInputStream dis=new DataInputStream(fis);){
				int x=dis.readInt();
				int y=dis.readInt();
				f.setLocation(x, y);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		f.setLayout(null);
		// 关闭窗体的时候，退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        f.setVisible(true);
		
		//多线程 时刻记录位置
		new Thread() {
			public void run() {
				while(true) {
				//每100ms记录一次位置
					try {
						Thread.sleep(100);
						int x=f.getX();
						int y=f.getY();
						//创建数据输出流 写入文件
						FileOutputStream fos=new FileOutputStream(file);
						DataOutputStream dos=new DataOutputStream(fos);
						dos.writeInt(x);
						dos.writeInt(y);
						dos.close();
						fos.close();
					} catch (InterruptedException | IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
    
	//ActionListener监听测试
    public static void testActionListener() {
    	  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);
  
        final JLabel l = new JLabel();
  
        ImageIcon i = new ImageIcon("D:\\java-test\\Swing\\shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
  
        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);
  
        // 给按钮 增加 监听
        b.addActionListener(new ActionListener() {
  
            // 当按钮被点击时，就会触发 ActionEvent事件
            // actionPerformed 方法就会被执行
            public void actionPerformed(ActionEvent e) {
                l.setVisible(false);
            }
        });
  
        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    //KeyListener测试
    public static void testKeyListener() {
    	  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);
  
        final JLabel l = new JLabel();
  
        ImageIcon i = new ImageIcon("D:\\java-test\\Swing\\shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
  
        // 增加键盘监听
        f.addKeyListener(new KeyListener() {
  
            // 键被弹起
            public void keyReleased(KeyEvent e) {
  
                // 37代表按下了 “左键”
                if (e.getKeyCode() == 37) {
                    // 图片向左移动 （y坐标不变，x坐标减少）
                    l.setLocation(l.getX() - 10, l.getY());
                }
             // 38代表按下了 “上键”
                if (e.getKeyCode() == 38) {
                    // 图片向上移动 （x坐标不变，y坐标减少）
                    l.setLocation(l.getX(), l.getY()-10);
                }
             // 39代表按下了 “右键”
                if (e.getKeyCode() == 39) {
                    // 图片向右移动 （y坐标不变，x坐标增加）
                    l.setLocation(l.getX() + 10, l.getY());
                }
             // 40代表按下了 “下键”
                if (e.getKeyCode() == 40) {
                    // 图片向下移动 （x坐标不变，y坐标增加）
                    l.setLocation(l.getX(), l.getY() + 10);
                }
            }
  
            //键被按下
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
            	   // 37代表按下了 “左键”
                if (e.getKeyCode() == 37) {
                    // 图片向左移动 （y坐标不变，x坐标减少）
                    l.setLocation(l.getX() - 10, l.getY());
                }
             // 38代表按下了 “上键”
                if (e.getKeyCode() == 38) {
                    // 图片向上移动 （x坐标不变，y坐标减少）
                    l.setLocation(l.getX(), l.getY()-10);
                }
             // 39代表按下了 “右键”
                if (e.getKeyCode() == 39) {
                    // 图片向右移动 （y坐标不变，x坐标增加）
                    l.setLocation(l.getX() + 10, l.getY());
                }
             // 40代表按下了 “下键”
                if (e.getKeyCode() == 40) {
                    // 图片向下移动 （x坐标不变，y坐标增加）
                    l.setLocation(l.getX(), l.getY() + 10);
                }
            }
  
            // 一个按下弹起的组合动作
            public void keyTyped(KeyEvent e) {
            	
            }
        });
  
        f.add(l);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
    
    //MouseActionListener
    public static void testMouseListener() {
    	  
        final JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
  
        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("D:\\java-test\\Swing\\shana_heiheihei.png");
        l.setIcon(i);
        l.setBounds(375, 275, i.getIconWidth(), i.getIconHeight());
  
        f.add(l);
  
        l.addMouseListener(new MouseListener() {
  
            // 释放鼠标
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
  
            }
  
            // 按下鼠标
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
  
            }
  
            // 鼠标退出
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
  
            }
  
            // 鼠标进入
            public void mouseEntered(MouseEvent e) {
  
                Random r = new Random();
                int x = r.nextInt(f.getWidth() - l.getWidth());
                int y = r.nextInt(f.getHeight() - l.getHeight());
                l.setLocation(x, y);
  
            }
  
            // 按下释放组合动作为点击鼠标
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
  
            }
        });
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
    
    //MouseAdapter测试
    public static void MouseAdapter() {
    	  
        final JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
  
        final JLabel l = new JLabel("");

        ImageIcon i = new ImageIcon("D:\\java-test\\Swing\\shana_heiheihei.png");
        l.setIcon(i);
        l.setBounds(375, 275, i.getIconWidth(), i.getIconHeight());
  
        f.add(l);
  
        // MouseAdapter 适配器，只需要重写用到的方法，没有用到的就不用写了
        l.addMouseListener(new MouseAdapter() {
  
            // 只有mouseEntered用到了
            public void mouseEntered(MouseEvent e) {
  
                Random r = new Random();
  
                int x = r.nextInt(f.getWidth() - l.getWidth());
                int y = r.nextInt(f.getHeight() - l.getHeight());
  
                l.setLocation(x, y);
  
            }
        });
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
    public static void main(String[] args) {
    	//testJDialog();
    	testModalJDialog();//模态JDialog
    	//lastWeizhi();//记录上次窗口关闭位置的测试
    	//testActionListener();
    	//testKeyListener();
    	//testMouseListener();
    	//MouseAdapter();
    	
    }
    
}