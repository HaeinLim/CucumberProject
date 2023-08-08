function emailname(email) {
	document.getElementById('emailinput').value  = email;
}

function emailnum(){
	const email = $('#userEmail').val() +'@'+ $('#emailinput').val(); // 이메일 주소값 얻어오기!
	if($('#userEmail').val() == '' || $('#emailinput').val() == '') {
		alert("이메일을 입력해주세요");
		return false;
	}
	const checkInput = $('#checkInput'); // 인증번호 입력하는곳 
		$.ajax({
			type : 'post',
			url : "mailtoPw.do",
			data : {
				email : email
			},
			success : function () {
				alert('이메일이 전송되었습니다.');
				location.href="login.do";
			}					
		}); // end ajax
}