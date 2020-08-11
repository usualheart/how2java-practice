package multiplethread;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
  
public class ThreadPool {
  
    // �̳߳ش�С
    int threadPoolSize;
  
    // ��������
    LinkedList<Runnable> tasks = new LinkedList<Runnable>();
  
    // ��ͼ����������߳�
  
    public ThreadPool() {
        threadPoolSize = 10;
  
        // ����10�������������߳�
        synchronized (tasks) {
            for (int i = 0; i < threadPoolSize; i++) {
                new TaskConsumeThread("�����������߳� " + i).start();
            }
        }
    }
  
    public void add(Runnable r) {
        synchronized (tasks) {
            tasks.add(r);
            // ���ѵȴ��������������߳�
            tasks.notifyAll();
        }
    }
  
    class TaskConsumeThread extends Thread {
        public TaskConsumeThread(String name) {
            super(name);
        }
  
        Runnable task;
  
        public void run() {
            System.out.println("������ " + this.getName());
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();
                    // �������������߳̿��Լ����������
                    tasks.notifyAll();
  
                }
                System.out.println(this.getName() + " ��ȡ�����񣬲�ִ��");
                task.run();
            }
        }
    }
    
    //���������������� ���̳߳ؽ��в���
    public static void testPool() {
        ThreadPool pool = new ThreadPool();
  
        for (int i = 0; i < 5; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    //System.out.println("ִ������");
                    //��������Ǵ�ӡһ�仰
                    //�����Ƿ����ļ�
                    //������������
                }
            };
             
            pool.add(task);
             
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
  
    }
    
    //�����̳߳أ����������ٶȲ��ϼӿ�
    public static void testPoolAcc() {
        ThreadPool pool= new ThreadPool();
        int sleep=1000;
        while(true){
            pool.add(new Runnable(){
                @Override
                public void run() {
                    //System.out.println("ִ������");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(sleep);
                sleep = sleep>100?sleep-100:sleep;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
              
        }
          
    }
    
    public static void testPoolJava() throws InterruptedException {
        //java�ṩ���̳߳�
        ThreadPoolExecutor threadPool= new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        /*
	        ��һ������10 ��ʾ����̳߳س�ʼ����10���߳������湤��
	        �ڶ�������15 ��ʾ���10���̲߳������ˣ��ͻ��Զ����ӵ����15���߳�
	        ����������60 ��ϵ��ĸ�����TimeUnit.SECONDS����ʾ����60�룬��������̻߳�û�нӵ�������ͻ���գ���󱣳ֳ������10��
	        ���ĸ�����TimeUnit.SECONDS ����
	        ��������� new LinkedBlockingQueue() ����������ļ���
        execute������������µ�����
        */
        threadPool.execute(new Runnable(){
   
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("����1");
            }
               
        });
   
    }
    public static void main(String[] args) {
    	//testPool();
    	//testPoolAcc();
    	try {
			testPoolJava();
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
    }
  
}