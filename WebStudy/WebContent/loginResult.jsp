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
ȯ���մϴ�. ${sessionScope.LOGIN } ��!
</c:if>
<c:if test="${param.RESULT == 'NOK' }">
�α��ο� �����Ͽ����ϴ�.
</c:if>
<c:if test="${param.RESULT == 'NOKPWD' }">
�α��ο� �����Ͽ����ϴ�. �н����带 Ȯ���� �ּ���.
</c:if>
<c:if test="${param.CART == 'YES' }">
	<c:if test="${param.RESULT == 'OK' }">
		<script type="text/javascript">
			self.close();
			opener.window.location.reload();//�θ�â ���ΰ�ħ
		</script>
	</c:if>
	<c:if test="${param.RESULT == 'NOK' }">
		<script type="text/javascript">
			alert("�α��ο� �����Ͽ����ϴ�.");
		 	history.go(-1);
		</script>
	</c:if>
	<c:if test="${param.RESULT == 'NOKPWD' }">
		<script type="text/javascript">
			alert("�α��ο� �����Ͽ����ϴ�.");
		 	history.go(-1);
		</script>
	</c:if>
</c:if>
</body>
</html>