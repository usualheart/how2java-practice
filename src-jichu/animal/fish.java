package animal;

public class fish extends Animal implements pet  {
	private String name;
	//无参数的构造器
	public fish() {
			super(0);
		}
	
	public void walk() {
		System.out.println("无法行走，没有腿");
	}
	public void eat() {
		System.out.println("鱼吃东西");
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public void play() {
		System.out.println("鱼在玩耍");
	}
	public static void main(String[] args) {
		fish yu=new fish();
		yu.setName("鲤鱼");
		System.out.println(yu.getName());
		yu.walk();
		yu.eat();
		yu.play();
	}
}
