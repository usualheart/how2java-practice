package character;
import property.Item;
import property.LifePotion;
public class ADHero extends Hero implements AD,Mortal{
	int moveSpeed; //子类的移动速度 ，调用父类的可用super关键字
	
	//ADHero的构造方法
	public ADHero() {
		//System.out.println("AD Hero的无参数构造方法");
	}
	public ADHero(String name) {
    	super(name);//关键字super显式调用父类的带参数的构造方法
    	//System.out.println("AD Hero的一个参数构造方法");
    }
	
	
	//攻击方法
	public void attack() {
        System.out.println(name + " 进行了一次攻击 ，但是不确定打中谁了");
    }
    // 可变数量的参数
    public void attack(Hero... heros) {
        for (int i = 0; i < heros.length; i++) {
            System.out.println(name + " 攻击了 " + heros[i].name);
 
        }
    }//必须提供AD接口中声明的方法physicAttack()
    public void physicAttack() {
    	System.out.println("进行物理攻击");
    }
    
    // 重写useItem，并在其中调用父类的userItem方法
    public void useItem(Item i) {
        System.out.println("adhero use item");
        super.useItem(i);
    }
    //死亡方法
    public void die() {
    	System.out.println("物理英雄"+this.name+"死亡");
    }
    //获取移动速度，子类
    public int getMoveSpeed() {
    	return this.moveSpeed;
    }
  //获取移动速度，来自父类
    public int getMoveSpeed2() {
    	return super.moveSpeed;
    }
    
    
    //隐藏父类的battleWin方法
    public static void battleWin() {
    	System.out.println("物理英雄赢得战争胜利!");
    }
    public static void main(String[] args) {
        ADHero bh = new ADHero();
        bh.name = "赏金猎人";
 
        Hero h1 = new Hero();
        h1.name = "盖伦";
        Hero h2 =  new Hero();
        h2.name = "提莫";
 
        bh.attack();
        bh.attack(h1, h2);
        Hero.battleWin();
        ADHero.battleWin();
        //测试隐藏效果，bh为子类h为Hero类，所以调用的是Hero的类方法
        Hero h=bh;
        h.battleWin();
        //测试super关键字
        ADHero de=new ADHero("德莱文"); 
        
        //使用物品
        LifePotion lp = new LifePotion();
        de.useItem(lp);
        //使用接口AD的默认攻击
        de.adattack();
    }
 
}