package character;
import property.Item;
import property.LifePotion;
public class ADHero extends Hero implements AD,Mortal{
	int moveSpeed; //������ƶ��ٶ� �����ø���Ŀ���super�ؼ���
	
	//ADHero�Ĺ��췽��
	public ADHero() {
		//System.out.println("AD Hero���޲������췽��");
	}
	public ADHero(String name) {
    	super(name);//�ؼ���super��ʽ���ø���Ĵ������Ĺ��췽��
    	//System.out.println("AD Hero��һ���������췽��");
    }
	
	
	//��������
	public void attack() {
        System.out.println(name + " ������һ�ι��� �����ǲ�ȷ������˭��");
    }
    // �ɱ������Ĳ���
    public void attack(Hero... heros) {
        for (int i = 0; i < heros.length; i++) {
            System.out.println(name + " ������ " + heros[i].name);
 
        }
    }//�����ṩAD�ӿ��������ķ���physicAttack()
    public void physicAttack() {
    	System.out.println("����������");
    }
    
    // ��дuseItem���������е��ø����userItem����
    public void useItem(Item i) {
        System.out.println("adhero use item");
        super.useItem(i);
    }
    //��������
    public void die() {
    	System.out.println("����Ӣ��"+this.name+"����");
    }
    //��ȡ�ƶ��ٶȣ�����
    public int getMoveSpeed() {
    	return this.moveSpeed;
    }
  //��ȡ�ƶ��ٶȣ����Ը���
    public int getMoveSpeed2() {
    	return super.moveSpeed;
    }
    
    
    //���ظ����battleWin����
    public static void battleWin() {
    	System.out.println("����Ӣ��Ӯ��ս��ʤ��!");
    }
    public static void main(String[] args) {
        ADHero bh = new ADHero();
        bh.name = "�ͽ�����";
 
        Hero h1 = new Hero();
        h1.name = "����";
        Hero h2 =  new Hero();
        h2.name = "��Ī";
 
        bh.attack();
        bh.attack(h1, h2);
        Hero.battleWin();
        ADHero.battleWin();
        //��������Ч����bhΪ����hΪHero�࣬���Ե��õ���Hero���෽��
        Hero h=bh;
        h.battleWin();
        //����super�ؼ���
        ADHero de=new ADHero("������"); 
        
        //ʹ����Ʒ
        LifePotion lp = new LifePotion();
        de.useItem(lp);
        //ʹ�ýӿ�AD��Ĭ�Ϲ���
        de.adattack();
    }
 
}