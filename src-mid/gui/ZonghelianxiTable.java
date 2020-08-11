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
		//��ʼ����Ҫ�õ���Dao,�����漰�������ݵĲ���  ��ʹ����һ����DAO
		public static HeroDAO dao = new HeroDAO();
		//���ַ����������ʽ����������˵���
		public static Integer[] yeShu() {
	        int total=dao.getTotal();
	        //��������ֵ���Ŀ
	        int countYe=(total+9)/10;//���㹲�ж��ٸ�ҳ��
	        ArrayList<Integer> l=new ArrayList<Integer>();
	        for(int i=1;i<=countYe;i++) {
	        	l.add(i);
	        }
	        return l.toArray(new Integer[l.size()]);
		}
		
		
		//������Ӱ�ť������һ��JDialog����JDialog�н�������
		public static void tableAddDeleteEdit() {
			 
	        JFrame f = new JFrame("LoL");
	        f.setSize(400, 330);
	        f.setLocation(200, 200);
	        f.setLayout(new BorderLayout());
	 
	        //���õ���TableModel
	        final HeroTableModelDao htm = new HeroTableModelDao();
	        final JTable t = new JTable(htm);
	        // ����ѡ��ģʽΪ ֻ��ѡ��һ��
	        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        // ѡ�е�һ�� ������0��
	        t.getSelectionModel().setSelectionInterval(0, 0);
	       
	        
	        //JTable��ҳ�������岿��
	        JPanel p=new JPanel();
	        p.setPreferredSize(new Dimension(400,100));
	        JButton bAdd = new JButton("����");
	        JButton bDelete = new JButton("ɾ��");
	        JButton bEdit = new JButton("�༭ ");
	        
	        

	        
	        //��ҳ���ܵ���ҳ�ĳ�ʼ���Ͱ�ť��ҳ ��Ҫ�õ��ı�����ʼ��
	        htm.heros=dao.list(0, 10);
	        int[] ends= {10};//endָ��ǰҳ������һ��Ԫ�ص���һ��Ԫ�أ�����һҳ�ĵ�һ��Ԫ�أ�
	        
	        //ʵ�ְ�ť��ҳ�ļ�����ť
	        JPanel pFenye=new JPanel();//ʵ�ַ�ҳ�����
	        JButton bHome = new JButton("��ҳ");
	        JButton bLast = new JButton("��һҳ");
	        JButton bNext = new JButton("��һҳ");
	        JButton bEnd = new JButton("ĩҳ");
	        
	        /*
	                    * ʵ���������ҳ���ܵ������� ���¼�����
	         */
	        //��������ֵ���Ŀ
	        JComboBox <Integer>cb = new JComboBox<Integer>(yeShu());
	        cb.setPreferredSize(new Dimension(60,30));
	        cb.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO �Զ����ɵķ������
					//����1��ʾ��ѡ�е��Ǹ�һ��
					if(e.getStateChange()==1) {
						//����Ҫ���� ֻ��Ҫcb.getSelectedIndex()
						//String selected=(String) e.getItem();
						//int selectedInt=Integer.parseInt(selected);//����ѡ�񵽵��������ͽ��б�ʾ
						//System.out.println((String) e.getItem()+"  "+selectedInt+" "+cb.getSelectedIndex());
						
						int ye=cb.getSelectedIndex();
						int zongye=cb.getItemCount();
						int total=dao.getTotal();//total����ÿ�θ���
						
						int start=ye*10;
				        if(ye!=zongye-1) {
				        	htm.heros=dao.list(start, 10);
				        	ends[0]=start+10;//������ť��¼��ǰҳ�����ڵ�λ��
				        	if(start==0) {//��һ����Ҫ�԰�ť���д���
				        		bLast.setEnabled(false);
				        		bHome.setEnabled(false);
				        	}else {
					        	//�������(��Ϊ��һҳ��ĩҳʱ)Ӧ�ð�ť��������ʾ
					        	bLast.setEnabled(true);
				        		bHome.setEnabled(true);
				        		bNext.setEnabled(true);
					        	bEnd.setEnabled(true);
				        	}
				        }
				        else {
				        	//���һҳ���⴦��
				        	htm.heros=dao.list(start, total-start);
				        	ends[0]=total;//������ť��¼��ǰҳ�����ڵ�λ��
				        	
				        	//���һҳʱ�԰�ť�Ĵ���
				        	bNext.setEnabled(false);
				        	bEnd.setEnabled(false);
				        	bHome.setEnabled(true);//��ҳ����Ϊ����
				        	bLast.setEnabled(true);//����һҳ��ť����Ϊ����
				        	
			    		}
			    		t.updateUI();
					}
					//System.out.println(e.getStateChange()+"  "+e.getItem()+"  ");
				}
	        	
	        });
	        
	        
	        /*
	         * ʵ�ְ�ť��ҳ���ܵĲ���
	         */
	        pFenye.add(bHome);
	        pFenye.add(bLast);
	        pFenye.add(cb);
	        pFenye.add(bNext);
	        pFenye.add(bEnd);
	       
	        //ʵ�ַ�ҳ��ť���¼�����
	        bHome.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	    	        int total=dao.getTotal();//����Ӱ���˷�ҳ��ť�Ĺ��� ��ִ�����ӻ���ɾ������ʱ �����total���и���
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
	        		//cb.setSelectedItem(1);//����������ѡ�����Ŀ//��Ϊ��ѡ��ἤ����������¼� ���³����ظ��ʹ���
	        		t.updateUI();
	        	}
	        });
	        //��һҳ
	        bLast.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	    	        int total=dao.getTotal();//����Ӱ���˷�ҳ��ť�Ĺ��� ��ִ�����ӻ���ɾ������ʱ �����total���и���
	        		int start=ends[0]-20,count =10;
	        		if(ends[0]>20&&ends[0]!=total) {
	        			start=ends[0]-20;
	        			count=10;
	        		}else if(ends[0]==total) {
	        			//Ϊĩҳ
        				start=10*((total-1)/10)-10;//total-1��Ϊ����ĩҳ�������������Ȼ����������һҳ
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
	        		//cb.setSelectedItem(start/10+1);//����������ѡ�����Ŀ
	        		t.updateUI();
	        	}
	        });
	        //��һҳ
	        bNext.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	    	        int total=dao.getTotal();//����Ӱ���˷�ҳ��ť�Ĺ��� ��ִ�����ӻ���ɾ������ʱ �����total���и���
	        		int start=ends[0];
	        		int count;
	        		//System.out.println("2next��total�ǣ�"+total+"ends[o]:"+ends[0]);//����
	        		if(total>=ends[0]+10)
	        			count=10;
	        		else {
	        			//˵������ĩҳ
	        			count=total-start;
	        			bEnd.setEnabled(false);
	        			bNext.setEnabled(false);
	        		}
	        		//System.out.println("2next��total�ǣ�"+total+"ends[o]:"+ends[0]+"count:"+count);//����
	        		htm.heros=dao.list(start, count);
	        		ends[0]+=count;
	        		bHome.setEnabled(true);
	        		bLast.setEnabled(true);//����һҳ��ť����Ϊ����
	        		//cb.setSelectedItem(start/10+1);//����������ѡ�����Ŀ!ע�� �����û�������ʾ���³���
	        		//��ʹ�ø�ѡ��ʱ�����Բ�����дButton�����ʾ���ݲ��ֵĲ��� ֻ��Ҫ�жϵ�ǰ���ڵڼ�ҳ���� Ȼ����ø�ѡ�� Ȼ�󼴿ɼ��� ��������¼� ������ʾ����
	        		//��Ϊ��ѡ��ἤ����������¼� ���³����ظ��ʹ���
	        		t.updateUI();
	        	}
	        });
	        //ĩҳ
	        bEnd.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	    	        int total=dao.getTotal();//����Ӱ���˷�ҳ��ť�Ĺ��� ��ִ�����ӻ���ɾ������ʱ �����total���и���
	    	        int start=10*(total/10);
	    	        if(start!=total) {
	    	        	htm.heros=dao.list(start, total-start);
		        	//	cb.setSelectedItem(start/10+1);//����������ѡ�����Ŀ
	    	        }
	    	        else {
	    	        	htm.heros=dao.list(total-10, 10);
		        		//cb.setSelectedItem(total/10);//����������ѡ�����Ŀ
		        	}
	        		ends[0]=total;
	        		bNext.setEnabled(false);
	        		bEnd.setEnabled(false);
	        		bHome.setEnabled(true);//��ҳ����Ϊ����
	        		bLast.setEnabled(true);//����һҳ��ť����Ϊ����
	        		t.updateUI();
	        	
	        	}
	        });
	        
	        p.add(bAdd);
	        p.add(bDelete);
	        p.add(bEdit);
	        p.add(pFenye);//����ҳ������ײ������
	        f.add(p, BorderLayout.SOUTH);
	        
	        //���Ӻ�ɾ�����õĶԻ���
	        JDialog dAddEdit=new JDialog();
	        
	        dAddEdit.setBounds(250, 250, 300, 300);
	        dAddEdit.setLayout(new FlowLayout());
	        final JLabel lName = new JLabel("���ƣ�");
	        final JTextField tfName = new JTextField("");
	        final JLabel lHp = new JLabel("Ѫ����");
	        final JTextField tfHp = new JTextField("");
	        final JLabel lDamage = new JLabel("�˺���");
	        final JTextField tfDamage = new JTextField("");
	        Dimension ltfd=new Dimension(100, 30);
	        lName.setPreferredSize(ltfd);
	        lHp.setPreferredSize(ltfd);
	        lDamage.setPreferredSize(ltfd);
	        tfName.setPreferredSize(ltfd);
	        tfHp.setPreferredSize(ltfd);
	        tfDamage.setPreferredSize(ltfd);
	        JButton bDAdd=new JButton("�ύ");//���ӽ�����ύ �ȵ���ҳ���Ӱ�ť������ �Ž������Ի����
	        bDAdd.setPreferredSize(ltfd);
	        JButton bDEdit=new JButton("�ύ");//�༭������ύ �ȵ���ҳ���Ӱ�ť������ �Ž������Ի����
	        bDEdit.setPreferredSize(ltfd);
	        
	        //����JDialog
	        dAddEdit.add(lName);
	        dAddEdit.add(tfName);
	        dAddEdit.add(lHp);
	        dAddEdit.add(tfHp);
	        dAddEdit.add(lDamage);
	        dAddEdit.add(tfDamage);
	        dAddEdit.setResizable(false);
	        
	       
	        
	        // Ϊ��ҳ��Ӱ�ť��Ӽ���
	        bAdd.addActionListener(new ActionListener() {
	        	 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	        		dAddEdit.remove(bDEdit);////���༭�ġ��ύ��������г�ȥ
	    	        dAddEdit.add(bDAdd);//�ȵ���ҳ���Ӱ�ť������ �Ž������Ի���� ��������ѡ���Գ��ֶԻ����Ľ��� 
	            	dAddEdit.setTitle("������Ҫ��ӵ�����");
	            	//�ı�����Ϊ��
	            	tfName.setText("");
	     	        tfHp.setText("");
	     	        tfDamage.setText("");
	            	
	            	dAddEdit.setVisible(true);
	            }
	        });
	        
	        //�ԶԻ������ӹ��ܵġ��ύ����ť���м���
	        bDAdd.addActionListener(new ActionListener() {
	 
	        	 
	            public void actionPerformed(ActionEvent e) {
	            	
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
		                h.damage=Integer.parseInt(tfDamage.getText());
		                // ͨ��dao�Ѹö�����뵽���ݿ�
		                dao.add(h);
	                }catch(NumberFormatException e1) {
	                	JOptionPane.showMessageDialog(f, "Ѫ�����˺����������֣�");;
	                	// ����������ȡ����
	                	tfHp.grabFocus();
	                    return;
	                }
	                
	                // ͨ��dao����tablemodel�е����ݣ����ַ�ʽ�������Ӻ� ��ʾ���е����� Ŀǰ��Ϊ��ʾ��ҳ�������
	                //htm.heros = dao.list();
	                
	                
	                
	                ends[0]++;//��Ҫ�����ָ�������и��£�
	                //���ݲ�������ݿ������ ���Ƿ���Ҫ��ҳ�����ж�
	                int total=dao.getTotal();
	                if(total%10==1)cb.addItem(cb.getItemAt(cb.getItemCount()-1)+1);
	                //����Ϊ���Ӻ���ʾ��ҳ��Ĵ��� ����ʾ���һҳ ע�⵱ǰ�����ʱ���޷�������ʾ��Item״̬û�з����仯��ʱ��
	                cb.setSelectedIndex(0);//�л����� �õڶ����л�����⵽
	                cb.setSelectedIndex(cb.getItemCount()-1);
	                
	                // ѡ�и��µ�һ�� ������0�� ѡ�� ��һ�� ����Ϊ DAO�ǰ��� ID�������ѯ�����Ե�һ�о����¼��������
	               // t.getSelectionModel().setSelectionInterval(0, 0);
	               
	                
	                
	                dAddEdit.setVisible(false);//�ɹ������ر༭����
	                t.updateUI(); // ����JTable��updateUI��ˢ�½��档// ˢ�½����ʱ�򣬻ᵽtablemodel��ȥȡ���µ�����, ���ܿ����¼ӽ�ȥ��������
	                JOptionPane.showMessageDialog(f, "�ύ�ɹ���");
	                
	            }

	        });
	        
	      //����ҳɾ����ť���м���
	        bDelete.addActionListener(new ActionListener() {
	 
	        	 
	            public void actionPerformed(ActionEvent e) {
	            	
	            	//����Ƿ�ѡ����ĳһ�У�δѡ������о���
	            	int indexTable=t.getSelectionModel().getMinSelectionIndex();
	            	if(indexTable==-1) {
	            		JOptionPane.showMessageDialog(f, "ɾ��ǰӦ��ѡ��һ��", "����", 2);
	            		return;
	            	}
	            	
	            	//ѡ��Ի���
	            	int option = JOptionPane.showOptionDialog(f, "ȷ��Ҫɾ����", "ѡ��һ��ѡ��", 1, 3, null, null, null);
	            	if(option==JOptionPane.CANCEL_OPTION||option==JOptionPane.NO_OPTION) return;//ѡ��ȡ�����߷� �򷵻�
	            	
	            	
	            	//ִ��ɾ������
	            	int id=(int) t.getValueAt(indexTable, 0);
	                dao.delete(id);
	                // ͨ��dao����tablemodel�е�����
	                // htm.heros = dao.list();

	                //����ɾ�������ݿ������ ���Ƿ���Ҫ��ҳ�����ж�
	                int total=dao.getTotal();
	                if(total%10==0)cb.removeItemAt(cb.getItemCount()-1);//ȥ�����һ����
	                
	                //����Ϊɾ����ǰ���ڵ�ҳ�棬��ѡ�񵱰�ť��ҳ�治һ��ʱ��Ч��
	                cb.setSelectedIndex(cb.getSelectedIndex());
	                
	                // ѡ�и��µ�һ�� ������0�� ѡ�� ��һ�� ����Ϊ DAO�ǰ��� ID�������ѯ�����Ե�һ�о����¼��������
	                t.getSelectionModel().setSelectionInterval(0, 0);
	                // ����JTable��updateUI��ˢ�½��档
	                // ˢ�½����ʱ�򣬻ᵽtablemodel��ȥȡ���µ�����
	                // ���ܿ����¼ӽ�ȥ��������
	                t.updateUI();
	            }

	        });
	        
	        //����ҳ�༭��ť���м���
	         int ids[]=new int[1];//id�ڱ༭��ʱ����Ҫ�õ�
	        bEdit.addActionListener(new ActionListener() {
	 
	            public void actionPerformed(ActionEvent e) {
	            	
	            	
	            	//����Ƿ�ѡ����ĳһ�У�δѡ������о���
	            	int indexTable=t.getSelectionModel().getMinSelectionIndex();
	            	if(indexTable==-1) {
	            		JOptionPane.showMessageDialog(f, "ɾ��ǰӦ��ѡ��һ��", "����", 2);
	            		return;
	            	}
	            	dAddEdit.remove(bDAdd);
	            	dAddEdit.add(bDEdit);//�༭�ġ��ύ����ť����Ի����
	            	dAddEdit.setTitle("������ݽ����޸�");
	            	dAddEdit.setVisible(true);
	            	
	            	int id=(int) t.getValueAt(indexTable, 0);//��ȡ����е����� �����������Table�е����� ��TableModel�����ݿⶼ�޹�
	            	ids[0]=id;
	            	String name=(String) t.getValueAt(indexTable, 1);
	            	Float hp=(Float) t.getValueAt(indexTable, 2);
	            	int damage=(int) t.getValueAt(indexTable, 3);
	            	
	            	tfName.setText(name);
	     	        tfHp.setText(String.valueOf(hp));
	     	        tfDamage.setText(String.valueOf(damage));
	     	        
	            }
	        });
	        
	        //�ԶԻ����༭�ġ��ύ����ť���м���
	        bDEdit.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	                Hero h = new Hero();
	                try{
	                	h.id=ids[0];//����id
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
		                h.damage=Integer.parseInt(tfDamage.getText());
		                // ͨ��dao�Ѹö�����뵽���ݿ�
		                dao.update(h);
	                }catch(NumberFormatException e1) {
	                	JOptionPane.showMessageDialog(f, "Ѫ�����˺����������֣�");
	                	// ����������ȡ����
	                	tfHp.grabFocus();
	                    return;
	                }
	                
	                // ͨ��dao����tablemodel�е�����
	                // htm.heros = dao.list();
	                
	                //����Ϊɾ����ǰ���ڵ�ҳ�棬��ѡ�񵱰�ť��ҳ�治һ��ʱ��Ч��
	                cb.setSelectedIndex(cb.getSelectedIndex());
	                
	                // ѡ�и��µ�һ�� ������0�� ѡ�� ��һ�� ����Ϊ DAO�ǰ��� ID�������ѯ�����Ե�һ�о����¼��������
	                t.getSelectionModel().setSelectionInterval(0, 0);
	                // ����JTable��updateUI��ˢ�½��档
	                // ˢ�½����ʱ�򣬻ᵽtablemodel��ȥȡ���µ�����
	                // ���ܿ����¼ӽ�ȥ��������
	                
	                dAddEdit.setVisible(false);//�ɹ������ر༭����
	                t.updateUI();
	                JOptionPane.showMessageDialog(f, "�ύ�ɹ���");
		                
	        	}
	            	
	        });
	        
	        JScrollPane sp = new JScrollPane(t);
	        f.add(sp, BorderLayout.CENTER);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setVisible(true);
		}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/*
		 * ����Ƥ���ķ���
		
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		 */
		tableAddDeleteEdit();//������Ӱ�ť������һ��JDialog����JDialog�н������� table�����ݿ⽻���Ľ���
	}

}
