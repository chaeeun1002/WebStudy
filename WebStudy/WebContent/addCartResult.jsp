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
<c:if test="${param.RESULT == 'OK' }">
장바구니에 ${param.NUM }개의 상품이 담겼습니다.
<input type="button" value="닫기" onClick="javascript:self.close();">
</c:if>
<c:if test="${param.RESULT == 'NULLOK' }">
장바구니에 새로운 ${param.NUM }개의 상품이 담겼습니다.
<input type="button" value="닫기" onClick="javascript:self.close();">
</c:if>
<c:if test="${param.RESULT == 'NULLNOK' }">
새로운 상품을 장바구니에 담는 과정에서 문제가 발생했습니다.<br/>
관리자에게 문의해 주세요.
<input type="button" value="닫기" onClick="javascript:self.close();">
</c:if>
<c:if test="${param.RESULT == 'NOK' }">
장바구니에 담는 과정에서 문제가 발생했습니다.<br/>
관리자에게 문의해 주세요.
</c:if>
</body>
</html>