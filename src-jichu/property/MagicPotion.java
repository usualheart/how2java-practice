package property;

public class MagicPotion extends Item{
	public void effect() {
		System.out.println("��ƿʹ�ú󣬿��Ի�ħ��");
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		MagicPotion m=new MagicPotion();
		m.effect();
		int a=1;
		String b="����";
		System.out.println(a+b);
		//��Ķ�̬
		Item i1= new LifePotion();
        Item i2 = new MagicPotion();
        System.out.print("i1��Item���ͣ�ִ��effect��ӡ:");
        i1.effect();
        System.out.print("i2Ҳ��Item���ͣ�ִ��effect��ӡ:");
        i2.effect();
	}

}
