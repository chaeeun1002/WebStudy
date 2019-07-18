<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>자유게시판 글 읽기</h3>
제목 : ${BBS.title }<br/><br/>
작성자 : ${BBS.id }<br/><br/>
작성일 : ${BBS.bbs_date }<br/><br/>
<hr><br/>
${BBS.content }<br/><br/><br/>
<input type="button" value="목록으로" onClick="location.href='BbsListServlet'">
</body>
</html>