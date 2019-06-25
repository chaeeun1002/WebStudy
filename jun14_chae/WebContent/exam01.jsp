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
<h3>추천된 맛집 리스트</h3>
<c:forEach var="ten" items="${list }">
	<li>${ten }</li>
</c:forEach>
</body>
</html>