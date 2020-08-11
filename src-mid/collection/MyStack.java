package collection;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Collections;

public class MyStack implements Stack {
	LinkedList<CoHero>Ch=new LinkedList<CoHero>();
	
	Lock lock=new ReentrantLock();
	
	//��Ӣ�����뵽���λ��,����synchronized ����Ϊ�̰߳�ȫ���࣬ͨ��Collections�ṩ�ķ���Ҳ����ת��
	// public synchronized void push(CoHero h) {
    //ͨ��Lock����Ϊ�̰߳�ȫ����
	public  void push(CoHero h) {
			lock.lock();
	    	Ch.addLast(h);
	    	lock.unlock();
    }
    //�����һ��Ӣ��ȡ����
    //public synchronized CoHero pull() {
	public CoHero pull() {
			lock.lock();
	    	CoHero tmp= Ch.removeLast();
	    	lock.unlock();
	    	return tmp;
    }
    //�鿴���һ��Ӣ��
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
		m.push(gl);//��ʼװ��Ӣ��
		Collections.synchronizedList(m.Ch);//ͨ����MyStack��ߵ�Listת��Ϊ�̰߳�ȫ����ķ�ʽ��MyStackת��Ϊ�̰߳�ȫ����
		
		Thread[] T1=new Thread[10000];
		Thread[] T2=new Thread[1000];
		//10000���߳�����ֵ
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
		//10000���̼߳�hpֵ
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
		
		//��20000���̼߳������̣߳�����ȷ���̶߳��������
		for(int i=0;i<10000;i++) {
			try {
				T1[i].join();
			//	T2[i].join();
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		for(Thread tmp:T2) {
			try {
				tmp.join();
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		CoHero tmp=m.peek();
		System.out.println(tmp.name+"\t"+tmp.hp);
		
	}
	
	public static void main(String[]args) {
			testSyn();//�����޸�Ϊ�̰߳�ȫ��֮���Ч��
		}
}
