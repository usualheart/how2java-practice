package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import jdbc.HeroDAO;
import multiplethread.Hero;

public class ZonghelianxiTable {
		//初始化需要用到的Dao,所有涉及到对数据的操作  均使用这一个嗯DAO
		public static HeroDAO dao = new HeroDAO();
		//以字符串数组的形式返回下拉框菜单项
		public static Integer[] yeShu() {
	        int total=dao.getTotal();
	        //下拉框出现的条目
	        int countYe=(total+9)/10;//计算共有多少个页面
	        ArrayList<Integer> l=new ArrayList<Integer>();
	        for(int i=1;i<=countYe;i++) {
	        	l.add(i);
	        }
	        return l.toArray(new Integer[l.size()]);
		}
		
		
		//点击增加按钮，出现一个JDialog，在JDialog中进行增加
		public static void tableAddDeleteEdit() {
			 
	        JFrame f = new JFrame("LoL");
	        f.setSize(400, 330);
	        f.setLocation(200, 200);
	        f.setLayout(new BorderLayout());
	 
	        //所用到的TableModel
	        final HeroTableModelDao htm = new HeroTableModelDao();
	        final JTable t = new JTable(htm);
	        // 设置选择模式为 只能选中一行
	        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        // 选中第一行 （基本0）
	        t.getSelectionModel().setSelectionInterval(0, 0);
	       
	        
	        //JTable主页下面的面板部分
	        JPanel p=new JPanel();
	        p.setPreferredSize(new Dimension(400,100));
	        JButton bAdd = new JButton("增加");
	        JButton bDelete = new JButton("删除");
	        JButton bEdit = new JButton("编辑 ");
	        
	        

	        
	        //分页功能的首页的初始化和按钮分页 需要用到的变量初始化
	        htm.heros=dao.list(0, 10);
	        int[] ends= {10};//end指向当前页面的最后一个元素的下一个元素（即下一页的第一个元素）
	        
	        //实现按钮分页的几个按钮
	        JPanel pFenye=new JPanel();//实现分页的面板
	        JButton bHome = new JButton("首页");
	        JButton bLast = new JButton("上一页");
	        JButton bNext = new JButton("下一页");
	        JButton bEnd = new JButton("末页");
	        
	        /*
	                    * 实现下拉框分页功能的下拉框 和事件监听
	         */
	        //下拉框出现的条目
	        JComboBox <Integer>cb = new JComboBox<Integer>(yeShu());
	        cb.setPreferredSize(new Dimension(60,30));
	        cb.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO 自动生成的方法存根
					//等于1表示被选中的那个一项
					if(e.getStateChange()==1) {
						//不需要这样 只需要cb.getSelectedIndex()
						//String selected=(String) e.getItem();
						//int selectedInt=Integer.parseInt(selected);//将被选择到的行用整型进行表示
						//System.out.println((String) e.getItem()+"  "+selectedInt+" "+cb.getSelectedIndex());
						
						int ye=cb.getSelectedIndex();
						int zongye=cb.getItemCount();
						int total=dao.getTotal();//total必须每次更新
						
						int start=ye*10;
				        if(ye!=zongye-1) {
				        	htm.heros=dao.list(start, 10);
				        	ends[0]=start+10;//帮助按钮记录当前页面所在的位置
				        	if(start==0) {//第一行需要对按钮进行处理
				        		bLast.setEnabled(false);
				        		bHome.setEnabled(false);
				        	}else {
					        	//正常情况(不为第一页和末页时)应该按钮都正常显示
					        	bLast.setEnabled(true);
				        		bHome.setEnabled(true);
				        		bNext.setEnabled(true);
					        	bEnd.setEnabled(true);
				        	}
				        }
				        else {
				        	//最后一页特殊处理
				        	htm.heros=dao.list(start, total-start);
				        	ends[0]=total;//帮助按钮记录当前页面所在的位置
				        	
				        	//最后一页时对按钮的处理
				        	bNext.setEnabled(false);
				        	bEnd.setEnabled(false);
				        	bHome.setEnabled(true);//首页设置为可用
				        	bLast.setEnabled(true);//将上一页按钮设置为可用
				        	
			    		}
			    		t.updateUI();
					}
					//System.out.println(e.getStateChange()+"  "+e.getItem()+"  ");
				}
	        	
	        });
	        
	        
	        /*
	         * 实现按钮分页功能的部分
	         */
	        pFenye.add(bHome);
	        pFenye.add(bLast);
	        pFenye.add(cb);
	        pFenye.add(bNext);
	        pFenye.add(bEnd);
	       
	        //实现分页按钮的事件监听
	        bHome.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	    	        int total=dao.getTotal();//总数影响了分页按钮的功能 当执行增加或者删除操作时 必须对total进行更新
	        		if(total>=10) {
	        			htm.heros=dao.list(0, 10);
	        			ends[0]=10;}
	        		else {
	        			htm.heros=dao.list(0, total);
	        			ends[0]=total;}
	        		bLast.setEnabled(false);
	        		bHome.setEnabled(false);
	        		bNext.setEnabled(true);
	        		bEnd.setEnabled(true);
	        		//cb.setSelectedItem(1);//设置下拉框选择的条目//因为该选项会激发下拉框的事件 导致出现重复和错误！
	        		t.updateUI();
	        	}
	        });
	        //上一页
	        bLast.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	    	        int total=dao.getTotal();//总数影响了分页按钮的功能 当执行增加或者删除操作时 必须对total进行更新
	        		int start=ends[0]-20,count =10;
	        		if(ends[0]>20&&ends[0]!=total) {
	        			start=ends[0]-20;
	        			count=10;
	        		}else if(ends[0]==total) {
	        			//为末页
        				start=10*((total-1)/10)-10;//total-1是为了在末页是满的情况下依然可以跳到上一页
        				count=10;
	        		}else if(ends[0]>=10&&ends[0]<=20) {
	        			start=0;
	        			count=10;
	        			bLast.setEnabled(false);
	        			bHome.setEnabled(false);
	        		}
	        		htm.heros=dao.list(start, count);
	        		ends[0]=start+count;
	        		bNext.setEnabled(true);
	        		bEnd.setEnabled(true);
	        		//cb.setSelectedItem(start/10+1);//设置下拉框选择的条目
	        		t.updateUI();
	        	}
	        });
	        //下一页
	        bNext.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	    	        int total=dao.getTotal();//总数影响了分页按钮的功能 当执行增加或者删除操作时 必须对total进行更新
	        		int start=ends[0];
	        		int count;
	        		//System.out.println("2next的total是："+total+"ends[o]:"+ends[0]);//测试
	        		if(total>=ends[0]+10)
	        			count=10;
	        		else {
	        			//说明到了末页
	        			count=total-start;
	        			bEnd.setEnabled(false);
	        			bNext.setEnabled(false);
	        		}
	        		//System.out.println("2next的total是："+total+"ends[o]:"+ends[0]+"count:"+count);//测试
	        		htm.heros=dao.list(start, count);
	        		ends[0]+=count;
	        		bHome.setEnabled(true);
	        		bLast.setEnabled(true);//将上一页按钮设置为可用
	        		//cb.setSelectedItem(start/10+1);//设置下拉框选择的条目!注意 该设置会数据显示导致出错！
	        		//当使用该选项时，可以不用再写Button里边显示数据部分的操作 只需要判断当前处于第几页即可 然后调用该选项 然后即可激发 下拉框的事件 进行显示处理
	        		//因为该选项会激发下拉框的事件 导致出现重复和错误！
	        		t.updateUI();
	        	}
	        });
	        //末页
	        bEnd.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	    	        int total=dao.getTotal();//总数影响了分页按钮的功能 当执行增加或者删除操作时 必须对total进行更新
	    	        int start=10*(total/10);
	    	        if(start!=total) {
	    	        	htm.heros=dao.list(start, total-start);
		        	//	cb.setSelectedItem(start/10+1);//设置下拉框选择的条目
	    	        }
	    	        else {
	    	        	htm.heros=dao.list(total-10, 10);
		        		//cb.setSelectedItem(total/10);//设置下拉框选择的条目
		        	}
	        		ends[0]=total;
	        		bNext.setEnabled(false);
	        		bEnd.setEnabled(false);
	        		bHome.setEnabled(true);//首页设置为可用
	        		bLast.setEnabled(true);//将上一页按钮设置为可用
	        		t.updateUI();
	        	
	        	}
	        });
	        
	        p.add(bAdd);
	        p.add(bDelete);
	        p.add(bEdit);
	        p.add(pFenye);//将分页面板加入底部的面板
	        f.add(p, BorderLayout.SOUTH);
	        
	        //增加和删除公用的对话框
	        JDialog dAddEdit=new JDialog();
	        
	        dAddEdit.setBounds(250, 250, 300, 300);
	        dAddEdit.setLayout(new FlowLayout());
	        final JLabel lName = new JLabel("名称：");
	        final JTextField tfName = new JTextField("");
	        final JLabel lHp = new JLabel("血量：");
	        final JTextField tfHp = new JTextField("");
	        final JLabel lDamage = new JLabel("伤害：");
	        final JTextField tfDamage = new JTextField("");
	        Dimension ltfd=new Dimension(100, 30);
	        lName.setPreferredSize(ltfd);
	        lHp.setPreferredSize(ltfd);
	        lDamage.setPreferredSize(ltfd);
	        tfName.setPreferredSize(ltfd);
	        tfHp.setPreferredSize(ltfd);
	        tfDamage.setPreferredSize(ltfd);
	        JButton bDAdd=new JButton("提交");//增加界面的提交 等到主页增加按钮被按下 才将其加入对话面板
	        bDAdd.setPreferredSize(ltfd);
	        JButton bDEdit=new JButton("提交");//编辑界面的提交 等到主页增加按钮被按下 才将其加入对话面板
	        bDEdit.setPreferredSize(ltfd);
	        
	        //加入JDialog
	        dAddEdit.add(lName);
	        dAddEdit.add(tfName);
	        dAddEdit.add(lHp);
	        dAddEdit.add(tfHp);
	        dAddEdit.add(lDamage);
	        dAddEdit.add(tfDamage);
	        dAddEdit.setResizable(false);
	        
	       
	        
	        // 为主页添加按钮添加监听
	        bAdd.addActionListener(new ActionListener() {
	        	 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	        		dAddEdit.remove(bDEdit);////将编辑的“提交”从面板中出去
	    	        dAddEdit.add(bDAdd);//等到主页增加按钮被按下 才将其加入对话面板 这样可以选择性呈现对话面板的界面 
	            	dAddEdit.setTitle("请输入要添加的数据");
	            	//文本框置为空
	            	tfName.setText("");
	     	        tfHp.setText("");
	     	        tfDamage.setText("");
	            	
	            	dAddEdit.setVisible(true);
	            }
	        });
	        
	        //对对话面板添加功能的“提交”按钮进行监听
	        bDAdd.addActionListener(new ActionListener() {
	 
	        	 
	            public void actionPerformed(ActionEvent e) {
	            	
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
		                h.damage=Integer.parseInt(tfDamage.getText());
		                // 通过dao把该对象加入到数据库
		                dao.add(h);
	                }catch(NumberFormatException e1) {
	                	JOptionPane.showMessageDialog(f, "血量或伤害必须是数字！");;
	                	// 名称输入框获取焦点
	                	tfHp.grabFocus();
	                    return;
	                }
	                
	                // 通过dao更新tablemodel中的数据，这种方式是在增加后 显示所有的数据 目前改为显示分页后的数据
	                //htm.heros = dao.list();
	                
	                
	                
	                ends[0]++;//需要将最后指向的项进行更新！
	                //根据插入后数据库的总数 对是否需要加页进行判断
	                int total=dao.getTotal();
	                if(total%10==1)cb.addItem(cb.getItemAt(cb.getItemCount()-1)+1);
	                //更改为增加后显示分页后的窗口 即显示最后一页 注意当前情况有时候无法激活显示：Item状态没有发生变化的时候
	                cb.setSelectedIndex(0);//切换两次 让第二次切换被检测到
	                cb.setSelectedIndex(cb.getItemCount()-1);
	                
	                // 选中更新的一行 （基本0） 选中 第一行 ，因为 DAO是按照 ID倒排序查询，所以第一行就是新加入的数据
	               // t.getSelectionModel().setSelectionInterval(0, 0);
	               
	                
	                
	                dAddEdit.setVisible(false);//成功后隐藏编辑窗口
	                t.updateUI(); // 调用JTable的updateUI，刷新界面。// 刷新界面的时候，会到tablemodel中去取最新的数据, 就能看到新加进去的数据了
	                JOptionPane.showMessageDialog(f, "提交成功！");
	                
	            }

	        });
	        
	      //对主页删除按钮进行监听
	        bDelete.addActionListener(new ActionListener() {
	 
	        	 
	            public void actionPerformed(ActionEvent e) {
	            	
	            	//检查是否选中了某一行，未选中则进行警告
	            	int indexTable=t.getSelectionModel().getMinSelectionIndex();
	            	if(indexTable==-1) {
	            		JOptionPane.showMessageDialog(f, "删除前应该选中一行", "警告", 2);
	            		return;
	            	}
	            	
	            	//选择对话框
	            	int option = JOptionPane.showOptionDialog(f, "确认要删除？", "选择一个选项", 1, 3, null, null, null);
	            	if(option==JOptionPane.CANCEL_OPTION||option==JOptionPane.NO_OPTION) return;//选择取消或者否 则返回
	            	
	            	
	            	//执行删除动作
	            	int id=(int) t.getValueAt(indexTable, 0);
	                dao.delete(id);
	                // 通过dao更新tablemodel中的数据
	                // htm.heros = dao.list();

	                //根据删除后数据库的总数 对是否需要减页进行判断
	                int total=dao.getTotal();
	                if(total%10==0)cb.removeItemAt(cb.getItemCount()-1);//去掉最后一个项
	                
	                //更改为删除当前所在的页面，该选择当按钮与页面不一致时无效！
	                cb.setSelectedIndex(cb.getSelectedIndex());
	                
	                // 选中更新的一行 （基本0） 选中 第一行 ，因为 DAO是按照 ID倒排序查询，所以第一行就是新加入的数据
	                t.getSelectionModel().setSelectionInterval(0, 0);
	                // 调用JTable的updateUI，刷新界面。
	                // 刷新界面的时候，会到tablemodel中去取最新的数据
	                // 就能看到新加进去的数据了
	                t.updateUI();
	            }

	        });
	        
	        //对主页编辑按钮进行监听
	         int ids[]=new int[1];//id在编辑的时候需要用到
	        bEdit.addActionListener(new ActionListener() {
	 
	            public void actionPerformed(ActionEvent e) {
	            	
	            	
	            	//检查是否选中了某一行，未选中则进行警告
	            	int indexTable=t.getSelectionModel().getMinSelectionIndex();
	            	if(indexTable==-1) {
	            		JOptionPane.showMessageDialog(f, "删除前应该选中一行", "警告", 2);
	            		return;
	            	}
	            	dAddEdit.remove(bDAdd);
	            	dAddEdit.add(bDEdit);//编辑的“提交”按钮加入对话面板
	            	dAddEdit.setTitle("请对数据进行修改");
	            	dAddEdit.setVisible(true);
	            	
	            	int id=(int) t.getValueAt(indexTable, 0);//获取表格中的数据 这里的索引是Table中的索引 与TableModel和数据库都无关
	            	ids[0]=id;
	            	String name=(String) t.getValueAt(indexTable, 1);
	            	Float hp=(Float) t.getValueAt(indexTable, 2);
	            	int damage=(int) t.getValueAt(indexTable, 3);
	            	
	            	tfName.setText(name);
	     	        tfHp.setText(String.valueOf(hp));
	     	        tfDamage.setText(String.valueOf(damage));
	     	        
	            }
	        });
	        
	        //对对话面板编辑的“提交”按钮进行监听
	        bDEdit.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	                Hero h = new Hero();
	                try{
	                	h.id=ids[0];//设置id
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
		                h.damage=Integer.parseInt(tfDamage.getText());
		                // 通过dao把该对象加入到数据库
		                dao.update(h);
	                }catch(NumberFormatException e1) {
	                	JOptionPane.showMessageDialog(f, "血量或伤害必须是数字！");
	                	// 名称输入框获取焦点
	                	tfHp.grabFocus();
	                    return;
	                }
	                
	                // 通过dao更新tablemodel中的数据
	                // htm.heros = dao.list();
	                
	                //更改为删除当前所在的页面，该选择当按钮与页面不一致时无效！
	                cb.setSelectedIndex(cb.getSelectedIndex());
	                
	                // 选中更新的一行 （基本0） 选中 第一行 ，因为 DAO是按照 ID倒排序查询，所以第一行就是新加入的数据
	                t.getSelectionModel().setSelectionInterval(0, 0);
	                // 调用JTable的updateUI，刷新界面。
	                // 刷新界面的时候，会到tablemodel中去取最新的数据
	                // 就能看到新加进去的数据了
	                
	                dAddEdit.setVisible(false);//成功后隐藏编辑窗口
	                t.updateUI();
	                JOptionPane.showMessageDialog(f, "提交成功！");
		                
	        	}
	            	
	        });
	        
	        JScrollPane sp = new JScrollPane(t);
	        f.add(sp, BorderLayout.CENTER);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setVisible(true);
		}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * 设置皮肤的方法
		
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		 */
		tableAddDeleteEdit();//点击增加按钮，出现一个JDialog，在JDialog中进行增加 table和数据库交互的界面
	}

}
