package kr.or.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.member.vo.Member;
import kr.or.member.vo.MemberRowMapper;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public MemberDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		String query = "select * from member_tbl";
		List list = jdbcTemplate.query(query, new MemberRowMapper());
		return (ArrayList<Member>) list;
	}

	public int insertMember(Member m) {
		String query = "insert into member_tbl values(?,?,?,?)";
		Object[] params = { m.getMemberId(), m.getMemberPw(), m.getMemberName(), m.getMemberAge() };
		int result = jdbcTemplate.update(query, params);
		return result;
	}

}
