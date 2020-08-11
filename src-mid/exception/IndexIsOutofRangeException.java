package exception;

public class IndexIsOutofRangeException extends Exception {
	public IndexIsOutofRangeException(){
		super("下标超出范围异常");
    }
}