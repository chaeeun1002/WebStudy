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
			<p><a href="login.jsp?BODY=front.jsp">소개</a><br/>
			<a href="">공지사항</a><br/>
			<a href="login.jsp?BODY=bbsInput.html">자유게시판 쓰기</a><br/>
			<a href="login.jsp?BODY=BbsListServlet">자유게시판 목록</a><br/>
			<a href="login.jsp?BODY=itemInput.jsp">상품정보 등록</a><br/>
			<a href="login.jsp?BODY=ProductListServlet">상품정보 목록</a><br/>
			<a href="">고객센터</a><br/><br/>
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