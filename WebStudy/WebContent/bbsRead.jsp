<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�����Խ��� �� �б�</h3>
���� : ${BBS.title }<br/><br/>
�ۼ��� : ${BBS.id }<br/><br/>
�ۼ��� : ${BBS.bbs_date }<br/><br/>
<hr><br/>
${BBS.content }<br/><br/><br/>
<input type="button" value="�������" onClick="location.href='BbsListServlet'">
</body>
</html>