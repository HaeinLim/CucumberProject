function regpassword (password) {
	  var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,10}$/
	  document.getElementById('checkpw').style.color = 'red';
	  document.getElementById('checkpw').innerHTML = '비밀번호 미일치';
	  document.getElementById('passwordCheck').value = '';
	  if(true == reg.test(password))
		  document.getElementById('regpass').style.color = 'green';
	  else
		  document.getElementById('regpass').style.color = 'red';
	  return;
}
	
function passCheck(pch) {
	var password = document.getElementById('pw').value;
	if(password == pch){
		document.getElementById('checkpw').style.color = 'green';
		document.getElementById('checkpw').innerHTML = '비밀번호 일치';
	}
	else{
		document.getElementById('checkpw').style.color = 'red';
		document.getElementById('checkpw').innerHTML = '비밀번호 미일치';
	}
}

function formcheck(){	
	if(document.getElementById('pw').value == '' || document.getElementById('regpass').style.color == 'red' || document.getElementById('passwordCheck').value == '' || document.getElementById('passwordCheck').value != document.getElementById('pw').value){	
		alert("비밀번호 미변경");
		document.getElementById('pw').value = 'no';
	}
	alert("회원정보 수정 완료");
	document.getElementById('update').submit();

}
function del(){
	if(window.confirm("정말 탈퇴하시겠습니까?")){
		alert("탈퇴되었습니다");
		location.href="deleteMem.do"
	}
	else
		return false;
}
