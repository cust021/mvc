<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>무비 리스트</h3>
<table border="1">
	<tr>
		<th>번호</th>
		<th>영화 제목</th>
		<th>영화 설명</th>
		<th>장르</th>
	</tr>
	<c:forEach items="${classInfoList}" var="movieInfo">
	<tr>
		<td>${movieInfo.miNum}</td>
		<td>${movieInfo.miTitle}</td>
		<td>${movieInfo.miDesc}</td>
		<td>${movieInfo.miGenre}</td>
	</tr>
</c:forEach>
	<tr>
		<td align="right" colspan="4"> <button onclick="location.href='/movie-info/inssert'">등록</button>
	</tr>
</table>
</body>
</html>