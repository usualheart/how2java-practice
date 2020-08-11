package character;
public class APHero extends Hero implements AP, Mortal{
	public APHero() {
		// TODO 自动生成的构造函数存根
	}
    public APHero(String string) {
		// TODO 自动生成的构造函数存根
    	this.name=string;
	}

	public void attack() {
        System.out.println(name + " 进行了一次攻击 ，但是不确定打中谁了");
    }
 
    // 可变数量的参数
    public void attack(Hero... heros) {
        for (int i = 0; i < heros.length; i++) {
            System.out.println(name + " 攻击了 " + heros[i].name);
 
        }
    }

  
    //AD魔法攻击
    public void magicAttack() {
    	System.out.println("进行魔法攻击");
    }
    //Mortal die override
    public void die() {
    	System.out.println("魔法英雄"+this.name+"死亡");
    }
    public static void main(String[] args) {
        APHero bh = new APHero();
        bh.name = "赏金猎人";
 
 
    }
 
}