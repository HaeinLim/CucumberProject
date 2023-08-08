function delPost(e) {
	if(window.confirm('게시물을 삭제하시겠습니까?'))
		location.href="AdDelPost.do?postId="+e;
	else return false;
}

function delRepPost(e){
	if(window.confirm('게시물신고를 삭제하시겠습니까?'))
		location.href="delrepPost.do?postReportId="+e;
	else return false;
}