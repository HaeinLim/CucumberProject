var Pcode="";
var email="";
function pnum(){
	const phone = $('#telF').val() + $('#telM').val() + $('#telL').val();
	if(phone == '') {
		alert("전화번호를 입력해주세요");
		return false;
	}
	const pInput = $('#pInput'); // 인증번호 입력하는곳 
		$.ajax({
			type : 'post',
			url : "phoneToEmail.do",
			data : {
				phone : phone
			},
			success : function (data) {
				pInput.attr('disabled', false);
				alert('인증번호가 전송되었습니다.');
				Pcode = data["rannum"];
				email = data["email"];
			}					
		}); // end ajax
}

function pRan(){
	var val = document.getElementById('pInput').value;
	if(val == '') {
		alert("전화번호 인증을 진행해주세요");
		return false;
	}
	else if(Pcode == val){
		if(email == '') {
			alert("미가입 고객입니다. 회원가입을 진행해주세요");
			window.location.href="join.do";
		}
		document.getElementById('pnum').innerHTML = 'Email : ' + email;
		document.getElementById('pnum').style.display = 'block';
	}
	else{
		alert("인증번호가 일치하지 않습니다");
	}
}