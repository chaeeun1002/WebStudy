<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function doCheck(){
	var id = document.getElementById("ID").value;
	location.href = 'IdCheckServlet?ID='+id;
}
</script>
</head>
<body>
<h3 align="center">ȸ������</h3>
<form action="">
	<table align="center">
		<tr height="50">
			<td>���̵�</td>
			<td>
				<input type="text" id="ID" name="ID" size="20" value="${param.ID }"/>
				<input type="button" value="�ߺ�Ȯ��" onClick="doCheck()"/>
				<c:if test="${param.RESULT == 'OK' }">
					��밡���� ���̵� �Դϴ�.
				</c:if>
				<c:if test="${param.RESULT == 'NOK' }">
					����� �� ���� ���̵� �Դϴ�.
				</c:if>
			</td>
		</tr>
		<tr height="50">
			<td>�н�����</td>
			<td><input type="password" name="PWD" size="20"/></td>
		</tr>
		<tr height="50">
			<td>�н����� Ȯ��</td>
			<td>
			<input type="password" name="PWDCHK" size="20"/>
			<input type="button" value="Ȯ��"/>
			</td>
		</tr>
		<tr height="50">
			<td>����</td>
			<td>
				<input type="radio" name="GEN" value="F"/>����
				<input type="radio" name="GEN" value="M"/>����
			</td>
		</tr>
		<tr height="50">
			<td>��ȭ��ȣ</td>
			<td>
				<select name="FIRST_PHONE">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="013">013</option>
				</select><label> -</label>
				<input type="text" name="MID_PHONE" size="5"/><label> -</label>
				<input type="text" name="LAST_PHONE" size="5"/>
			</td>
		</tr>
		<tr height="50">
			<td>�̸���</td>
			<td>
				<input type="text" name="EMAIL_ID" size="10"><label> @</label>
				<select name="EMAIL_ADDR">
					<option value="naver">naver.com</option>
					<option value="daum">daum.net</option>
					<option value="yahoo">yahoo.com</option>
					<option value="google">google.com</option>
				</select>
			</td>
		</tr>
		<tr height="50">
			<td>���</td>
			<td>
				<input type="radio" name="GRADE" value="admin"/>������
				<input type="radio" name="GRADE" value="user"/>ȸ��
			</td>
		</tr>
		<tr height="50">
			<td colspan="2" align="center">
				<input type="submit" value="ȸ������" onClick="doEntry()"/>
				<input type="reset" value="���"/>
				<input type="button" value="��������" onClick="location.href='main.jsp?BODY=front.jsp'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>