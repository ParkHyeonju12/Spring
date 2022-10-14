package kr.or.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.or.member.model.service.MemberService;
public class ScheduleTest {
	/*
	 쇼핑몰개발
	-회원 가입을 하는 경우 -> 회원가입쿠폰(발행 후 일주일동안 사용가능)
	-MEMBER_TBL -> INSERT
	-쿠폰 -> INSERT
	-관리자가 매일 들어가서 만료된 쿠폰을 삭제 ->불-편
	-스케쥴링 -> 매일 00시 00분에 쿠폰을 조회해서 만료된 날짜 쿠폰을 자동으로 삭제  
	    1  	|   2  	|   3  	|  	4  |      5        	| 6  |   7	   |
   		초 	|  	분  	| 	시   	|  날짜   |      월            	|요일   |   년도	   |
		0~59|  0~59	|  0~23	| 1~31 | 1~12 or JAN~DEC|1~7 |1970~2099|
	 	*   |   *  	|   *   |   *  |      *  	    | *  |    *	   |
	    -   |   -  	|   -   |   -  |      -  	    | -  |    -	   |
	    /   |   /  	|   /   |   /  |      /  	    | /  |    /	   |
	   	    |     	|       | L, W |        	    |L,# |   	   |
	    예시)
	 	1) 10 * * * * *		: 매분 10초에 한번씩 -> 1분에 1번
	 	2) 10 10 * * * * 	: 매시간 10분 10초에 한번씩 -> 1시간에 1번
	 	3) * 10 * * * *		: 매시간 10분 매초마다 -> 1시간에 60번만 동작(매시간 10분 0초,10분 1초,10분 2초...,10분59초까지 동작하고 11분 되는 순간 멈춤)
	 	4) 0 0-5 * * * *	: 매시간(0분 0초, 1분 0초, 2분 0초,,,5분 0초)
	 	5) 0 50 7 * * 2-6	: (월~금)매일 7시 50분에 한 번 
	 	6) 0 30/10 7 * * 2-6: (월~금)7시 30분 부터 10분 간격으로
	 	7) 0 0 10 25W * * 	: 매월 25일 10시 0분 0초
	 	w는 가까운 평일을 의미	->(25일이 평일인 경우		: 25일에 동작)
	 					->(25일이 토요일인 경우	: 24일에 동작)
	 					->(25일이 일요일인 경우 	: 26일에 동작)
	 	8) 0 0 10L * * 		: 매월 마지막날 10시 0분 0초
	 	9) 0 0 10LW * * 	: 매월 마지막 평일 10시 0분 0초
	 	10) 0 0 10 * * L 	: 토요일 10시 0분 0초
	 	11) 0 0 10 * * 5L 	: 마지막 목요일 10시 0분 0초
	 	12) 0 0 10 * * 4#2 	: 2번째 수요일 10시 0분 0초
	 	
	 */
	@Autowired
	private MemberService service;
	
	//자동실행하는 이 메소드는 매개변수를 줄 수 없다! 매개 변수를 아예 넣으면 안됨 에러남 삐--
	@Scheduled(fixedDelay = 5000)
	public void scheduleTest1() {
		System.out.println("예약작업 자동 실행 메소드!!-----5초");
	}
	@Scheduled(fixedDelay = 10000)
	public void scheduleTest2() {
		System.out.println("예약작업 자동 실행 메소드!!-----10초");
	}
	@Scheduled(cron = "0 45 10 * * *")
	public void scheduleTest3() {
		service.deleteMember(34);
		System.out.println("크론식으로 동작하는 함수");
	}
}
