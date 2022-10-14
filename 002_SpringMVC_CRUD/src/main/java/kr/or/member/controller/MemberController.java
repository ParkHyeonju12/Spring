package kr.or.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.member.model.service.MemberService;
import kr.or.member.model.vo.Member;

@Controller
public class MemberController {
	//autowired: 스프링이 만든 객체중에  선언된 변수와 일치하는 타입을 찾아서 값을 대입
	@Autowired
	private MemberService service;
	public MemberController() {
		super();
		System.out.println("컨트롤러 생성");
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/joinFrm.do")
	public String joinFrm() {
		return "member/joinFrm";
	}
	@RequestMapping(value="/join.do")
	public String join(Member m) {
		System.out.println(m);
		int result = service.insertMember(m);
		if(result>0) {
			return "member/joinSuccess";
		}else {
			return "member/joinFail";
		}
	}
	@RequestMapping(value="/login.do")
	public String login(Member m, HttpSession session) {
		Member member = service.selectOneMember(m);
		if(member != null) {
			//로그인 성공했으니까 정보 세션에 등록해주기
			//기존 세션에 정보등록하는 방법 
			session.setAttribute("m", member);
		}
		//메인페이지로 이동 
		//ViewResolver가 앞뒤에 값을 붙이지 않고 주소 요청
		return "redirect:/";
	}
	@RequestMapping(value="/searchMember.do")
	public String searchMember(String searchId, Model model) {
		Member m = service.selectOneMember(searchId);
		if(m != null) {
			model.addAttribute("m", m);
			System.out.println(m);
			return "member/searchMember";
		}else {
			return "redirect:/";
		}
	}
}
