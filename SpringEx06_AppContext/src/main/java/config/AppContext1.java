package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import SpringEx06_AppContext.ChangePasswordService;
import SpringEx06_AppContext.MemberDao;
import SpringEx06_AppContext.MemberInfoPrinter;
import SpringEx06_AppContext.MemberListPrinter;
import SpringEx06_AppContext.MemberPrinter;
import SpringEx06_AppContext.MemberRegisterService;

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
