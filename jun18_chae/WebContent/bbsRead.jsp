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
<h3>게시글 보기</h3>
<table border="1">
	<tr>
		<th>글번호</th>
		<td>${BBS.seqno }</td>
	</tr>
	<tr>
		<th>글제목</th>
		<td>${BBS.title }</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${BBS.bbs_date }</td>
	</tr>
	<tr>
		<th>글내용</th>
		<td>${BBS.content }</td>
	</tr>
</table>
</body>
</html>