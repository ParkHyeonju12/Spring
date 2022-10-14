<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>
	<form action="/updatePwFrm.do">
		<fieldset>
			<legend>비밀번호 변경하기</legend>
			현재 비밀번호 입력: <input type="password" name="memberPw"><span id="pwChk1"></span><br>
			새 비밀번호 입력: <input type="password" name="memberNewPw"><span id="pwChk2"></span><br>
			새 비밀번호 확인: <input type="password" name="memberRePw"><br>
			<input type="submit" value="비밀번호 변경하기">
		</fieldset>
	</form>
	<script>
	$("[name=memberPw]").on("change",function(){
		const memberPw = $(this).val();
		$.ajax({
			url: "/pwCheck.do",
			data: {memberPw:memberPw},
			success : function(data){
				console.log(data);
				if(data == "0"){
					$("#pwChk").text("현재 비밀번호와 일치하지 않습니다.");
					$("#pwChk").css("color","red");
				}else{
					$("#pwChk").text("현재 비밀번호와 일치합니다.");
					$("#pwChk").css("color","green");
				}
		});
	});
	</script>
</body>
</html>