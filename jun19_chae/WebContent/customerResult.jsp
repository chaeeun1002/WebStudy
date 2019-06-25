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
<c:if test="${param.RESULT == 'OK' }">
고객 정보가 등록되었습니다.
</c:if>
<c:if test="${param.RESULT == 'NOK' }">
고객 정보 등록 과정에서 문제가 발생했습니다.
</c:if>
</body>
</html>