<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %><!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>게시글 목록</h2>
<table border="1">
	<tr>
		<th width="40">글번호</th>
		<th width="200">글제목</th>
		<th width="200">작성일</th>
	</tr>
	<c:forEach begin="1" end="10">
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>