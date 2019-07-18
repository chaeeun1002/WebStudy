<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	if(document.frm.ID.value == ""){
		alert("아이디를 입력해 주세요.");
		document.frm.ID.focus();
		return false;
	}else if(document.frm.PWD.value == ""){
		alert("패스워드를 입력해 주세요.");
		document.frm.PWD.focus();
		return false;
	}else{
		return true;
	}
}
</script>
</head>
<body>
<c:choose>
	<c:when test="${param.RESULT == 'noLogin' }">
		<h3 align="center">서비스를 이용하려면 로그인이 필요합니다.</h3>
		<form action="LoginServlet" method="post" name="frm" onSubmit="return check()">
			<!-- submit 버튼을 눌렀을 때 자바 script의 check()함수를 검사해서 리턴되는 값이 true일때 servlet으로 넘어감. -->
			아이디 : <input type="text" size = "20" name="ID"/><br/>
			패스워드 : <input type="password" size="20" name="PWD"/><br/><br/>
			<input type="submit" value="로그인"/>
			<input type="reset" value="취소"/>
			<input type="button" value="회원가입" onClick="location.href='main.jsp?BODY=join.jsp'"><br/><br/>
		</form>  
	</c:when>
	<c:when test="${param.RESULT == 'noCart' }">
		<h3 align="center">장바구니에 담으려면 로그인이 필요합니다.</h3>
		<form action="CartLoginServlet" method="post" name="frm" onSubmit="return check()">
			<!-- submit 버튼을 눌렀을 때 자바 script의 check()함수를 검사해서 리턴되는 값이 true일때 servlet으로 넘어감. -->
			아이디 : <input type="text" size = "20" name="ID"/><br/>
			패스워드 : <input type="password" size="20" name="PWD"/><br/><br/>
			<input type="submit" value="로그인"/>
			<input type="reset" value="취소"/>
			<input type="button" value="회원가입" onClick="location.href='main.jsp?BODY=join.jsp'"><br/><br/>
		</form>
	</c:when>
	<c:otherwise>
		<form action="LoginServlet" method="post" name="frm" onSubmit="return check()">
			<!-- submit 버튼을 눌렀을 때 자바 script의 check()함수를 검사해서 리턴되는 값이 true일때 servlet으로 넘어감. -->
			아이디 : <input type="text" size = "20" name="ID"/><br/>
			패스워드 : <input type="password" size="20" name="PWD"/><br/><br/>
			<input type="submit" value="로그인"/>
			<input type="reset" value="취소"/>
			<input type="button" value="회원가입" onClick="location.href='main.jsp?BODY=join.jsp'"><br/><br/>
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>