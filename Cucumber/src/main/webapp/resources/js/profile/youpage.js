function repMem(e) {
	if(window.confirm('해당 회원을 신고하시겠습니까?')){
	$.ajax({
			type : 'post',
			url : "repMem.do",
			data : {
				memId : e
			},
			success : function () {
				alert("신고 접수가 완료되었습니다");
			}					
		}); // end ajax		
	}
	else return false;
		
}