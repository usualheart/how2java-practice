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
 
        // ����ϵ�title
        String[] columnNames = new String[] { "id", "name", "hp", "damage" };
        // ����е����ݣ���һ����ά����
        String[][] heros = new String[][] { { "1", "����", "616", "100" },
                { "2", "��Ī", "512", "102" }, { "3", "����", "832", "200" } };
        JTable t = new JTable(heros, columnNames);
        
        //����JScrollPane ����Ҳ��ʾ�����ı��� ���� �����޷���ʾ����
        JScrollPane sp=new JScrollPane(t);
        //���򴴽�һ���յ�JScrollPane����ͨ��setViewportView��table����JScrollPane��
        // JScrollPane sp = new JScrollPane(t);
        // sp.setViewportView(t);
        
        // �����п�ȵķ���
        t.getColumnModel().getColumn(0).setPreferredWidth(10);
        
        // ��sp����JTable���뵽JFrame��
        f.add(sp, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
	
	//TabelModel��ʽ�Ĳ���
	public static void testTableModel() {
		  
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        //����һ��TableModel
        HeroTableModel htm= new HeroTableModel();
         
        //���� TableModel������ Table
        JTable t = new JTable(htm);
  
        JScrollPane sp = new JScrollPane(t);
  
        f.add(sp, BorderLayout.CENTER);
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }
	
		//TabelModel+Dao��ʽ�Ĳ���
		/*
		 * ͨ��TableModel��DAO�����ʾ���ݿ���Hero��Ϣ��
		DAOʹ��HeroDAO
		��TableModel�У�ʹ�ô�DAO���ص�List��ΪTableModel������
		ֻ��Ҫ�޸�HeroTableModel�������޸�TestGUI�� ������������Model���˼���е����ݷ���ĺô�����ֻ��Ҫ���ݷ����仯��ʱ���޸�Model���ɣ�����GUI���֣�����Ҫ���κθĶ�
		*/
		public static void testTableModelDao() {
			  
	        JFrame f = new JFrame("LoL");
	        f.setSize(400, 300);
	        f.setLocation(200, 200);
	        f.setLayout(new BorderLayout());
	 
	        //����һ��TableModel
	        HeroTableModelDao htm= new HeroTableModelDao();
	         
	        //���� TableModel������ Table
	        JTable t = new JTable(htm);
	        
	        
	        
	        //��������еı仯
	        // ׼��һ��Panel�����һ��Label������ʾ������ѡ����
	        JPanel p = new JPanel();
	        final JLabel l = new JLabel("��ʱδѡ����Ŀ");
	        p.add(l);
	        // ʹ��selection������������table���ĸ���Ŀ��ѡ��
	        t.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
  
                    // ��ѡ����ĳһ�е�ʱ�򴥷����¼�
                    public void valueChanged(ListSelectionEvent e) {
                        // ��ȡ��һ�б�ѡ����
                        int row = t.getSelectedRow();
                        // ����ѡ�е��У���HeroTableModel�л�ȡ��Ӧ�Ķ���
                        Hero h = htm.heros.get(row);
                        // ���±�ǩ����
                        l.setText("��ǰѡ�е�Ӣ���ǣ� " + h.name);
  
                    }
                });
	        
	        
	        JScrollPane sp = new JScrollPane(t);
	        f.add(p, BorderLayout.NORTH);//����table�仯�����
	        f.add(sp, BorderLayout.CENTER);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	        f.setVisible(true);
	    }
	
	//����table
	public static void updateTable() {
		 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        //
        final HeroTableModelDao htm = new HeroTableModelDao();
 
        
        final JTable t = new JTable(htm);
        // ����ѡ��ģʽΪ ֻ��ѡ��һ��
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // ѡ�е�һ�� ������0��
        t.getSelectionModel().setSelectionInterval(0, 0);
        
        
        // ���� һ�� panel���ڷ������ƣ�Ѫ������������ ��ť
        JPanel p = new JPanel();
        final JLabel lName = new JLabel("����");
        final JTextField tfName = new JTextField("");
        final JLabel lHp = new JLabel("Ѫ��");
        final JTextField tfHp = new JTextField("");
        JButton bAdd = new JButton("����");
        tfName.setPreferredSize(new Dimension(80, 30));
        tfHp.setPreferredSize(new Dimension(80, 30));
        //����panel
        p.add(lName);
        p.add(tfName);
        p.add(lHp);
        p.add(tfHp);
        p.add(bAdd);
 
        // Ϊ���Ӱ�ť��Ӽ���
        bAdd.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
 
                HeroDAO dao = new HeroDAO();
                
                // ������������ݴ���һ��Hero����
                Hero h = new Hero();
                try{
                	
	                h.name = tfName.getText();
	                // Ҳ����ͨ��name�����ж� �����Ƿ�Ϊ��
	                if(h.name.equals("") ){
	                	 // �����Ի�����ʾ�û�
	                    JOptionPane.showMessageDialog(f, "���Ʋ���Ϊ��");
	                    // ����������ȡ����
	                    tfName.grabFocus();
	                    return;
	                };
	                h.hp = Float.parseFloat(tfHp.getText());
	                // ͨ��dao�Ѹö�����뵽���ݿ�
	                dao.add(h);
                }catch(NumberFormatException e1) {
                	JOptionPane.showMessageDialog(f, "Ѫ�����������֣�");;
                	// ����������ȡ����
                	tfHp.grabFocus();
                    return;
                }
                
 
                // ͨ��dao����tablemodel�е�����
                htm.heros = dao.list();
                
                // ѡ�и��µ�һ�� ������0�� ѡ�� ��һ�� ����Ϊ DAO�ǰ��� ID�������ѯ�����Ե�һ�о����¼��������
                t.getSelectionModel().setSelectionInterval(0, 0);
                
                // ����JTable��updateUI��ˢ�½��档
                // ˢ�½����ʱ�򣬻ᵽtablemodel��ȥȡ���µ�����
                // ���ܿ����¼ӽ�ȥ��������
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
		// TODO �Զ����ɵķ������
		//testJibenTable();
		//testTableModel();
		//testTableModelDao();//ͨ��TableModel��DAO�����ʾ���ݿ���Hero��Ϣ��
		//updateTable();//���������ݵ����ݿ���
		
	}

}
