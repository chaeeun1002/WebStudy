<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">고객 등록</h2>
<form action="CustomerPostServlet" method="post">
	<fieldset>
		<legend>고객 정보 입력</legend>
		<label>고객 ID<br/>
		<input type="text" name="ID" size="10" required/></label><br/>
		<label>고객 이름<br/>
		<input type="text" name="NAME" size="20" required/></label><br/>
		<label>고객 주소<br/>
		<input type="text" name="ADDR" size="30" required/></label><br/>
		<label>가입일<br/>
		<input type="date" name="REG"/></label><br/><br/>
		<input type="submit" value="등록"/>
	</fieldset>
</form>
</body>
</html>