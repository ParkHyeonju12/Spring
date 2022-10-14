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
	<h1>게시판 글쓰기</h1>
	<hr>
	<form action="/boardWrite.do" method="post">
	제목: <input type="text" name="boardTitle"><br>
	내용 : <textarea type="text" name="boardContent"></textarea><br>
	<input type="hidden" boardWriter" value="${sessionScope.m.memberId }"><br>
	 <input type="submit" value="글 등록하기">
	</form>
</body>
</html>