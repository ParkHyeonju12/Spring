package kr.or.member.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.member.model.vo.Member;

@Repository
public class MemberDao {
@Autowired
private SqlSessionTemplate sqlSession;

	public MemberDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member selectOneMember(Member member) {
		// TODO Auto-generated method stub
		Member m = sqlSession.selectOne("member.selectOneMember",member);
		return m;
	}

	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		List list = sqlSession.selectList("member.selectAllMember");
		return (ArrayList<Member>)list;
	}

	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("member.insertMember",m);
		return result;
	}

	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		int result = sqlSession.update("member.updateMember",member);
		return result;
	}

	public int deleteMember(int memberNo) {
		// TODO Auto-generated method stub
		int result = sqlSession.delete("member.deleteMember",memberNo);
		return result;
	}

	public ArrayList<Member> selectSearchName(String memberName) {
		// TODO Auto-generated method stub
		List list = sqlSession.selectList("member.selectSearchName",memberName);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> searchMember1(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		List list = sqlSession.selectList("member.searchMember1",map);
		return (ArrayList<Member>)list;
	}
	public ArrayList<Member> searchMember2(Member m) {
		// TODO Auto-generated method stub
		List list = sqlSession.selectList("member.searchMember2",m);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> selectIdList() {
		// TODO Auto-generated method stub
		List list = sqlSession.selectList("member.selectIdList");
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> searchMember3(String[] memberId) {
		List list = sqlSession.selectList("member.searchMember3",memberId);
		// TODO Auto-generated method stub
		//HashMap<String, Object> map = new HashMap<String, Object>();
		//map.put("array", memberId);
		//List list = sqlSession.selectList("member.searchMember3",map);
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> searchMember4() {
		// TODO Auto-generated method stub
		List list = sqlSession.selectList("member.searchMember4");
		return (ArrayList<Member>)list;
	}

	public int changePw(Member m) {
		// TODO Auto-generated method stub
		return sqlSession.update("member.changePw",m);
	}


}