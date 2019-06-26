<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	body{
		background : white;
	}
</style>
</head>
<body>
<table border="1">
	<tr>
		<th width="80">글번호</th>
		<th width="150">글제목</th>
		<th width="200">작성일</th>
		<th width="100">작성자</th>
	</tr>
	<c:forEach var="bbs" begin="0" end="${BLIST.listSize - 1 }">
		<tr>
			<td>${BLIST.seqnoList[bbs] }</td>
			<td><a href="BbsReadServlet?SEQNO=${BLIST.seqnoList[bbs] }">${BLIST.titleList[bbs] }</a></td>
			<td>${BLIST.dateList[bbs] }</td>
			<td>${BLIST.writerList[bbs] }</td>
		</tr>
	</c:forEach>
	
<!-- 	(예)JSP에서 seqnoList를 입력 하면, 서블릿에서 getSeqnoList를 찾음 -->
	
<%-- 	<c:forEach var="bbs" items="${BBSLIST }"> --%>
<!-- 		<tr> -->
<%-- 			<td width="80" align="center">${bbs.seqno }</td> --%>
<%-- 			<td width="300" align="center"><a href="BbsReadServlet?SEQNO=${bbs.seqno }">${bbs.title }</a></td> --%>
<%-- 			<td width="220" align="center">${bbs.bbs_date }</td> --%>
<%-- 			<td width="150" align="center">${bbs.id }</td> --%>
<!-- 		</tr> -->
<%-- 	</c:forEach> --%>
</table>
<br/>
<c:if test="${!BLIST.firstPage }">
	<a href="BbsListServlet?FIRST_PAGE=${BLIST.seqnoList[0] }">이전 페이지</a>
</c:if>
<c:forEach var="p" begin="1" end="${PAGE }"> 
<a href="BbsListServlet?PAGE_NO=${p }">${p }</a>
</c:forEach>
<c:if test="${!BLIST.lastPage }">
	<a href="BbsListServlet?LAST_PAGE=${BLIST.seqnoList[BLIST.listSize -1] }">다음 페이지</a>
</c:if>
<br/>
</body>
</html>