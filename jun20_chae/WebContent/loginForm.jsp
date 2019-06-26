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
		<label>로그인<br /> 
		<input type="text" name="id" size="15" />
		</label><br /> 
		<label>암호<br /> 
		<input type="password" name="pwd" size="15" />
		</label><br /><br /> 
		<input type="submit" value="로그인">
		<span id="join"><a href="login.jsp?BODY=join.jsp">회원가입</a></span>
<!-- 		span태그 : span태그 안에 있는 영역에 별도로 스타일을 지정하기 위해 사용. -->
	</form>
</body>
</html>