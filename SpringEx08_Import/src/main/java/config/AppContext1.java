package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import SpringEx08_Import.MemberDao;
import SpringEx08_Import.MemberPrinter;

@Configuration
public class AppContext1 {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	// 생성자 방식
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
}
