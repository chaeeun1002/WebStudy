<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${param.RESULT == 'OK' }">
�α��� �Ǿ����ϴ�.
ȯ���մϴ� ${sessionScope.LOGIN }��.
</c:if>

<!-- el�� �ڹٰ�ü�� ȣ���� �� ����ϴ� �̸�. -->
<!-- HttpServletRequest : requestScope -->
<!-- HttpSession : sessionScope -->

<c:if test="${param.RESULT == 'NOK' }">
�н����尡 ��ġ���� �ʽ��ϴ�.
</c:if>
<c:if test="${param.RESULT == 'NULL' }">
�Է��Ͻ� ������ ������ �������� �ʽ��ϴ�.
</c:if>
</body>
</html>