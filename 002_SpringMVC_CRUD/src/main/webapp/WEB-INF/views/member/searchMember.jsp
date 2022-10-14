<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
<fieldset>
<legend>회원조회</legend>
	<ul>
	<li>아이디: ${m.memberId }</li>
	<li>비밀번호: ${m.memberPw }</li>
	<li>이름: ${m.memberName }</li>
	<li>전화번호: ${m.phone }</li>
	<li>이메일: ${m.email }</li>
	</ul>
</fieldset>
<a href="/">메인으로 가기</a>
</body>
</html>