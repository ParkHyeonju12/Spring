package kr.or.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import kr.or.member.model.service.MemberService;
import kr.or.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/login.do")
	public String login(Member member, HttpSession session) {
		Member m = service.selectOneMember(member);
		if(m!=null) {
			session.setAttribute("m", m);
		}
		return "redirect:/";
	}
	@RequestMapping(value="/selectAllMember.do")
	public String selectAllMember(Model model) {
		ArrayList<Member> list = service.selectAllMember();
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	@RequestMapping(value="/joinFrm.do")
	public String joinFrm() {
		return "member/joinFrm";
	}
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping(value="/join.do")
	public String join(Member m) {
		int result = service.insertMember(m);
		if(result>0) {
			return "redirect:/";
		}else { 
			return "member/joinFrm";
		}
	}
	@RequestMapping(value="/searchMemberId.do")
	public String selectOneMember(Member member, Model model) {
		Member m = service.selectOneMember(member);
		if(m!=null) {
			model.addAttribute("m",m);
			return "member/searchMember";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping(value="/mypage.do")
	public String mypage() {
		return "member/mypage";
	}
	@RequestMapping(value="/deleteMember.do")
	public String deleteMember(@SessionAttribute Member m) {
		int result = service.deleteMember(m.getMemberNo());
		if(result>0) {
			return "redirect:/logout.do";
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/update.do")
	public String updateMember(Member m, HttpSession session) {
		Member member = service.updateMember(m); 
		if(member != null) {
			session.setAttribute("m",m);
			return "redirect:/mypage.do";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping(value="/searchMemberName.do")
	public String searchMemberName(Member m, Model model) {
		ArrayList<Member> list = service.searchMemberName(m);
		model.addAttribute("list",list);
		return "member/nameList";
	}
	@RequestMapping(value="/searchMember1.do")
	public String searchMember(String type, String keyword, Model model) {
		ArrayList<Member> list = service.searchMember1(type,keyword);
		/* 마이바티스는 데이터 타입 매개변수를 하나밖에 못준다 */
		model.addAttribute("list",list);
		return "member/nameList";
	}
	@RequestMapping(value="/searchMember2.do")
	public String searchMember2(Member m, Model model) {
		ArrayList<Member> list=service.searchMember2(m);
		model.addAttribute("list",list);
		return "redirect:/";
	}
	@RequestMapping(value="/idList.do")
	public String idList(Model model) {
		ArrayList<String> list= service.selectAllId();
		model.addAttribute("list",list);
		return "member/idList";
	}
	@RequestMapping(value="/searchMember3.do")
	public String searchMember3(String[] memberId, Model model) {
		System.out.println(memberId);
		ArrayList<Member> list = service.searchMember3(memberId);
		model.addAttribute("list",list);
		return "member/memberList";
	}
	@RequestMapping(value="/searchMember4.do")
	public String searchMember4(Model model) {
		ArrayList<Member> list = service.searchMember4();
		model.addAttribute("list",list);
		return "member/memberList";
	}
	@ResponseBody //페이지 이동이 아니라 return으로 데이터를 넘겨주는 태그
	@RequestMapping(value="/idCheck.do")
	public String idCheck(Member m) {
		Member member = service.selectOneMember(m);
		if(member == null) {
			//사용 가능
			return "0";
		}else {
			//이미 사용 중
			return "1";
		}
	}
	@ResponseBody
	@RequestMapping(value="/ajaxAllMember.do",produces = "application/json;charset=utf-8")
	public String ajaxAllMember() {
		ArrayList<Member> list = service.selectAllMember();
		Gson gson = new Gson();
		String result = gson.toJson(list);
		System.out.println(result);
		return result;
	}
	@RequestMapping(value="/updatePwFrm.do")
	public String updatePw() {
		return "member/updatePwFrm";
	}
	@RequestMapping(value="/pwChangeFrm.do")
	public String pwChangeFrm() {
		return "member/currentPwCheckFrm";
	}
	@RequestMapping(value="/currentPwCheck.do")
	public String currentPwCheck(Member m) {
		//데이터베이스에서 pw를 조회한 후
		//입력한 비밀번호와 조회한 비밀번호가 같은지 체크
		Member member = service.selectOneMember(m);
		if(member != null) {
			return "member/pwChangFrm";
		}else {
			return "redirect:/mypage.do";
		}
	}
	@RequestMapping(value="/pwChange.do")
	public String pwChange(Member m) {
		int result = service.changePwMember(m);
		if(result>0) {
			//변경 성공 시 session 데이터 적용
			return "redirect:/logout.do";
		}else {
			return "redirect:/mypage.do";
		}
	}
	@RequestMapping(value="/searchPwFrm.do")
	public String searchPwFrm() {
		return "member/searchPwFrm";
	}
	@RequestMapping(value="/searchPw.do")
	public String searchPw(Member m) {
		Member member = service.selectOneMember(m);
		if(member != null) {
			return "member/searchPw2";
		}else {
			return "redirect:/searchPwFrm.do ";
		}
	}
	
}
