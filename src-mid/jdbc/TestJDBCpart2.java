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
	//PrepareStatement的测试和与Statement的运行速度比较
    public static void testPS() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
  
        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps = c.prepareStatement(sql);
        	Statement s=c.createStatement();
        ) {
        	long time1=System.currentTimeMillis();

            String sql2 = "insert into hero values(null,"+"'test"+"',"+100+","+50+")";
            for(int i=0;i<1000;i++) {
	            s.execute(sql2);
            }

        	long time2=System.currentTimeMillis();
            // 设置参数
        		ps.setString(1, "test");
	            ps.setFloat(2, 100);
	            ps.setInt(3, 50);
            for(int i=0;i<1000;i++) {
	            // 执行
	            ps.execute();
            }
        	long time3=System.currentTimeMillis();
        	
        	System.out.printf("Statement用时%dms%nPrepareStatement用时%dms%n",time2-time1,time3-time2);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
    }
  //分页查询的方法
    public static void list(int start, int count) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    	
    	//会自动关闭连接
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
    	System.out.println("list执行语句成功！");
    }
    
    //使用execute的分页查询execute可以执行查询语句
    //然后通过getResultSet，把结果集取出来
    public static void list2(int start, int count) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    	
    	//会自动关闭连接
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
    	System.out.println("list2执行语句成功！");
    }
    
    //获取表的元数据
    public static void yuanshuju()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "admin");) {
  
            // 查看数据库层面的元数据
            // 即数据库服务器版本，驱动版本，都有哪些数据库等等
            DatabaseMetaData dbmd = c.getMetaData();
  
            // 获取数据库服务器产品名称
            System.out.println("数据库产品名称:\t"+dbmd.getDatabaseProductName());
            // 获取数据库服务器产品版本号
            System.out.println("数据库产品版本:\t"+dbmd.getDatabaseProductVersion());
            // 获取数据库服务器用作类别和表名之间的分隔符 如test.user
            System.out.println("数据库和表分隔符:\t"+dbmd.getCatalogSeparator());
            // 获取驱动版本
            System.out.println("驱动版本:\t"+dbmd.getDriverVersion());
  
            System.out.println("可用的数据库列表：");
            // 获取数据库名称
            ResultSet rs = dbmd.getCatalogs();
  
            while (rs.next()) {
                System.out.println("数据库名称:\t"+rs.getString(1));
            }
  
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
    
    //获取自增ID，通过自增ID删除前一条（存在的）数据
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
            ps.setString(1, "自增英雄");
            ps.setFloat(2, 616);
            ps.setInt(3, 100);
   
            // 执行插入语句
            ps.execute();
   
            // 在执行完插入语句后，MySQL会为新插入的数据分配一个自增长id
            // JDBC通过getGeneratedKeys获取该id
            ResultSet rs = ps.getGeneratedKeys();
            int id=0;
            if (rs.next()) {
                id = rs.getInt(1);
                System.out.println("加入的记录id是："+id);
            }
            boolean flag=false;//判断是否找到了存在的上一个ID记录;
            System.out.println("删除的记录是：");
            while(!flag) {
            	id--;//指向上一条记录
            	String sqlQuery="select * from hero where id="+id;
            	s.execute(sqlQuery) ;//有结果返回true
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
            if(id==0)System.out.println("上一个ID对应的记录不存在");
            else {
                
	            String sqlDelete ="delete from hero where id="+id;
	            s.execute(sqlDelete);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //事物练习,询问是否删除数据库前10条记录
    public static void shiwu() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    	
    	//会自动关闭连接
    	try(Connection c =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
    			"root", "admin");
    			Statement s=c.createStatement();){
    		String sqlQuery="select * from Hero limit 0,5";
    		ResultSet r=s.executeQuery(sqlQuery);
    		System.out.println("要删除的文件是：");
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
    		System.out.println("请问是否要删除？Y/N");
    		while(!flag) {
	    		Scanner shuru=new Scanner(System.in);
	    		String zhiling=shuru.nextLine();
	    		if(zhiling.equals("Y")) {
	    			flag=true;
	    			c.commit();
	    			System.out.println("已提交删除！");
	    			
	    		}
	    		else if (zhiling.equals("N")) {
	    			flag=true;
	    			System.out.println("已终止删除。");
	    		}
	    		else {
	    			System.out.println("请问是否要删除？Y/N");
	    		}
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public static void main(String[] args) {
    	
    	//testPS();
    	//list(5,5);//分页查询1
    	//list2(5,5);
    	//yuanshuju();
    	//zizengID();
    	shiwu();
    	
    }
}