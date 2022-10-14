package kr.or.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.member.model.vo.Member;
import kr.or.member.model.vo.MemberRowmapper;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Dao생성");
	}

	public int insertMember(Member m) {
		//1. PreparedStatement방식으로 쿼리문 작성
		String query="insert into member_tbl values(member_seq.nextval,?,?,?,?,?)";
		//2. 위치홀더가 1개라도 있는 경우(없으면 2번 생략) 
		Object[] params = {m.getMemberId(),m.getMemberPw(),m.getMemberName(),m.getPhone(),m.getEmail()};
		//3. 쿼리문, 2번에서 만든 위치홀더에 들어갈 값을 이용해서 쿼리문 실행
		//insert/update/delete인 경우 update()메소드 사용
		int result = jdbcTemplate.update(query,params);
		return result;
	}

	public Member selectOneMember(Member m) {
		// TODO Auto-generated method stub
		String query="select * from member_tbl where member_id=? and member_pw=?";
		Object[] params = {m.getMemberId(),m.getMemberPw()};
		List list = jdbcTemplate.query(query,params,new MemberRowmapper());
		//조회는 항상 List타입으로 데이터를 반환
		if(list.isEmpty()) {
			return null;
		}else {
			Member member = (Member)list.get(0);
			return member;
		}
	}

	public Member selectOneMember(String searchId) {
		// TODO Auto-generated method stub
		String query = "select * from member_tbl where member_id=?";
		Object[] params = {searchId};
		List list = jdbcTemplate.query(query, params, new MemberRowmapper());
		if(list.isEmpty()) {
			return null;
		}else {
			Member m =(Member)list.get(0);
			return m;
		}
	}

	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		String query = "select * from member_tbl";
		List list = jdbcTemplate.query(query, new MemberRowmapper());
		if(list.isEmpty()) {
			return null;
		}else {
			
			return (ArrayList<Member>) list;
		}
	}

	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		String query ="update member_tbl set member_pw=?, phone=?, email=? where member_id=?";
		Object[] params = {m.getMemberPw(), m.getPhone(),m.getEmail(),m.getMemberId()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

	public int deleteMember(int memberNo) {
		// TODO Auto-generated method stub
		String query = "delete from member_tbl where member_no=?";
		Object[] params = {memberNo};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

}
