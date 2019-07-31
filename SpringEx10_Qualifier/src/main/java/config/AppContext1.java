package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import SpringEx10_Qualifier.MemberDao;
import SpringEx10_Qualifier.MemberPrinter;

@Configuration
public class AppContext1 {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("printer")
	/*
	 * MemberPrinter를 사용하는 모든 곳에 해당 Qualifier를 설정해줘야 한다
	 */
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberPrinter memberPrinter2() {
		return new MemberPrinter();
	}
}
