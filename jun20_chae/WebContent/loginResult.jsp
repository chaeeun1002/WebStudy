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
로그인 되었습니다.
환영합니다 ${sessionScope.LOGIN }님.
</c:if>

<!-- el이 자바객체를 호출할 때 사용하는 이름. -->
<!-- HttpServletRequest : requestScope -->
<!-- HttpSession : sessionScope -->

<c:if test="${param.RESULT == 'NOK' }">
패스워드가 일치하지 않습니다.
</c:if>
<c:if test="${param.RESULT == 'NULL' }">
입력하신 정보의 계정은 존재하지 않습니다.
</c:if>
</body>
</html>