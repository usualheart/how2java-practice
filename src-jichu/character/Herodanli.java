package character;

public class Herodanli {   
    public String name; //姓名  
    float hp; //血量
    float armor; //护甲  
    int moveSpeed; //移动速度 
    static String copyright;//类属性，静态属性 版权
    //物品栏的容量
    public static int itemCapacity=8; //声明的时候 初始化
    static{
        itemCapacity = 6;//静态初始化块 初始化
    }
    //构造方法,构造单例步骤1，已经进行了私有化
    private Herodanli() {
    }
    private Herodanli(String name,float hp) {
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
    private Herodanli(String name,float hp,
    		float armor,int moveSpeed) {
    	this(name,hp);
    	this.armor=armor;
    	this.moveSpeed=moveSpeed;
    }
    //构造单例步骤2,静态书香指向实例
    private static Herodanli instance;
    //构造单例步骤3，返回静态属性 此处为懒汉模式
    public static Herodanli getinstance() {
    	if(instance==null)instance=new Herodanli();
    	return instance;
    }
    public void huixue(int xp){
        this.hp = this.hp + xp;
        //回血完毕后，血瓶=0,其实无法修改之外的参数
        xp=0;
    }
    //复活
    public void revive(Herodanli h){
        h = new Herodanli("提莫",383);
    }
    //展示英雄状态
    public void show() {
    	System.out.println(name+"   "+hp+"  "+armor+"  "+moveSpeed);
    }
    //类方法，静态方法 通过类就可以直接调用
    public static void battleWin(){
        System.out.println("战争胜利！");
    }
   
    public static void main(String[] args) {
       /* //创建一个对象
        new Hero();     
        //使用一个引用来指向这个对象
        Hero h = new Hero();*/
    	
        
        Herodanli garen = new Herodanli("盖伦",87.8f,99.8f,60); 
        Herodanli teemo = new Herodanli("提莫",66.5f,89.5f,73);
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
        Herodanli.copyright = "版权由Riot Games公司所有";
        System.out.println(garen.name);
        System.out.println(garen.copyright);
        System.out.println(teemo.name);    
        System.out.println(teemo.copyright);
        
        //无需对象，直接调用类方法
        Herodanli.battleWin();
        
        System.out.println(Herodanli.itemCapacity);
        
    }  
      
}