package character;
import exception.EnemyHeroIsDeadException;
import property.Item;
public class Hero {   
    public  int damage = 0;
	public String name; //����  
    public float hp; //Ѫ��
    float armor; //����  
    int moveSpeed; //�ƶ��ٶ� 
    static String copyright;//�����ԣ���̬���� ��Ȩ
    //��Ʒ��������
    public static int itemCapacity=8; //������ʱ�� ��ʼ��
    static{
        itemCapacity = 6;//��̬��ʼ���� ��ʼ��
    }
    //��ʽ�޲ι��췽��
    public Hero() {
    	//System.out.println("Hero���޲������췽��");
    }
    //һ���������췽��
    public Hero(String name) {
    	this.name=name;
    	//System.out.println("Hero��һ���������췽��");
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
    //����this�Ĺ��췽��
    public Hero(String name,float hp,
    		float armor,int moveSpeed) {
    	this(name,hp);
    	this.armor=armor;
    	this.moveSpeed=moveSpeed;
    }
    /*//���쵥������2,��̬����ָ��ʵ��
    private static Hero instance;
    //���쵥������3�����ؾ�̬���� �˴�Ϊ����ģʽ
    public static Hero getinstance() {
    	if(instance==null)instance=new Hero();
    	return instance;
    }
    */
    
    //���췽�� hp,damage
    public Hero(String string, int nextInt, int nextInt2) {
		// TODO �Զ����ɵĹ��캯�����
    	this.name=string;
    	hp=nextInt;
    	damage=nextInt2;
	}
	// ʹ����Ʒ����
    public void useItem(Item i) {
        i.effect();
    }
    //��Ѫ����
    public void huixue(int xp){
        this.hp = this.hp + xp;
        //��Ѫ��Ϻ�Ѫƿ=0,��ʵ�޷��޸�֮��Ĳ���
        xp=0;
    }
    
    //����Ӣ�۵ķ���
    public void attackHero(Hero x) throws EnemyHeroIsDeadException {
    	if(x.hp==0) {
    		throw new EnemyHeroIsDeadException(x.name+"�Ѿ������޷�����");
    	}
    }
    //ɱ������
    public void kill(Mortal m) {
    	System.out.print(this.name+"��");
    	m.die();
    }
    //����
    public void revive(Hero h){
        h = new Hero("��Ī",383);
    }
    //չʾӢ��״̬
    public void show() {
    	System.out.println(name+"   "+hp+"  "+armor+"  "+moveSpeed);
    }
    //�෽������̬���� ͨ����Ϳ���ֱ�ӵ���
    public static void battleWin(){
        System.out.println("Ӣ��ս��ʤ����");
    }
   
    public static void main(String[] args) {
       /* //����һ������
        new Hero();     
        //ʹ��һ��������ָ���������
        Hero h = new Hero();*/
    	
        /*
        Hero garen = new Hero("����",87.8f,99.8f,60); 
        Hero teemo = new Hero("��Ī",66.5f,89.5f,73);
        System.out.println("Ӣ��    Ѫ��        ����   �ƶ��ٶ�");
        garen.show();
        teemo.show();
        //ʹ��Ѫƿ����
        int xueping=100;
        teemo.huixue(xueping);
        System.out.println(xueping);
        
        System.out.println(teemo.hp); 
        teemo.hp=0;
        teemo.revive(teemo);
        System.out.println(teemo.hp); 
        
        //������ ����̬����
        Hero.copyright = "��Ȩ��Riot Games��˾����";
        System.out.println(garen.name);
        System.out.println(garen.copyright);
        System.out.println(teemo.name);    
        System.out.println(teemo.copyright);
        
        //�������ֱ�ӵ����෽��
        Hero.battleWin();
       
        System.out.println(Hero.itemCapacity);
        
        //��ת��Ϊ�ӿ�(����ת��)
        ADHero ad = new ADHero();
        AD adi = ad;
        
        //��̬
        ADHero wusong = new ADHero();
        wusong.name="����";
        APHero sunwukong = new APHero();
        sunwukong.name="�����";
        garen.kill(wusong);
        teemo.kill(sunwukong);
        */
       
    	//�쳣���Բ���
    	Hero garen =  new Hero();
        garen.name = "����";
        garen.hp = 616;
 
        Hero teemo =  new Hero();
        teemo.name = "��Ī";
        teemo.hp = 0;
         
        try {
            garen.attackHero(teemo);
             
        } catch (EnemyHeroIsDeadException e) {
            // TODO Auto-generated catch block
            System.out.println("�쳣�ľ���ԭ��:"+e.getMessage());
            e.printStackTrace();
        }
    }
	
      
}