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
상품정보가 등록되었습니다.
</c:if>
<c:if test="${param.RESULT == 'NOK' }">
상품정보 등록 중 문제가 발생했습니다. 관리자에게 문의해주세요.
</c:if>
</body>
</html>