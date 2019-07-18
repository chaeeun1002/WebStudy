<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h4>상품 정보 등록</h4>
<form action="ItemPostServlet" method="post">
상품이름 : <input type="text" size="30" name="NAME"/><br/><br/>
상품가격 : <input type="text" size="30" name="PRICE"/><br/><br/>
원산지 : 
<input type="radio" name="ORIGIN" value="KOR"/>한국산
<input type="radio" name="ORIGIN" value="FOR"/>외국산<br/><br/>
상품설명 : <br/>
<textarea rows="5" cols="80" name="INFO"></textarea><br/><br/>
<hr><br/>
<input type="submit" value="상품 등록"/>
<input type="reset" value="취소"/>
</form>
</body>
</html>