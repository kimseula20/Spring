package SpringEx14_Autowired_Nullable;

public class MemberSummaryPrinter extends MemberPrinter {
	public void printer(Member member) {
		System.out.printf("회원정보 >>> 이메일 : %s, 이름 : %s\n", 
				 member.getEmail(),member.getName());
	}
}
