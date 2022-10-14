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
<h1>회원목록</h1>
	<hr>
	<form action="/searchMember3.do" method="post">
	<c:forEach items="${list}" var="m">
	<input type="checkbox" name="memberId" value="${m.memberId }">${m.memberId }
	</c:forEach>
	<input type="submit" value="조회">
	</form>
	<a href="/">메인으로 돌아가기</a>
</body>
</html>