<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
ȯ���մϴ�.<br/>
${sessionScope.LOGIN }��.<br/><br/>
<form action="LogoutServlet" method="get">
	<input type="submit" value="�α׾ƿ�"/>
</form>
</body>
</html>