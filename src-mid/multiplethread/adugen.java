package multiplethread;

//����ȭ�����߳�ʵ��
public class adugen extends Thread{
	private Hero hero;
	public  adugen() {
		
	}
	public  adugen(Hero h) {
		hero=h;
	}
	//��дrun����
	public void run() {
		int i=0;
		while(true){
			try {
				Thread.sleep(1000);
				i++;
				System.out.println(hero.name+"ʹ���˲���ȭ�����ǵ�"+i+"��");
				if(i%3==0) {
					i=0;
					System.out.println(hero.name+"��ʼΪʱ5��ĳ���...");
					Thread.sleep(5000);
				}
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		adugen gl=new adugen(new Hero("����"));
		gl.start();
		adugen tm=new adugen(new Hero("��Ī"));
		tm.start();
	}

}
