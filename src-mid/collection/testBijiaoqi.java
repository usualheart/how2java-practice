package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import property.Item;

public class testBijiaoqi {
	//ͨ��������췽������һ��TreeSet��ʹ�����еĵ������ǵ������
	public static void testTreeSet() {
		//���һ�������ıȽ�����o1<o2ʱ����1
		Comparator<Integer>daoxu=new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO �Զ����ɵķ������
				if(o1<o2)return 1;//Ĭ�ϴ�С�������򣬶�Ӧ��compare o1>o2�� ����1���˴�Ϊ�˵��򣬷�
				else return -1;
			}
			
		};
		TreeSet<Integer>ts=new TreeSet<Integer>();
		for(int i=1;i<20;i+=2) {
			ts.add(i);
			ts.add(i-1);
		}
		System.out.println(ts);
		//TreeSet<Integer>tsDao=new TreeSet<Integer>(daoxu);
		//19.03.01��дͨ��Lambda���ʽ��д
		TreeSet<Integer>tsDao=new TreeSet<Integer>((o1,o2)-> {if(o1<o2)return 1;else return -1;});
		tsDao.addAll(ts);
		System.out.println(tsDao);
	}
	
	//ͨ��Comparable�ӿڽ��бȽ�
	public static void cmpItem() {
		List<Item>l=new ArrayList<Item>();
		for(int i=0;i<10;i++) {
			Item tmp=new Item("Item"+i);
			tmp.price=(int) (100*(float)Math.random());
			l.add(tmp);
		}	
		for(Item t:l) {
			t.showItem();
		}
		//Collections.sort(l);
		//19.03.01��дͨ��Lambda���ʽ��д
		List<Item>tmp=l;
		Collections.sort(tmp,(o1,o2)-> {if(o1.price<o2.price)return 1;else return -1;});
		System.out.println("ͨ��lambda�����");
		for(Item t:tmp) {
			t.showItem();
		}
		
		//19.03.01����Item �еľ�̬����compareItem����ʵ��
		tmp=l;
		Collections.sort(tmp,(o1,o2)-> Item.compareItem(o1,o2));
		System.out.println("ͨ��Item �еľ�̬����compareItem����Ϊ�����");
		for(Item t:tmp) {
			t.showItem();
		}
		
		//19.03.01���������еĶ��󷽷�compareTo����ʵ��
		tmp=l;
		Collections.sort(tmp,(o1,o2)-> o1.compareTo(o2));
		System.out.println("ͨ��Item �еľ�̬����compareItem����Ϊ�����");
		for(Item t:tmp) {
			t.showItem();
		}
		//System.out.println(l);
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		testTreeSet();
		cmpItem();
	}

}
