package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import SpringEx08_Import.MemberDao;
import SpringEx08_Import.MemberPrinter;

@Configuration
//@Import(AppContext2.class)
//public class AppContextImport {
//	@Bean
//	public MemberDao memberDao() {
//		return new MemberDao();
//	}

//	// 생성자 방식
//	@Bean
//	public MemberPrinter memberPrinter() {
//		return new MemberPrinter();
//	}
//}
@Import({AppContext1.class, AppContext2.class})
public class AppContextImport{
	
}