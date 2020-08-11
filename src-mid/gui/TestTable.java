package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jdbc.HeroDAO;
import multiplethread.Hero;

public class TestTable {
	public static void testJibenTable() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        // 表格上的title
        String[] columnNames = new String[] { "id", "name", "hp", "damage" };
        // 表格中的内容，是一个二维数组
        String[][] heros = new String[][] { { "1", "盖伦", "616", "100" },
                { "2", "提莫", "512", "102" }, { "3", "奎因", "832", "200" } };
        JTable t = new JTable(heros, columnNames);
        
        //加入JScrollPane 可以也显示出表格的标题 否则 标题无法显示出来
        JScrollPane sp=new JScrollPane(t);
        //或则创建一个空的JScrollPane，再通过setViewportView把table放在JScrollPane中
        // JScrollPane sp = new JScrollPane(t);
        // sp.setViewportView(t);
        
        // 设置列宽度的方法
        t.getColumnModel().getColumn(0).setPreferredWidth(10);
        
        // 把sp而非JTable加入到JFrame上
        f.add(sp, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	
	//TabelModel方式的测试
	public static void testTableModel() {
		  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        //创建一个TableModel
        HeroTableModel htm= new HeroTableModel();
         
        //根据 TableModel来创建 Table
        JTable t = new JTable(htm);
  
        JScrollPane sp = new JScrollPane(t);
  
        f.add(sp, BorderLayout.CENTER);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
	
		//TabelModel+Dao方式的测试
		/*
		 * 通过TableModel与DAO结合显示数据库中Hero信息。
		DAO使用HeroDAO
		在TableModel中，使用从DAO返回的List作为TableModel的数据
		只需要修改HeroTableModel，无需修改TestGUI。 这正好演绎了Model设计思想中的数据分离的好处，当只需要数据发生变化的时候，修改Model即可，界面GUI部分，不需要做任何改动
		*/
		public static void testTableModelDao() {
			  
	        JFrame f = new JFrame("LoL");
	        f.setSize(400, 300);
	        f.setLocation(200, 200);
	        f.setLayout(new BorderLayout());
	 
	        //创建一个TableModel
	        HeroTableModelDao htm= new HeroTableModelDao();
	         
	        //根据 TableModel来创建 Table
	        JTable t = new JTable(htm);
	        
	        
	        
	        //监听表格中的变化
	        // 准备一个Panel上面放一个Label用于显示哪条被选中了
	        JPanel p = new JPanel();
	        final JLabel l = new JLabel("暂时未选中条目");
	        p.add(l);
	        // 使用selection监听器来监听table的哪个条目被选中
	        t.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
  
                    // 当选择了某一行的时候触发该事件
                    public void valueChanged(ListSelectionEvent e) {
                        // 获取哪一行被选中了
                        int row = t.getSelectedRow();
                        // 根据选中的行，到HeroTableModel中获取对应的对象
                        Hero h = htm.heros.get(row);
                        // 更新标签内容
                        l.setText("当前选中的英雄是： " + h.name);
  
                    }
                });
	        
	        
	        JScrollPane sp = new JScrollPane(t);
	        f.add(p, BorderLayout.NORTH);//监听table变化的面板
	        f.add(sp, BorderLayout.CENTER);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	        f.setVisible(true);
	    }
	
	//更新table
	public static void updateTable() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        //
        final HeroTableModelDao htm = new HeroTableModelDao();
 
        
        final JTable t = new JTable(htm);
        // 设置选择模式为 只能选中一行
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // 选中第一行 （基本0）
        t.getSelectionModel().setSelectionInterval(0, 0);
        
        
        // 增加 一个 panel用于放置名称，血量输入框和增加 按钮
        JPanel p = new JPanel();
        final JLabel lName = new JLabel("名称");
        final JTextField tfName = new JTextField("");
        final JLabel lHp = new JLabel("血量");
        final JTextField tfHp = new JTextField("");
        JButton bAdd = new JButton("增加");
        tfName.setPreferredSize(new Dimension(80, 30));
        tfHp.setPreferredSize(new Dimension(80, 30));
        //加入panel
        p.add(lName);
        p.add(tfName);
        p.add(lHp);
        p.add(tfHp);
        p.add(bAdd);
 
        // 为增加按钮添加监听
        bAdd.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
 
                HeroDAO dao = new HeroDAO();
                
                // 根据输入框数据创建一个Hero对象
                Hero h = new Hero();
                try{
                	
	                h.name = tfName.getText();
	                // 也可以通过name长度判断 名称是否为空
	                if(h.name.equals("") ){
	                	 // 弹出对话框提示用户
	                    JOptionPane.showMessageDialog(f, "名称不能为空");
	                    // 名称输入框获取焦点
	                    tfName.grabFocus();
	                    return;
	                };
	                h.hp = Float.parseFloat(tfHp.getText());
	                // 通过dao把该对象加入到数据库
	                dao.add(h);
                }catch(NumberFormatException e1) {
                	JOptionPane.showMessageDialog(f, "血量必须是数字！");;
                	// 名称输入框获取焦点
                	tfHp.grabFocus();
                    return;
                }
                
 
                // 通过dao更新tablemodel中的数据
                htm.heros = dao.list();
                
                // 选中更新的一行 （基本0） 选中 第一行 ，因为 DAO是按照 ID倒排序查询，所以第一行就是新加入的数据
                t.getSelectionModel().setSelectionInterval(0, 0);
                
                // 调用JTable的updateUI，刷新界面。
                // 刷新界面的时候，会到tablemodel中去取最新的数据
                // 就能看到新加进去的数据了
                t.updateUI();
            }
        });
 
        JScrollPane sp = new JScrollPane(t);
 
        f.add(p, BorderLayout.NORTH);
        f.add(sp, BorderLayout.CENTER);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//testJibenTable();
		//testTableModel();
		//testTableModelDao();//通过TableModel与DAO结合显示数据库中Hero信息。
		//updateTable();//以新增数据到数据库中
		
	}

}
