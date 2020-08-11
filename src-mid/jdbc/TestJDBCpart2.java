package jdbc;
    
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
    
public class TestJDBCpart2 {
	//PrepareStatement�Ĳ��Ժ���Statement�������ٶȱȽ�
    public static void testPS() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
  
        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
            // ����sql��䴴��PreparedStatement
            PreparedStatement ps = c.prepareStatement(sql);
        	Statement s=c.createStatement();
        ) {
        	long time1=System.currentTimeMillis();

            String sql2 = "insert into hero values(null,"+"'test"+"',"+100+","+50+")";
            for(int i=0;i<1000;i++) {
	            s.execute(sql2);
            }

        	long time2=System.currentTimeMillis();
            // ���ò���
        		ps.setString(1, "test");
	            ps.setFloat(2, 100);
	            ps.setInt(3, 50);
            for(int i=0;i<1000;i++) {
	            // ִ��
	            ps.execute();
            }
        	long time3=System.currentTimeMillis();
        	
        	System.out.printf("Statement��ʱ%dms%nPrepareStatement��ʱ%dms%n",time2-time1,time3-time2);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
    }
  //��ҳ��ѯ�ķ���
    public static void list(int start, int count) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    	
    	//���Զ��ر�����
    	try(Connection c =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
    			"root", "admin");
    			Statement s=c.createStatement();){
    		String sql="select * from Hero limit "+start+","+count+";";
    		ResultSet r=s.executeQuery(sql);
    		while(r.next()) {
    			int id=r.getInt("id");
    			String name=r.getString("name");
    			float hp=r.getFloat("hp");
    			int damage=r.getInt(4);
    			System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	System.out.println("listִ�����ɹ���");
    }
    
    //ʹ��execute�ķ�ҳ��ѯexecute����ִ�в�ѯ���
    //Ȼ��ͨ��getResultSet���ѽ����ȡ����
    public static void list2(int start, int count) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    	
    	//���Զ��ر�����
    	try(Connection c =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
    			"root", "admin");
    			Statement s=c.createStatement();){
    		String sql="select * from Hero limit "+start+","+count+";";
    		s.execute(sql) ;
    		ResultSet r=s.getResultSet();
    		while(r.next()) {
    			int id=r.getInt("id");
    			String name=r.getString("name");
    			float hp=r.getFloat("hp");
    			int damage=r.getInt(4);
    			System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	System.out.println("list2ִ�����ɹ���");
    }
    
    //��ȡ���Ԫ����
    public static void yuanshuju()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");) {
  
            // �鿴���ݿ�����Ԫ����
            // �����ݿ�������汾�������汾��������Щ���ݿ�ȵ�
            DatabaseMetaData dbmd = c.getMetaData();
  
            // ��ȡ���ݿ��������Ʒ����
            System.out.println("���ݿ��Ʒ����:\t"+dbmd.getDatabaseProductName());
            // ��ȡ���ݿ��������Ʒ�汾��
            System.out.println("���ݿ��Ʒ�汾:\t"+dbmd.getDatabaseProductVersion());
            // ��ȡ���ݿ�������������ͱ���֮��ķָ��� ��test.user
            System.out.println("���ݿ�ͱ�ָ���:\t"+dbmd.getCatalogSeparator());
            // ��ȡ�����汾
            System.out.println("�����汾:\t"+dbmd.getDriverVersion());
  
            System.out.println("���õ����ݿ��б�");
            // ��ȡ���ݿ�����
            ResultSet rs = dbmd.getCatalogs();
  
            while (rs.next()) {
                System.out.println("���ݿ�����:\t"+rs.getString(1));
            }
  
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
    
    //��ȡ����ID��ͨ������IDɾ��ǰһ�������ڵģ�����
    public static void zizengID() {
    	try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
        		Statement s=c.createStatement();
                ) {
            ps.setString(1, "����Ӣ��");
            ps.setFloat(2, 616);
            ps.setInt(3, 100);
   
            // ִ�в������
            ps.execute();
   
            // ��ִ�����������MySQL��Ϊ�²�������ݷ���һ��������id
            // JDBCͨ��getGeneratedKeys��ȡ��id
            ResultSet rs = ps.getGeneratedKeys();
            int id=0;
            if (rs.next()) {
                id = rs.getInt(1);
                System.out.println("����ļ�¼id�ǣ�"+id);
            }
            boolean flag=false;//�ж��Ƿ��ҵ��˴��ڵ���һ��ID��¼;
            System.out.println("ɾ���ļ�¼�ǣ�");
            while(!flag) {
            	id--;//ָ����һ����¼
            	String sqlQuery="select * from hero where id="+id;
            	s.execute(sqlQuery) ;//�н������true
            	ResultSet rsend=s.getResultSet();
            	if(rsend.next())flag=true;
            	if(flag) {
            		int idtmp =rsend.getInt("id");
            		String nametmp=rsend.getString(2);
            		Float hptmp=rsend.getFloat("hp");
            		int damagetmp=rsend.getInt("damage");
            		System.out.printf("%d\t%s\t%f\t%d%n", id, nametmp, hptmp, damagetmp);
            	}
            }
            if(id==0)System.out.println("��һ��ID��Ӧ�ļ�¼������");
            else {
                
	            String sqlDelete ="delete from hero where id="+id;
	            s.execute(sqlDelete);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //������ϰ,ѯ���Ƿ�ɾ�����ݿ�ǰ10����¼
    public static void shiwu() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    	
    	//���Զ��ر�����
    	try(Connection c =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
    			"root", "admin");
    			Statement s=c.createStatement();){
    		String sqlQuery="select * from Hero limit 0,5";
    		ResultSet r=s.executeQuery(sqlQuery);
    		System.out.println("Ҫɾ�����ļ��ǣ�");
    		c.setAutoCommit(false);
    		ArrayList<Integer> ids=new ArrayList<Integer>();
    		while(r.next()) {
    			int id=r.getInt("id");
    			ids.add(id);
    			String name=r.getString("name");
    			float hp=r.getFloat("hp");
    			int damage=r.getInt(4);
    			System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
    		}
    		
    		for(int idtmp:ids) {
    			String sqlDelete="delete from hero where id="+idtmp+";";
    			s.execute(sqlDelete);
    		}
    		
    		boolean flag=false;
    		System.out.println("�����Ƿ�Ҫɾ����Y/N");
    		while(!flag) {
	    		Scanner shuru=new Scanner(System.in);
	    		String zhiling=shuru.nextLine();
	    		if(zhiling.equals("Y")) {
	    			flag=true;
	    			c.commit();
	    			System.out.println("���ύɾ����");
	    			
	    		}
	    		else if (zhiling.equals("N")) {
	    			flag=true;
	    			System.out.println("����ֹɾ����");
	    		}
	    		else {
	    			System.out.println("�����Ƿ�Ҫɾ����Y/N");
	    		}
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public static void main(String[] args) {
    	
    	//testPS();
    	//list(5,5);//��ҳ��ѯ1
    	//list2(5,5);
    	//yuanshuju();
    	//zizengID();
    	shiwu();
    	
    }
}