<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="LogoutServlet" method="get">
�ȳ��ϼ���?<br/> ${sessionScope.LOGIN }��~<br/>
<input type="submit" value="�α׾ƿ�"/>
</form>
</body>
</html>