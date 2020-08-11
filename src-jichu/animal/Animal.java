package animal;

public abstract class  Animal {
	protected int legs;
	protected Animal(int legs){
		this.legs=legs;
	}
	public abstract void eat();
	public void walk() {
		System.out.printf("用%d只腿行走\n",this.legs);
	}

}
