package multiplethread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThread {
	
	public static void testJoin() {
        
        final Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 616;
        gareen.damage = 50;
  
        final Hero teemo = new Hero();
        teemo.name = "��Ī";
        teemo.hp = 300;
        teemo.damage = 30;
          
        final Hero bh = new Hero();
        bh.name = "�ͽ�����";
        bh.hp = 500;
        bh.damage = 65;
          
        final Hero leesin = new Hero();
        leesin.name = "äɮ";
        leesin.hp = 455;
        leesin.damage = 80;
          
        Thread t1= new Thread(){
            public void run(){
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }              
            }
        };
          
        t1.start();
 
        //����ִ�е����һֱ��main�߳�������
        try {
            //t1�̼߳��뵽main�߳�������ֻ��t1�߳����н������Ż����������
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }              
            }
        };
        //��۲쵽���װ���Īɱ���󣬲�����t2�߳�
        t2.start();
          
    }
    public static void testSleep() {
         
        Thread t1= new Thread(){
            public void run(){
                int seconds =0;
                while(true){
                    try {
                        Thread.sleep(1000);//����߳�û�����ߣ���᲻�ϵ�ִ��
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    seconds++;
                    System.out.printf("�Ѿ�����LOL %d ��%n", seconds);
                }              
            }
        };
       // t1.setDaemon(true);//����t1Ϊ�ػ����̺󣬵�һ����������е��̶߳����ػ��̵߳�ʱ�򣬽�����ǰ���̡�
        t1.start();
         
    }
    
    public static void testThreadClass() {
        
        Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 616;
        gareen.damage = 50;
 
        Hero teemo = new Hero();
        teemo.name = "��Ī";
        teemo.hp = 300;
        teemo.damage = 30;
         
        Hero bh = new Hero();
        bh.name = "�ͽ�����";
        bh.hp = 500;
        bh.damage = 65;
         
        Hero leesin = new Hero();
        leesin.name = "äɮ";
        leesin.hp = 455;
        leesin.damage = 80;
         
        KillThread killThread1 = new KillThread(gareen,teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh,leesin);
        killThread2.start();
         
    }
    
    
    //�߳��������ȼ��Ĳ���
    public static void testSetPriority() {
        
        final Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 616;
        gareen.damage = 1;
  
        final Hero teemo = new Hero();
        teemo.name = "��Ī";
        teemo.hp = 300;
        teemo.damage = 1;
          
        final Hero bh = new Hero();
        bh.name = "�ͽ�����";
        bh.hp = 500;
        bh.damage = 1;
          
        final Hero leesin = new Hero();
        leesin.name = "äɮ";
        leesin.hp = 450;
        leesin.damage = 1;
          
        Thread t1= new Thread(){
            public void run(){
 
                while(!teemo.isDead()){
                	//��ʱ��ͣ
                	//Thread.yield();
                	
                    gareen.attackHero(teemo);
                }              
            }
        };
          
        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }              
            }
            
        };
         
        t1.setPriority(10);//1-10Ҳ������ΪThread.MAX_PRIORITY)
        t2.setPriority(1);//Thread.MIN_PRIORITY
        t1.start();

        t2.start();
          
    }
    
    public static void testTongbu() {
        
        final Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 10000;
           
        System.out.printf("���׵ĳ�ʼѪ���� %.0f%n", gareen.hp);
           
        //���߳�ͬ������ָ���Ƕ���߳�ͬʱ�޸�һ�����ݵ�ʱ�򣬵��µ�����
           
        //���������10000��Ѫ�������ڻ����ͬʱ�ֱ��Է����Ӣ�۹���
           
        //��JAVA��������ʾ�������ж���߳��ڼ��ٸ��׵�hp
        //ͬʱ���ж���߳��ڻָ����׵�hp
           
        //n���߳����Ӹ��׵�hp
           
        int n = 10000;
   
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];
           
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                	//ʹ��gareen��Ϊsynchronized
                    synchronized (gareen) {
                        gareen.recover();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
               
        }
           
        //n���̼߳��ٸ��׵�hp
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                    gareen.hurt();////�ڷ���hurt����synchronized(this)
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads[i] = t;
        }
        
        //�ȴ����������߳̽���
        for (Thread t : addThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //�ȴ����м����߳̽���
        for (Thread t : reduceThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        //����ִ�е�����������Ӻͼ����̶߳�������
           
        //���Ӻͼ����̵߳�������һ���ģ�ÿ�ζ����ӣ�����1.
        //��ô�����̶߳������󣬸��׵�hpӦ�û��ǳ�ʼֵ
           
        //������ʵ�Ϲ۲쵽���ǣ�
                   
        System.out.printf("%d�������̺߳�%d�������߳̽�����%n���׵�Ѫ������� %.0f%n", n,n,gareen.hp);
           
    }
    
    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
    //����synchronized��ʹ��
    public static void testSC() {
        final Object someObject = new Object();
          
        Thread t1 = new Thread(){
            public void run(){
                try {
                    System.out.println( now()+" t1 �߳��Ѿ�����");
                    System.out.println( now()+this.getName()+ " ��ͼռ�ж���someObject");
                    synchronized (someObject) {
                          
                        System.out.println( now()+this.getName()+ " ռ�ж���someObject");
                        Thread.sleep(5000);
                        System.out.println( now()+this.getName()+ " �ͷŶ���someObject");
                    }
                    System.out.println(now()+" t1 �߳̽���");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        t1.setName(" t1");
        t1.start();
        Thread t2 = new Thread(){
  
            public void run(){
                try {
                    System.out.println( now()+" t2 �߳��Ѿ�����");
                    System.out.println( now()+this.getName()+ " ��ͼռ�ж���someObject");
                    synchronized (someObject) {
                        System.out.println( now()+this.getName()+ " ռ�ж���someObject");
                        Thread.sleep(5000);
                        System.out.println( now()+this.getName()+ " �ͷŶ���someObject");
                    }
                    System.out.println(now()+" t2 �߳̽���");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        t2.setName(" t2");
        t2.start();
    }
    
    
    //��������
    public static void sisuo() {
        final Hero ahri = new Hero();
        ahri.name = "��β����";
        final Hero annie = new Hero();
        annie.name = "����";
         
        Thread t1 = new Thread(){
            public void run(){
                //ռ�о�β����
                synchronized (ahri) {
                    System.out.println("t1 ��ռ�о�β����");
                    try {
                        //ͣ��1000���룬��һ���߳����㹻��ʱ��ռ�а���
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                     
                    System.out.println("t1 ��ͼռ�а���");
                    System.out.println("t1 �ȴ��� ��������");
                    synchronized (annie) {
                        System.out.println("do something");
                    }
                }  
                 
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run(){
                //ռ�а���
                synchronized (annie) {
                    System.out.println("t2 ��ռ�а���");
                    try {
                         
                        //ͣ��1000�룬��һ���߳����㹻��ʱ��ռ�����þ�β����
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("t2 ��ͼռ�о�β����");
                    System.out.println("t2 �ȴ��� ��������");
                    synchronized (ahri) {
                        System.out.println("do something");
                    }
                }  
                 
            }
        };
        t2.start();
   }
    
    
    public static void main(String[] args) {
    	//testSleep();
    	//testJoin();
    	//testThreadClass() ;//���Լ̳���Thread�����ʵ�ֶ��̵߳ķ���
    	//testSetPriority();//�����������ȼ�����̵߳�ִ��Ч��
    	 testTongbu();//ͬ���������,���ϸ�Ӣ�ۼ�Ѫ��Ѫ ���Ƿ���ִ���
    	//testSC();
    	//sisuo();
    }

     
}