package SpringEx11_Qualifier;

public class MemberSummaryPrinter extends MemberPrinter {
	public void printer(Member member) {
		System.out.printf("회원정보 >>> 아이디 : %d, 이메일 : %s, 이름 : %s, 등록일 : %tF\n", 
				 member.getEmail(),member.getName());
	}
}
