package kr.or.iei.controller;

import javax.servlet.http.HttpServletRequest;

public class LoginController implements Controller{

	@Override
	public String request(HttpServletRequest request) {
		//값추출
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		//비즈니스 로직 (서비스를 통한 id, pw검증 // 서비스 만들어서 -> dao)
		//user01 / 1234
		boolean result1 = memberId.equals("user01");
		boolean result2 = memberPw.equals("1234");
		boolean result = result1 && result2;
		//결과처리
		if(result) {
			return "loginSuccess";
		}else {
			return "loginFail";
		}
	}
}
