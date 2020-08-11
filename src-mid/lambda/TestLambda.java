package lambda;
   
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import multiplethread.Hero;
   
public class TestLambda {
	
	
	
	//�����෽ʽ�ҳ�����������Hero
    public static void niminglei() {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("��ʼ����ļ��ϣ�");
        System.out.println(heros);
        System.out.println("ʹ��������ķ�ʽ��ɸѡ�� hp>100 && damange<50��Ӣ��");
        HeroChecker checker = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp>100 && h.damage<50);
            }
        };
           
        filter(heros,checker);
    }
   
    //lambda��ʽ��ֻ��Ҫ����һ�����ʽ����
    public static void lambda() {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("��ʼ����ļ��ϣ�");
        System.out.println(heros);
        System.out.println("ʹ��Lamdba�ķ�ʽ��ɸѡ�� hp>100 && damange<50��Ӣ��");
        filter(heros,h->h.hp>100 && h.damage<50);
        
        System.out.println("Lambda���ʽ�е��������еĶ����matched������");       //��Ҫ��Hero�����matched����
        filter(heros,h-> h.matched() );
  
        System.out.println("���������ж���ķ��� ֮���˽����");       
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