<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function validate(form){
	//form�� form��ü�� �Ű������� ������.
	if(form.TITLE.value == ""){
		alert("������ �Է��ϼ���.");
		return false;
	}else if(form.PASSWORD.value == ""){
		alert("��ȣ�� �Է��ϼ���.");
		return false;
	}else if(form.IMAGENAME.value == ""){
		alert("�̹��� ������ �����ϼ���.");
		return false;
	}
	var result = confirm("������ �����Ͻðڽ��ϱ�?");
	if(result == false) return false;
}
</script>
</head>
<body>
<form action="WriteDoServlet" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
<!-- ������ ������ ���ε� �Ǵ� ��� �ݵ�� �޼��� post�� ������, enctype�� �ʿ��ϴ�. -->
<!-- enctype�� �������� ������ ���� ���ε尡 ���� ������ ��Ĺ�� ���� ��ü request ��ü�� ��� �� �� ����. -->
<input type="hidden" name="orderno" value="${IMAGE.order_no + 1 }"/>

<c:if test="${! empty IMAGE.group_id }">
<input type="hidden" name="groupid" value="${param.groupid }"/>
</c:if>

<c:if test="${! empty IMAGE.parent_id }">
<input type="hidden" name="parentid" value="${param.parentid }"/>
</c:if>

<table align="center">
	<tr>
		<td width="150" height="50">������</td>
		<td>
		<input type="text" name="TITLE" size="40" value="${TITLE }"/>
		</td>
	</tr>
	<tr>
		<td height="50">�г���</td>
		<td><input type="text" name="WRITERNAME" size="20"/></td>
	</tr>
	<tr>
		<td height="50">�̸���</td>
		<td><input type="text" name="EMAIL" size="20"/></td>
	</tr>
	<tr>
		<td height="50">��ȣ</td>
		<td><input type="password" name="PASSWORD" size="20"/></td>
	</tr>
	<tr>
		<td height="50">�̹���</td>
		<td><input type="file" name="IMAGENAME"/></td>
	</tr>
	<tr>
		<td>����</td>
		<td><textarea rows="8" cols="40" name="CONTENT"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" height="50" align="center"><input type="submit" value="�� ��"/></td>
	</tr>
</table>
</form>
</body>
</html>