<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h4>��ǰ ���� ���</h4>
<form action="ItemPostServlet" method="post">
��ǰ�̸� : <input type="text" size="30" name="NAME"/><br/><br/>
��ǰ���� : <input type="text" size="30" name="PRICE"/><br/><br/>
������ : 
<input type="radio" name="ORIGIN" value="KOR"/>�ѱ���
<input type="radio" name="ORIGIN" value="FOR"/>�ܱ���<br/><br/>
��ǰ���� : <br/>
<textarea rows="5" cols="80" name="INFO"></textarea><br/><br/>
<hr><br/>
<input type="submit" value="��ǰ ���"/>
<input type="reset" value="���"/>
</form>
</body>
</html>