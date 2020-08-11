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
	
	//����ʵ����List�ӿ��⣬LinkedList��ʵ����˫������ṹDeque�����Ժܷ������ͷβ����ɾ������
	//LinkedList ����ʵ����List��Deque�⣬��ʵ����Queue�ӿ�(����)��
	/*Queue���Ƚ��ȳ����� FIFO�����÷�����
	offer ��������Ԫ��
	poll ȡ����һ��Ԫ��
	peek �鿴��һ��Ԫ��*/
	
	public static void testLianbiao() {
		//LinkedList��һ��˫������ṹ��list
        LinkedList<CoHero> ll =new LinkedList<CoHero>();
        
        //���Կ��Ժܷ������ͷ����β����������
        //���������µ�Ӣ��
        ll.addLast(new CoHero("CoHero1"));
        ll.addLast(new CoHero("CoHero2"));
        ll.addLast(new CoHero("CoHero3"));
        System.out.println(ll);
         
        //����ǰ������µ�Ӣ��
        ll.addFirst(new CoHero("CoHeroX"));
        System.out.println(ll);
         
        //�鿴��ǰ���Ӣ��
        System.out.println(ll.getFirst());
        //�鿴������Ӣ��
        System.out.println(ll.getLast());
        //�鿴���ᵼ��Ӣ�۱�ɾ��
        System.out.println(ll);
        
        //ȡ����ǰ���Ӣ��
        System.out.println(ll.removeFirst());
        //ȡ��������Ӣ��
        System.out.println(ll.removeLast());
        //ȡ���ᵼ��Ӣ�۱�ɾ��
        System.out.println(ll);
	}
		//������List������100000�����ݣ��ȽϿ���
		public static void testSpeed() {
			List<Integer> l;
	        l = new ArrayList<>();
	        insertFirst(l, "ArrayList");
	        insertMid(l,"ArrayList");
	        l = new LinkedList<>();
	        insertFirst(l, "LinkedList");
	        insertMid(l,"ArrayList");
	        
	        
		}
		
		//���Բ���ArrayList��ĳ��������ٶ�
		public static void findArrayList() {
	        List<CoHero> CoHeros = new ArrayList<CoHero>();
	            
	        for (int j = 0; j < 2000000; j++) {
	            CoHero h = new CoHero("CoHero " + j);
	            CoHeros.add(h);
	        }
	            
	        // ����10�β��ң��۲�����ƽ��ֵ
	        for (int i = 0; i < 10; i++) {
	            // ����CoHeros��Ԫ�ص�˳��
	            Collections.shuffle(CoHeros);
	             
	            long start = System.currentTimeMillis();
	     
	            String target = "CoHero 1000000";
	     
	            for (CoHero CoHero : CoHeros) {
	                if (CoHero.name.equals(target)) {
	                    System.out.println("�ҵ��� CoHero!" );
	                    break;
	                }
	            }
	            long end = System.currentTimeMillis();
	            long elapsed = end - start;
	            System.out.println("һ�����ˣ�" + elapsed + " ����");
	        }
	             
	    }
		//��������������
		private static void insertFirst(List<Integer> l, String type) {
	        int total = 1000 * 100;
	        final int number = 5;
	        long start = System.currentTimeMillis();
	        for (int i = 0; i < total; i++) {
	            l.add( number);//��������������
	        }
	        long end = System.currentTimeMillis();
	        System.out.printf("��%s ��������%d�����ݣ��ܹ���ʱ %d ���� %n", type, total, end - start);
	    }
		//���м�������ݣ��ȽϿ���
		private static void insertMid(List<Integer> l, String type) {
	        int total = 100 * 1000;
	        int index = total/2;
	        final int number = 5;
	        //��ʼ��
	        for (int i = 0; i < total; i++) {
	            l.add(number);
	        }
	         
	        long start = System.currentTimeMillis();
	        for (int i = 0; i < total; i++) {
	             l.add(index, 7);
	        }
	        long end = System.currentTimeMillis();
	        System.out.printf("��%s ���м����%d�����ݣ��ܹ���ʱ %d ���� %n", type,total,end - start);
	        System.out.println();
	    }
		
		
	
	 public static void testQueue() {
	        //��ArrayListһ����LinkedListҲʵ����List�ӿ�
	        List ll =new LinkedList<CoHero>();
	          
	        //����ͬ����LinkedList��ʵ����Deque��������ʵ����Queue����ӿ�
	        //Queue����FIFO �Ƚ��ȳ��Ķ���
	        Queue<CoHero> q= new LinkedList<CoHero>();
	          
	        //���ڶ��е������
	        System.out.print("��ʼ�����У�\t");
	        q.offer(new CoHero("CoHero1"));
	        q.offer(new CoHero("CoHero2"));
	        q.offer(new CoHero("CoHero3"));
	        q.offer(new CoHero("CoHero4"));
	          
	        System.out.println(q);
	        System.out.print("�ѵ�һ��Ԫ��ȡpoll()����:\t");
	        //ȡ����һ��CoHero��FIFO �Ƚ��ȳ�
	        CoHero h = q.poll();
	        System.out.println(h);
	        System.out.print("ȡ����һ��Ԫ��֮��Ķ���:\t");
	        System.out.println(q);
	          
	        //�ѵ�һ���ó�����һ�������ǲ�ȡ����
	        h=q.peek();
	        System.out.print("�鿴peek()��һ��Ԫ��:\t");
	        System.out.println(h);
	        System.out.print("�鿴�����ᵼ�µ�һ��Ԫ�ر�ȡ����:\t");
	        System.out.println(q);
	          
	    }
	    
	  public static void testHashMap() {
	         HashMap<String,String> dictionary = new HashMap<>();
	         dictionary.put("adc", "����Ӣ��");
	         dictionary.put("apc", "ħ��Ӣ��");
	         dictionary.put("t", "̹��");
	         System.out.println(dictionary.get("apc"));
	         
	         
	         //
	         HashMap<String,CoHero> heroMap = new HashMap<String,CoHero>();
	         
	         heroMap.put("gareen", new CoHero("gareen1"));
	         System.out.println(heroMap);
	          
	         //keyΪgareen�Ѿ���value�ˣ�����gareen��Ϊkey�������ݣ��ᵼ��ԭӢ�ۣ�������
	         //���������µ�Ԫ�ص�Map��
	         heroMap.put("gareen", new CoHero("gareen2"));
	         System.out.println(heroMap);
	          
	         //���map
	         heroMap.clear();
	         CoHero gareen = new CoHero("gareen");
	          
	         //ͬһ�����������Ϊֵ���뵽map�У�ֻҪ��Ӧ��key��һ��
	         heroMap.put("hero1", gareen);
	         heroMap.put("hero2", gareen);
	          
	         System.out.println(heroMap);
	     }
	
	  
	//ʹ�����ַ�������Ӣ�۲�����ʱ��
	public static void findHero() {
		ArrayList<CoHero>ACHs=new ArrayList<CoHero>();
		ArrayList<CoHero>ans=new ArrayList<CoHero>();
		ArrayList<CoHero>ans1=new ArrayList<CoHero>();
		//����HashMap
		HashMap<String,ArrayList<CoHero>>HCHs=new HashMap<>();
		for(int i=0;i<3000000;i++) {
			CoHero h=new CoHero("CoHero-"+(int)(10000*Math.random()));
			ACHs.add(h);
			//HashMap��ӣ�����ֵ����,tmp�洢���е���h.name��Ӣ�۶���
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
        System.out.printf("��ʹ��HashMapʱ����%dms%n",time1-time0);
        System.out.printf("ʹ��HashMapʱ����%dms%n",time2-time1);
	}
	//��תHashMap������ֵ��ת
	public static HashMap<String, String> fanzhuanHashMap() {
		HashMap<String,String> hm=new HashMap<String,String>();
		HashMap<String,String> mh=new HashMap<String,String>();//��ŷ�ת���HashMap
		hm.put("adc", "����Ӣ��");
		hm.put("apc", "ħ��Ӣ��");
		hm.put("t", "̹��");
		
		
		Set<String>hs=hm.keySet();
		Iterator<String> it=hs.iterator();
		while(it.hasNext()) {
			String tmp=it.next();
			mh.put(hm.get(tmp), tmp);
		}
		return mh;
		
	}
	
	//����HashMap���ҵ�ʱ��
	public static void findHashMap() {
        
        HashMap<String,CoHero> CoHeroMap = new HashMap<String,CoHero>();
        for (int j = 0; j < 2000000; j++) {
            CoHero h = new CoHero("CoHero " + j);
            CoHeroMap.put(h.name, h);
        }
        System.out.println("����׼�����");
  
        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            //����������CoHero 1000000�Ķ���
            CoHero target = CoHeroMap.get("CoHero 1000000");
            System.out.println("�ҵ��� CoHero!" + target.name);
            long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.println("һ�����ˣ�" + elapsed + " ����");
        }
  
    }
	
	//HashSetԪ�ز��ܹ��ظ�
	public static void testHashSet() {
		HashSet<String> names = new HashSet<String>();
        names.add("gareen");
        System.out.println(names);
        //�ڶ��β���ͬ�������ݣ��ǲ岻��ȥ�ģ�������ֻ�ᱣ��һ��
        names.add("gareen");
        System.out.println(names);
        
        
        HashSet<Integer> numbers = new HashSet<Integer>();
        numbers.add(9);
        numbers.add(5);
        numbers.add(1);
        // Set�е�Ԫ�����У����ǰ��ղ���˳��
        System.out.println(numbers);
        
	}
	//HashSet���⣬�ҳ��ظ����ַ���
	public static void findChongfu() {
		String[] strs=PojieMima.suiStrArray(100,2);
		HashSet<String>strHS=new HashSet<String>();
		HashSet<String>Chongfu=new HashSet<String>();
		for(int i=0;i<strs.length;i++) {
			if(!strHS.add(strs[i]))Chongfu.add(strs[i]);
		}
		System.out.printf("%n����%d���ظ����ַ�������%n%s",Chongfu.size(),Chongfu);
	}
	
	//����50��0-9999���������Ҫ�����ظ�
	public static void suijishu() {
		
		HashSet<Integer> hs=new HashSet<Integer>();
		while(hs.size()!=50) {
			int tmp=(int) (Math.random()*10000);
			hs.add(tmp);
		}
		System.out.println(hs);
	}
	
	//����LinkedHashSet�ļȲ��ظ�������˳������ԣ���Math.PI�е����֣����ճ���˳���ӡ��������ͬ���֣�ֻ����һ��
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
