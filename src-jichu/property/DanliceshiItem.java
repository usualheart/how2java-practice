package property;
//public class Armordanli { extends Itemdanli
//单例子改造后无法继承itemdanli
public class DanliceshiItem {
	int ac;
	String name;
	int price;
	

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		//测试Item单例
		Itemdanli weiyi=Itemdanli.getinstance();
		weiyi.showItem();
		weiyi.name="洪荒之力";
		weiyi.price=9999;
		weiyi.showItem();
		Itemdanli weier=Itemdanli.getinstance();
		weier.weizhi="宇宙";
		weiyi.showItem();

	}

}
