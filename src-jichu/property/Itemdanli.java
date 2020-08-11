package property;
//改造Item为饿汉式单例
public class Itemdanli {
	
		String name;
		int price;
		int shuliang=0;
		String weizhi;
		//私有化构造方法
		private Itemdanli() {
			
		}
		//饿汉式改造Item
		private static Itemdanli instance=new Itemdanli();
		public static Itemdanli getinstance() {
			return instance;
		}
		
		void showItem() {
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
		int getShuliang() {
			return shuliang;
		}
		public static void main(String[] args) {
			Itemdanli xueping =new Itemdanli();
			xueping.name="血瓶";
			xueping.price=50;
			xueping.weizhi="桌子上";
			Itemdanli caoxie=new Itemdanli();
			caoxie.name="草鞋";
			caoxie.price=300;
			caoxie.weizhi="床底";
			Itemdanli changjian=new Itemdanli();
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
			
	}

}
