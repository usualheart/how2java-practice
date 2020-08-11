package character;
//因为Hero修改为单例模式 导致无法继承
//public class ADHero extends Hero{
public class ADHerodanli {
	
	String name;
	
    public void attack() {
        System.out.println(name + " 进行了一次攻击 ，但是不确定打中谁了");
    }
 
    // 可变数量的参数
    public void attack(Herodanli... heros) {
        for (int i = 0; i < heros.length; i++) {
            System.out.println(name + " 攻击了 " + heros[i].name);
 
        }
    }
 
    public static void main(String[] args) {
        ADHerodanli bh = new ADHerodanli();
        bh.name = "赏金猎人";
 
        Herodanli h1 = Herodanli.getinstance();
        h1.name = "盖伦";
        Herodanli h2 = Herodanli.getinstance();
        h2.name = "提莫";
 
        bh.attack();
        bh.attack(h1, h2);
 
    }
 
}