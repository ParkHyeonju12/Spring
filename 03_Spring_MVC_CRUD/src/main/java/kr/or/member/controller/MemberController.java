package kr.or.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.member.model.service.MemberService;
import kr.or.member.model.vo.Member;
@Controller
public class MemberController {
	@Autowired
	private MemberService service;

	public MemberController() {
		super();
		System.out.println("컨트롤러 생성 뿅");
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/login.do")
	public String login(Member m) {
		return "member/login";
	}
	
	@RequestMapping(value="/mypage.do")
	public String mypage() {
		return "member/mypage";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping(value="/update.do")
	public String update(Member member, @SessionAttribute Member m) {
		int result = service.updateMember(member);
		if(result>0) {
			m.setMemberPw(member.getMemberPw());
			m.setPhone(member.getPhone());
			m.setEmail(member.getEmail());
			return "redirect:/mypage.do";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping(value="allMember.do")
	public String selectAllMember() {
		ArrayList<Member> list = service.selectAllMember();
	}
	
}
