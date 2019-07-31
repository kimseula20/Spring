package SpringEx13_Autowired_Optional;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * @Autowired 애노테이션도 @Qualifier애노테이션이 없으면 필드나 파라미터 이름을 한정자로 사용한다
 * 아래의 코드는 @Autowired 애노테이션이 지정되어 있지만 @Qualifier 애노테이션은 지정이 되어 있지 않으므로
 * 필드 명인 printer가 한정자로 사용된다
 */

public class MemberInfoPrinter2 {
	@Autowired
	private MemberPrinter printer;
}
