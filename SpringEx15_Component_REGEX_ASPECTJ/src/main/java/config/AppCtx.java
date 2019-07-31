package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import SpringEx15_Component.ChangePasswordService;
import SpringEx15_Component.MemberDao;
import SpringEx15_Component.MemberInfoPrinter;
import SpringEx15_Component.MemberListPrinter;
import SpringEx15_Component.MemberPrinter;
import SpringEx15_Component.MemberRegisterService;
import SpringEx15_Component.MemberSummaryPrinter;
import SpringEx15_Component.VersionPrinter;

/*
 * FilterType.REGEX -> 정규표현식을 사용해서 제외 대상을 지정한다 -> SpringEx15_Component.으로 시작하고 Dao로 끝나는 정규표현식을 지정
 * SpringEx15_Component.MemberDao 클래스를 컴포넌트 스캔 대상에서 제외한다
 * 
 * FilterType.ASPECTJ -> 정규표현식 대신 AspectJ패턴을 사용해서 대상을 지정한다
 */

@Configuration
@ComponentScan(basePackages = {"SpringEx15_Component", "spring"}, 
			   /*excludeFilters = @Filter(type = FilterType.REGEX, pattern = "SpringEx15_Component\\..*Dao")*/
			   excludeFilters = @Filter(type = FilterType.ASPECTJ, pattern = "SpringEx15_Component.*Dao")
			   )
public class AppCtx {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService();
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		return new ChangePasswordService();
	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
