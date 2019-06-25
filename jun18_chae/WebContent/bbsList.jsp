<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>글번호</th>
		<th>글제목</th>
		<th>작성일</th>
	</tr>
	<c:forEach var="bbs" items="${BBSLIST }">
		<tr>
			<td width="100" align="center">${bbs.seqno }</td>
			<td width="300" align="center"><a href="BbsReadServlet?SEQNO=${bbs.seqno }">${bbs.title }</a></td>
			<td width="200" align="center">${bbs.bbs_date }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>