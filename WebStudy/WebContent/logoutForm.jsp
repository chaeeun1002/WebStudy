<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
환영합니다.<br/>
${sessionScope.LOGIN }님.<br/><br/>
<form action="LogoutServlet" method="get">
	<input type="submit" value="로그아웃"/>
</form>
</body>
</html>