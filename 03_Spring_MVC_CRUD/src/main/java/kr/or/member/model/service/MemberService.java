package kr.or.member.model.service;

import java.util.ArrayList;

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
		System.out.println("서비스 생성 뿅");
		// TODO Auto-generated constructor stub
	}

	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		int result = dao.updateMember(member);
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		ArrayList<Member> list = dao.selectAllMember();
		return list;
	}
	
}
