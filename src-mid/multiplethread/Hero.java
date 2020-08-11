package multiplethread;

//方便lambda使用的Hero类
public class Hero implements Comparable<Hero>{
	public int id;//增加id属性 方便数据库使用
    public String name;
    public float hp;
        
    public int damage;
        
    public Hero(){
           
    }
       
    public Hero(String name) {
        this.name =name;
   
    }
       
    //初始化name,hp,damage的构造方法
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
            	System.out.println("加血线程wait...");
				this.wait();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
        }
        hp = hp + 1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        // 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
        this.notify();
    }
 
    public synchronized void hurt() {
        while(hp == 1) {//不能为if 必须为while,若为if会导致，可能同时唤醒多个该线程进而导致错误
            try {
                // 让占有this的减血线程，暂时释放对this的占有，并等待
            	System.out.println("伤害线程wait...");
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        hp = hp - 1;
        if(hp==998) {
        	System.out.println("伤害线程唤醒所有加血线程...");
        	this.notify();//
        }
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
    }
    public void attackHero(Hero h) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
         
        if(h.isDead())
            System.out.println(h.name +"死了！");
    }
    
 
    public boolean isDead() {
        return 0>=hp?true:false;
    }
       
}