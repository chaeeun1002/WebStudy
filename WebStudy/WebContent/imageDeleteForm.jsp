<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function validate(form){
	if(form.password.value=""){
		alert("��ȣ�� �Է��ϼ���.");
		return false;
	}
	var r = confirn("������ �����Ͻðڽ��ϱ�?");
	if(r == false)return false;
}
</script>
</head>
<body>
<form action="ImageDeleteServlet" method="post" onSubmit="return validate(this)">
	<input type="hidden" name="id" value="${IMAGE.writing_id }">
	<div align="center">
	<table>
		<tr>
		<td height="40">������</td>
		<td>${IMAGE.title }</td>
	</tr>
	<tr>
		<td height="40">�ۼ���</td>
		<td>${IMAGE.writer_name }</td>
	</tr>
	<tr>
		<td height="40">�̸���</td>
		<td>${IMAGE.email }</td>
	</tr>
	<tr>
		<td height="40">��ȣ</td>
		<td><input type="password" name="PWD" size="20"/></td>
	</tr>
	<tr>
		<td colspan="2"><img alt="" src="upload/${IMAGE.image_name }" width="500" height="300"></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="����"/>
			<input type="button" value="���" onClick="javascript:history.go(-1)"/>
		</td>
	</tr>
	</table>
	</div>
</form>
</body>
</html>