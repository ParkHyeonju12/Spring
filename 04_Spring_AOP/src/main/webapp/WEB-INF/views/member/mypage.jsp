<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1>
	<hr>
	<form action="/update.do" method="post">
		<fieldset>
			번호 : <input type="text" name="memberNo" value="${sessionScope.m.memberNo }" disabled><br>
			아이디 : <input type="text" name="memberId" value="${sessionScope.m.memberId }" readlonly><br>
			비밀번호 : <input type="password" name="memberPw" value="${sessionScope.m.memberPw }"><br>
			이름 : <input type="text" name="memberName" value="${sessionScope.m.memberName }" disabled><br>
			전화번호 : <input type="text" name="phone" value="${sessionScope.m.phone }"><br>
			이메일 : <input type="text" name="email" value="${sessionScope.m.email }"><br>
			<input type="submit" value="수정"/>
		</fieldset>
	</form>
	<form action="/updatePwFrm.do" method="post">
		<input type="submit" value="비밀번호 변경">
	</form>
	<a href="/">메인페이지로</a>
	<a href="/pwChangeFrm.do">비밀번호 변경하기</a>
</body>
</html>