<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th width="150">고객아이디</th>
		<th width="150">고객등록일</th>
	</tr>
	<c:forEach var="cus" items="${LIST }">
		<tr>
			<td><a href="CustomerReadServlet?ID=${cus.cust_id }">${cus.cust_id }</a></td>
			<td>${cus.cust_reg_date }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>