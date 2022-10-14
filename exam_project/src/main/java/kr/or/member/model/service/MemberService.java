package kr.or.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.member.model.dao.MemberDao;
import kr.or.member.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;

	public MemberService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		return dao.selectAllMember();
	}

	public int insertMember(Member m) {
		return dao.insertMember(m);
	}

}
