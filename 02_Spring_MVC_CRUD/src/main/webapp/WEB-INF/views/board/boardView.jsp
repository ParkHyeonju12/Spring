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
	<h1>게시물상세보기</h1>
	<hr>
	<table border="1">
		<tr>
			<th>글번호</th>
			<td>${b.boardNo }</td>
			<th>제목</th>
			<td>${b.date }</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="3"><c:forEach items="${b.fileList }" var="f">
					<p>
						<a href="/boardFileDown.do?fileNo=${f.fileNo }">${f.fileName }</a>
					</p>
				</c:forEach></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">${b.boardContent }</td>
		</tr>
		<c:if test="${sessionScope.m.memberId eq b.boardWriter }">
			<tr>
				<th colspan="4">
				<a href="/boardUpdateFrm2.do?boardNo=${b.boardNo }">수정</a>
				<a href="/boardDelete2.do?boardNo=${b.boardNo }">삭제</a>
				</th>
			</tr>
		</c:if>
	</table>

<!-- 
	<form action="/boardUpdate.do" method="post">
		<fieldset>
			번호: <input type="text" name="boardNo" value="${board.boardNo }"
				disabled><br> 제목: <input type="text" name="boardTitle"
				value="${board.boardTitle }" readonly><br> 작성자: <input
				type="text" name="boardWriter" value="${sessionScope.m.memberId }"><br>
			내용: <input type="text" name="boardContent"
				value="${board.boardContent }" disabled><br> 작성일: <input
				type="text" name="date" value="${board.date}"><br> <input
				type="submit" value="내용수정">
		</fieldset>
	</form>
 -->
	
</body>
</html>