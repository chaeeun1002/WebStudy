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
	//form은 form전체를 매개변수로 가져옴.
	if(form.TITLE.value == ""){
		alert("제목을 입력하세요.");
		return false;
	}else if(form.PASSWORD.value == ""){
		alert("암호를 입력하세요.");
		return false;
	}else if(form.IMAGENAME.value == ""){
		alert("이미지 파일을 선택하세요.");
		return false;
	}
	var result = confirm("정말로 저장하시겠습니까?");
	if(result == false) return false;
}
</script>
</head>
<body>
<form action="WriteDoServlet" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">
<!-- 파일이 서버로 업로드 되는 경우 반드시 메서드 post로 보내고, enctype이 필요하다. -->
<!-- enctype을 지정하지 않으면 파일 업로드가 되지 않으며 톰캣의 내장 객체 request 객체를 사용 할 수 없다. -->
<input type="hidden" name="orderno" value="${IMAGE.order_no + 1 }"/>

<c:if test="${! empty IMAGE.group_id }">
<input type="hidden" name="groupid" value="${param.groupid }"/>
</c:if>

<c:if test="${! empty IMAGE.parent_id }">
<input type="hidden" name="parentid" value="${param.parentid }"/>
</c:if>

<table align="center">
	<tr>
		<td width="150" height="50">글제목</td>
		<td>
		<input type="text" name="TITLE" size="40" value="${TITLE }"/>
		</td>
	</tr>
	<tr>
		<td height="50">닉네임</td>
		<td><input type="text" name="WRITERNAME" size="20"/></td>
	</tr>
	<tr>
		<td height="50">이메일</td>
		<td><input type="text" name="EMAIL" size="20"/></td>
	</tr>
	<tr>
		<td height="50">암호</td>
		<td><input type="password" name="PASSWORD" size="20"/></td>
	</tr>
	<tr>
		<td height="50">이미지</td>
		<td><input type="file" name="IMAGENAME"/></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea rows="8" cols="40" name="CONTENT"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" height="50" align="center"><input type="submit" value="등 록"/></td>
	</tr>
</table>
</form>
</body>
</html>