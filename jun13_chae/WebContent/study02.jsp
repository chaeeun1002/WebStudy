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
<!-- 여기서 할일은 서블릿이 보낸 HttpServletRequest 객체로부터 brands라고 하는 이름의 속성에 저장된 데이터를 출력한다. -->
${cnt + 1}<br/>    <%-- ${ } : EL --%>
<h3>추천된 맥주 이름</h3>
<c:forEach var="count" begin="1" end="10" step="2">
	<h5>${count }</h5>
</c:forEach>
<c:forEach var="brand" items="${brands }">
	<li>${brand }</li>
</c:forEach>
</body>
</html>