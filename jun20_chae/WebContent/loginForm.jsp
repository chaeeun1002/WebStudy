<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<label>�α���<br /> 
		<input type="text" name="id" size="15" />
		</label><br /> 
		<label>��ȣ<br /> 
		<input type="password" name="pwd" size="15" />
		</label><br /><br /> 
		<input type="submit" value="�α���">
		<a href="login.jsp?BODY=join.jsp">ȸ������</a>
	</form>
</body>
</html>