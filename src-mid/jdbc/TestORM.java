package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import multiplethread.Hero;

public class TestORM {
	
	
	//��һ��Hero������뵽���ݿ���
	public static void add(Hero h) {
		int id=h.id;
		String name =h.name;
		Float hp=h.hp;
		int damage=h.damage;
		String sql="insert into hero values ("+id+ ",'"+name+"',"+hp+","+damage+");";
		TestJDBC.execute(sql);
		System.out.println("����Ӣ�۳ɹ���");
	}
	//�����Hero�����Ӧ������ɾ����
	public static void delete(Hero h) {
		int id=h.id;
		String sql="delete from hero where id="+id+";";
		TestJDBC.execute(sql);
		System.out.println("ɾ��Ӣ�۳ɹ���");
	}
	//��������Hero����
	public static void update(Hero h) {
		int id=h.id;
		String name =h.name;
		Float hp=h.hp;
		int damage=h.damage;
		String sql="update hero set name='"+name+"',hp="+hp+",damage="+damage+" where id="+id+";";
		TestJDBC.execute(sql);
		System.out.println("�������ݳɹ���");
	}
	//�����е�Hero���ݲ�ѯ������ת��ΪHero����󣬷���һ�������з���
	public static List<Hero> list(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<Hero>l=new ArrayList<Hero>();
		try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
			Statement s=c.createStatement();
				){
			String sql="select * from hero;";
			ResultSet rs=s.executeQuery(sql);
			while (rs.next()) {
				Hero hero = new Hero();
				int id =rs.getInt("id");
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.id = id;
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                l.add(hero);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.printf("���ݿ⹲��%d������%n",l.size());
		return l;
	}
	//��ѯ���ݿ��¼���� ��int��ʽ����
		public static int count(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			int count=0;
			try(Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "admin");
				Statement s=c.createStatement();
					){
				String sql="select count(*) from hero;";
				ResultSet rs=s.executeQuery(sql);
				if (rs.next()) {
					count =rs.getInt(1);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.printf("���ݿ⹲��%d������%n",count);
			return count;
		}



	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		Hero h=new Hero();
		h.id=5;
		h.name="Hero ORM";
		h.hp=100.5f;
		h.damage=50;
		count();
		add(h);
		count();
		Hero deleteHero=new Hero();
		deleteHero.id=12;
		delete(deleteHero);
		h.name="Hero ORM�޸ĺ�";
		count();
		update(h);
		//System.out.println(list());
		
		

	}

}
