<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Spring MVC</h1>
	<hr>
	<form action="/login.do" method="post">
		아이디: <input type="text" name="memberId"><br>
		비밀번호 : <input type="password" name="memberPw">
		<input type="submit" value="로그인">
	</form>
	<hr>
	<form action="/search.do" method="get">
		조회할 아이디 : <input type="text" name="memberId">
		<input type="submit" value="조회">
	</form>
</body>
</html>