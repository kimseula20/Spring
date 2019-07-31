package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import SpringEx18_Spring_LifeCycle.Client;
import SpringEx18_Spring_LifeCycle.Client2;


@Configuration
public class AppContext {
	@Bean(initMethod = "startConnect", destroyMethod = "close2")
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("host");
		return client2;
	}
	
	@Bean(initMethod = "aaa", destroyMethod = "bbb")
	public Client client() {
		Client client = new Client();
		client.setHost("host");
		return client;
	}
	

}
