package multiplethread;

//波动拳，多线程实现
public class adugen extends Thread{
	private Hero hero;
	public  adugen() {
		
	}
	public  adugen(Hero h) {
		hero=h;
	}
	//重写run方法
	public void run() {
		int i=0;
		while(true){
			try {
				Thread.sleep(1000);
				i++;
				System.out.println(hero.name+"使用了波动拳，这是第"+i+"发");
				if(i%3==0) {
					i=0;
					System.out.println(hero.name+"开始为时5秒的充能...");
					Thread.sleep(5000);
				}
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		adugen gl=new adugen(new Hero("盖伦"));
		gl.start();
		adugen tm=new adugen(new Hero("提莫"));
		tm.start();
	}

}
