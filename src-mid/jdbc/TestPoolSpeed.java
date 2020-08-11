package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestPoolSpeed {
	
	public static void main(String[]args) {
		
		
		//ʹ�ô�ͳ��ʽ ����100���߳� �����ݿ��������
		long time1=System.currentTimeMillis();
		ConnectionPool cp=new ConnectionPool(10);
		Thread[] ts=new Thread[100];
		for(int i=0;i<100;i++) {
			Thread tmp=new Thread() {
				public void run() {
					Connection c=cp.getConnection();
					String sql="insert into item values(null,?,?);";
					try(PreparedStatement ps=c.prepareStatement(sql);){
						ps.setString(1, "test��ƷPool");
						ps.setInt(2, 100);
						ps.execute();
					}catch(SQLException e) {
						e.printStackTrace();
					}
					cp.returnConnection(c);//����Ҫ�黹����
				}
			};
			ts[i]=tmp;
		}
		
		for(Thread tmp:ts) {
			try {
				tmp.start();
				tmp.join();
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		long time2=System.currentTimeMillis();
		System.out.printf("ʹ�����ݿ����ӳ���ʱ%dms%n",time2-time1);
		long time3=System.currentTimeMillis();
		//ʹ�ô�ͳ��ʽ ����100���߳� �����ݿ��������
		for(int i=0;i<100;i++) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			String sql="insert into item values(null,?,?);";
			try(	Connection c =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
					"root", "admin");
					PreparedStatement ps=c.prepareStatement(sql);){
				ps.setString(1, "test��Ʒchuantong");
				ps.setInt(2, 100);
				ps.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		long time4=System.currentTimeMillis();
		
		System.out.printf("ʹ�ô�ͳ��ʽ��ʱ%dms%n",time4-time3);
	}
	
}
