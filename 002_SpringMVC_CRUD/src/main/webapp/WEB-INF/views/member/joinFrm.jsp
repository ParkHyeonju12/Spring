<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/join.do" method="post">
<fieldset>
	<legend>회원가입</legend>
	아이디 : <input type="text" name="memberId"><br>
	비밀번호 : <input type="password" name="memberPw"><br>
	이름 : <input type="text" name="memberName"><br>
	전화번호 : <input type="text" name="phone"><br>
	이메일 : <input type="text" name="email"><br>
	<input type="submit" value="회원가입"><br>
	<a href="/">메인으로 돌아가기</a><br>
</fieldset>
</form>
</body>
</html>