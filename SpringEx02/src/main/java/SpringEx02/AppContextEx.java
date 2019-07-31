package SpringEx02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContextEx {
	
	@Bean
	public Practice practice() {
		Practice p = new Practice();
		p.setUserStr("%s, 환영합니다^_^");
		return p;
	}
	
	@Bean
	public Practice practice1() {
		Practice p = new Practice();
		p.setUserStr("%s, 너무 어려워요 T.T");
		return p;
	}
	
	@Bean
	public Practice practice2() {
		Practice p = new Practice();
		p.setUserStr("%s, 언제쯤 익숙해질까요 ...");
		return p;
	}
}
