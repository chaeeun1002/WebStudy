<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %><!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>�Խñ� ���</h2>
<table border="1">
	<tr>
		<th width="40">�۹�ȣ</th>
		<th width="200">������</th>
		<th width="200">�ۼ���</th>
	</tr>
	<c:forEach begin="1" end="10">
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>