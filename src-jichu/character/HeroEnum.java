package character;

enum HeroType{
	TANK,WIZARD,ASSASSIN,ASSIST,
	WARRIOR,RANGED,PUSH,FARMING;}

public class HeroEnum {
	
	public static void main(String[] args) {
		HeroType Hero=HeroType.TANK;
		
		switch(Hero){
			case TANK:
				System.out.println("̹��");
				break;
			case ASSASSIN:
				System.out.println("��ʦ");
				break;
			case ASSIST:
				System.out.println("�̿�");
				break;
			case FARMING:
				System.out.println("����");
				break;
			case PUSH:
				System.out.println("��ս");
				break;
			case RANGED:
				System.out.println("Զ��");
				break;
			case WARRIOR:
				System.out.println("�ƽ�");
				break;
			case WIZARD:
				System.out.println("��Ұ");
				break;
			default:
				break;
			
		}
		//����ö������
		for(HeroType h:HeroType.values()) {
			System.out.println(h);
		}
	}
}

	
