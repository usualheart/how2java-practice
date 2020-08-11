package exception;

public class OverdraftException extends Exception{
	double deficit=0;	
	public double getDeficit() {
		return deficit;
	}
	public OverdraftException(String msg,double df) {
		super(msg+df+"Ԫ");
		deficit=df;
	}
	
}
