package character;

public class Herodanli {   
    public String name; //����  
    float hp; //Ѫ��
    float armor; //����  
    int moveSpeed; //�ƶ��ٶ� 
    static String copyright;//�����ԣ���̬���� ��Ȩ
    //��Ʒ��������
    public static int itemCapacity=8; //������ʱ�� ��ʼ��
    static{
        itemCapacity = 6;//��̬��ʼ���� ��ʼ��
    }
    //���췽��,���쵥������1���Ѿ�������˽�л�
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
    //����this�Ĺ��췽��
    private Herodanli(String name,float hp,
    		float armor,int moveSpeed) {
    	this(name,hp);
    	this.armor=armor;
    	this.moveSpeed=moveSpeed;
    }
    //���쵥������2,��̬����ָ��ʵ��
    private static Herodanli instance;
    //���쵥������3�����ؾ�̬���� �˴�Ϊ����ģʽ
    public static Herodanli getinstance() {
    	if(instance==null)instance=new Herodanli();
    	return instance;
    }
    public void huixue(int xp){
        this.hp = this.hp + xp;
        //��Ѫ��Ϻ�Ѫƿ=0,��ʵ�޷��޸�֮��Ĳ���
        xp=0;
    }
    //����
    public void revive(Herodanli h){
        h = new Herodanli("��Ī",383);
    }
    //չʾӢ��״̬
    public void show() {
    	System.out.println(name+"   "+hp+"  "+armor+"  "+moveSpeed);
    }
    //�෽������̬���� ͨ����Ϳ���ֱ�ӵ���
    public static void battleWin(){
        System.out.println("ս��ʤ����");
    }
   
    public static void main(String[] args) {
       /* //����һ������
        new Hero();     
        //ʹ��һ��������ָ���������
        Hero h = new Hero();*/
    	
        
        Herodanli garen = new Herodanli("����",87.8f,99.8f,60); 
        Herodanli teemo = new Herodanli("��Ī",66.5f,89.5f,73);
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
        Herodanli.copyright = "��Ȩ��Riot Games��˾����";
        System.out.println(garen.name);
        System.out.println(garen.copyright);
        System.out.println(teemo.name);    
        System.out.println(teemo.copyright);
        
        //�������ֱ�ӵ����෽��
        Herodanli.battleWin();
        
        System.out.println(Herodanli.itemCapacity);
        
    }  
      
}