package animal;

public class Cat extends Animal implements pet {
	String name;
	//�޲����Ĺ�����
	public Cat() {
			this("");
		}
	public Cat(String name) {
		super(4);
		this.name=name;
	}
	
	public void eat() {
		System.out.println("è�Զ���");
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public void play() {
		System.out.println("è����ˣ");
	}
	public static void main(String[] args) {
		Cat yu=new Cat("��è");
		System.out.println(yu.getName());
		yu.walk();
		yu.eat();
		yu.play();
	}
}
