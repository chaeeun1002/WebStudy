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
<c:if test="${param.MODIFY == 'update' }">
	<script type="text/javascript">
		alert("��ٱ��ϰ� ����Ǿ����ϴ�.");
		location.href="CartListServlet";
	</script>
</c:if>
<c:if test="${param.MODIFY == 'delete' }">
	<script type="text/javascript">
		alert("��ٱ��Ͽ��� �����Ǿ����ϴ�.");
		location.href="CartListServlet";
	</script>
</c:if>
</body>
</html>