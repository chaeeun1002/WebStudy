<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>��õ�� ���� ����Ʈ</h3>
<c:forEach var="ten" items="${list }">
	<li>${ten }</li>
</c:forEach>
</body>
</html>