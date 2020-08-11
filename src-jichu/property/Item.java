package property;
// 修饰为abstract时 抽象类不可以直接实例化
import character.AD;
public class Item implements Comparable<Item>{
		
		public int id;
		public String name;
		public  int price;
		int shuliang=0;
		String weizhi;
		public Item() {
			// TODO 自动生成的构造函数存根
		}
		public Item(String string) {
			// TODO 自动生成的构造函数存根
			this.name=string;
		}
		public void showItem() {
			String out="物品："+name+" 价格： "+price+" 位置："+weizhi+"\t";
			System.out.println(out);
		}
		void xiao() {
			System.out.println(name+"消失");
		}
		void wuxian() {
			
		}
		void goumai(int a) {
			shuliang+=a;
		}
		//返回物品数量
		int getShuliang() {
			return shuliang;
		}
		public void effect() {
			System.out.println("物品使用后，可以有效果");
		}
		//重写Object类的一些方法
		public String toString() {
			return this.name+this.price;
		}
		public void finalize() {
			System.out.println(this.name+"正在被回收...");
		}
		public boolean equals(Object o) {
			if(o instanceof Item)//判断o是否是Item的实例
			{	Item h=(Item)o;
				return this.price==h.price;
			}
			return false;
		}
		
		
		//Item的一个抽象方法
	//	public abstract boolean disposable();// 抽象类不可以直接实例化
		
		//Comparable接口方法
		@Override
		public int compareTo(Item o) {
			// TODO 自动生成的方法存根
			if(this.price<o.price)return 1;
			else return -1;
		}
		//引用静态方法实现
		public static int compareItem(Item o1,Item o2) {
			if(o1.price<o2.price)return -1;
			else return 1;
		}
		public static void main(String[] args) {
			Item xueping =new Item();
			xueping.name="血瓶";
			xueping.price=50;
			xueping.weizhi="桌子上";
			Item caoxie=new Item();
			caoxie.name="草鞋";
			caoxie.price=50;
			caoxie.weizhi="床底";
			Item changjian=new Item();
			changjian.name="长剑";
			changjian.price=350;
			changjian.weizhi="墙上";
			

			xueping.showItem();
			caoxie.showItem();
			changjian.showItem();
			xueping.xiao();
			System.out.println("购买前血瓶数量："+xueping.getShuliang());
			xueping.goumai(1);
			System.out.println("购买后血瓶数量："+xueping.getShuliang());
			
			//重写Object方法的测试
			System.out.println(xueping.toString());
			xueping.finalize();
			System.out.println(xueping.equals(caoxie));
			
	}

}
