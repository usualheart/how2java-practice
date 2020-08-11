package character;

public class Support extends Hero implements Healer {
	public void heal() {
		System.out.println(name+"��ȷ��Ϊ˭�ṩ������...");
	}
	public void heal(Hero h) {
		System.out.println(name+"Ϊ"+h.name+"����Ѫ...");
	}
	public void heal(Hero...h) {
		for(int i=0;i<h.length;i++) {
			System.out.println(name+"Ϊ"+h[i].name+"����Ѫ...");
		}
	}
	public void heal(Hero h,int hp) {
		System.out.println(name+"Ϊ"+h.name+"����"+hp+"��Ѫ...");
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Support Huatuo=new Support();
		Huatuo.name="��٢";
		ADHero bh = new ADHero();
        bh.name = "�ͽ�����";
        Hero h1 = new Hero();
        h1.name = "����";
        Hero h2 = new Hero();
        h2.name = "��Ī";
        
        Huatuo.heal();
        Huatuo.heal(bh);
        Huatuo.heal(h1,bh,h2);
        Huatuo.heal(bh,100);
   
	}

}
