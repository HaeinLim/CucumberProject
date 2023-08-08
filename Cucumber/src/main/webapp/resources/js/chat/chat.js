function deletechat(e) {
	if(window.confirm("해당 채팅방을 삭제 하시겠습니까?")){
		 location.href="deleteChat.do?chatId="+e;
	}
	else {
		return false;
	}
}