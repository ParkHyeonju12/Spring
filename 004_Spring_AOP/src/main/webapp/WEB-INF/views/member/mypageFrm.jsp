<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MyPage</h1>
	<hr>
	<form action="/mypageUpdate.do" method="post">
		<fieldset>
			<legend>마이페이지</legend>
			회원번호: <input type="text" value="${member.memberNo }" name="memberNo" readonly><br>
			아이디: <input type="text" value="${member.memberId }" name="memberId" readonly><br>
			이름: <input type="text" value="${member.memberName }" name="memberName" readonly><br>
			전화번호: <input type="text" value="${member.phone }" name="phone"><br>
			이메일: <input type="text" value="${member.email }" name="email"><br>
			<input type="submit" value="회원정보수정">
		</fieldset>
	</form>
	<a href="/pwChangeFrm.do">비밀번호 변경하기</a><br>
	<a href="/">메인으로</a>
</body>
</html>