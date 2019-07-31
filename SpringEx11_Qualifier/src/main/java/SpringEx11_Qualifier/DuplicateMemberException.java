package SpringEx11_Qualifier;

/*
 * 회원 중 동일한 email을 가지고 있는 회원이 있을 경우 발생시키는 Exception
 */
public class DuplicateMemberException extends RuntimeException{
	public DuplicateMemberException(String message) {
		super(message);
	}
}
