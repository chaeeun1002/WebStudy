<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>자유게시판 글쓰기</h3>
<form action="bbsPost.do" method="post">
제 목 : <input type="text" size="30" name="TITLE"/><br/><br/>
<textarea rows="5" cols="80" name="CONTENT"></textarea><br/><br/>
<hr><br/>
<input type="submit" value="글 올리기"/>
<input type="reset" value="취소"/>
</form>
</body>
</html>