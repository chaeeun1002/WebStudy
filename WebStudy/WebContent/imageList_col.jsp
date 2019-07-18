<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 열우선 이미지 게시판 목록 -->
</head>
<body>
<c:if test="${!empty IMAGELIST }">
<table>
	<tr>
		<td align="right"><b>${startRow }~${endRow } / ${count }</b></td>
	</tr>
</table>
<div align="center">
<table>
	<c:set var="count" value="0"/>
<!-- 	set : 변수를 선언해주는 태그 -->
	<c:set var="loop" value="0"/>
	<c:forEach var="image" items="${IMAGELIST }">
		<c:if test="${loop % 5 == 0 }">
			<tr>
		</c:if>
		<td align="center" width="150">
			<img alt="" src="upload/${image.image_name }" width="100" height="100"/><br/>
			<a href="javascript:goView(${image.writing_id })">${image.title }</a><br/><br/>
			${image.writer_name }<br/><br/>
			${image.register_date }
			<c:set var="count" value="${count + 1 }"/>
			<c:set var="loop" value="${loop + 1 }"/>
		</td>
		<c:if test="${loop % 5 == 0 }">
			</tr>
		</c:if>
	</c:forEach>
</table>
</div>
</c:if>
<c:if test="${empty IMAGELIST }">
등록된 게시글이 존재하지 않습니다.
</c:if>
<form name="imageRead" method="post">
	<input type="hidden" name="id"/>
</form>
<script type="text/javascript">
function goView(id){
	document.imageRead.id.value = id;
	document.imageRead.action="ImageReadServlet";
	document.imageRead.submit();
}
</script>
<div align="center">
<c:forEach var="p" begin="1" end="${pageCount }">
<a href="javascript:goPage(${p })">${p }</a>
</c:forEach>
</div>
<script type="text/javascript">
function goPage(no){
	document.move.action="ImageListServlet";
	document.move.page.value=no;
	document.move.submit();
}
</script>
<form name="move" method="post">
	<input type="hidden" name="id"/>
	<input type="hidden" name="page"/>
</form>
</body>
</html>