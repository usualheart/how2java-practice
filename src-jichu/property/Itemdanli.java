package property;
//����ItemΪ����ʽ����
public class Itemdanli {
	
		String name;
		int price;
		int shuliang=0;
		String weizhi;
		//˽�л����췽��
		private Itemdanli() {
			
		}
		//����ʽ����Item
		private static Itemdanli instance=new Itemdanli();
		public static Itemdanli getinstance() {
			return instance;
		}
		
		void showItem() {
			String out="��Ʒ��"+name+" �۸� "+price+" λ�ã�"+weizhi+"\t";
			System.out.println(out);
		}
		void xiao() {
			System.out.println(name+"��ʧ");
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
			xueping.name="Ѫƿ";
			xueping.price=50;
			xueping.weizhi="������";
			Itemdanli caoxie=new Itemdanli();
			caoxie.name="��Ь";
			caoxie.price=300;
			caoxie.weizhi="����";
			Itemdanli changjian=new Itemdanli();
			changjian.name="����";
			changjian.price=350;
			changjian.weizhi="ǽ��";
			

			xueping.showItem();
			caoxie.showItem();
			changjian.showItem();
			xueping.xiao();
			System.out.println("����ǰѪƿ������"+xueping.getShuliang());
			xueping.goumai(1);
			System.out.println("�����Ѫƿ������"+xueping.getShuliang());
			
	}

}
