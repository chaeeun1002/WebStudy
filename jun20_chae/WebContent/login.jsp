<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	body{
		font-family : 'HYHeadLine';
		font-size : 18px;
	}
	#header{
		width : 800px;
		margin : 0 auto;
		background : red;
	}
	#wrap{
		width : 800px;
		height : 310px;
		margin : 0 auto;
	}
	#aside{
		width : 200px;
		height : 100%;
		float : left;
		background : orange;
	}
	#content{
		width : 600px;
		height : 100%;
		float : right;
		background-image : url(imgs/5.jpg);
		background-size : 600px 310px; 
	}
</style>
</head>
<body>
<div id="header">
	<img alt="" src="imgs/logo.gif">
</div>
<div id="wrap">
	<div id="aside">
		<fieldset>
			<c:choose>
				<c:when test="${sessionScope.LOGIN != null }">
					<jsp:include page="logoutForm.jsp"></jsp:include>
				</c:when>
				<c:otherwise>
					<jsp:include page="loginForm.jsp"></jsp:include>
				</c:otherwise>
			</c:choose>
			<p><a href="login.jsp?BODY=front.jsp">�Ұ�</a><br/>
			<a href="">��������</a><br/>
			<a href="login.jsp?BODY=bbsInput.html">�����Խ��� ����</a><br/>
			<a href="login.jsp?BODY=BbsListServlet">�����Խ��� ���</a><br/>
			<a href="login.jsp?BODY=itemInput.jsp">��ǰ���� ���</a><br/>
			<a href="login.jsp?BODY=ProductListServlet">��ǰ���� ���</a><br/>
			<a href="">������</a><br/><br/>
		</fieldset>
	</div>
	<div id="content">
	<c:choose>
		<c:when test="${param.BODY != null }">
			<jsp:include page="${param.BODY }"/>
		</c:when>
		<c:otherwise>
			<jsp:include page="front.jsp"/>	
		</c:otherwise>
	</c:choose>
	</div>
</div>
</body>
</html>