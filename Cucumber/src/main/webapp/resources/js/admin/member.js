function delMem(e) {
	if(window.confirm('회원을 강제 탈퇴하시겠습니까?')) 
		location.href="adDelMem.do?memId="+e;

	else return false;
}
