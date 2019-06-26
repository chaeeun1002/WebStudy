function loginCheck() {
	if (document.frm.userid.value.length == 0) {
		alert("ID�� �Է��ϼ���.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("��ȣ�� �Է��ϼ���.");
		frm.pwd.focus();
		return false;
	}
	return true;
}

function idCheck() {
	if (document.frm.userid.value == "") {
		alert('ID�� �Է��ϼ���.');
		document.formm.userid.focus();
		return;
	}
	var url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok(userid) {
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
}

function joinCheck() {
	if (document.frm.name.value.length == 0) {
		alert("이름을 입력해주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.userid.value.length == 0) {
		alert("ID를 입력해주세요.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.userid.value.length < 4) {
		alert("ID는 4자 이상 입력해주세요.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호를 입력해주세요.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd.value != document.frm.pwd_check.value) {
		alert("암호가 맞지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.reid.value.length == 0) {
		alert("ID 를 사용하실 수 없습니다.");
		frm.userid.focus();
		return false;
	}
	return true;
}