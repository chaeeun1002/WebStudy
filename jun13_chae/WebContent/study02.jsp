<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Study02 Result</title>
</head>
<body>
<!-- ���⼭ ������ ������ ���� HttpServletRequest ��ü�κ��� brands��� �ϴ� �̸��� �Ӽ��� ����� �����͸� ����Ѵ�. -->
${cnt + 1}<br/>    <%-- ${ } : EL --%>
<h3>��õ�� ���� �̸�</h3>
<c:forEach var="count" begin="1" end="10" step="2">
	<h5>${count }</h5>
</c:forEach>
<c:forEach var="brand" items="${brands }">
	<li>${brand }</li>
</c:forEach>
</body>
</html>