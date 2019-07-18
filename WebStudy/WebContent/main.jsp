<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
body {
	margin-top:50px;
	font-family: 'HYHeadLine', 'HY견고딕', 'HYPost';
	font-size : 17px;
}
#header {
	width:820px;	
	height:70px;
	margin:0 auto; 
}
#wrap {
	width:870px; 
	height:750px; 
	margin:0 auto;
}
#menu {
	width:230px; 
	height:750px;
	float:left; 
	background:rgb(178,204,255);
}
#content{
	width:640px; 
	height:100%; 
	float:right;
	background-image:url('imgs/background.jpg');
	background-size:cover;
}
fieldset{
	border:0px;
}
a{
	text-decoration:none;
}
a:link{
	color:black;
}
a:visited{
	color:black;
}
a:hover{
	color:rgb(70,65,217);
}
a:active{
	color:rgb(217,229,255);
}
h2{
	font-color:rgb(70,65,217);
}
#join{
	font-size:13px;
}
</style>
</head>
<body>
<div id="header">
	<h2>WebStudy Project</h2>
</div>
<div id="wrap">
	<div id="menu">
	<br/>
	<fieldset>
		<c:choose>
			<c:when test="${sessionScope.LOGIN == null }">
				<jsp:include page="loginForm.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="logoutForm.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
		<br/>
		<a href="main.jsp?BODY=front.jsp">소개</a><br/><br/>
		<a>공지사항</a><br/><br/>
		<a href="main.jsp?BODY=bbsInput.jsp">자유게시판 쓰기</a><br/><br/>
		<a href="BbsListServlet">자유게시판 읽기</a><br/><br/>
		<a href="main.jsp?BODY=itemInput.jsp">상품정보 등록</a><br/><br/>
		<a href="ItemListServlet">상품목록 읽기</a><br/><br/>
		<a href="CartListServlet">장바구니</a><br/><br/>
		<a href="WriteFormServlet">이미지게시판 쓰기/답글</a><br/><br/>
		<!-- 서블릿에서 이미지게시판 쓰기 jsp 호출 -->
		<a href="ImageListServlet">이미지게시판 읽기</a>
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