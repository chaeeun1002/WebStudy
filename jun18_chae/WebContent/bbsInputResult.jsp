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
<!-- 		�Խñ��� ��ϵǾ����ϴ�. -->
<%-- 	</c:when> --%>
<%-- 	<c:otherwise> --%>
<!-- 		�Խñ� ��ϰ������� ������ �߻��߽��ϴ�. -->
<%-- 	</c:otherwise> --%>
<%-- </c:choose> --%>

<c:if test="${param.RESULT == 'OK' }">
	�Խñ��� ��ϵǾ����ϴ�.
</c:if>
<c:if test="${param.RESULT == 'NOK' }">
	�Խñ� ��ϰ������� ������ �߻��߽��ϴ�.
</c:if>
</body>
</html>