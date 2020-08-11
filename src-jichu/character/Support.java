package character;

public class Support extends Hero implements Healer {
	public void heal() {
		System.out.println(name+"不确定为谁提供了治疗...");
	}
	public void heal(Hero h) {
		System.out.println(name+"为"+h.name+"加了血...");
	}
	public void heal(Hero...h) {
		for(int i=0;i<h.length;i++) {
			System.out.println(name+"为"+h[i].name+"加了血...");
		}
	}
	public void heal(Hero h,int hp) {
		System.out.println(name+"为"+h.name+"加了"+hp+"的血...");
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Support Huatuo=new Support();
		Huatuo.name="华佗";
		ADHero bh = new ADHero();
        bh.name = "赏金猎人";
        Hero h1 = new Hero();
        h1.name = "盖伦";
        Hero h2 = new Hero();
        h2.name = "提莫";
        
        Huatuo.heal();
        Huatuo.heal(bh);
        Huatuo.heal(h1,bh,h2);
        Huatuo.heal(bh,100);
   
	}

}
