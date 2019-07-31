package SpringEx18_Spring_LifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean{

	private String host;
	
	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client.afterPropertiesSet() 메서드 실행");
	}
	
	public void send() {
		System.out.println("Client.send() to " + host);
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Client.destroy() 메서드 실행");
	}
	
	public void aaa() {
		System.out.println("ggg");
	}
	
	public void bbb() {
		System.out.println("bbb");
	}
	
	
}
