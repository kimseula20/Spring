package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import SpringEx09_Autowired.ChangePasswordService;
import SpringEx09_Autowired.MemberDao;
import SpringEx09_Autowired.MemberInfoPrinter;
import SpringEx09_Autowired.MemberListPrinter;
import SpringEx09_Autowired.MemberPrinter;
import SpringEx09_Autowired.MemberRegisterService;

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
		/*
		 * 의존을 주입하지 않아도 스프링이 @Autowired가 붙인 필드에 해당 타입의
		 * 빈 객체를 찾아서 주입한다
		 */
//		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	// 생성자 방식
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(/*memberDao(), memberPrinter()*/);
	}
	
	// setter 방식
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		/*
		 * 의존을 주입하지 않아도 스프링이 @Autowired가 붙인 필드에 해당 타입의
		 * 빈 객체를 찾아서 주입한다
		 */
//		infoPrinter.setMemberDao(memberDao());
//		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
	}
}
