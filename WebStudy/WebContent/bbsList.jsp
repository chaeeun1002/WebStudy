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
	<table>
		<tr>
			<th width="100" height="70">�۹�ȣ</th>
			<th width="200">������</th>
			<th width="100">�ۼ���</th>
			<th width="150">�ۼ���</th>
		</tr>
		<c:forEach var="bbs" begin="0" end="${BBSLIST.listSize - 1 }">
			<tr>
				<td align="center" height="50">${BBSLIST.seqnoList[bbs] }</td>
				<td align="center"><a href="BbsReadServlet?SEQNO=${BBSLIST.seqnoList[bbs] }">${BBSLIST.titleList[bbs] }</a></td>
				<td align="center">${BBSLIST.idList[bbs]}</td>
				<td align="center">${BBSLIST.bbs_dateList[bbs]}</td>
			</tr>
		</c:forEach>
	</table>
	<br/><br/>
	<c:if test="${! BBSLIST.firstPage }">
	<a href="BbsListServlet?FIRST_PAGE=${BBSLIST.seqnoList[0] }">����������</a>
	</c:if>
	<c:forEach var="p" begin="1" end="${PAGE }">
	<a href="BbsListServlet?PAGE=${p }">${p }</a>
	</c:forEach>
	<c:if test="${! BBSLIST.lastPage }">
	<a href="BbsListServlet?LAST_PAGE=${BBSLIST.seqnoList[BBSLIST.listSize-1] }">����������</a>
	</c:if>
</body>
</html>