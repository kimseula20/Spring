package SpringEx23_DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


public class MemberRowMapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member(rs.getString("EMAIL"),
								   rs.getString("PASSWORD"),
								   rs.getString("NAME"),
								   rs.getTimestamp("REGDATE").toLocalDateTime());
		member.setId(rs.getLong("ID"));
		return member;
	}
	List<Member> results = JdbcTemplate.query(
			"SELECT & FROM member WHERE email = ? and name = ?", new MemberRowMapper(), email, name);
}
