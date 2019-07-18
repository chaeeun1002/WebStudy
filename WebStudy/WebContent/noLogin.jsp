<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div>
해당 서비스는 로그인 후 이용하실 수 있습니다.
<form action="LoginServlet" method="post"> 
아이디 : <input type="text" size = "20" name="ID"/><br/>
패스워드 : <input type="password" size="20" name="PWD"/><br/><br/>
<input type="submit" value="로그인"/>
<input type="reset" value="취소"/>
</form>
</div>
</body>
</html>