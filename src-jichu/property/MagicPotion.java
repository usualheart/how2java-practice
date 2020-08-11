package property;

public class MagicPotion extends Item{
	public void effect() {
		System.out.println("蓝瓶使用后，可以回魔法");
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MagicPotion m=new MagicPotion();
		m.effect();
		int a=1;
		String b="笨蛋";
		System.out.println(a+b);
		//类的多态
		Item i1= new LifePotion();
        Item i2 = new MagicPotion();
        System.out.print("i1是Item类型，执行effect打印:");
        i1.effect();
        System.out.print("i2也是Item类型，执行effect打印:");
        i2.effect();
	}

}
