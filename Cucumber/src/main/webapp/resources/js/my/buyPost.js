function delBuy(buyId){
	if(window.confirm('해당 구매 내역을 삭제하시겠습니까?')) {
		location.href="delBuyPost.do?buyId="+data;
	}
	else return false;
}