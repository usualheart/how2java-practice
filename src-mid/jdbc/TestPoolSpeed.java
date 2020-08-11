package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestPoolSpeed {
	
	public static void main(String[]args) {
		
		
		//使用传统方式 创建100个线程 向数据库插入数据
		long time1=System.currentTimeMillis();
		ConnectionPool cp=new ConnectionPool(10);
		Thread[] ts=new Thread[100];
		for(int i=0;i<100;i++) {
			Thread tmp=new Thread() {
				public void run() {
					Connection c=cp.getConnection();
					String sql="insert into item values(null,?,?);";
					try(PreparedStatement ps=c.prepareStatement(sql);){
						ps.setString(1, "test物品Pool");
						ps.setInt(2, 100);
						ps.execute();
					}catch(SQLException e) {
						e.printStackTrace();
					}
					cp.returnConnection(c);//用完要归还连接
				}
			};
			ts[i]=tmp;
		}
		
		for(Thread tmp:ts) {
			try {
				tmp.start();
				tmp.join();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		long time2=System.currentTimeMillis();
		System.out.printf("使用数据库连接池用时%dms%n",time2-time1);
		long time3=System.currentTimeMillis();
		//使用传统方式 创建100个线程 向数据库插入数据
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
				ps.setString(1, "test物品chuantong");
				ps.setInt(2, 100);
				ps.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		long time4=System.currentTimeMillis();
		
		System.out.printf("使用传统方式用时%dms%n",time4-time3);
	}
	
}
