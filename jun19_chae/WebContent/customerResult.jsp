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
�� ������ ��ϵǾ����ϴ�.
</c:if>
<c:if test="${param.RESULT == 'NOK' }">
�� ���� ��� �������� ������ �߻��߽��ϴ�.
</c:if>
</body>
</html>