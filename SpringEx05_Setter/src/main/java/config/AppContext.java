package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import SpringEx05_Setter.ChangePasswordService;
import SpringEx05_Setter.MemberDao;
import SpringEx05_Setter.MemberInfoPrinter;
import SpringEx05_Setter.MemberListPrinter;
import SpringEx05_Setter.MemberPrinter;
import SpringEx05_Setter.MemberRegisterService;

@Configuration
public class AppContext {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	// 생성자 방식
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
	
	// setter 방식
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
	}
}
