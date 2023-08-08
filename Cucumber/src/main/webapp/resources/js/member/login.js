window.onload = function logalert(){
	if(document.getElementById('noses').value == 'noses')
	alert("아이디 및 비밀번호가 틀렸습니다");
}

function formcheck(){
	if(document.getElementById('email').value == '') {
		alert("이메일을 입력해 주세요");
		return false;
	}
	else if(document.getElementById('pw').value == '') {
		alert('비밀번호를 입력해주세요');
		return false;
	}
	else {
		document.getElementById('login').submit();
	}
}