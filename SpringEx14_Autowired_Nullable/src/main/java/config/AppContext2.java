package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import SpringEx14_Autowired_Nullable.ChangePasswordService;
import SpringEx14_Autowired_Nullable.MemberDao;
import SpringEx14_Autowired_Nullable.MemberInfoPrinter;
import SpringEx14_Autowired_Nullable.MemberListPrinter;
import SpringEx14_Autowired_Nullable.MemberPrinter;
import SpringEx14_Autowired_Nullable.MemberRegisterService;
import SpringEx14_Autowired_Nullable.MemberSummaryPrinter;

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
		return new MemberSummaryPrinter();
	}
	
	@Bean
	// 한정자 infoPrinter
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		return infoPrinter;
	}
}
