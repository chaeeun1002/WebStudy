<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	}
	var result = confirm("������ �����Ͻðڽ��ϱ�?");
	if(result == false) return false;
}
</script>
<!-- <script src="http://code.jauery.com/jquery-1.8.3.js"></script> -->
<!-- <script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script> -->
<!-- <script type="text/javascript"> -->
<!-- // $(function(form) { -->
<!-- // 	$(".input_click_init").focus(function(){ -->
<!-- // 		$(this).val(''); -->
<!-- // 	}).blur(function() { -->
<!-- // 		if($(this).val() == "") { $(this).val("0");} -->
<!-- // 	}); -->
<!-- // }); -->
<!-- </script> -->
</head>
<body>
<form action="ImageModifyServlet" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
<!-- ������ ������ ���ε� �Ǵ� ��� �ݵ�� �޼��� post�� ������, enctype�� �ʿ��ϴ�. -->
<input type="hidden" name="id" value="${IMAGE.writing_id }"/>
<table align="center">
	<tr>
		<td width="150" height="50">������</td>
		<td><input type="text" name="TITLE" size="40" value="${IMAGE.title }" onFocus="this.value='';return true;"/></td>
	</tr>
	<tr>
		<td height="50">�г���</td>
		<td><input type="text" name="WRITERNAME" size="20" value="${IMAGE.writer_name }" onFocus="this.value='';return true;"/></td>
	</tr>
	<tr>
		<td height="50">�̸���</td>
		<td><input type="text" name="EMAIL" size="20" value="${IMAGE.email }" onFocus="this.value='';return true;"/></td>
	</tr>
	<tr>
		<td height="50">��ȣ</td>
		<td><input type="password" name="PASSWORD" size="20"/></td>
	</tr>
	<tr>
		<td height="50">�̹���</td>
		<td>
			<input type="file" name="IMAGENAME"/>
			<input type="hidden" name="imageName" value="${IMAGE.image_name }">
			<img alt="" src="upload/${IMAGE.image_name }" width="500" height="300">
		</td>
	</tr>
	<tr>
		<td>����</td>
		<td><textarea rows="8" cols="40" name="CONTENT" onFocus="this.value='';return true;">${IMAGE.content }</textarea></td>
	</tr>
	<tr>
		<td colspan="2" height="50" align="center">
			<input type="submit" value="�� ��"/>
			<input type="button" value="�� ��" onClick="javascript:history.go(-1)"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>