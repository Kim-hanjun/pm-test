
public class MyException extends Exception {

	public static final long serialVersionUID = 7718828512143293558L;
	
	private final int ERR_CODE;
	
	MyException(String msg, int errcode){
		super(msg);
		ERR_CODE = errcode;
	}
	
	MyException(String msg){
		// 에러코드 없이 msg만 들어오면 100이라는 에러코드를 주겠다
		this(msg, 100);
	}
	
	public int getErrcode() {
		return ERR_CODE;
	}

}
