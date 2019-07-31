package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import SpringEx16_Component_Annotation.ChangePasswordService;
import SpringEx16_Component_Annotation.MemberDao;
import SpringEx16_Component_Annotation.MemberInfoPrinter;
import SpringEx16_Component_Annotation.MemberListPrinter;
import SpringEx16_Component_Annotation.MemberPrinter;
import SpringEx16_Component_Annotation.MemberRegisterService;
import SpringEx16_Component_Annotation.MemberSummaryPrinter;
import SpringEx16_Component_Annotation.VersionPrinter;
import spring.ManualBean;
import spring.NoProduct;

/* 
 * FilterType.ANNOTATION : 특정 애노테이션을 붙인 타입을 컴포넌트 대상에서 제외할 때 사용
 * NoProduct or ManualBean으로 애노테이션을 붙이면 해당 클래스는 컴포넌트 스캔 대상에서 제외
 * 
 * FilterType.ASSIGNABLE_TYPE : 특정 타입이나 그 하위 타입을 컴포넌트 스캔 대상에서 제외할 때 사용
 * 특정 클래스를 직접 지정하므로 별도 해당 클래스에 코드를 추가할 필요 없다
 * 
 * ##설정할 필터가 두 개 이상일 시 : excludeFilters 속성의 배열을 사용하면 된다
 * ex)
 * @ComponentScan(basePackages = {"SpringEx16_Component", "spring"},
 * 								  excludeFilters = {@Filter(type = FilterType.ANNOTATION, classes = ManualBean.class),
 * 													@Filter(type = FilterType.REGEX, pattern = "SpringEx16_Componenet\\..*")
 * 												    })
 */

@Configuration
@ComponentScan(basePackages = {"SpringEx16_Component", "spring"}, 
			   /*excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = {NoProduct.class, ManualBean.class})*/
			   excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class)
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
