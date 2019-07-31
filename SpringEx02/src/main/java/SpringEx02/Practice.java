package SpringEx02;

public class Practice {
	
	private String userStr;
	
	public String example(String str) {
		return String.format(userStr, str);
	}
	
	public void setUserStr(String userStr) {
		this.userStr = userStr;
	}
}
