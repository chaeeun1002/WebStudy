<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty IMAGE }">
존재하지 않는 글입니다.
</c:if>
<c:if test="${!empty IMAGE }">
<h3 align="center">이미지게시판 글 읽기</h3>
<div align="center"> 
<table>
	<tr>
		<td height="40">글제목</td>
		<td>${IMAGE.title }</td>
	</tr>
	<tr>
		<td height="40">작성자</td>
		<td>${IMAGE.writer_name }</td>
	</tr>
	<tr>
		<td colspan="2"><img alt="" src="upload/${IMAGE.image_name }" width="500" height="300"></td>
	</tr>
	<tr>
		<td height="40">글내용</td>
		<td>${IMAGE.content }</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<a href="javascript:goReply()">[답글]</a>
			<a href="javascript:goModify()">[수정]</a>
			<a href="javascript:goDelete()">[삭제]</a>
			<a href="ImageListServlet">[목록]</a>
		</td>
	</tr>
</table>
</div>
</c:if>
<form name="move" method="post">
	<input type="hidden" name="id" value="${IMAGE.writing_id }"/>
	<input type="hidden" name="parentid" value="${IMAGE.writing_id }"/>
	<input type="hidden" name="groupid" value="${IMAGE.group_id }"/>
</form>
<script type="text/javascript">
function goDelete(){
	document.move.action = "ImageDeleteFormServlet";
	document.move.submit();
}
function goModify(){
	document.move.action = "ImageModifyFormServlet";
	document.move.submit();
}
function goReply(){
	document.move.action = "WriteFormServlet";
	document.move.submit();
}
</script>
</body>
</html>