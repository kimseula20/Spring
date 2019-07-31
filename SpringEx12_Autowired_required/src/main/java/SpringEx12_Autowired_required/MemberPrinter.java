package SpringEx12_Autowired_required;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
/*
 * 아래의 코드는 dateTimeFormatter가 null이여도 정상적으로 작동한다
 * 하지만 @Autowired 애노테이션은 애노테이션을 붙인 타입에 해당하는 빈이 존재하지 않으면
 * Exception을 발생시킨다.
 * 
 * MemberPrinter는 setDateFormatter()메서드에 자동 주입할 빈이 존재하지 않으면 Exception을 발생하기보단
 * 필드가 null이기만 하면 된다.
 * 
 * 이와 같이 자동 주입할 대상이 필수가 아닌 경우에는 @Autowired의 required 속성을 false로 지정하면 된다
 */
public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;
	
//	@Autowired
	// required 속성을 false로 지정하면 매칭되는 빈이 없어도 Exception이 발생하지 않는다
	// setDateFormetter()메서드를 실행하지 않는다
	@Autowired(required = false)
	public void setDateFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
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
