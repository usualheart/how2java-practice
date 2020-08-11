package socket;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GuiTalkServer {
	
	/*
     * ������������˴���
     */
    //���ݿⲿ��
    static Connection c=null;//Ϊ�˶��ʹ��
    static PreparedStatement ps=null;//ps��ʽִ��sql���
    static Statement s1=null;
    //���ݿ�ĳ�ʼ������
    public static void init(){
        try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e1) {
    		// TODO �Զ����ɵ� catch ��
    		e1.printStackTrace();
    	}
        try {
        	//�˴���cû�йر� ��������� ���ݿ�����Ҫ��ʱ�ر�
    		c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
    		String sql="select * from dictionary where receive=?";
    		ps=c.prepareStatement(sql);
    		//s1=c.createStatement();
    	}catch (SQLException e1) {
    		e1.printStackTrace();
    	}
    }
    //���ݻظ���ѯ���ݿ����Ƿ��ж�Ӧ�Ļظ� �������Ӧ��Ӧ�Ļظ����򷵻�null
    public static String response(String receive){
    	String huifu=null;
		try {
			//��һ��ִ��sql�ķ�ʽ
			//ResultSet rs = s1.executeQuery("select * from dictionary where receive='"+receive+"'");
			//�ڶ���ִ�з�ʽ
			ps.setString(1, receive);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				huifu=rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return huifu;
    }
    
    
    //����������
    static Socket s;
    public static void gui() {
    	
    	 /*
    	 * ��������ʼ��
    	 */
    	Thread socket=new Thread() {
        	public void run() {
		    	try {
		       	 	ServerSocket ss = new ServerSocket(8888);
		       	 	s = ss.accept();
		            init();//�����ݿ���г�ʼ������
		       } catch (UnknownHostException e) {
		           e.printStackTrace();
		       } catch (IOException e) {
		           e.printStackTrace();
		       }
          	}
        };
        socket.start();
	   	/*
	   	  * GUI����
	   	*/
    	JFrame f=new JFrame();
    	f.setTitle("������");
    	f.setBounds(400,200,400,400);
    	f.setLayout(new BorderLayout());
    	
    	//�������
    	JPanel p=new JPanel();
    	p.setLayout(null);
    	p.setPreferredSize(new Dimension(150,300));
    	
    	JTextArea ta=new JTextArea();
    	ta.setSize(120, 100);
    	ta.setLocation(15, 80);
    	ta.setLineWrap(true);//�����Զ�����
    	JButton b=new JButton("����");
    	b.setSize(120, 30);
    	b.setLocation(15, 200);
    	p.add(b);
    	p.add(ta);
    	
    	
    	//�ұ���ʾ����
    	JTextArea taPingmu=new JTextArea();
    	taPingmu.setText("�����Ѿ���ʼ...�����ڶ˿ں�:8888");
    	taPingmu.setLineWrap(true);//�����Զ�����
    	JScrollPane sp=new JScrollPane(taPingmu);
    	
    	f.add(p, BorderLayout.WEST);
    	f.add(sp, BorderLayout.CENTER);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setVisible(true);
    	
    	try {//ͼ�ν��������Ϻ��ٰѷ�������ʼ���������߳�
			socket.join();
		} catch (InterruptedException e2) {
			// TODO �Զ����ɵ� catch ��
			e2.printStackTrace();
		}
    	
    	//Ϊ���Ͱ�ť����¼�
    	b.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
				String response=ta.getText();
				taPingmu.append("\r\n��������"+response);
				ta.setText(null);
				
				try {
					OutputStream os=s.getOutputStream();
					DataOutputStream dos = new DataOutputStream(os);//��������ͻ��˷������ݵ�������
	            	if(null!=response) {
		            	synchronized (this) {//��response����ͬ��
							dos.writeUTF(response);
							response=null;
			            }
	            	}
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
    			
    		}
    	});
    	
    	
    	
    	//����һ���µ��߳� ���ڽ��տͻ�����Ϣ ������Ӧ�Ĵ���
        new Thread() {
        	public void run() {
	            while(true) {
	            	try {
	            		InputStream is = s.getInputStream();
	            		DataInputStream dis = new DataInputStream(is);//����������װ��DataInputStream
			            //ʹ��readUTF��ȡ�ַ��� ֻҪ�������������� ��Ҫ�������������ݲ����������
	            		String msg= dis.readUTF();
			            //System.out.println("�ͻ�����Ϣ��"+msg);
			            taPingmu.append("\r\n�ͻ��ˣ�"+msg);
			            //�õ����ݿ���Ӧ�ظ���Ϣ ��������������
			            String tmp=response(msg);
			            if(null!=tmp) {
			            	//taPingmu.append("\r\n��������"+tmp);
			            	//dos.writeUTF(tmp);
			            	ta.setText(tmp);
			            	b.doClick();
			            }
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	            } 
        	}
        }.start();
    	
    }
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		gui();
		//ServerInit();
	}

}
