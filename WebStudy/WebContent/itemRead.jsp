<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>상품 정보</h3>
상품코드 : ${ITEM.code }<br/><br/> 
상품이름 : ${ITEM.name }<br/><br/>
상품가격 : ${ITEM.price }<br/><br/>
<hr><br/>
${ITEM.info }<br/><br/><br/>
<input type="button" value="목록으로" onClick="location.href='ItemListServlet'">
</body>
</html>