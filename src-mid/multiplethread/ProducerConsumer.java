package multiplethread;

import java.util.Collections;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//�������߳���
public class ProducerConsumer  {
	//ͨ��Lock����ʵ��
	final Lock lock=new ReentrantLock();
	final Condition notFull=lock.newCondition();
	final Condition notEmpty=lock.newCondition();
	
	
	public synchronized void produce(Stack<Character> s) throws InterruptedException {
		
		while(s.size()==200) {
			this.wait();
		}
		char random=(char) ((int)(Math.random()*26)+'A');//��������Ĵ�д�ַ�
		s.push(random);
		System.out.println("Producerѹ�룺"+random);
		this.notify();
		
	}
	public synchronized void consume(Stack<Character> s) throws InterruptedException {

		while(s.size()==0) {
			this.wait();
		}
		System.out.println("Consumer������"+s.pop());
		this.notify();
	}
	
	//ͨ��Condition����ʵ��������-������
	public  void produceC(Stack<Character> s) throws InterruptedException {
			lock.lock();
			try {
				while(s.size()==200) {
					notEmpty.await();
				}
				char random=(char) ((int)(Math.random()*26)+'A');//��������Ĵ�д�ַ�
				s.push(random);
				System.out.println("Producerѹ�룺"+random);
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
			System.out.println("Consumer������"+s.pop());
			notEmpty.signal();
		}
		finally {
			lock.unlock();
		}
	}
	
	//ʵ�ֵ�������-�����߲���
	public static void main(String[] args) {
		// ���ԣ���2�������ߺ�3��������ͬʱ����
		Stack<Character> s=new Stack<Character>();
		//ջ�������Ϊ�̰߳�ȫ����
		Collections.synchronizedCollection(s);
		ProducerConsumer p=new ProducerConsumer();
		
		for(int i=0;i<2;i++) {
			Thread pt=new Thread() {
				public void run() {
					while(true) {
						try {
							Thread.sleep(100);
							p.produce(s);//produceͨ��synchronized����ʵ�ֵ�������-�����߲��� produceC:lock����
						} catch (InterruptedException e) {
							// TODO �Զ����ɵ� catch ��
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
							p.consume(s);//consumeͨ��synchronized����ʵ�ֵ�������-�����߲��� consumeC:lock����
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
