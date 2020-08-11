package collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

import shuzizifuchuan.PojieMima;
public class TestOtherCollection {
	
	//除了实现了List接口外，LinkedList还实现了双向链表结构Deque，可以很方便的在头尾插入删除数据
	//LinkedList 除了实现了List和Deque外，还实现了Queue接口(队列)。
	/*Queue是先进先出队列 FIFO，常用方法：
	offer 在最后添加元素
	poll 取出第一个元素
	peek 查看第一个元素*/
	
	public static void testLianbiao() {
		//LinkedList是一个双向链表结构的list
        LinkedList<CoHero> ll =new LinkedList<CoHero>();
        
        //所以可以很方便的在头部和尾部插入数据
        //在最后插入新的英雄
        ll.addLast(new CoHero("CoHero1"));
        ll.addLast(new CoHero("CoHero2"));
        ll.addLast(new CoHero("CoHero3"));
        System.out.println(ll);
         
        //在最前面插入新的英雄
        ll.addFirst(new CoHero("CoHeroX"));
        System.out.println(ll);
         
        //查看最前面的英雄
        System.out.println(ll.getFirst());
        //查看最后面的英雄
        System.out.println(ll.getLast());
        //查看不会导致英雄被删除
        System.out.println(ll);
        
        //取出最前面的英雄
        System.out.println(ll.removeFirst());
        //取出最后面的英雄
        System.out.println(ll.removeLast());
        //取出会导致英雄被删除
        System.out.println(ll);
	}
		//在两种List最后插入100000条数据，比较快慢
		public static void testSpeed() {
			List<Integer> l;
	        l = new ArrayList<>();
	        insertFirst(l, "ArrayList");
	        insertMid(l,"ArrayList");
	        l = new LinkedList<>();
	        insertFirst(l, "LinkedList");
	        insertMid(l,"ArrayList");
	        
	        
		}
		
		//测试查找ArrayList中某个对象的速度
		public static void findArrayList() {
	        List<CoHero> CoHeros = new ArrayList<CoHero>();
	            
	        for (int j = 0; j < 2000000; j++) {
	            CoHero h = new CoHero("CoHero " + j);
	            CoHeros.add(h);
	        }
	            
	        // 进行10次查找，观察大体的平均值
	        for (int i = 0; i < 10; i++) {
	            // 打乱CoHeros中元素的顺序
	            Collections.shuffle(CoHeros);
	             
	            long start = System.currentTimeMillis();
	     
	            String target = "CoHero 1000000";
	     
	            for (CoHero CoHero : CoHeros) {
	                if (CoHero.name.equals(target)) {
	                    System.out.println("找到了 CoHero!" );
	                    break;
	                }
	            }
	            long end = System.currentTimeMillis();
	            long elapsed = end - start;
	            System.out.println("一共花了：" + elapsed + " 毫秒");
	        }
	             
	    }
		//在最后面插入数据
		private static void insertFirst(List<Integer> l, String type) {
	        int total = 1000 * 100;
	        final int number = 5;
	        long start = System.currentTimeMillis();
	        for (int i = 0; i < total; i++) {
	            l.add( number);//在最后面插入数据
	        }
	        long end = System.currentTimeMillis();
	        System.out.printf("在%s 最后面插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);
	    }
		//在中间插入数据，比较快慢
		private static void insertMid(List<Integer> l, String type) {
	        int total = 100 * 1000;
	        int index = total/2;
	        final int number = 5;
	        //初始化
	        for (int i = 0; i < total; i++) {
	            l.add(number);
	        }
	         
	        long start = System.currentTimeMillis();
	        for (int i = 0; i < total; i++) {
	             l.add(index, 7);
	        }
	        long end = System.currentTimeMillis();
	        System.out.printf("在%s 最中间插入%d条数据，总共耗时 %d 毫秒 %n", type,total,end - start);
	        System.out.println();
	    }
		
		
	
	 public static void testQueue() {
	        //和ArrayList一样，LinkedList也实现了List接口
	        List ll =new LinkedList<CoHero>();
	          
	        //所不同的是LinkedList还实现了Deque，进而又实现了Queue这个接口
	        //Queue代表FIFO 先进先出的队列
	        Queue<CoHero> q= new LinkedList<CoHero>();
	          
	        //加在队列的最后面
	        System.out.print("初始化队列：\t");
	        q.offer(new CoHero("CoHero1"));
	        q.offer(new CoHero("CoHero2"));
	        q.offer(new CoHero("CoHero3"));
	        q.offer(new CoHero("CoHero4"));
	          
	        System.out.println(q);
	        System.out.print("把第一个元素取poll()出来:\t");
	        //取出第一个CoHero，FIFO 先进先出
	        CoHero h = q.poll();
	        System.out.println(h);
	        System.out.print("取出第一个元素之后的队列:\t");
	        System.out.println(q);
	          
	        //把第一个拿出来看一看，但是不取出来
	        h=q.peek();
	        System.out.print("查看peek()第一个元素:\t");
	        System.out.println(h);
	        System.out.print("查看并不会导致第一个元素被取出来:\t");
	        System.out.println(q);
	          
	    }
	    
	  public static void testHashMap() {
	         HashMap<String,String> dictionary = new HashMap<>();
	         dictionary.put("adc", "物理英雄");
	         dictionary.put("apc", "魔法英雄");
	         dictionary.put("t", "坦克");
	         System.out.println(dictionary.get("apc"));
	         
	         
	         //
	         HashMap<String,CoHero> heroMap = new HashMap<String,CoHero>();
	         
	         heroMap.put("gareen", new CoHero("gareen1"));
	         System.out.println(heroMap);
	          
	         //key为gareen已经有value了，再以gareen作为key放入数据，会导致原英雄，被覆盖
	         //不会增加新的元素到Map中
	         heroMap.put("gareen", new CoHero("gareen2"));
	         System.out.println(heroMap);
	          
	         //清空map
	         heroMap.clear();
	         CoHero gareen = new CoHero("gareen");
	          
	         //同一个对象可以作为值插入到map中，只要对应的key不一样
	         heroMap.put("hero1", gareen);
	         heroMap.put("hero2", gareen);
	          
	         System.out.println(heroMap);
	     }
	
	  
	//使用两种方法查找英雄并测试时间
	public static void findHero() {
		ArrayList<CoHero>ACHs=new ArrayList<CoHero>();
		ArrayList<CoHero>ans=new ArrayList<CoHero>();
		ArrayList<CoHero>ans1=new ArrayList<CoHero>();
		//定义HashMap
		HashMap<String,ArrayList<CoHero>>HCHs=new HashMap<>();
		for(int i=0;i<3000000;i++) {
			CoHero h=new CoHero("CoHero-"+(int)(10000*Math.random()));
			ACHs.add(h);
			//HashMap添加，根据值分类,tmp存储所有等于h.name的英雄对象
			ArrayList<CoHero>tmp=new ArrayList<CoHero>();
			tmp.add(h);
			if(null!=HCHs.get(h.name))
				tmp.addAll(HCHs.get(h.name));
			HCHs.put(h.name,tmp);
		}
		
		long time0=System.currentTimeMillis();
        for(CoHero h:ACHs) {
        	if(h.name.equals("CoHero-8"))ans.add(h);
        }
        long time1=System.currentTimeMillis();
        ans1.addAll(HCHs.get("CoHero-8"));
        long time2=System.currentTimeMillis();
        
        System.out.println(ans.size());
        System.out.println(ans1.size());
        System.out.printf("不使用HashMap时间是%dms%n",time1-time0);
        System.out.printf("使用HashMap时间是%dms%n",time2-time1);
	}
	//反转HashMap，键和值反转
	public static HashMap<String, String> fanzhuanHashMap() {
		HashMap<String,String> hm=new HashMap<String,String>();
		HashMap<String,String> mh=new HashMap<String,String>();//存放反转后的HashMap
		hm.put("adc", "物理英雄");
		hm.put("apc", "魔法英雄");
		hm.put("t", "坦克");
		
		
		Set<String>hs=hm.keySet();
		Iterator<String> it=hs.iterator();
		while(it.hasNext()) {
			String tmp=it.next();
			mh.put(hm.get(tmp), tmp);
		}
		return mh;
		
	}
	
	//测试HashMap查找的时间
	public static void findHashMap() {
        
        HashMap<String,CoHero> CoHeroMap = new HashMap<String,CoHero>();
        for (int j = 0; j < 2000000; j++) {
            CoHero h = new CoHero("CoHero " + j);
            CoHeroMap.put(h.name, h);
        }
        System.out.println("数据准备完成");
  
        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            //查找名字是CoHero 1000000的对象
            CoHero target = CoHeroMap.get("CoHero 1000000");
            System.out.println("找到了 CoHero!" + target.name);
            long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.println("一共花了：" + elapsed + " 毫秒");
        }
  
    }
	
