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
��ٱ��Ͽ� ${param.NUM }���� ��ǰ�� �����ϴ�.
<input type="button" value="�ݱ�" onClick="javascript:self.close();">
</c:if>
<c:if test="${param.RESULT == 'NULLOK' }">
��ٱ��Ͽ� ���ο� ${param.NUM }���� ��ǰ�� �����ϴ�.
<input type="button" value="�ݱ�" onClick="javascript:self.close();">
</c:if>
<c:if test="${param.RESULT == 'NULLNOK' }">
���ο� ��ǰ�� ��ٱ��Ͽ� ��� �������� ������ �߻��߽��ϴ�.<br/>
�����ڿ��� ������ �ּ���.
<input type="button" value="�ݱ�" onClick="javascript:self.close();">
</c:if>
<c:if test="${param.RESULT == 'NOK' }">
��ٱ��Ͽ� ��� �������� ������ �߻��߽��ϴ�.<br/>
�����ڿ��� ������ �ּ���.
</c:if>
</body>
</html>