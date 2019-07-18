<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function doCheck(){
	var id = document.getElementById("ID").value;
	location.href = 'IdCheckServlet?ID='+id;
}
</script>
</head>
<body>
<h3 align="center">회원가입</h3>
<form action="">
	<table align="center">
		<tr height="50">
			<td>아이디</td>
			<td>
				<input type="text" id="ID" name="ID" size="20" value="${param.ID }"/>
				<input type="button" value="중복확인" onClick="doCheck()"/>
				<c:if test="${param.RESULT == 'OK' }">
					사용가능한 아이디 입니다.
				</c:if>
				<c:if test="${param.RESULT == 'NOK' }">
					사용할 수 없는 아이디 입니다.
				</c:if>
			</td>
		</tr>
		<tr height="50">
			<td>패스워드</td>
			<td><input type="password" name="PWD" size="20"/></td>
		</tr>
		<tr height="50">
			<td>패스워드 확인</td>
			<td>
			<input type="password" name="PWDCHK" size="20"/>
			<input type="button" value="확인"/>
			</td>
		</tr>
		<tr height="50">
			<td>성별</td>
			<td>
				<input type="radio" name="GEN" value="F"/>여자
				<input type="radio" name="GEN" value="M"/>남자
			</td>
		</tr>
		<tr height="50">
			<td>전화번호</td>
			<td>
				<select name="FIRST_PHONE">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="013">013</option>
				</select><label> -</label>
				<input type="text" name="MID_PHONE" size="5"/><label> -</label>
				<input type="text" name="LAST_PHONE" size="5"/>
			</td>
		</tr>
		<tr height="50">
			<td>이메일</td>
			<td>
				<input type="text" name="EMAIL_ID" size="10"><label> @</label>
				<select name="EMAIL_ADDR">
					<option value="naver">naver.com</option>
					<option value="daum">daum.net</option>
					<option value="yahoo">yahoo.com</option>
					<option value="google">google.com</option>
				</select>
			</td>
		</tr>
		<tr height="50">
			<td>등급</td>
			<td>
				<input type="radio" name="GRADE" value="admin"/>관리자
				<input type="radio" name="GRADE" value="user"/>회원
			</td>
		</tr>
		<tr height="50">
			<td colspan="2" align="center">
				<input type="submit" value="회원가입" onClick="doEntry()"/>
				<input type="reset" value="취소"/>
				<input type="button" value="메인으로" onClick="location.href='main.jsp?BODY=front.jsp'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>