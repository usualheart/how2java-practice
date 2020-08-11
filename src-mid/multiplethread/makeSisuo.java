package multiplethread;

public class makeSisuo {
	public static void main(String[]args) {
		Hero a=new Hero("a");
		Hero b=new Hero("b");
		Hero c=new Hero("c");
		Thread t1=new Thread() {
			public void run() {
				synchronized(a) {
					System.out.println("t1�Ѿ�ռ��a!");
					System.out.println("t1����ռ��b...");
					synchronized(b) {
						System.out.println("t1�Ѿ�ռ��b!");
						System.out.println("t1����ռ��c...");
						synchronized(c) {
							System.out.println("t1�Ѿ�ռ��c!");
							System.out.println("t1�ɹ��ˣ�");
						}
					}
				}
			}
		};
		t1.start();
		
		Thread t2=new Thread() {
			public void run() {
				synchronized(b) {
					System.out.println("t2�Ѿ�ռ��b!");
					System.out.println("t2����ռ��c...");
					synchronized(c) {
						System.out.println("t2�Ѿ�ռ��c!");
						System.out.println("t2����ռ��a...");
						synchronized(a) {
							System.out.println("t2�Ѿ�ռ��a!");
							System.out.println("t2�ɹ��ˣ�");
						}
					}
				}
			}
		};
		t2.start();
		
		Thread t3=new Thread() {
			public void run() {
				synchronized(c) {
					System.out.println("t3�Ѿ�ռ��c!");
					System.out.println("t3����ռ��a...");
					synchronized(a) {
						System.out.println("t3�Ѿ�ռ��a!");
						System.out.println("t3����ռ��b...");
						synchronized(b) {
							System.out.println("t3�Ѿ�ռ��b!");
							System.out.println("t3�ɹ��ˣ�");
						}
					}
				}
			}
		};
		t3.start();
	}
}
