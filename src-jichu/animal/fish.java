package animal;

public class fish extends Animal implements pet  {
	private String name;
	//�޲����Ĺ�����
	public fish() {
			super(0);
		}
	
	public void walk() {
		System.out.println("�޷����ߣ�û����");
	}
	public void eat() {
		System.out.println("��Զ���");
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public void play() {
		System.out.println("������ˣ");
	}
	public static void main(String[] args) {
		fish yu=new fish();
		yu.setName("����");
		System.out.println(yu.getName());
		yu.walk();
		yu.eat();
		yu.play();
	}
}
