package SpringEx18_Spring_LifeCycle;

public class Client2 {

	private String host;
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public void startConnect() {
		System.out.println("Client2.startConnect() 메서드 실행");
	}
	
	public void send2() {
		System.out.println("Client2.send2() : " + host);
	}
	
	public void close2() {
		System.out.println("Client2.close2() 메서드 실행");
	}
	
}
