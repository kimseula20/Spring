package SpringEx13_Autowired_Optional;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
/*
 * 스프링 5 버전부터는 @Autowired 애노테이션의 required속성을 false로 하는 대신
 * java 8의 Optional을 사용해도 된다
 */
public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;
	
//	@Autowired
//	 required 속성을 false로 지정하면 매칭되는 빈이 없어도 Exception이 발생하지 않는다
//	 setDateFormetter()메서드를 실행하지 않는다
//	@Autowired(required = false)
//	public void setDateFormatter(DateTimeFormatter dateTimeFoormatter) {
//		this.dateTimeFormatter = dateTimeFormatter;
//	}
	@Autowired
	public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt) {
		if(formatterOpt.isPresent()) {
			this.dateTimeFormatter = formatterOpt.get();
		}else {
			this.dateTimeFormatter = null;
		}
	}
	
	public void print(Member member) {
		if(dateTimeFormatter == null) {
			System.out.printf("회원정보 : 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF\n",
					member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
		}else {
			System.out.printf("회원정보 : 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %s\n",
					member.getId(), member.getEmail(), member.getName(),
					dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
	
	
}
