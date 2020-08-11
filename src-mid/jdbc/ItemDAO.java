package jdbc;


import java.sql.Connection;
 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import property.Item;
public class ItemDAO implements DAO<Item>{
  
    public ItemDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
                "admin");
    }
  
    public int getTotal() {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select count(*) from item";
  
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
  
            System.out.println("total:" + total);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return total;
    }
  
    public void add(Item item) {
  
        String sql = "insert into item values(null,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, item.name);
            ps.setFloat(2, item.price);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();//以ResultSet的形式返回自动生成的值（比如id等)
            if (rs.next()) {
                int id = rs.getInt(1);
                item.id = id;//以数据库自动生成的值更新item的id
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public void update(Item item) {
 
        String sql = "update item set name= ?, price = ? where id = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, item.name);
            ps.setFloat(2, item.price);
            ps.setInt(3, item.id);
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
  
    public void delete(int id) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from item where id = " + id;
  
            s.execute(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public Item get(int id) {
        Item item = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select * from item where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                item = new Item();
                String name = rs.getString(2);
                int price = rs.getInt("price");
                item.name = name;
                item.price = price;
                item.id = id;
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return item;
    }
  
    public List<Item> list() {
        return list(0, Short.MAX_VALUE);
    }
  
    public List<Item> list(int start, int count) {
        List<Item> items = new ArrayList<Item>();
  
        String sql = "select * from item order by id desc limit ?,? ";
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
            	Item item = new Item();
                String name = rs.getString(2);
                int id =rs.getInt(1);
                int price = rs.getInt("price");
                item.name = name;
                item.price = price;
                item.id = id;
                items.add(item);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return items;
    }
  
    
    public static void main(String[]args) {
    	ItemDAO id=new ItemDAO();
    	for(int i=0;i<10;i++) {
    		Item tmp=new Item();
    		tmp.name="Item"+i;
    		tmp.price=50+i*10;
    		id.add(tmp);
    	}
    	System.out.println(id.list());
    	System.out.println("数据库总数是："+id.getTotal());
    	id.delete(1);
    	System.out.println("删除后数据库总数是："+id.getTotal());
    	Item tmp2=id.get(2);
    	System.out.println(id.get(2));
    	tmp2.name=tmp2.name+"修改后";
    	id.update(tmp2);
    	System.out.println(id.list());
    	
    }
}
