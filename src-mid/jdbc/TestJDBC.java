package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void chushihuaQudong() {
           
        //初始化驱动
        try {
            //驱动类com.mysql.jdbc.Driver
            //就在 mysql-connector-java-5.0.8-bin.jar中
            //如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
            Class.forName("com.mysql.jdbc.Driver");
              
            System.out.println("数据库驱动加载成功 ！");
   
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
    }
    public static void jianlilianjie() {
    	Connection c=null;
    	Statement s=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
  
            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 how2java
            // 编码方式 UTF-8
            // 账号 root
            // 密码 admin
  
            c = DriverManager
                    .getConnection(
                            "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                            "root", "admin");
  
            System.out.println("连接成功，获取连接对象： " + c);
            
            // 注意：使用的是 java.sql.Statement
            // 不要不小心使用到： com.mysql.jdbc.Statement;
            s = c.createStatement();//创建statement 用于执行sql语句
            System.out.println("获取 Statement对象： " + s);
            
            // 准备sql语句
            // 注意： 字符串要用单引号'
            //批量添加数据
            /*
            for(int i=0;i<100;i++) {
	            String sql = "insert into hero values(null,"+"'英雄"+String.valueOf(i)+"',"+(i+100)+","+50+")";
	            s.execute(sql);
            }
            
            System.out.println("执行插入语句成功");
            */
            //删除数据
            /*
            String sql = "delete from hero where id=2";
            s.execute(sql);
            System.out.println("执行删除语句成功");
            */
            
            //修改数据
            /*
            String sql = "update hero set name = '英雄007' where id = 7";
            s.execute(sql);
            System.out.println("执行修改语句成功");
            */
            

            // 执行查询语句，并把结果集返回给ResultSet
            /*
            String sql = "select * from hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");// 可以使用字段名
                String name = rs.getString(2);// 也可以使用字段的顺序
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
            // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
            // rs.close();*/
            
            //获取数据库的总数
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            int total = 0;
            while (rs.next()) {
                total = rs.getInt(1);
            }
            System.out.println("表Hero中总共有:" + total+" 条数据");
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
        	/*或者通过这种方式可以自动关闭
        	 * try (
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin");
            Statement s = c.createStatement();             
        ){...
        }catch(...){...}
        	 */
        	 
            // 先关闭Statement
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            // 后关闭Connection
            if (c != null)
                try {
                    c.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
 
        }
  
    }
    
    //执行sql语句的方法，增加删除改动均可以
    public static void execute(String sql) {
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
    		s.execute(sql);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	//System.out.println("执行语句成功！");
    }
    

    
    public static void main(String[] args) {
    	//jianlilianjie();
    	//execute("insert into hero values (1, '盖伦', 616, 100);");
    	
    }
}