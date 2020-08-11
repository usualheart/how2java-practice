package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MyHashMap implements IHashMap {
	
	Object[] x=new Object[2000];
	@Override
	public void put(String key, Object object) {
		// TODO �Զ����ɵķ������
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
	
	//����HashMap���ҵ�ʱ��
	public static void main(String[]args) {
	        
	        MyHashMap CoHeroMap = new MyHashMap();
	        ArrayList<CoHero>al=new ArrayList<CoHero>();
	        for (int j = 0; j < 100000; j++) {
	        	int tmp=(int) (Math.random()*9000)+1000;
	            CoHero h = new CoHero("CoHero-" + tmp);
	            al.add(h);
	            CoHeroMap.put(h.name, h);
	        }
	        System.out.println("����׼�����");
	        
	        //ֱ�Ӳ���ʱ�����
	        ArrayList<CoHero>ans=new ArrayList<CoHero>();
	        long time0=System.currentTimeMillis();
	        for(CoHero hh:al) {
	        	if(hh.name.equals("CoHero-5555"))ans.add(hh);
	        }
	        long time1=System.currentTimeMillis();
            System.out.printf("ArrayList�ҵ���CoHero!\t%s%n�����ˣ�%d����%n",ans,time1-time0);
            
            
            long start = System.currentTimeMillis();
            //����������CoHero 1000000�Ķ���
            Object target = CoHeroMap.get("CoHero-5555");
            System.out.println("MyHashMap�ҵ��� CoHero!\t" + target);
            long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.println("�����ˣ�" + elapsed + " ����");
	        
	  
	    }

}
