<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>��ǰ ����</h3>
��ǰ�ڵ� : ${ITEM.code }<br/><br/> 
��ǰ�̸� : ${ITEM.name }<br/><br/>
��ǰ���� : ${ITEM.price }<br/><br/>
<hr><br/>
${ITEM.info }<br/><br/><br/>
<input type="button" value="�������" onClick="location.href='ItemListServlet'">
</body>
</html>