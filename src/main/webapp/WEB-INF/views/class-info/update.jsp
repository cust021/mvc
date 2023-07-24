<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원수정</h3>
<form action="/class-info/update" method="POST">
	<input type="hidden" name="ciNum" value="${classInfo.ciNum }">
	<input type="text" name="ciName" placeholder="강의 명 " value="${classInfo.ciId}"><br>
	<input type="text" name="ciDesc" placeholder="강의 정보"  value="${classInfo.ciDesc}"><br>
	<button>수정</button>
</form>
</body>
</html>