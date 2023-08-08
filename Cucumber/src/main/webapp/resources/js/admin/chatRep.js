function repMem(e) {
	if(window.confirm('회원 경고를 진행하시겠습니까'))
		location.href="memAl.do?memId="+e;
	else return false;
}

function delRepChat(e){
	if(window.confirm('신고를 삭제하시겠습니까?'))
		location.href="delrepChat.do?chatReportId="+e;
	else return false;
}