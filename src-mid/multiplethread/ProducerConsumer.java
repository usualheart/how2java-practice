package multiplethread;

import java.util.Collections;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//生产者线程类
public class ProducerConsumer  {
	//通过Lock方法实现
	final Lock lock=new ReentrantLock();
	final Condition notFull=lock.newCondition();
	final Condition notEmpty=lock.newCondition();
	
	
	public synchronized void produce(Stack<Character> s) throws InterruptedException {
		
		while(s.size()==200) {
			this.wait();
		}
		char random=(char) ((int)(Math.random()*26)+'A');//生成随机的大写字符
		s.push(random);
		System.out.println("Producer压入："+random);
		this.notify();
		
	}
	public synchronized void consume(Stack<Character> s) throws InterruptedException {

		while(s.size()==0) {
			this.wait();
		}
		System.out.println("Consumer弹出："+s.pop());
		this.notify();
	}
	
	//通过Condition方法实现生产者-消费者
	public  void produceC(Stack<Character> s) throws InterruptedException {
			lock.lock();
			try {
				while(s.size()==200) {
					notEmpty.await();
				}
				char random=(char) ((int)(Math.random()*26)+'A');//生成随机的大写字符
				s.push(random);
				System.out.println("Producer压入："+random);
				notFull.signal();
			}
			finally {
				lock.unlock();
			}
			
		}
	public void consumeC(Stack<Character> s) throws InterruptedException {
		lock.lock();
		try {
			while(s.size()==0) {
				notFull.await();
			}
			System.out.println("Consumer弹出："+s.pop());
			notEmpty.signal();
		}
		finally {
			lock.unlock();
		}
	}
	
	//实现的生产者-消费者测试
	public static void main(String[] args) {
		// 测试，让2个生产者和3个消费者同时运行
		Stack<Character> s=new Stack<Character>();
		//栈必须改造为线程安全的类
		Collections.synchronizedCollection(s);
		ProducerConsumer p=new ProducerConsumer();
		
		for(int i=0;i<2;i++) {
			Thread pt=new Thread() {
				public void run() {
					while(true) {
						try {
							Thread.sleep(100);
							p.produce(s);//produce通过synchronized方法实现的生产者-消费者测试 produceC:lock方法
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						//System.out.println(s.size());
					}
				}
			};
			pt.start();
		}
		for(int i=0;i<3;i++) {
			Thread ct=new Thread() {
				public void run() {
					while(true) {
						try {
							Thread.sleep(1000);
							p.consume(s);//consume通过synchronized方法实现的生产者-消费者测试 consumeC:lock方法
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						}
						//System.out.println(s.size());
					}
				}
			};
			ct.start();
		}

		
	}

}
