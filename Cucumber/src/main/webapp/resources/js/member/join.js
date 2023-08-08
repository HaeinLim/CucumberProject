function emailname(email) {
	document.getElementById('emailinput').value  = email;
}

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
	if(document.getElementById('userEmail').value == '' || document.getElementById('emailinput').value == '') {
		alert("이메일을 입력해 주세요");
		return false;
	}
//	else if(document.getElementById('emailnum').innerText == '인증 미완료' || Ecode == '') {
//		alert('이메일 인증을 진행해 주세요');
//		return false;
//	}
	else if(document.getElementById('pw').value == '' || document.getElementById('regpass').style.color == 'red') {
		alert('비밀번호를 확인해주세요');
		return false;
	}
	else if(document.getElementById('passwordCheck').value == '' || document.getElementById('passwordCheck').value != document.getElementById('pw').value) {
		alert('비밀번호 재확인을 확인해주세요');
		return false;
	}
	else if(document.getElementById('nick').value == '') {
		alert('닉네임을 입력해주세요');
		return false;
	}
	else if(document.getElementById('checknick').innerText == '닉네임 중복 미확인') {
		alert('닉네임 중복을 진행해주세요');
		return false;
	}
	else if(document.getElementById('checknick').innerText == '닉네임 중복 사용불가') {
		alert('다른 닉네임을 입력해주세요');
		return false;
	}
	else if(document.getElementById('telF').value == '' || document.getElementById('telM').value == '' || document.getElementById('telL').value == ''){
		alert('전화번호를 입력해주세요');
		return false;
	}
//	else if(document.getElementById('pnum').innerText == '인증 미완료' || Pcode=='') {
//		alert('전화번호 인증을 진행해 주세요');
//		return false;
//	}
	else {
		alert("회원가입 완료");
		document.getElementById('join').submit();
	}
}

var Ecode="";
function emailnum(){
	const email = $('#userEmail').val() +'@'+ $('#emailinput').val(); // 이메일 주소값 얻어오기!
	if(email == '') {
		alert("이메일을 입력해주세요");
		return false;
	}
	const checkInput = $('#checkInput'); // 인증번호 입력하는곳 
		$.ajax({
			type : 'post',
			url : "mailcheck.do",
			data : {
				email : email
			},
			success : function (data) {
				if(data == 'no') {
					alert("이미 가입된 회원입니다");
					window.location.href = "#";
				}
				else {
					checkInput.attr('disabled', false);
					alert('인증번호가 전송되었습니다.');
					Ecode = data;
				}
			}					
		}); // end ajax
}

function emailRan(val){
	if(Ecode == val){
		document.getElementById('emailnum').style.color = 'green';
		document.getElementById('emailnum').innerHTML = '인증완료';
		document.getElementById('checkInput').disabled = true;
	}
	else{
		document.getElementById('emailnum').style.color = 'red';
		document.getElementById('emailnum').innerHTML = '인증 미완료';
	}
}

var Pcode="";
function pnum(){
	const phone = $('#telF').val() + $('#telM').val() + $('#telL').val();
	if(phone == '') {
		alert("전화번호를 입력해주세요");
		return false;
	}
	const pInput = $('#pInput'); // 인증번호 입력하는곳 
		$.ajax({
			type : 'post',
			url : "phonecheck.do",
			data : {
				phone : phone
			},
			success : function (data) {
				pInput.attr('disabled', false);
				alert('인증번호가 전송되었습니다.');
				Pcode = data;
			}					
		}); // end ajax
}

function pRan(val){
	if(Pcode == val){
		document.getElementById('pnum').style.color = 'green';
		document.getElementById('pnum').innerHTML = '인증완료';
		document.getElementById('pInput').disabled = true;
	}
	else{
		document.getElementById('pnum').style.color = 'red';
		document.getElementById('pnum').innerHTML = '인증 미완료';
	}
}

function ncheck(){
	if(document.getElementById('nick').value == ''){
		alert('닉네임을 입력해 주세요');
		return false;
	}
	const nick = $('#nick').val();
		$.ajax({
			type : 'post',
			url : "nickcheck.do",
			data : {
				nick : nick
			},
			success : function (data) {
				if(data == 'no') {
					document.getElementById('checknick').style.color = 'red';
					document.getElementById('checknick').innerHTML = '닉네임 중복 사용불가';
				}
				else {
					document.getElementById('checknick').style.color = 'green';
					document.getElementById('checknick').innerHTML = '닉네임 사용가능';				
				}
				
			}					
		}); // end ajax
}