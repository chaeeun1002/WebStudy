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
		<th width="100">��ǰ�ڵ�</th>
		<td width="150" align="center">${ITEM.code }</td>
	</tr>
	<tr>
		<th>��ǰ�̸�</th>
		<td align="center">${ITEM.name }</td>
	</tr>
	<tr>
		<th>��ǰ����</th>
		<td align="center">${ITEM.price }</td>
	</tr>
	<tr>
		<th>��ǰ������</th>
		<td align="center">${ITEM.origin }</td>
	</tr>
	<tr>
		<th colspan="2">��ǰ����</th>
	</tr>
	<tr>
		<td colspan="2" align="center">${ITEM.info }</td>
	</tr>
</table>
</body>
</html>