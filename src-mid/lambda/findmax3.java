package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import multiplethread.Hero;

public class findmax3 {
	//�ҵ�hp�����ߵ�Ӣ�� ��ӡ����
	public static void find3() {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println(heros);
       
        
        //���������
        System.out.println("�����������");
        heros
        .stream()
        .sorted((h1,h2)->h1.hp<h2.hp?1:-1)
        .forEach(h->System.out.print(h)); 
        
        System.out.println("ͨ���ۺϲ��������˺������ߵ��Ǹ�Ӣ��");
        Hero mx3DamageHero =
                heros
                .stream()
                .sorted((h1,h2)->h1.hp<h2.hp?1:-1)
                .limit(3)
                .min((h1,h2)->(int)(h1.hp-h2.hp))
                .get();
        System.out.print(mx3DamageHero);     
         
    }
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		find3();
	}

}
