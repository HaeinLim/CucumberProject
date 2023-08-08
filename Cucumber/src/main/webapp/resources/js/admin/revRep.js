function delRev(e) {
	if(window.confirm('리뷰를 삭제하시겠습니까'))
		location.href="addelRev.do?revId="+e;
	else return false;
}

function delRepRev(e){
	if(window.confirm('신고를 삭제하시겠습니까?'))
		location.href="delrevRep.do?revRepId="+e;
	else return false;
}