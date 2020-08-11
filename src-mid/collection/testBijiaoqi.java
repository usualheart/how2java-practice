package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import property.Item;

public class testBijiaoqi {
	//通过这个构造方法创建一个TreeSet，使得其中的的数字是倒排序的
	public static void testTreeSet() {
		//设计一个整数的比较器，o1<o2时返回1
		Comparator<Integer>daoxu=new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO 自动生成的方法存根
				if(o1<o2)return 1;//默认从小到大排序，对应的compare o1>o2是 返回1，此处为了倒序，反
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
		//19.03.01改写通过Lambda表达式改写
		TreeSet<Integer>tsDao=new TreeSet<Integer>((o1,o2)-> {if(o1<o2)return 1;else return -1;});
		tsDao.addAll(ts);
		System.out.println(tsDao);
	}
	
	//通过Comparable接口进行比较
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
		//19.03.01改写通过Lambda表达式改写
		List<Item>tmp=l;
		Collections.sort(tmp,(o1,o2)-> {if(o1.price<o2.price)return 1;else return -1;});
		System.out.println("通过lambda排序后：");
		for(Item t:tmp) {
			t.showItem();
		}
		
		//19.03.01引用Item 中的静态方法compareItem方法实现
		tmp=l;
		Collections.sort(tmp,(o1,o2)-> Item.compareItem(o1,o2));
		System.out.println("通过Item 中的静态方法compareItem排序为正序后：");
		for(Item t:tmp) {
			t.showItem();
		}
		
		//19.03.01引用容器中的对象方法compareTo方法实现
		tmp=l;
		Collections.sort(tmp,(o1,o2)-> o1.compareTo(o2));
		System.out.println("通过Item 中的静态方法compareItem排序为倒序后：");
		for(Item t:tmp) {
			t.showItem();
		}
		//System.out.println(l);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		testTreeSet();
		cmpItem();
	}

}
