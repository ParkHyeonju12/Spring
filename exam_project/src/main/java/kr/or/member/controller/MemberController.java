package kr.or.member.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.member.model.service.MemberService;
import kr.or.member.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;

	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/allMember.do")
	public String allMember(Model model) {
		ArrayList<Member> member = service.selectAllMember();
		model.addAttribute("m", member);
		return "member/allMember";
	}

	@RequestMapping(value = "/joinMember.do")
	public String joinMember(Member m) {
		int result = service.insertMember(m);
		if(result>0) {
			return "joinSuccess";
			
		}else {
			return "redirect:/";
		}
	}

}
