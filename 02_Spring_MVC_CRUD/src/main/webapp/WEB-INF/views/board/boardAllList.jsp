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
	<h1>게시물 목록 조회</h1>
	<hr>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<c:forEach items="${list }" var="b">
			<tr>
				<td>${b.boardNo }</td>
				<td onClick="location.href='/boardView.do?boardNo=${b.boardNo }'" style="cursor:pointer;">${b.boardTitle }</td></a>
				<td>${b.boardWriter }</td>
				<td>${b.date }</td>
			</tr>
		</c:forEach>
	</table>
	<form action="/boardWriteFrm.do">
	<button type="submit" value="글쓰기">글쓰기</button>
	</form>
	<form action="/boardWriteFrm2.do">
	<button type="submit" value="글쓰기">???</button>
	</form>
</body>
</html>