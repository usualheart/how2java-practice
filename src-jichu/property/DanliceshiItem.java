package property;
//public class Armordanli { extends Itemdanli
//�����Ӹ�����޷��̳�itemdanli
public class DanliceshiItem {
	int ac;
	String name;
	int price;
	

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		//����Item����
		Itemdanli weiyi=Itemdanli.getinstance();
		weiyi.showItem();
		weiyi.name="���֮��";
		weiyi.price=9999;
		weiyi.showItem();
		Itemdanli weier=Itemdanli.getinstance();
		weier.weizhi="����";
		weiyi.showItem();

	}

}
