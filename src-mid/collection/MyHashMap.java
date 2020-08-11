package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MyHashMap implements IHashMap {
	
	Object[] x=new Object[2000];
	@Override
	public void put(String key, Object object) {
		// TODO 自动生成的方法存根
		Entry e=new Entry(key,object);
		int hashcode=TestHashcode.hashcode(key);
		if(null==x[hashcode]) {
			LinkedList<Entry>l=new LinkedList<Entry>();
			l.add(e);
			x[hashcode]=l;
		}
		else {
			LinkedList<Entry>l=(LinkedList<Entry>) x[hashcode];
			l.add(e);
			x[hashcode]=l;
		}
	}

	@Override
	public Object get(String key) {
		
		int hashcode=TestHashcode.hashcode(key);
		if(null==x[hashcode]) {
			return null;
		}
		else {
			LinkedList<Entry>l= (LinkedList<Entry>) x[hashcode];
	        ArrayList<CoHero>al=new ArrayList<CoHero>();
			for(Entry tmp:l) {
				if(tmp.key.equals(key))al.add((CoHero) tmp.value);
			}
			if (al.size()==1)return al.get(0);
			else return al;
		}
	}
	
	//测试HashMap查找的时间
	public static void main(String[]args) {
	        
	        MyHashMap CoHeroMap = new MyHashMap();
	        ArrayList<CoHero>al=new ArrayList<CoHero>();
	        for (int j = 0; j < 100000; j++) {
	        	int tmp=(int) (Math.random()*9000)+1000;
	            CoHero h = new CoHero("CoHero-" + tmp);
	            al.add(h);
	            CoHeroMap.put(h.name, h);
	        }
	        System.out.println("数据准备完成");
	        
	        //直接查找时间测试
	        ArrayList<CoHero>ans=new ArrayList<CoHero>();
	        long time0=System.currentTimeMillis();
	        for(CoHero hh:al) {
	        	if(hh.name.equals("CoHero-5555"))ans.add(hh);
	        }
	        long time1=System.currentTimeMillis();
            System.out.printf("ArrayList找到了CoHero!\t%s%n花费了：%d毫秒%n",ans,time1-time0);
            
            
            long start = System.currentTimeMillis();
            //查找名字是CoHero 1000000的对象
            Object target = CoHeroMap.get("CoHero-5555");
            System.out.println("MyHashMap找到了 CoHero!\t" + target);
            long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.println("花费了：" + elapsed + " 毫秒");
	        
	  
	    }

}
