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
		<th>�޴��̸�</th>
	</tr>
	<c:forEach var="drink" items="${MENUS }">
		<tr><td width="120" align="center">${drink }</td></tr>
	</c:forEach>
</table>
<br/>
<table border="1">
	<tr>
		<th>�ƽþƱ���</th>
		<c:forEach var="country" items="${ASIA }">
			<tr><td width="120" align="center">${country }</td></tr>
		</c:forEach>
	</tr>
</table>
<br/>
<table border="1">
	<tr>
		<th>�̸�</th>
		<th>�а�</th>
		<th>����</th>
		<th>�ּ�</th>
		<th>����</th>
	</tr>
	<c:forEach var="std" items="${STUDENTS }">
		<tr>
			<td width="100" align="center">${std.name }</td>
			<td width="100" align="center">${std.major }</td>
			<td width="60" align="center">${std.gender }</td>
			<td width="60" align="center">${std.addr }</td>
			<td width="60" align="center">${std.score }</td>
		</tr>
	</c:forEach>
</table>
<br/>
<table border="1">
	<tr>
		<th>�̸�</th>
		<th>������</th>
		<th>�Ұ�</th>
		<th>�̹���</th>
		<th>����</th>
	</tr>
	<c:forEach var="fruit" items="${FRUITS }">
		<tr>
			<td width="80" align="center">${fruit.name }</td>
			<td width="80" align="center">${fruit.origin }</td>
			<td width="120" align="center">${fruit.info }</td>
			<td width="80" align="center"><img alt="" src="imgs/${fruit.image }" width="100" height="50"></td>
			<td width="100" align="center">${fruit.price }</td>
		</tr>
	</c:forEach>
</table>
<br/>
<table border="1">
	<tr>
		<th>��ȭ�̹���</th>
		<th>��ȭ����</th>
		<th>��ȭ�ٰŸ�</th>
		<th>��ȭ������</th>
		<th>��ȭ��������</th>
	</tr>
	<c:forEach var="movie" items="${MOVIES }">
		<tr>
			<td width="120" align="center"><img alt="" src="imgs/${movie.image }" width="90" height="150"></td>
			<td width="120" align="center">${movie.title }</td>
			<td width="450" align="center">${movie.info }</td>
			<td width="150" align="center">${movie.release }</td>
			<td width="100" align="center">${movie.age }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>