	//HashSet元素不能够重复
	public static void testHashSet() {
		HashSet<String> names = new HashSet<String>();
        names.add("gareen");
        System.out.println(names);
        //第二次插入同样的数据，是插不进去的，容器中只会保留一个
        names.add("gareen");
        System.out.println(names);
        
        
        HashSet<Integer> numbers = new HashSet<Integer>();
        numbers.add(9);
        numbers.add(5);
        numbers.add(1);
        // Set中的元素排列，不是按照插入顺序
        System.out.println(numbers);
        
	}
	//HashSet问题，找出重复的字符串
	public static void findChongfu() {
		String[] strs=PojieMima.suiStrArray(100,2);
		HashSet<String>strHS=new HashSet<String>();
		HashSet<String>Chongfu=new HashSet<String>();
		for(int i=0;i<strs.length;i++) {
			if(!strHS.add(strs[i]))Chongfu.add(strs[i]);
		}
		System.out.printf("%n共有%d种重复的字符串，是%n%s",Chongfu.size(),Chongfu);
	}
	
	//生成50个0-9999的随机数，要求不能重复
	public static void suijishu() {
		
		HashSet<Integer> hs=new HashSet<Integer>();
		while(hs.size()!=50) {
			int tmp=(int) (Math.random()*10000);
			hs.add(tmp);
		}
		System.out.println(hs);
	}
	
	//利用LinkedHashSet的既不重复，又有顺序的特性，把Math.PI中的数字，按照出现顺序打印出来，相同数字，只出现一次
	public static void testLHS() {
		LinkedHashSet<Integer>lhs=new LinkedHashSet();
		
		double x=Math.PI;
		while(lhs.size()!=10) {
			int tmp=(int)x;
			x=(x-tmp)*10;
			lhs.add(tmp);
		}
		System.out.println(lhs);
	}
	
	
	public static void main(String[] args) {
		//testLianbiao();
		//testSpeed();
		//testQueue();
		//findArrayList();
		
		//testHashMap();
		//findHero();
		findHashMap();
		//System.out.println(fanzhuanHashMap());
		
		//testHashSet();
		//findChongfu();
		//suijishu();
		//testLHS();
	}
}
