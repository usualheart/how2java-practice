package socket;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JTextField;

public class GuiTalkClint {
	
    
    //�ͻ��˲���
    static Socket s;
    static String ip;
    static Thread socket;
    public static void gui() {
    	
    	
    	
	   	/*
	   	  * GUI����
	   	*/
    	JFrame f=new JFrame();
    	f.setTitle("�ͻ���");
    	f.setBounds(800,200,400,400);
    	f.setLayout(new BorderLayout());
    	
    	//�������
    	JPanel p=new JPanel();
    	p.setLayout(null);
    	p.setPreferredSize(new Dimension(150,300));
    	JTextField tf=new JTextField();
    	tf.setSize(120, 30);
    	tf.setLocation(15, 40);
    	tf.setText("127.0.0.1");
    	
    	JTextArea ta=new JTextArea();
    	ta.setSize(120, 100);
    	ta.setLocation(15, 80);
    	ta.setLineWrap(true);//�����Զ�����
    	JButton b=new JButton("����");
    	b.setSize(120, 30);
    	b.setLocation(15, 200);
    	p.add(tf);
    	p.add(b);
    	p.add(ta);
    	


    	//�ұ���ʾ����
    	JTextArea taPingmu=new JTextArea();
    	taPingmu.setText("\t\n�밴�س�����ȷ��ip��ַ...");
    	taPingmu.setLineWrap(true);//�����Զ�����
    	JScrollPane sp=new JScrollPane(taPingmu);
    	
    	f.add(p, BorderLayout.WEST);
    	f.add(sp, BorderLayout.CENTER);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setVisible(true);
    	 
    	
    	/*
    	 * �ͻ��˹��ܲ���
    	 */
    	
    	//����һ���µ��߳� ���ڽ��շ�������Ϣ ��Ҫ���������ip��ַ���������߳�
        Thread receive=new Thread() {
        	public void run() {
	            while(true) {
	            	try {
	            		InputStream is = s.getInputStream();
	            		DataInputStream dis = new DataInputStream(is);//����������װ��DataInputStream
			            //ʹ��readUTF��ȡ�ַ���
	            		String msg= dis.readUTF();
			            taPingmu.append("\r\n��������"+msg);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	            } 
        	}
        };
    	
    	tf.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO �Զ����ɵķ������
				if(e.getKeyCode()==10)
				{
					ip=tf.getText();
			        taPingmu.setText("\t\n�������ӷ�����...");
					socket=new Thread() {
			        	public void run() {
					    	try {
					    		s= new Socket(ip, 8888);
					       } catch (IOException e) {
					           e.printStackTrace();
					       } 
			          	}
			        };
			        try {//ͼ�ν��������Ϻ��ٰѷ�������ʼ���������߳�
			        	socket.start();
			        	socket.join();
					} catch (InterruptedException e2) {
						// TODO �Զ����ɵ� catch ��
						e2.printStackTrace();
					}
			        taPingmu.setText("\t\n�����Ѿ���ʼ...");
			        receive.start();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO �Զ����ɵķ������
				
			}
    		
    	});
    	
    	//Ϊ���Ͱ�ť����¼�
    	b.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
				String response=ta.getText();
				taPingmu.append("\r\n�ͻ��ˣ�"+response);
				try {
					OutputStream os=s.getOutputStream();
					DataOutputStream dos = new DataOutputStream(os);//��������ͻ��˷������ݵ�������
	            	dos.writeUTF(response);
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				ta.setText(null);
    		}
    	});
    	
    	
    	
    	
    	
    }
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		gui();
		//ServerInit();
	}

}
