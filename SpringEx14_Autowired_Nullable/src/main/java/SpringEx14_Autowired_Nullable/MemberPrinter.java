package SpringEx14_Autowired_Nullable;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
/*
 * @Autowired(required = false)와 @Nullable의 차이
 * required가 false로 지정되면 대상 빈이 존재하지 않으면 메서드를 호출하지 않지만
 * @Nullable은 자동 주입할 빈이 존재하지 않아도 메서드가 호출 된다
 */
public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
//	@Autowired
//	 required 속성을 false로 지정하면 매칭되는 빈이 없어도 Exception이 발생하지 않는다
//	 setDateFormetter()메서드를 실행하지 않는다
	@Autowired(required = false)
	public void setDateFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
//	@Autowired
//	public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt) {
//		if(formatterOpt.isPresent()) {
//			this.dateTimeFormatter = formatterOpt.get();
//		}else {
//			this.dateTimeFormatter = null;
//		}
//	}
	
//	@Autowired
//	public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
//		this.dateTimeFormatter = dateTimeFormatter;
//	}
	
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
