function delQna(e) {
	if(window.confirm('문의글을 삭제하시겠습니까?'))
		location.href="adDelQna.do?qnaId="+e;
	else return false;
}

function delRepQna(e){
	if(window.confirm('신고를 삭제하시겠습니까?'))
		location.href="adDelRepQna.do?qnaReportId="+e;
	else return false;
}