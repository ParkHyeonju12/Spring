package kr.or.member.model.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.member.model.vo.Member;

@Repository
public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public MemberDao() {
		super();
		System.out.println("Dao 생성 뿅");
		// TODO Auto-generated constructor stub
	}
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		String query = "update member_tbl set member_pw=?, phone=?, email=? where member_id=?";
		Object[] params = {member.getMemberPw(),member.getPhone(),member.getEmail(),member.getMemberId()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}
	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		String query = "select * from member_tbl";
		
		return null;
	}

}
