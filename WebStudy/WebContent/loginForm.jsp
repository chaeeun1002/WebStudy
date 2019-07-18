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
		alert("���̵� �Է��� �ּ���.");
		document.frm.ID.focus();
		return false;
	}else if(document.frm.PWD.value == ""){
		alert("�н����带 �Է��� �ּ���.");
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
		<h3 align="center">���񽺸� �̿��Ϸ��� �α����� �ʿ��մϴ�.</h3>
		<form action="LoginServlet" method="post" name="frm" onSubmit="return check()">
			<!-- submit ��ư�� ������ �� �ڹ� script�� check()�Լ��� �˻��ؼ� ���ϵǴ� ���� true�϶� servlet���� �Ѿ. -->
			���̵� : <input type="text" size = "20" name="ID"/><br/>
			�н����� : <input type="password" size="20" name="PWD"/><br/><br/>
			<input type="submit" value="�α���"/>
			<input type="reset" value="���"/>
			<input type="button" value="ȸ������" onClick="location.href='main.jsp?BODY=join.jsp'"><br/><br/>
		</form>  
	</c:when>
	<c:when test="${param.RESULT == 'noCart' }">
		<h3 align="center">��ٱ��Ͽ� �������� �α����� �ʿ��մϴ�.</h3>
		<form action="CartLoginServlet" method="post" name="frm" onSubmit="return check()">
			<!-- submit ��ư�� ������ �� �ڹ� script�� check()�Լ��� �˻��ؼ� ���ϵǴ� ���� true�϶� servlet���� �Ѿ. -->
			���̵� : <input type="text" size = "20" name="ID"/><br/>
			�н����� : <input type="password" size="20" name="PWD"/><br/><br/>
			<input type="submit" value="�α���"/>
			<input type="reset" value="���"/>
			<input type="button" value="ȸ������" onClick="location.href='main.jsp?BODY=join.jsp'"><br/><br/>
		</form>
	</c:when>
	<c:otherwise>
		<form action="LoginServlet" method="post" name="frm" onSubmit="return check()">
			<!-- submit ��ư�� ������ �� �ڹ� script�� check()�Լ��� �˻��ؼ� ���ϵǴ� ���� true�϶� servlet���� �Ѿ. -->
			���̵� : <input type="text" size = "20" name="ID"/><br/>
			�н����� : <input type="password" size="20" name="PWD"/><br/><br/>
			<input type="submit" value="�α���"/>
			<input type="reset" value="���"/>
			<input type="button" value="ȸ������" onClick="location.href='main.jsp?BODY=join.jsp'"><br/><br/>
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>