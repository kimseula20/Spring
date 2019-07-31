package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import SpringEx07_Autowired.ChangePasswordService;
import SpringEx07_Autowired.MemberDao;
import SpringEx07_Autowired.MemberInfoPrinter;
import SpringEx07_Autowired.MemberListPrinter;
import SpringEx07_Autowired.MemberPrinter;
import SpringEx07_Autowired.MemberRegisterService;

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
		pwdSvc.setMemberDao(memberDao);
		return pwdSvc;
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao, memberPrinter);
	}
	
	// setter 방식
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		/*
		 *setter메서드를 사용해서 의존 주입을 하지 않아도 스프링 컨테이너가 @Autowired를 붙인 필드에
		 *자동으로 해당 타입의 빈 객체를 주입한다
		 */
//		infoPrinter.setMemberDao(memberDao);
//		infoPrinter.setPrinter(memberPrinter);
		return infoPrinter;
	}
}
