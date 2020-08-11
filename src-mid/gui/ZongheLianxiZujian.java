package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import io.CopyFindFile;


public class ZongheLianxiZujian {
	//�����Ϊ���жϻ�����У��
	//��JTextField���������ݣ����Ա߼�һ����ťJButton,�������ť��ʱ���ж�JTextFiled����û�����ݣ���ʹ��JOptionPane������ʾ
	public static void isKongOrIsShuzi() {
		JFrame f=new JFrame();
		f.setTitle("LOL");
		f.setSize(500, 500);
		f.setLocation(500, 200);
		f.setLayout(new FlowLayout());
		
		JTextField tf=new JTextField();
		tf.setPreferredSize(new Dimension(100, 30));
		JButton b=new JButton("���");
		f.add(tf);
		f.add(b);
		
		//�ж��Ƿ�Ϊ�յ��¼�
		ActionListener isKong=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				//�ж��ı����Ƿ�Ϊ��
				if(tf.getText().length()==0) {
					JOptionPane.showMessageDialog(f, "�ı����ǿյģ�", "����",2);
				}else {
					JOptionPane.showMessageDialog(f, "�ܺã��ı����ǿյ�", "��Ҫ��ʾ",1);
				}
			}
		};
		//�ж��Ƿ����ֵ��¼�
		ActionListener isShuzi=new ActionListener() {
			//�ж��ַ������Ƿ�ȫ��Ϊ���������
			public boolean shuziStr(String str) {
				boolean flag=true;
				for(int i=0;i<str.length();i++) {
					if(str.charAt(i)<='9'&&str.charAt(i)>='0')continue;
					else {
						flag=false;
						break;
					}
				}
				return flag;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵ� �������
				//�ж��ı������ַ����Ƿ�ȫ�������ֹ��ɵ�
				if(shuziStr(tf.getText())) {
					JOptionPane.showMessageDialog(f, "�ı�����������������ɵģ�", "��Ϣ",1);
				}else {
					JOptionPane.showMessageDialog(f, "�ı������ݲ������֣�", "��Ҫ��ʾ",2);
				}
			}
		};
		
		//��Ӽ����¼�
		b.addActionListener(isShuzi);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	//ʵ���˺������½����֤���棨�����ݿ����ӣ�
	public static void zhanghaoMimaYanzheng() {
		JFrame f=new JFrame();
		f.setTitle("LOL");
		f.setSize(500, 500);
		f.setLocation(500, 200);
		f.setLayout(new FlowLayout());
		
		JLabel lzhanghao=new JLabel();
		lzhanghao.setText("�˺ţ�");
		
		JTextField tfuser=new JTextField();
		tfuser.setPreferredSize(new Dimension(100, 30));
		JLabel lmima=new JLabel();
		lmima.setText("���룺");
		JPasswordField pf=new JPasswordField();
		pf.setPreferredSize(new Dimension(100, 30));
		JButton b=new JButton("��½");
		
		//���ü����¼�
		ActionListener denglu=new ActionListener() {
			
			public  boolean panduanPasswd(String name,String password) {
		        boolean flag=false;
				try {
		            Class.forName("com.mysql.jdbc.Driver");
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		 
		        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
		                "root", "admin");
		                Statement s = c.createStatement();
		              ) {
		            
		            String sql = "select * from user where name = '" + name +"' and password = '" + password+"'";
		            // ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
		            ResultSet rs = s.executeQuery(sql);
		              
		            if(rs.next())
		                flag= true;
		            
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        return flag;
		   
		    }
			public void actionPerformed(ActionEvent e) {
				String user=tfuser.getText();
				char[]passwd=pf.getPassword();
				if(panduanPasswd(user,String.valueOf(passwd)))
					JOptionPane.showMessageDialog(f, "��½�ɹ���", "��Ϣ",1);
				else 
					JOptionPane.showMessageDialog(f, "�û������������", "����",2);
			}
		};
		b.addActionListener(denglu);
		
		
		//������
		f.add(lzhanghao);
		f.add(tfuser);
		f.add(lmima);
		f.add(pf);
		f.add(b);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);//���ý����Ƿ���Ե��ڴ�С��false�����Ե��ڽ����С
		f.setVisible(true);
	}
	
	//ʵ�ֽ����������ƻƺ׵Ķ���
	public static void huanghe() {
		JFrame f=new JFrame();
		f.setTitle("�ƺ׶���������");
		f.setSize(600, 500);
		f.setLocation(500, 200);
		f.setLayout(new FlowLayout());
		
		String labelming[]= {
				"������","��˾���ͣ�","��˾���ƣ�","�ϰ����ƣ�","��","��Ʒ��","�۸������λ"
		};
		JTextField tfs[]=new JTextField[7];
		for(int i=0;i<7;i++) {
			JLabel ltmp=new JLabel(labelming[i]);
			ltmp.setPreferredSize(new Dimension(130,30));
			ltmp.setFont(new Font("����",Font.PLAIN,16));//�����������
			f.add(ltmp);
			
			JTextField tftmp=new JTextField();
			tftmp.setPreferredSize(new Dimension(120,30));
			tftmp.setFont(new Font("����",Font.PLAIN,16));
			tfs[i]=tftmp;
			f.add(tftmp);
		}
		//��ӿհױ�ǩ �����Ű�
		JLabel none=new JLabel();
		none.setPreferredSize(new Dimension(255,30));
		f.add(none);
		
		//������ɰ�ť
		JButton shengcheng=new JButton("����");
		shengcheng.setFont(new Font("����",Font.BOLD,16));
		shengcheng.setPreferredSize(new Dimension(100,30));
		f.add(shengcheng);
		
		//��Ӵ��������ı���
		JTextArea ta=new JTextArea();
		ta.setFont(new Font("����",Font.PLAIN,16));
		//ta.setPreferredSize(new Dimension(500,400));��ӹ������ܶ��ı�������ƫ�ó��ȣ�
		ta.setLineWrap(true);//�����Զ�����
		
		//��������
		JScrollPane sp=new JScrollPane(ta);
		sp.setPreferredSize(new Dimension(500,200));
		f.add(sp);
		
		ActionListener duanzi=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String diming=tfs[0].getText();
				String leixing=tfs[1].getText();
				String gongsi=tfs[2].getText();
				String laoban=tfs[3].getText();
				int jine=Integer.parseInt(tfs[4].getText());
				String chanpin=tfs[5].getText();
				String danwei=tfs[6].getText();
				String str=String.format("%s���%s%s�����ˣ����˵��ϰ�%s�Ժ��ζģ�"
						+ "Ƿ����%d���ڣ���������С��������!����û�а취������%s�ֹ���!"
						+ "ԭ�۶���һ%s�ࡢ��%s�ࡢ��%s���Ǯ��������ȫ��ֻ����ʮ"
						+ "�飬ͳͳֻҪ��ʮ��!%s���˵����㲻����!����������������˴���꣬"
						+ "�㲻�����ʣ��㻹��Ѫ��Ǯ������Ѫ��Ǯ!",diming,leixing,gongsi,
						laoban,jine,chanpin,danwei,danwei,danwei,laoban);
				ta.setText(str);
			}
		};
		shengcheng.addActionListener(duanzi);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}
	
	public static void fulijisuanqi() {
		JFrame f=new JFrame();
		f.setTitle("����������");
		f.setSize(400, 400);
		f.setLocation(500, 200);
		f.setLayout(new FlowLayout());
		
		//��ʼ����Ҫ�õ�������
		String labelming[]= {
				"��ʼ�ʽ�","ÿ������","��������","ÿ��׷���ʽ�","�����","��Ϣ��","��Ϣ��"
		};
		String danwei[]= {"��","%","��","��","��","��","��",};
		JTextField tfs[]=new JTextField[7];
		//���㶯��
		ActionListener jisuan=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int benjin=Integer.parseInt(tfs[0].getText());
				double rate=Integer.parseInt(tfs[1].getText());
				int year=Integer.parseInt(tfs[2].getText());
				int addMoneyYear=Integer.parseInt(tfs[3].getText());
				
				int benjinhe=benjin+(year-1)*addMoneyYear;
				/*//�����㷨
				double lixi=0;
				double benxihe=benjin;//��¼ÿһ�������Ϣǰ�ı�Ϣ��
				for(int i=0;i<year;i++) {
					lixi=benxihe*(rate/100);//����ÿ�����Ϣ
					benxihe=benxihe+addMoneyYear+lixi;//�Ժ�ÿ���Ӧ������Ϣ�ı���Ϊǰһ��ı�Ϣ�ͼ���ÿ�����ı����Լ�ǰһ�����ɵ���Ϣ
				}
				//��Ϣ�Ͷ�������һ�����ӵ��ʽ����Ӧ�ý�ȥ��
				benxihe-=addMoneyYear;
				*/
				///*
				//�ڶ����㷨
				double benxihe=0;
				//����ÿ�������ʽ����Ϣ
				for(int i=1;i<year;i++) {
					benxihe+=addMoneyYear*(Math.pow(1+rate/100, i));
				}
				benxihe+=benjin*(Math.pow(1+rate/100, year));
				//*/
				
				//��ʾ���
				tfs[4].setText(String.valueOf(benjinhe));
				tfs[5].setText(String.valueOf(benxihe-benjinhe));
				tfs[6].setText(String.valueOf(benxihe));
			}
		};
		//���ɲ����������ı����
		for(int i=0;i<7;i++) {
			JLabel ltmp=new JLabel(labelming[i]);
			ltmp.setPreferredSize(new Dimension(130,30));
			ltmp.setFont(new Font("����",Font.BOLD,16));//�����������
			f.add(ltmp);
			
			JTextField tftmp=new JTextField();
			tftmp.setPreferredSize(new Dimension(120,30));
			tftmp.setFont(new Font("����",Font.PLAIN,16));
			tfs[i]=tftmp;
			f.add(tftmp);
			
			JLabel ldanwei=new JLabel(danwei[i]);
			ldanwei.setPreferredSize(new Dimension(30,30));
			ldanwei.setFont(new Font("����",Font.BOLD,16));//�����������
			f.add(ldanwei);
			
			if(i==3) {
				//��Ӽ��㰴ť
				JPanel bl=new JPanel();
				JButton shengcheng=new JButton("����");
				shengcheng.setFont(new Font("����",Font.BOLD,16));
				shengcheng.setPreferredSize(new Dimension(200,35));
				shengcheng.addActionListener(jisuan);
				bl.add(shengcheng);//��ť��������ϱ�
				bl.setPreferredSize(new Dimension(300,60));
				f.add(bl);
			}
		}
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setResizable(false);
		f.setVisible(true);
	}
	
	public static void jindutiao() {
		JFrame f=new JFrame();
		f.setTitle("Dangerous!");
		f.setBounds(300, 300, 500, 350);
		//f.setBackground(Color.blue);

        f.getContentPane().setBackground(Color.BLACK);
		f.setLayout(null);
		
		JLabel l=new JLabel("����׼����ը...");
		l.setSize(new Dimension(450,60));
		l.setLocation(50,50);
		l.setFont(new Font("����",Font.BOLD,50));
		l.setForeground(Color.RED);
		f.add(l);
		
		JProgressBar pb=new JProgressBar();
		pb.setMaximum(100);//�ܹ�20��ʱ�� 4�� 6�� 10�� 3���׶� �ٶȷֱ�
		pb.setValue(0);
		pb.setStringPainted(true);
		pb.setSize(new Dimension(400,50));
		pb.setLocation(50, 120);
		pb.setForeground(Color.RED);//������ɫ
		f.add(pb);
		
		new Thread() {
			public void run() {
				long startTime=System.currentTimeMillis();
				long endTime=startTime+26000;
				long tmp=startTime;
				while(tmp!=endTime) {
					if((tmp-startTime)<8000&&(tmp-startTime)%100==0)pb.setValue((int) ((tmp-startTime)/100));
					else if ((tmp-startTime)>8000&&(tmp-startTime)<10000&&(tmp-startTime)%200==0) pb.setValue((int) (80+(tmp-8000-startTime)/200));
					else if ((tmp-startTime)>10000&&(tmp-startTime)%1600==0)pb.setValue((int) (90+(tmp-10000-startTime)/1600));
					tmp=System.currentTimeMillis();
				}
				pb.setValue((int) (tmp-startTime));
			}
		}.start();
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}
	
	public static void copyFileGUI() {
		JFrame f=new JFrame();
		f.setTitle("�����������ļ��и���");
		f.setBounds(300, 300, 500, 250);
		f.setLayout(new FlowLayout());
		
		JLabel lsrc=new JLabel("Դ�ļ���ַ��");
		JTextField tfsrc=new JTextField();
		tfsrc.setText("D:\\picture");
		tfsrc.setPreferredSize(new Dimension(150,30));
		JLabel ldes=new JLabel("���Ƶ���");
		JTextField tfdes=new JTextField();
		tfdes.setPreferredSize(new Dimension(150,30));
		tfdes.setText("D:\\java-test\\new\\");
		JButton start=new JButton("��ʼ����");
		JLabel ljindu=new JLabel("�ļ����ƽ��ȣ�");
		
		JProgressBar pb=new JProgressBar();
		pb.setPreferredSize(new Dimension(250,30));
		pb.setMaximum(100);
		pb.setStringPainted(true);
		//�������ӵ����
		f.add(lsrc);
		f.add(tfsrc);
		f.add(ldes);
		f.add(tfdes);
		f.add(start);
		f.add(ljindu);
		f.add(pb);
		
		//Ϊ��������¼�����
		start.addActionListener(new ActionListener() {
			
			//ͳ���ļ��еĴ�С
			public long wenjianjiaSize(String str) {
				File[] fs=(new File(str)).listFiles();
				long sum=0;
				for(int i=0;i<fs.length;i++) {
					if(fs[i].isFile())
						sum+=fs[i].length();
					else
						sum+=wenjianjiaSize(fs[i].getAbsolutePath());
				}
				return sum;
			}
			//�����ļ�
			public void copyFile(String srcFile, String destFile){
				File sFile=new File(srcFile);
				File dFile=new File(destFile);
				try(
						FileInputStream fis=new FileInputStream(sFile);
						//BufferedReader br=new BufferedReader(fr);
						FileOutputStream fos=new FileOutputStream(dFile);
						//PrintWriter pw= new PrintWriter(fw);
					){	byte tmp[]=new byte[(int) sFile.length()];
						fis.read(tmp);
						fos.write(tmp);
						//file
						fileCopyed+=sFile.length();//ÿ�θ����ļ�֮��   ���Ѿ����Ƶ��ļ���С���и��� 
						//System.out.println("�����ɹ���"+fileCopyed);//ʵʱ��ʾ�Ѿ����Ƶ��ļ����ܴ�С
					}
					catch(IOException e) {
						e.printStackTrace();
					}
				
			}
			
			//�����ļ��У���Դ�ļ��������е��ļ� ���Ƶ�Ŀ���ļ�����(�������ļ���)
			public void copyFolder(String srcFolder, String destFolder){
				File sFolder=new File(srcFolder);
				File dFolder=new File(destFolder);
				
				//��Ŀ���ļ���Ϊ�գ����д���
				if(!dFolder.exists()) dFolder.mkdirs();
				File sFiles[]=sFolder.listFiles();
				for(int i=0;i<sFiles.length;i++) {
					System.out.println(sFiles[i].getAbsolutePath());
					if(sFiles[i].isFile())copyFile(sFiles[i].getAbsolutePath(),destFolder+sFiles[i].getName());
					else copyFolder(sFiles[i].getAbsolutePath(),destFolder+sFiles[i].getName()+"/");
				}  
			}
			long  fileCopyed=0;//��¼�Ѿ��������ļ��Ĵ�С��copyFile������Ҫ�õ��������
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String src=tfsrc.getText();
				String des=tfdes.getText();
				
				long Max=wenjianjiaSize(src);//����Դ�ļ��е��ļ���С
				//System.out.println(Max+"   "+(int)Max);//���Դ�ļ��е��ܴ�С �Լ�ǿ��ת��Ϊint��ֵ ����ǿ��ת�����int�޷�����Ҫ��
				fileCopyed=0;//ÿ���Ѿ����Ƶ��ļ�Ҫ����
				
				
				new Thread() {
					public void run() {
						while(fileCopyed!=Max) {
							int fileCopyedInt=(int) (fileCopyed*100/Max);//����intλ��������������
							System.out.println(fileCopyedInt);
							pb.setValue(fileCopyedInt);
							/*
							 * �� Ӧ�ó������¼��߳���ִ�г�ʱ��Ĳ���ʱ��������������AWT�¼����������ֹ���ػ�����ķ�����
							 * ��ͬ��������������·�����Ӧ�ó�����Ӧһ�������û� ���������ʱ�������ӵ�һ����ť������GUI������¼����������ִ������
							 * ��������ݿ��ܻ���Ҫ�ϳ�ʱ�䣬ʹ�¼��̹߳���ֱ��Զ��ϵͳ������Ϊֹ�� 
							 * ��Ӧ�ó������JProgressBar��setValue����ʱ�����������ܸ������ڲ�״̬������repaint�����������һ���¼����õ�AWT�¼� �����С�
							 * ���ҵ��ǣ�ֱ��Ӧ�ó�����¼������������䴦���ѿ���Ȩ���ص��̵߳��¼�����ѭ�������ܴ�����¼���
							 * 
							 * �±ߵ������ǵ�һ�ֽ���취
							 * ����JComponent��paintImmediately���������
							 */
							//Dimension d=f.getSize();
							//pb.paintImmediately(0, 0, d.width, d.height);
							
							try {
								Thread.sleep(100);//��Ϣ100ms
							} catch (InterruptedException e) {
								// TODO �Զ����ɵ� catch ��
								e.printStackTrace();
							}
						};
						pb.setValue(100);
					}
				}.start();
				//��ʼ�����ļ�
				//�����������ˢ�µĵڶ��ֽ���취 �Ѹ����ļ��еķ����Ž�һ���µ��߳���ߣ�
				new Thread() {
					public void run() {
						copyFolder(src,des);
					}
				}.start();
			}
			
		});
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//isKongOrIsShuzi();
		//zhanghaoMimaYanzheng();//�˺������½��ʵ��
		//huanghe();//�ƺ׶���������
		fulijisuanqi();//����������
		//jindutiao();//��ĥ�˵Ľ�����
		//copyFileGUI();�����ļ���
		
	}

}
