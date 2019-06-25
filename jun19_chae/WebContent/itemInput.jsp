<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="ProductPostServlet" method="post">
<table>

	<tr><th>상품번호</th>
		<td><input type="text" name="NO" size="5"/></td>
	</tr>
	<tr><th>상품이름</th>
		<td><input type="text" name="NAME" size="15"/></td>
	</tr>
	<tr><th>상품가격</th>
		<td><input type="text" name="PRICE" size="10"/></td>
	</tr>
	<tr><th>상품설명</th>
		<td><textarea rows="3" cols="10" name="INFO"></textarea></td>
	</tr>
	<tr><th>상품원산지</th>
		<td>
			<input type="radio" name="ORIGIN" value="KOR" selected="selected"/>한국산
			<input type="radio" name="ORIGIN" value="FOR"/>외국산 
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="상품등록"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>