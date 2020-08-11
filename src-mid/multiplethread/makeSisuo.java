package multiplethread;

public class makeSisuo {
	public static void main(String[]args) {
		Hero a=new Hero("a");
		Hero b=new Hero("b");
		Hero c=new Hero("c");
		Thread t1=new Thread() {
			public void run() {
				synchronized(a) {
					System.out.println("t1已经占有a!");
					System.out.println("t1请求占有b...");
					synchronized(b) {
						System.out.println("t1已经占有b!");
						System.out.println("t1请求占有c...");
						synchronized(c) {
							System.out.println("t1已经占有c!");
							System.out.println("t1成功了！");
						}
					}
				}
			}
		};
		t1.start();
		
		Thread t2=new Thread() {
			public void run() {
				synchronized(b) {
					System.out.println("t2已经占有b!");
					System.out.println("t2请求占有c...");
					synchronized(c) {
						System.out.println("t2已经占有c!");
						System.out.println("t2请求占有a...");
						synchronized(a) {
							System.out.println("t2已经占有a!");
							System.out.println("t2成功了！");
						}
					}
				}
			}
		};
		t2.start();
		
		Thread t3=new Thread() {
			public void run() {
				synchronized(c) {
					System.out.println("t3已经占有c!");
					System.out.println("t3请求占有a...");
					synchronized(a) {
						System.out.println("t3已经占有a!");
						System.out.println("t3请求占有b...");
						synchronized(b) {
							System.out.println("t3已经占有b!");
							System.out.println("t3成功了！");
						}
					}
				}
			}
		};
		t3.start();
	}
}
