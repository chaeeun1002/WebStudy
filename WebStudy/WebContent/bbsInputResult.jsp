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
게시글이 등록되었습니다.
</c:if>
<c:if test="${param.IRESULT == 'NOK' }">
게시글 등록과정에서 문제가 발생했습니다.<br/>
관리자에게 문의해주세요.
</c:if>
</body>
</html>