<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th width="100">��ǰ�ڵ�</th>
		<th width="100">��ǰ�̸�</th>
		<th width="100">��ǰ����</th>
		<th width="100">��ǰ����</th>
		<th width="100">�����ݾ�</th>
		<th width="100">����/����</th>
	</tr>
	<c:forEach var="cart" items="${CARTLIST }">
	<form action="ModifyCartServlet" method="post">
		<input type="hidden" name="CODE" value="${cart.code }"/>
		<tr height="70">
			<td align="center">${cart.code }</td>
			<td align="center">${cart.name }</td>
			<td align="center">
				<fmt:formatNumber groupingUsed="true">${cart.price }</fmt:formatNumber>��
			</td>
			<td align="center"><input type="text" name="NUM" size="10" value="${cart.num }"></td>
			<td align="center">
				<fmt:formatNumber groupingUsed="true">${cart.price * cart.num }</fmt:formatNumber>��
			</td>
			<td align="center">
				<input type="submit" value="����" name="BTN"/>
				<input type="submit" value="����" name="BTN"/>
			</td>
		</tr>
	</form>
	</c:forEach>
	<form action="" method="post">
		<table>
			<tr>
				<td>�� �����ݾ� : </td>
				<td>
					<fmt:formatNumber groupingUsed="true">${TOTAL }</fmt:formatNumber>��
				</td>
				<td><input type="submit" value="�����ϱ�"/></td>
			</tr>
		</table>
	</form>
</table>
</script>
</body>
</html>