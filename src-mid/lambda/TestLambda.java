package lambda;
   
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import multiplethread.Hero;
   
public class TestLambda {
	
	
	
	//匿名类方式找出满足条件的Hero
    public static void niminglei() {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("使用匿名类的方式，筛选出 hp>100 && damange<50的英雄");
        HeroChecker checker = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp>100 && h.damage<50);
            }
        };
           
        filter(heros,checker);
    }
   
    //lambda方式，只需要传递一个表达式即可
    public static void lambda() {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("使用Lamdba的方式，筛选出 hp>100 && damange<50的英雄");
        filter(heros,h->h.hp>100 && h.damage<50);
        
        System.out.println("Lambda表达式中调用容器中的对象的matched方法：");       //需要在Hero中添加matched方法
        filter(heros,h-> h.matched() );
  
        System.out.println("引用容器中对象的方法 之过滤结果：");       
        filter(heros, Hero::matched);
        
    }
    
    private static void filter(List<Hero> heros,HeroChecker checker) {
        for (Hero hero : heros) {
            if(checker.test(hero))
                System.out.print(hero);
        }
    }
    
    
    public static void main(String[] args) {
    	//niminglei();
    	lambda();
    }
   
}