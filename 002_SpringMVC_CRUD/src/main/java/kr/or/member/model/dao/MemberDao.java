package kr.or.member.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.member.model.vo.Member;
import kr.or.member.model.vo.MemberRowMapper;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public MemberDao() {
		super();
		System.out.println("디에이오 생성");
		// TODO Auto-generated constructor stub
	}
	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		String query="INSERT INTO MEMBER_TBL VALUES(MEMBER_SEQ.NEXTVAL,?,?,?,?,?)";
		Object[] params = {m.getMemberId(),m.getMemberPw(),m.getMemberName(),m.getPhone(),m.getEmail()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}
	public Member selectOneMember(Member m) {
		// TODO Auto-generataed method stub
		String query ="select * from member_tbl where member_id=?and member_pw=?";
		Object[] params = {m.getMemberId(),m.getMemberPw()};
		List list = jdbcTemplate.query(query, params, new MemberRowMapper());
		if(list.isEmpty()) {
			return null;
		}else {
			return (Member)list.get(0);
		}
	}
	public Member selectOneMember(String searchId) {
		// TODO Auto-generated method stub
		String query = "select * from member_tbl where member_id=?";
		Object[] params = {searchId};
		List list = jdbcTemplate.query(query, params, new MemberRowMapper());
		if(list.isEmpty()) {
			return null;
		}else {
			return (Member)list.get(0);
		}
	}

}
