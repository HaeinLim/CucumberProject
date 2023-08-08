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

function formcheck(){
	if(document.getElementById('nick').value == '') {
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
	else {
		alert("닉네임 변경 완료");
		document.getElementById('update').submit();
	}
}