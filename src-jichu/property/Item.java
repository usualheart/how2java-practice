package property;
// ����Ϊabstractʱ �����಻����ֱ��ʵ����
import character.AD;
public class Item implements Comparable<Item>{
		
		public int id;
		public String name;
		public  int price;
		int shuliang=0;
		String weizhi;
		public Item() {
			// TODO �Զ����ɵĹ��캯�����
		}
		public Item(String string) {
			// TODO �Զ����ɵĹ��캯�����
			this.name=string;
		}
		public void showItem() {
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
		//������Ʒ����
		int getShuliang() {
			return shuliang;
		}
		public void effect() {
			System.out.println("��Ʒʹ�ú󣬿�����Ч��");
		}
		//��дObject���һЩ����
		public String toString() {
			return this.name+this.price;
		}
		public void finalize() {
			System.out.println(this.name+"���ڱ�����...");
		}
		public boolean equals(Object o) {
			if(o instanceof Item)//�ж�o�Ƿ���Item��ʵ��
			{	Item h=(Item)o;
				return this.price==h.price;
			}
			return false;
		}
		
		
		//Item��һ�����󷽷�
	//	public abstract boolean disposable();// �����಻����ֱ��ʵ����
		
		//Comparable�ӿڷ���
		@Override
		public int compareTo(Item o) {
			// TODO �Զ����ɵķ������
			if(this.price<o.price)return 1;
			else return -1;
		}
		//���þ�̬����ʵ��
		public static int compareItem(Item o1,Item o2) {
			if(o1.price<o2.price)return -1;
			else return 1;
		}
		public static void main(String[] args) {
			Item xueping =new Item();
			xueping.name="Ѫƿ";
			xueping.price=50;
			xueping.weizhi="������";
			Item caoxie=new Item();
			caoxie.name="��Ь";
			caoxie.price=50;
			caoxie.weizhi="����";
			Item changjian=new Item();
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
			
			//��дObject�����Ĳ���
			System.out.println(xueping.toString());
			xueping.finalize();
			System.out.println(xueping.equals(caoxie));
			
	}

}
