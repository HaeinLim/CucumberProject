function allRev(revRad) {
	var memId = document.getElementById('memId').value;
	location.href='allRev.do?revRad='+revRad+'&memId='+memId;
}
function repRev(revId) {
	if(window.confirm('해당 리뷰를 신고하시겠습니까?')){
			$.ajax({
			type : 'post',
			url : "repRev.do",
			data : {
				revId : revId
			},
			success : function () {
				alert("신고되었습니다");
			}					
		}); // end ajax
	}
		
	else return false;
}

function delRev(revId) {
	if(window.confirm('해당 리뷰를 삭제하시겠습니까?'))
		location.href="delRev.do?revId="+revId;
	else return false;
}
