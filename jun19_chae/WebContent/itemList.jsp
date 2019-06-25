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
		<th>��ǰ�ڵ�</th>
		<th>��ǰ�̸�</th>
		<th>��ǰ����</th>
		<th>��ǰ������</th>
	</tr>
	<c:forEach var="item" items="${LIST }">
		<tr>
			<td width="100" align="center">${item.code }</td>
			<td width="100" align="center"><a href="ProductReadServlet?CODE=${item.code }">${item.name }</a></td>
			<td width="100" align="center">${item.price }</td>
			<td width="80" align="center">${item.origin }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>