<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">�� ���</h2>
<form action="CustomerPostServlet" method="post">
	<fieldset>
		<legend>�� ���� �Է�</legend>
		<label>�� ID<br/>
		<input type="text" name="ID" size="10" required/></label><br/>
		<label>�� �̸�<br/>
		<input type="text" name="NAME" size="20" required/></label><br/>
		<label>�� �ּ�<br/>
		<input type="text" name="ADDR" size="30" required/></label><br/>
		<label>������<br/>
		<input type="date" name="REG"/></label><br/><br/>
		<input type="submit" value="���"/>
	</fieldset>
</form>
</body>
</html>