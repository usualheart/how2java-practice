package animal;

public class Cat extends Animal implements pet {
	String name;
	//无参数的构造器
	public Cat() {
			this("");
		}
	public Cat(String name) {
		super(4);
		this.name=name;
	}
	
	public void eat() {
		System.out.println("猫吃东西");
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public void play() {
		System.out.println("猫在玩耍");
	}
	public static void main(String[] args) {
		Cat yu=new Cat("灰猫");
		System.out.println(yu.getName());
		yu.walk();
		yu.eat();
		yu.play();
	}
}
