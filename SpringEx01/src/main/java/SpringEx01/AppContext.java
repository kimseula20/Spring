package SpringEx01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration 애노테이션은 해당 클래스를 스프링 설정 클래스로 지정한다
@Configuration
public class AppContext {
	// 스프링이 생성하는 객체를 빈(Bean) 객체라고 부르는데 이 빈 객체에 대한 정보를 담고 있는 메서드가 greeter() 메서드이다
	//@Bean 애노테이션을 메서드에 붙이면 해당 메서드가 생성한 객체를 스프링이 관리하는 빈 객체로 등록한다
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s,안녕하세요~");
		return g;
	}
	
	@Bean
	public Greeter greeter1() {
		Greeter g = new Greeter();
		g.setFormat("안녕하세요,%s");
		return g;
	}
}
