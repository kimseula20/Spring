package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import SpringEx12_Autowired_required.ChangePasswordService;
import SpringEx12_Autowired_required.MemberDao;
import SpringEx12_Autowired_required.MemberInfoPrinter;
import SpringEx12_Autowired_required.MemberListPrinter;
import SpringEx12_Autowired_required.MemberPrinter;
import SpringEx12_Autowired_required.MemberRegisterService;

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
