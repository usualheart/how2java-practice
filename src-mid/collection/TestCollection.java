package collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import character.APHero;
import character.Hero;
import property.Item;
 
public class TestCollection {
	
	//ɾ��ArrayList�����ֱ����8�ı�����Ӣ��
	public static void deleteAL() {
		ArrayList<CoHero> Chs=new ArrayList();
		for(int i=0;i<100;i++) {
			CoHero h=new CoHero("CoHero "+i);
			Chs.add(h);
		}
		System.out.printf("ɾ��ǰ��%n%s%n",Chs);
		
		ArrayList<CoHero> ChsDel=new ArrayList();//����׼��ɾ���Ķ������������ɾ��
		Iterator<CoHero> it=Chs.iterator();
		while(it.hasNext()) {
			CoHero h=it.next();	
			String ss[]=h.name.split(" ");
			if(Integer.parseInt(ss[1])%8==0) {
				System.out.println("ɾ��"+h.name);
				//Chs.remove(h);//������ֱ��ɾ�������������������
				ChsDel.add(h);//��Ҫɾ����Ӣ�ۼ���ArrayList
			}
		}
		Chs.removeAll(ChsDel);//ɾ������������Ӣ��
		System.out.printf("ɾ����%n%s%n",Chs);
	}
	
	
	public static void fanxingTest() {
        
        //���ڲ�ʹ�÷��͵������������������Ӣ�ۣ�Ҳ�������������Ʒ
        List heros = new ArrayList();
        heros.add(new Hero("����"));
          
        //�������ڴ��Ӣ�۵�����������Ҳ���Դ����Ʒ��
        heros.add(new Item("����"));
          
        //����ת�ͻ��������
        Hero h1=  (Hero) heros.get(0);
        //��������������ŵĶ���̫���ʱ�򣬾ͼǲ�����ĸ�λ�÷ŵ����������͵Ķ�����
        //Hero h2=  (Hero) heros.get(1);
          
        //���뷺��Generic
        //����������ʱ�򣬾�ָ��������������ֻ�ܷ�Hero���������ľͻ����
        List<Hero> genericheros = new ArrayList<Hero>();
        genericheros.add(new Hero("����"));
        //�������Hero���ͣ������ͷŲ���ȥ
        //genericheros.add(new Item("����"));
          
        //����֮�⣬���ܴ��Hero������
        genericheros.add(new APHero());
         
        //������ȡ�����ݵ�ʱ�򣬲���Ҫ�ٽ���ת���ˣ���Ϊ����϶��Ƿŵ�Hero����������
        Hero h = genericheros.get(0);
        Hero []hs=(Hero[])genericheros.toArray(new Hero[] {});
        System.out.println(hs[0].name);
    }
	
	//�ҳ�����Ϊstr��Ӣ��
	public static int indexName(ArrayList<?> heros,String str) {
		int flag=-1;
		CoHero heroArray[]=(CoHero[])heros.toArray(new CoHero[] {});
		for(int i=0;i<heroArray.length;i++) {
			if(heroArray[i].name.equals(str)) {
				flag=i;
				break;
			}
		}
		return flag;
	}
	
	public static void testCollections() {
		List<Integer> number=new ArrayList<Integer>();
		for(int i=0;i<10;i++) {
			number.add(i);
		}
		//shuffle 1000���ͳ��ǰ��λ����3��1��4Ƶ��
		int sum=0;
		for(int i=0;i<10000000;i++) {
			Collections.shuffle(number);
			if(number.get(0)==3&&number.get(1)==1&&number.get(2)==4) {sum++;System.out.println(number);}
		}
		System.out.printf("3��1��4�����ֵĸ�����%.5f%%%n",((double)sum)/100000);
	}
	
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        //������ArrayList�����ڴ�Ŷ���
    	/*
        ArrayList<CoHero> heros = new ArrayList();
        heros.add(new CoHero("����"));
        System.out.println(heros.size());
         
        //����������"capacity"�����Ŷ�������ӣ��Զ�����
        //ֻ��Ҫ����������������Ӣ�ۼ��ɣ����õ��Ļ��������ı߽����⡣
        heros.add( new CoHero("��Ī"));
        System.out.println(heros.size());
     
        
        
        //��ʼ��5������
        for (int i = 0; i < 5; i++) {
            heros.add(new CoHero("CollectionHero " + i));
        }
        CoHero specialCollectionHero = new CoHero("special CollectionHero");
        heros.add(specialCollectionHero);
        System.out.println(heros);
        CoHero hs[] = (CoHero[])heros.toArray(new CoHero[] {});
        System.out.println("����:" );
        for (int i = 0; i < hs.length; i++) {
        	System.out.println(hs[i].name);
        }
        
        //�ж�ArrayList heros���Ƿ�������Ϊhero1�Ķ��󣬲�����
        String str="��Ī";
        int index=indexName(heros,str);
        if(index!=-1) {
        	System.out.println("�ҵ�"+str+"����Ϊ"+index);
        }
        else System.out.println(str+"�����ڣ�");
        
        //ArrayList����
        //���Ͳ���
        fanxingTest();
        
        //ɾ��ArrayList��ĳЩ����
        deleteAL();
        */
        
    	
    	
        testCollections();
        
        
        
        /*
        //�ڶ��ֱ�����ʹ�õ�����
        System.out.println("--------ʹ��while��iterator-------");
        Iterator<CoHero> it= heros.iterator();
        //���ʼ��λ���ж�"��һ��"λ���Ƿ�������
        //����о�ͨ��nextȡ���������Ұ�ָ�������ƶ�
        //ֱ��"��һ��"λ��û������
        while(it.hasNext()){
            CoHero h = it.next();
            System.out.println(h);
        }
        //��������forд��
        System.out.println("--------ʹ��for��iterator-------");
        for (Iterator<CoHero> iterator = heros.iterator(); iterator.hasNext();) {
            CoHero hero = iterator.next();
            System.out.println(hero);
        }
        // �����֣���ǿ��forѭ��
        System.out.println("--------��ǿ��forѭ��-------");
        for (CoHero h : heros) {
            System.out.println(h);
        }
        */
        
        
    }
    
    
     
}