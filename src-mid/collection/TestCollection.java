package collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import character.APHero;
import character.Hero;
import property.Item;
 
public class TestCollection {
	
	//删除ArrayList中名字编号是8的倍数的英雄
	public static void deleteAL() {
		ArrayList<CoHero> Chs=new ArrayList();
		for(int i=0;i<100;i++) {
			CoHero h=new CoHero("CoHero "+i);
			Chs.add(h);
		}
		System.out.printf("删除前：%n%s%n",Chs);
		
		ArrayList<CoHero> ChsDel=new ArrayList();//保存准备删除的对象迭代结束后删除
		Iterator<CoHero> it=Chs.iterator();
		while(it.hasNext()) {
			CoHero h=it.next();	
			String ss[]=h.name.split(" ");
			if(Integer.parseInt(ss[1])%8==0) {
				System.out.println("删除"+h.name);
				//Chs.remove(h);//不可以直接删除，会引起迭代器错误！
				ChsDel.add(h);//将要删除的英雄加入ArrayList
			}
		}
		Chs.removeAll(ChsDel);//删除符合条件的英雄
		System.out.printf("删除后：%n%s%n",Chs);
	}
	
	
	public static void fanxingTest() {
        
        //对于不使用泛型的容器，可以往里面放英雄，也可以往里面放物品
        List heros = new ArrayList();
        heros.add(new Hero("盖伦"));
          
        //本来用于存放英雄的容器，现在也可以存放物品了
        heros.add(new Item("冰杖"));
          
        //对象转型会出现问题
        Hero h1=  (Hero) heros.get(0);
        //尤其是在容器里放的对象太多的时候，就记不清楚哪个位置放的是哪种类型的对象了
        //Hero h2=  (Hero) heros.get(1);
          
        //引入泛型Generic
        //声明容器的时候，就指定了这种容器，只能放Hero，放其他的就会出错
        List<Hero> genericheros = new ArrayList<Hero>();
        genericheros.add(new Hero("盖伦"));
        //如果不是Hero类型，根本就放不进去
        //genericheros.add(new Item("冰杖"));
          
        //除此之外，还能存放Hero的子类
        genericheros.add(new APHero());
         
        //并且在取出数据的时候，不需要再进行转型了，因为里面肯定是放的Hero或者其子类
        Hero h = genericheros.get(0);
        Hero []hs=(Hero[])genericheros.toArray(new Hero[] {});
        System.out.println(hs[0].name);
    }
	
	//找出名字为str的英雄
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
		//shuffle 1000万次统计前三位出现3，1，4频率
		int sum=0;
		for(int i=0;i<10000000;i++) {
			Collections.shuffle(number);
			if(number.get(0)==3&&number.get(1)==1&&number.get(2)==4) {sum++;System.out.println(number);}
		}
		System.out.printf("3，1，4，出现的概率是%.5f%%%n",((double)sum)/100000);
	}
	
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        //容器类ArrayList，用于存放对象
    	/*
        ArrayList<CoHero> heros = new ArrayList();
        heros.add(new CoHero("盖伦"));
        System.out.println(heros.size());
         
        //容器的容量"capacity"会随着对象的增加，自动增长
        //只需要不断往容器里增加英雄即可，不用担心会出现数组的边界问题。
        heros.add( new CoHero("提莫"));
        System.out.println(heros.size());
     
        
        
        //初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new CoHero("CollectionHero " + i));
        }
        CoHero specialCollectionHero = new CoHero("special CollectionHero");
        heros.add(specialCollectionHero);
        System.out.println(heros);
        CoHero hs[] = (CoHero[])heros.toArray(new CoHero[] {});
        System.out.println("数组:" );
        for (int i = 0; i < hs.length; i++) {
        	System.out.println(hs[i].name);
        }
        
        //判断ArrayList heros中是否有名字为hero1的对象，并返回
        String str="提莫";
        int index=indexName(heros,str);
        if(index!=-1) {
        	System.out.println("找到"+str+"坐标为"+index);
        }
        else System.out.println(str+"不存在！");
        
        //ArrayList测试
        //泛型测试
        fanxingTest();
        
        //删除ArrayList中某些对象
        deleteAL();
        */
        
    	
    	
        testCollections();
        
        
        
        /*
        //第二种遍历，使用迭代器
        System.out.println("--------使用while的iterator-------");
        Iterator<CoHero> it= heros.iterator();
        //从最开始的位置判断"下一个"位置是否有数据
        //如果有就通过next取出来，并且把指针向下移动
        //直到"下一个"位置没有数据
        while(it.hasNext()){
            CoHero h = it.next();
            System.out.println(h);
        }
        //迭代器的for写法
        System.out.println("--------使用for的iterator-------");
        for (Iterator<CoHero> iterator = heros.iterator(); iterator.hasNext();) {
            CoHero hero = iterator.next();
            System.out.println(hero);
        }
        // 第三种，增强型for循环
        System.out.println("--------增强型for循环-------");
        for (CoHero h : heros) {
            System.out.println(h);
        }
        */
        
        
    }
    
    
     
}