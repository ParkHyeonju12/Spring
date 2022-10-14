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
	<h1>Spring MVC CRUD</h1>
	<hr>
	<c:choose>
		<c:when test="${empty sessionScope.m }">
			<form action="/login.do">
				<fieldset>
					<legend>로그인</legend>
					아이디: <input type="text" name="memberId"> 비밀번호: <input
						type="password" name="memberPw"> <input type="submit"
						value="로그인">
				</fieldset>
			</form>
			<h3>
				<a href="/joinFrm.do">1. 회원가입</a>
			</h3>
		</c:when>
		<c:otherwise>
		<h2>
		[${sessionScope.m.memberId }님 방가방가]
		</h2>
		<form action="/searchMember.do" method="get">
		조회할 회원 아이디 입력: <input type="text" name="searchId">
		<input type="submit" value="조회">
		</form>
		<h3><a href="/logout.do">로그아웃</a></h3>
		<h3><a href="/searchAllMember.do">전체회원조회</a></h3>
		<h3><a href="/mypage.do">마이페이지</a></h3>
		<h3><a href="/deleteMember.do">회원탈퇴</a></h3>
		<hr>
		<hr>
		<h2><a href="/boardList.do">게시물 목록보기</a></h2>
		</c:otherwise>
	</c:choose>
</body>
</html>