package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void chushihuaQudong() {
           
        //��ʼ������
        try {
            //������com.mysql.jdbc.Driver
            //���� mysql-connector-java-5.0.8-bin.jar��
            //��������˵�һ������ĵ������ͻ��׳�ClassNotFoundException
            Class.forName("com.mysql.jdbc.Driver");
              
            System.out.println("���ݿ��������سɹ� ��");
   
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
  
            // ���������ݿ��Connection����
            // ������Ҫ�ṩ��
            // ���ݿ������ڵ�ip:127.0.0.1 (����)
            // ���ݿ�Ķ˿ںţ� 3306 ��mysqlר�ö˿ںţ�
            // ���ݿ����� how2java
            // ���뷽ʽ UTF-8
            // �˺� root
            // ���� admin
  
            c = DriverManager
                    .getConnection(
                            "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                            "root", "admin");
  
            System.out.println("���ӳɹ�����ȡ���Ӷ��� " + c);
            
            // ע�⣺ʹ�õ��� java.sql.Statement
            // ��Ҫ��С��ʹ�õ��� com.mysql.jdbc.Statement;
            s = c.createStatement();//����statement ����ִ��sql���
            System.out.println("��ȡ Statement���� " + s);
            
            // ׼��sql���
            // ע�⣺ �ַ���Ҫ�õ�����'
            //�����������
            /*
            for(int i=0;i<100;i++) {
	            String sql = "insert into hero values(null,"+"'Ӣ��"+String.valueOf(i)+"',"+(i+100)+","+50+")";
	            s.execute(sql);
            }
            
            System.out.println("ִ�в������ɹ�");
            */
            //ɾ������
            /*
            String sql = "delete from hero where id=2";
            s.execute(sql);
            System.out.println("ִ��ɾ�����ɹ�");
            */
            
            //�޸�����
            /*
            String sql = "update hero set name = 'Ӣ��007' where id = 7";
            s.execute(sql);
            System.out.println("ִ���޸����ɹ�");
            */
            

            // ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
            /*
            String sql = "select * from hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");// ����ʹ���ֶ���
                String name = rs.getString(2);// Ҳ����ʹ���ֶε�˳��
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
            // ��һ��Ҫ������ر�ReultSet����ΪStatement�رյ�ʱ�򣬻��Զ��ر�ResultSet
            // rs.close();*/
            
            //��ȡ���ݿ������
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            int total = 0;
            while (rs.next()) {
                total = rs.getInt(1);
            }
            System.out.println("��Hero���ܹ���:" + total+" ������");
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            // ���ݿ������ʱ������Դ����ز������������ɹر����ݿ�ĺ�ϰ��
        	/*����ͨ�����ַ�ʽ�����Զ��ر�
        	 * try (
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin");
            Statement s = c.createStatement();             
        ){...
        }catch(...){...}
        	 */
        	 
            // �ȹر�Statement
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            // ��ر�Connection
            if (c != null)
                try {
                    c.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
 
        }
  
    }
    
    //ִ��sql���ķ���������ɾ���Ķ�������
    public static void execute(String sql) {
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
    		s.execute(sql);
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	//System.out.println("ִ�����ɹ���");
    }
    

    
    public static void main(String[] args) {
    	//jianlilianjie();
    	//execute("insert into hero values (1, '����', 616, 100);");
    	
    }
}