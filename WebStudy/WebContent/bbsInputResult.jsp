<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${param.IRESULT == 'OK' }">
�Խñ��� ��ϵǾ����ϴ�.
</c:if>
<c:if test="${param.IRESULT == 'NOK' }">
�Խñ� ��ϰ������� ������ �߻��߽��ϴ�.<br/>
�����ڿ��� �������ּ���.
</c:if>
</body>
</html>