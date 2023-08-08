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
function formcheck(){
	if(document.getElementById('telF').value == '' || document.getElementById('telM').value == '' || document.getElementById('telL').value == ''){
		alert('전화번호를 입력해주세요');
		return false;
	}
//	else if(document.getElementById('pnum').innerText == '인증 미완료' || Pcode=='') {
//		alert('전화번호 인증을 진행해 주세요');
//		return false;
//	}
	else {
		alert("전화번호 변경 완료");
		document.getElementById('update').submit();
	}
}