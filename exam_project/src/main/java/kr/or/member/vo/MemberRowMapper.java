package kr.or.member.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Member m = new Member();
		m.setMemberId(rs.getString("member_id"));
		m.setMemberPw(rs.getString("member_pw"));
		m.setMemberName(rs.getString("member_name"));
		m.setMemberAge(rs.getInt("member_age"));
		return m;
	}

}
