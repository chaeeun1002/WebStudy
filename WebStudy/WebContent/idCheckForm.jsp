<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.form{
	margin-top : 45px;
}
</style>
</head>
<body>
<div id="form" align="center">
<h3>���̵� �ߺ� Ȯ��</h3>
</div>
<div align="center">
<form action="IdCheckServlet" method="post">
<input type="text" name="ID" id="userId" value="${param.ID }"/>
<input type="submit" value="�ߺ�Ȯ��"/>
</form>
</div>
</body>
</html>