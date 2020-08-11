package character;
import exception.EnemyHeroIsDeadException;
import property.Item;
public class Hero {   
    public  int damage = 0;
	public String name; //姓名  
    public float hp; //血量
    float armor; //护甲  
    int moveSpeed; //移动速度 
    static String copyright;//类属性，静态属性 版权
    //物品栏的容量
    public static int itemCapacity=8; //声明的时候 初始化
    static{
        itemCapacity = 6;//静态初始化块 初始化
    }
    //显式无参构造方法
    public Hero() {
    	//System.out.println("Hero的无参数构造方法");
    }
    //一个参数构造方法
    public Hero(String name) {
    	this.name=name;
    	//System.out.println("Hero的一个参数构造方法");
    }
    public Hero(String name,float hp) {
    	this.name=name;
    	this.hp=hp;
    }
   /* public Hero(String heroName,float heroHP,
    		float heroArmor,int heroMoveSpeed) {
    	name=heroName;
    	hp=heroHP;
    	armor=heroArmor;
    	moveSpeed=heroMoveSpeed;
    }
   */
    //带有this的构造方法
    public Hero(String name,float hp,
    		float armor,int moveSpeed) {
    	this(name,hp);
    	this.armor=armor;
    	this.moveSpeed=moveSpeed;
    }
    /*//构造单例步骤2,静态书香指向实例
    private static Hero instance;
    //构造单例步骤3，返回静态属性 此处为懒汉模式
    public static Hero getinstance() {
    	if(instance==null)instance=new Hero();
    	return instance;
    }
    */
    
    //构造方法 hp,damage
    public Hero(String string, int nextInt, int nextInt2) {
		// TODO 自动生成的构造函数存根
    	this.name=string;
    	hp=nextInt;
    	damage=nextInt2;
	}
	// 使用物品方法
    public void useItem(Item i) {
        i.effect();
    }
    //回血方法
    public void huixue(int xp){
        this.hp = this.hp + xp;
        //回血完毕后，血瓶=0,其实无法修改之外的参数
        xp=0;
    }
    
    //攻击英雄的方法
    public void attackHero(Hero x) throws EnemyHeroIsDeadException {
    	if(x.hp==0) {
    		throw new EnemyHeroIsDeadException(x.name+"已经死了无法攻击");
    	}
    }
    //杀死方法
    public void kill(Mortal m) {
    	System.out.print(this.name+"令");
    	m.die();
    }
    //复活
    public void revive(Hero h){
        h = new Hero("提莫",383);
    }
    //展示英雄状态
    public void show() {
    	System.out.println(name+"   "+hp+"  "+armor+"  "+moveSpeed);
    }
    //类方法，静态方法 通过类就可以直接调用
    public static void battleWin(){
        System.out.println("英雄战争胜利！");
    }
   
    public static void main(String[] args) {
       /* //创建一个对象
        new Hero();     
        //使用一个引用来指向这个对象
        Hero h = new Hero();*/
    	
        /*
        Hero garen = new Hero("盖伦",87.8f,99.8f,60); 
        Hero teemo = new Hero("提莫",66.5f,89.5f,73);
        System.out.println("英雄    血量        护甲   移动速度");
        garen.show();
        teemo.show();
        //使用血瓶治疗
        int xueping=100;
        teemo.huixue(xueping);
        System.out.println(xueping);
        
        System.out.println(teemo.hp); 
        teemo.hp=0;
        teemo.revive(teemo);
        System.out.println(teemo.hp); 
        
        //类属性 ，静态属性
        Hero.copyright = "版权由Riot Games公司所有";
        System.out.println(garen.name);
        System.out.println(garen.copyright);
        System.out.println(teemo.name);    
        System.out.println(teemo.copyright);
        
        //无需对象，直接调用类方法
        Hero.battleWin();
       
        System.out.println(Hero.itemCapacity);
        
        //类转型为接口(向上转型)
        ADHero ad = new ADHero();
        AD adi = ad;
        
        //多态
        ADHero wusong = new ADHero();
        wusong.name="武松";
        APHero sunwukong = new APHero();
        sunwukong.name="孙悟空";
        garen.kill(wusong);
        teemo.kill(sunwukong);
        */
       
    	//异常测试部分
    	Hero garen =  new Hero();
        garen.name = "盖伦";
        garen.hp = 616;
 
        Hero teemo =  new Hero();
        teemo.name = "提莫";
        teemo.hp = 0;
         
        try {
            garen.attackHero(teemo);
             
        } catch (EnemyHeroIsDeadException e) {
            // TODO Auto-generated catch block
            System.out.println("异常的具体原因:"+e.getMessage());
            e.printStackTrace();
        }
    }
	
      
}