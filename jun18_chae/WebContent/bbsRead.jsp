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
<h3>�Խñ� ����</h3>
<table border="1">
	<tr>
		<th>�۹�ȣ</th>
		<td>${BBS.seqno }</td>
	</tr>
	<tr>
		<th>������</th>
		<td>${BBS.title }</td>
	</tr>
	<tr>
		<th>�ۼ���</th>
		<td>${BBS.bbs_date }</td>
	</tr>
	<tr>
		<th>�۳���</th>
		<td>${BBS.content }</td>
	</tr>
</table>
</body>
</html>