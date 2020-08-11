package collection;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Collections;

public class MyStack implements Stack {
	LinkedList<CoHero>Ch=new LinkedList<CoHero>();
	
	Lock lock=new ReentrantLock();
	
	//把英雄推入到最后位置,加入synchronized 改造为线程安全的类，通过Collections提供的方法也可以转换
	// public synchronized void push(CoHero h) {
    //通过Lock改造为线程安全的类
	public  void push(CoHero h) {
			lock.lock();
	    	Ch.addLast(h);
	    	lock.unlock();
    }
    //把最后一个英雄取出来
    //public synchronized CoHero pull() {
	public CoHero pull() {
			lock.lock();
	    	CoHero tmp= Ch.removeLast();
	    	lock.unlock();
	    	return tmp;
    }
    //查看最后一个英雄
    //public synchronized CoHero peek() {
	public synchronized CoHero peek() {
			lock.lock();
	    	CoHero tmp= Ch.getLast();
	    	lock.unlock();
	    	return tmp;
    }
	
	public static void testSyn() {
		MyStack m=new MyStack();
		CoHero gl=new CoHero("gareen",10000);
		m.push(gl);//初始装入英雄
		Collections.synchronizedList(m.Ch);//通过将MyStack里边的List转换为线程安全的类的方式把MyStack转化为线程安全的类
		
		Thread[] T1=new Thread[10000];
		Thread[] T2=new Thread[1000];
		//10000个线程增加值
		for(int i=0;i<10000;i++) {
			Thread t1=new Thread() {
				public void run() {
					synchronized(m) {
						CoHero tmp=m.pull();
						tmp.hp+=1;
						m.push(tmp);
					}
				}
			};
			t1.start();
			T1[i]=t1;
		}
		//10000个线程减hp值
		for(int i=0;i<1000;i++) {
			Thread t2=new Thread() {
				public void run() {
					synchronized(m) {
						CoHero tmp=m.pull();
						tmp.hp-=1;
						m.push(tmp);
					}
				}
			};
			t2.start();
			T2[i]=t2;
		}
		
		//将20000个线程加入主线程，可以确保线程都运行完毕
		for(int i=0;i<10000;i++) {
			try {
				T1[i].join();
			//	T2[i].join();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		for(Thread tmp:T2) {
			try {
				tmp.join();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		CoHero tmp=m.peek();
		System.out.println(tmp.name+"\t"+tmp.hp);
		
	}
	
	public static void main(String[]args) {
			testSyn();//测试修改为线程安全类之后的效果
		}
}
