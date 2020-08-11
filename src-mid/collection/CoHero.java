package collection;


public class CoHero {
    public String name;
    public float hp;
 
    public int damage;
 
    public CoHero() {
 
    }
 
    // 增加一个初始化name的构造方法
    public CoHero(String name) {
 
        this.name = name;
    }
    
 // 增加一个初始化name和血量的构造方法
    public CoHero(String name,float h) {
 
        this.name = name;
        this.hp=h;
    }
 
    // 重写toString方法
    public String toString() {
        return name;
    }
 
}