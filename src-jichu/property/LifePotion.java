package property;

public class LifePotion extends Item {
	
	//override方法effect
	public void effect() {
		System.out.println("血瓶使用后可以回血");
	}
	//抽象方法,继承自抽象类Item
	public boolean disposable() {
		return true;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*Item i=new Item();
		i.effect();
		i.showItem();*/
		LifePotion lp =new LifePotion();
		lp.name="血瓶";
		lp.price=100;
		lp.effect();
		lp.showItem();
		System.out.println(lp.disposable());
	
	}

}
