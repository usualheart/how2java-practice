package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import multiplethread.Hero;

public class findmax3 {
	//找到hp第三高的英雄 打印名称
	public static void find3() {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println(heros);
       
        
        //输出排序结果
        System.out.println("输出排序结果：");
        heros
        .stream()
        .sorted((h1,h2)->h1.hp<h2.hp?1:-1)
        .forEach(h->System.out.print(h)); 
        
        System.out.println("通过聚合操作返回伤害第三高的那个英雄");
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
		// TODO 自动生成的方法存根
		find3();
	}

}
