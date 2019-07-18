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
환영합니다. ${sessionScope.LOGIN } 님!
</c:if>
<c:if test="${param.RESULT == 'NOK' }">
로그인에 실패하였습니다.
</c:if>
<c:if test="${param.RESULT == 'NOKPWD' }">
로그인에 실패하였습니다. 패스워드를 확인해 주세요.
</c:if>
<c:if test="${param.CART == 'YES' }">
	<c:if test="${param.RESULT == 'OK' }">
		<script type="text/javascript">
			self.close();
			opener.window.location.reload();//부모창 새로고침
		</script>
	</c:if>
	<c:if test="${param.RESULT == 'NOK' }">
		<script type="text/javascript">
			alert("로그인에 실패하였습니다.");
		 	history.go(-1);
		</script>
	</c:if>
	<c:if test="${param.RESULT == 'NOKPWD' }">
		<script type="text/javascript">
			alert("로그인에 실패하였습니다.");
		 	history.go(-1);
		</script>
	</c:if>
</c:if>
</body>
</html>