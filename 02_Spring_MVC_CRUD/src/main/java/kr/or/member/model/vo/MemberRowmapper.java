package kr.or.member.model.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowmapper implements RowMapper{
	@Override
	public Object mapRow(ResultSet rset, int rowNum) throws SQLException{
		Member m = new Member();
		m.setMemberNo(rset.getInt("member_no"));
		m.setMemberId(rset.getString("member_id"));
		m.setMemberPw(rset.getString("member_pw"));
		m.setMemberName(rset.getString("member_name"));
		m.setPhone(rset.getString("phone"));
		m.setEmail(rset.getString("email"));
		System.out.println(m);
		return m;
	}
}
