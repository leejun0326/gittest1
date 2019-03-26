<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/put" method="POST">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="submit"/>
	</form>
</body>
</html>