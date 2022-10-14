<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 작성(mybatis)</h1>
	<hr>
	<form action="/boardWrite.do" method="post" enctype="multipart/form-data">
	<table border ="1">
		<thead>
			<th>제목</th>
		</thead>
		<tbody>
			<tr>
				<td>
					<input type="text" name="boardTitle" style="width:100%; box-sizing: border-box;">
					<input type="hidden" name="boardWriter" value="${sessionScope.m.memberId }">
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
			</tr>
			<tr>
				<td>	
					<input type="file" name="boardFile" multiple>
				</td>
			</tr>
			<tr>
				<th>내용</th>
			</tr>
			<tr>
				<td>
				<textarea name="boardContent" style="width:100%; height:200px;box-sizing: border-box;"></textarea>
				</td>
			</tr>
			<input type="submit">	
		</tbody>
	</table>
	</form>
	
	
</body>
</html>