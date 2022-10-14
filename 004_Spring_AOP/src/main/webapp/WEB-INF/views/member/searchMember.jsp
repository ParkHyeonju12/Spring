<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>아이디로 회원 정보 조회</h1>
	<hr>
	<table border="1">
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
		</tr>
		<tr>
			<td>${m.memberNo }</td>
			<td>${m.memberId }</td>
			<td>${m.memberName }</td>
			<td>${m.phone }</td>
			<td>${m.email }</td>
		</tr>
	</table>
	<a href="/">메인으로</a>
</body>
</html>