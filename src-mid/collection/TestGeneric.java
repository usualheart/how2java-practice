package collection;

import java.util.ArrayList;

import character.ADHero;
import character.APHero;
import character.Hero;

public class TestGeneric {
	
	//����? extends�� �Ѵ�����ʵ�ֻ����һ�ַ���
	public static void iterate(ArrayList<?extends Hero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }
	
	//����? extends�� �Ѵ�����ʵ�ֻ����һ�ַ��� ��ʼ��
		public static  void add(ArrayList<Hero> list,Hero h) {
	        list.add(h);
	    }
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ArrayList<Hero> hs = new ArrayList<>();
        ArrayList<APHero> aphs = new ArrayList<>();
        ArrayList<ADHero> adhs = new ArrayList<>();
        
        for(int i=0;i<10;i++) {
        	Hero tmp=new Hero("Hero"+i);
        	hs.add(tmp);
        	APHero tmp1=new APHero("APHero"+i);
        	aphs.add(tmp1);
        	ADHero tmp2=new ADHero("ADHero"+i);
        	adhs.add(tmp2);
        	//add(hs,tmp1);//hs�ȿ���װHeroҲ����װAPHero
        }
        
        iterate(hs);
        iterate(aphs);
        iterate(adhs);
	}

}
