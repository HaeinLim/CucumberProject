function likey(postId) {
	$.ajax ({
			url : "likey.do",
			type : 'GET',
			data : {
						postId : postId
					},
			success : function(data){
				var li = Number(document.getElementById('pl').innerText);

				if(data == 1) {
					alert("찜 하셨습니다");
					if(document.getElementById('likey1'))
						document.getElementById('likey1').src= "resources/img/filledlikey.svg";
					if(document.getElementById('likey2'))
						document.getElementById('likey2').src= "resources/img/filledlikey.svg";
					document.getElementById('pl').innerText = li+1;
				}
				else {
					alert("찜 취소되었습니다");
					if(document.getElementById('likey1'))
						document.getElementById('likey1').src= "resources/img/likey.svg";
					if(document.getElementById('likey2'))
						document.getElementById('likey2').src= "resources/img/likey.svg";
					document.getElementById('pl').innerText = li -1;
				}
			}
		});
}
		

function delQna(qnaId, postId, depth){
	if(window.confirm('문의글을 삭제하시겠습니까?')) {
		location.href='delQna.do?qnaId='+qnaId+'&postId='+postId+'&depth='+depth;
	}
}