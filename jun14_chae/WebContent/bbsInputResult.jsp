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
<%-- <c:choose> --%>
<%-- 	<c:when test="${param.RESULT == 'OK' }"> --%>
<!-- 		게시글이 등록되었습니다. -->
<%-- 	</c:when> --%>
<%-- 	<c:otherwise> --%>
<!-- 		게시글 등록과정에서 문제가 발생했습니다. -->
<%-- 	</c:otherwise> --%>
<%-- </c:choose> --%>

<c:if test="${param.RESULT == 'OK' }">
	게시글이 등록되었습니다.
</c:if>
<c:if test="${param.RESULT == 'NOK' }">
	게시글 등록과정에서 문제가 발생했습니다.
</c:if>
</body>
</html>