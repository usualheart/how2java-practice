package property;

public class LifePotion extends Item {
	
	//override����effect
	public void effect() {
		System.out.println("Ѫƿʹ�ú���Ի�Ѫ");
	}
	//���󷽷�,�̳��Գ�����Item
	public boolean disposable() {
		return true;
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/*Item i=new Item();
		i.effect();
		i.showItem();*/
		LifePotion lp =new LifePotion();
		lp.name="Ѫƿ";
		lp.price=100;
		lp.effect();
		lp.showItem();
		System.out.println(lp.disposable());
	
	}

}
