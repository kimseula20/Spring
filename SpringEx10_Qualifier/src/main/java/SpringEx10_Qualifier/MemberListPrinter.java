package SpringEx10_Qualifier;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/*
 * @Qualifier는 필드 혹은 해당 메서드에 모두 사용이 가능하다
 */
public class MemberListPrinter {
	private MemberDao memberDao;
	@Autowired
	@Qualifier("printer")
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	public MemberListPrinter() {
		
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
//	@Autowired
//	@Qualifier("printer")
	public void setMemberPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		for (Member m : members) {
			printer.print(m);
		}
	}
}
