package character;

public interface AD {
	public void physicAttack();
	default void adattack() {
		System.out.println("ADÄ¬ÈÏÎïÀí¹¥»÷£¡");
	}
}
