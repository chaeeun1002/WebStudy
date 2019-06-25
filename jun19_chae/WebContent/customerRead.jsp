<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th width="120">고객아이디</th>
		<td width="150">${CUSTOMER.cust_id }</td>
	</tr>
	<tr>
		<th>고객이름</th>
		<td>${CUSTOMER.cust_name }</td>
	</tr>
	<tr>
		<th>고객주소</th>
		<td>${CUSTOMER.cust_addr }</td>
	</tr>
	<tr>
		<th>고객등록일</th>
		<td>${CUSTOMER.cust_reg_date }</td>
	</tr>
</table>
</body>
</html>