package property;

public class Armor extends Item {
	int ac;
	

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Armor bujia=new Armor();
		bujia.name="布甲";
		bujia.price=300;
		bujia.ac=15;
		Armor suozijia=new Armor();
		suozijia.name="锁子甲";
		suozijia.price=500;
		suozijia.ac=40;
		bujia.showItem();
		suozijia.showItem();

	}

}
