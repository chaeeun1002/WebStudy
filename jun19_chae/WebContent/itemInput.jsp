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

	<tr><th>��ǰ��ȣ</th>
		<td><input type="text" name="NO" size="5"/></td>
	</tr>
	<tr><th>��ǰ�̸�</th>
		<td><input type="text" name="NAME" size="15"/></td>
	</tr>
	<tr><th>��ǰ����</th>
		<td><input type="text" name="PRICE" size="10"/></td>
	</tr>
	<tr><th>��ǰ����</th>
		<td><textarea rows="3" cols="10" name="INFO"></textarea></td>
	</tr>
	<tr><th>��ǰ������</th>
		<td>
			<input type="radio" name="ORIGIN" value="KOR" selected="selected"/>�ѱ���
			<input type="radio" name="ORIGIN" value="FOR"/>�ܱ��� 
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="��ǰ���"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>