package property;

public class Armor extends Item {
	int ac;
	

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Armor bujia=new Armor();
		bujia.name="����";
		bujia.price=300;
		bujia.ac=15;
		Armor suozijia=new Armor();
		suozijia.name="���Ӽ�";
		suozijia.price=500;
		suozijia.ac=40;
		bujia.showItem();
		suozijia.showItem();

	}

}
