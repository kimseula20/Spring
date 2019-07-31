package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import SpringEx13_Autowired_Optional.ChangePasswordService;
import SpringEx13_Autowired_Optional.MemberDao;
import SpringEx13_Autowired_Optional.MemberInfoPrinter;
import SpringEx13_Autowired_Optional.MemberListPrinter;
import SpringEx13_Autowired_Optional.MemberPrinter;
import SpringEx13_Autowired_Optional.MemberRegisterService;

@Configuration
public class AppContext2 {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter memberPrinter;
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao);
	}
		
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		return pwdSvc;
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao, memberPrinter);
	}
	
	@Bean
	// 한정자 printer
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("mprint")
	// 한정자 mprint
	public MemberPrinter printer2() {
		return new MemberPrinter();
	}
	
	@Bean
	// 한정자 infoPrinter
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		return infoPrinter;
	}
}
