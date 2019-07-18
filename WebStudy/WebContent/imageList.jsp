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
<c:if test="${!empty IMAGELIST }">
<table>
	<tr>
		<td align="right"><b>${startRow }~${endRow } / ${count }</b></td>
	</tr>
</table>
<table>
	<tr>
		<td width="10"></td>
		<th>이미지</th>
		<th>글제목</th>
		<th>작성자</th>
		<th>작성일</th>
	</tr>
	<c:forEach var="image" items="${IMAGELIST }">
		<tr>
			<td></td>
			<td width="150" align="center"><img alt="" src="upload/${image.image_name }" width="100" height="80"></td>
			<td width="150" align="center"><a href="javascript:goView(${image.writing_id })">${image.title }</a></td>
			<td width="150" align="center">${image.writer_name }</td>
			<td width="150" align="center">${image.register_date }</td>
		</tr>
	</c:forEach>
</table>
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
<c:set var="startPage"
value="${currentPage-(currentPage % 10 == 0 ? 10 : (currentPage % 10))+1 }"/>
<c:set var="endPage" value="${startPage + 9 }"/>
<c:if test="${endPage > pageCount }">
<c:set var="endPage" value="${pageCount }"/>
</c:if>
<c:if test="${startPage > 10 }">
	<a href="javascript:goPage(${startPage - 1 })">[이전]</a>
</c:if>
<c:forEach var="pageNo" begin="${startPage }"
						end="${endPage }">
	<c:if test="${currentPage == pageNo }">
		<font size="5">
	</c:if>
	<a href="javascript:goPage(${pageNo })">[${pageNo }]</a>
	<c:if test="${currentPage == pageNo }">
		</font>
	</c:if>
</c:forEach>
<c:if test="${endPage < pageCount }">
	<a href="javascript:goPage(${endPage + 1 })">[다음]</a>
</c:if>
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
	<input type="hidden" name="page" value="${currentPage }"/>
</form>
</body>
</html>