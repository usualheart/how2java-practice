package character;
public class APHero extends Hero implements AP, Mortal{
	public APHero() {
		// TODO �Զ����ɵĹ��캯�����
	}
    public APHero(String string) {
		// TODO �Զ����ɵĹ��캯�����
    	this.name=string;
	}

	public void attack() {
        System.out.println(name + " ������һ�ι��� �����ǲ�ȷ������˭��");
    }
 
    // �ɱ������Ĳ���
    public void attack(Hero... heros) {
        for (int i = 0; i < heros.length; i++) {
            System.out.println(name + " ������ " + heros[i].name);
 
        }
    }

  
    //ADħ������
    public void magicAttack() {
    	System.out.println("����ħ������");
    }
    //Mortal die override
    public void die() {
    	System.out.println("ħ��Ӣ��"+this.name+"����");
    }
    public static void main(String[] args) {
        APHero bh = new APHero();
        bh.name = "�ͽ�����";
 
 
    }
 
}