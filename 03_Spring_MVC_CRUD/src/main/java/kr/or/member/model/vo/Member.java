package kr.or.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//get,setter자동완성
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //파라미터 있는 생성자
public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String phone;
	private String email;
}
