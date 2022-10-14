package kr.or.member.model.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.member.model.dao.MemberDao;
import kr.or.member.model.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;

	public MemberService() {
		super();
		System.out.println("서비스 생성");
		// TODO Auto-generated constructor stub
	}

	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		int result = dao.insertMember(m);
		return result;
	}

	public Member selectOneMember(Member m) {
		// TODO Auto-generated method stub
		Member member = dao.selectOneMember(m);
		return member;
	}

	public Member selectOneMember(String searchId) {
		// TODO Auto-generated method stub
		return dao.selectOneMember(searchId);
	}

	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		ArrayList<Member> list = dao.selectAllMember();
		return list;
	}

	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		int result = dao.updateMember(m);
		return result;
	}

	public int deleteMember(int memberNo) {
		// TODO Auto-generated method stub
		int result = dao.deleteMember(memberNo);
		return result;
	}
}
