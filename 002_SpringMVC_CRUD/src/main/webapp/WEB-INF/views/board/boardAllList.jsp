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
	<h1>게시물 목록</h1>
	<hr>
	<c:if test="${not empty sessionScope.m }">
		<h3>
			<a href="/boardWriteFrm.do">게시글 작성하기</a><br>
			<a href="/boardWriteFrm2.do">게시글 작성하기(파일첨부)</a>
		</h3>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${list }" var="b">
			<tr>
				<th>${b.boardNo }</th>
				<th>${b.boardTitle }</th>
				<th>${b.boardWriter }</th>
				<th>${b.boardDate }</th>
			</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>