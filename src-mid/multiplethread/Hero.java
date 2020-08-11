package multiplethread;

//����lambdaʹ�õ�Hero��
public class Hero implements Comparable<Hero>{
	public int id;//����id���� �������ݿ�ʹ��
    public String name;
    public float hp;
        
    public int damage;
        
    public Hero(){
           
    }
       
    public Hero(String name) {
        this.name =name;
   
    }
       
    //��ʼ��name,hp,damage�Ĺ��췽��
    public Hero(String name,float hp, int damage) {
        this.name =name;
        this.hp = hp;
        this.damage = damage;
    }
   
    @Override
    public int compareTo(Hero anotherHero) {
        if(damage<anotherHero.damage)
            return 1; 
        else
            return -1;
    }
    public boolean matched(){
    	   return this.hp>100 && this.damage<50;
    	}
    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }
    public synchronized void recover() {
       
        while(hp>=1000) {
        	try {
            	System.out.println("��Ѫ�߳�wait...");
				this.wait();
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
        }
        hp = hp + 1;
        System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
        // ֪ͨ��Щ�ȴ���this�����ϵ��̣߳������ѹ����ˣ����20�У��ȴ��ŵļ�Ѫ�̣߳����ѹ���
        this.notify();
    }
 
    public synchronized void hurt() {
        while(hp == 1) {//����Ϊif ����Ϊwhile,��Ϊif�ᵼ�£�����ͬʱ���Ѷ�����߳̽������´���
            try {
                // ��ռ��this�ļ�Ѫ�̣߳���ʱ�ͷŶ�this��ռ�У����ȴ�
            	System.out.println("�˺��߳�wait...");
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        hp = hp - 1;
        if(hp==998) {
        	System.out.println("�˺��̻߳������м�Ѫ�߳�...");
        	this.notify();//
        }
        System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
    }
    public void attackHero(Hero h) {
        try {
            //Ϊ�˱�ʾ������Ҫʱ�䣬ÿ�ι�����ͣ1000����
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        h.hp-=damage;
        System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n",name,h.name,h.name,h.hp);
         
        if(h.isDead())
            System.out.println(h.name +"���ˣ�");
    }
    
 
    public boolean isDead() {
        return 0>=hp?true:false;
    }
       
}