<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function joinCheck(){
	if(document.frm.name.value.length == 0){
		//document : body, frm : form의 name, name : 엘리먼트의 name, value : name의 값
		alert("이름을 입력해주세요.");
		frm.name.focus();
		return false;
	}
	if(document.frm.userid.value.length == 0){
		alert("ID를 입력해주세요.");
		frm.userid.focus();
		return false;
	}
	if(document.frm.userid.value.length < 5){
		alert("ID는 최소 5글자 이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value == ""){
		alert("암호를 입력해주세요.");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.pwd_check.value != document.frm.pwd.value){
		alert("암호를 확인해주세요.");
		frm.pwd_check.focus();
		return false;
	}
	if(document.frm.reid.value.length == 0){
		alert("ID중복체크를 해주세요.")
		return false;
	}
}
function idCheck(){
	
}
</script>
</head>
<body>
	<h2>회원 가입</h2>
	'*' 표시 항목은 필수 입력 항목입니다.
	<form action="join.do" method="post" name="frm">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20">*</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" size="20"  id="userid">* 
				<input type="hidden" name="reid" size="20"> 
				<!-- hidden : 눈에 안보이는 파라미터(중복체크를 했는지 안했는지 확인하기 위해 사용) -->
				<input type="button" value="중복 체크" onclick="idCheck()"></td>
			</tr>
			<tr>
				<td>암 호</td>
				<td><input type="password" name="pwd" size="20">*</td>
			</tr>
			<tr height="30">
				<td width="80">암호 확인</td>
				<td><input type="password" name="pwd_check" size="20">*</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="20"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" size="20"></td>
			</tr>
			<tr>
				<td>등급</td>
				<td><input type="radio" name="admin" value="0"
					checked="checked"> 일반회원 <input type="radio" name="admin"
					value="1"> 관리자</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="확인"
					onclick="return joinCheck()">
					<input type="reset" value="취소">
				</td>
			</tr>
			<tr>
				<td colspan="2">${message }</td>
			</tr>
		</table>
	</form>
</body>
</html>