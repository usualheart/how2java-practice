package character;
//��ΪHero�޸�Ϊ����ģʽ �����޷��̳�
//public class ADHero extends Hero{
public class ADHerodanli {
	
	String name;
	
    public void attack() {
        System.out.println(name + " ������һ�ι��� �����ǲ�ȷ������˭��");
    }
 
    // �ɱ������Ĳ���
    public void attack(Herodanli... heros) {
        for (int i = 0; i < heros.length; i++) {
            System.out.println(name + " ������ " + heros[i].name);
 
        }
    }
 
    public static void main(String[] args) {
        ADHerodanli bh = new ADHerodanli();
        bh.name = "�ͽ�����";
 
        Herodanli h1 = Herodanli.getinstance();
        h1.name = "����";
        Herodanli h2 = Herodanli.getinstance();
        h2.name = "��Ī";
 
        bh.attack();
        bh.attack(h1, h2);
 
    }
 
}