<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 작성하기(파일첨부)</h1>
<hr>
<form action="/boardWrite2.do" method="post" enctype="multipart/form-data">
<fieldset>
제목: <input type="text" name="boardTitle"><br>
첨부파일: <input type="file" multiple name="boardFile"><br>
내용: <textarea name="boardContent"></textarea><br>
<input type="hidden" name="boardWriter" value="${sessionScope.m.memberId }"><br>
<input type="submit" value="게시글 작성">
</fieldset>
</form>
</body>
</html>