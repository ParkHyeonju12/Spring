<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MVC 복습 중</h1>
	<hr>
	<c:choose>
		<c:when test="${empty sessionScope.m }">
		<form action="/login.do" method="post">
		<fieldset>
		<legend>로그인하기</legend>
		아이디: <input type="text" name="memberId">
		비밀번호: <input type="password" name="memberPw">
		<input type="submit" value="로그인"> 
		</fieldset>
		</form>
		</c:when>
	</c:choose>
</body>
</html>