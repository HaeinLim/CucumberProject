 // 웹소켓
var ws;
var userId = document.getElementById('userId').value;
var chatId = document.getElementById('chatId').value;
var check = document.getElementById('check').value;

window.onload=function() {
	// 채팅 입장 저장
	$.ajax({
			type : 'post',
			url : "chatlog.do",
			data : {
				chatId : chatId
			},
			success : function (data) {
				connect();
			}					
		}); // end ajax
	
		
	// 하단에 스크롤 고정
	$('#chatbody').scrollTop($('#chatbody')[0].scrollHeight);
	

}

function connect(){
	// 소켓 객체 생성
	ws = new WebSocket('ws://localhost:8080/cucumber/chat.do');
	ws.onopen = function() {
		register();
		console.log('등록');
	};
	ws.onmessage = function(e) {
		addMsg(e.data);
		console.log('메시지 받기');
	};
	ws.onclose = function(){
		console.log('종료');
	};
}

function getdate(){
	var today = new Date();
	var mon = today.getMonth();
	if(mon<10) mon = "0"+mon
	var date = today.getFullYear()%100 + '.' + mon + '.' + today.getDate()
	 + ' ' + today.getHours() + ':' + today.getMinutes();
	return date;
}

function register() {
	var msg={
		type : "register",
		chatId : chatId,
		memId : userId
	};
	ws.send(JSON.stringify(msg));
};

// 내가 메시지 보냄
function sendMsg() {
	var read;
	var content = document.getElementById('msg').value;
	var date = getdate();
	
	if(content == '')
		return false;
	
	//상대방의 로그인 여부를 파악해서 가져오는 ajax 필요
	$.ajax({
		type : 'post',
		url : "chatloguser.do",
		async:false,
		data : {
			chatId : chatId
		},
		success : function (data) {
			read = data;
			console.log(read);
		}					
	}); // end ajax
	
	if(read == 0){
		// 소켓에 보내기
		var msg={
			type : "text",
			chatId : chatId,
			memId : userId,
			content : content
		};
		ws.send(JSON.stringify(msg));
	};

	// table에 insert
	$.ajax({
		type : 'post',
		url : "insertMsg.do",
		async:false,
		data : {
			chatId : chatId,
			msgContent : content,
			msgRead : read
		},
		success : function (e) {
			if(document.getElementById("chatbody").getElementsByClassName("my")[0]) {
				var el = document.getElementById("chatbody").getElementsByClassName("my")[0];	
				var cl = el.cloneNode(true);
				if(read == 1)
					cl.firstElementChild.firstElementChild.innerText = read;
				else
					cl.firstElementChild.firstElementChild.innerText = '';
				cl.firstElementChild.firstElementChild.nextElementSibling.innerText = content;
				cl.firstElementChild.firstElementChild.nextElementSibling.nextElementSibling.innerText = date;
				document.getElementById("chatbody").appendChild(cl);
				$('#chatbody').scrollTop($('#chatbody')[0].scrollHeight);
				document.getElementById('msg').value = '';
				check = e;
			}
			else location.reload(true);
			}					
	}); // end ajax	
	

	
}

// 받은 메시지 띄우기
function addMsg(data) {
	// read 1 지우기
	var my = document.getElementById('chatbody').getElementsByClassName('my');
	for(var i =0; i<my.length; i++) {
		my[i].firstElementChild.firstElementChild.innerText = '';
	};
	
	var el = document.getElementById("chatbody").getElementsByClassName("you")[0];
	var cl = el.cloneNode(true);
	cl.firstElementChild.nextElementSibling.innerText = data;
	cl.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.innerText = getdate();
	document.getElementById("chatbody").appendChild(cl);
}

// 채팅방버튼 누르면 소켓 종료 및 로그인 off
function endchat(){
	if(check == 0) {
		$.ajax({
				type : 'post',
				url : "backDelChat.do",
				async:false,
				data : {
					chatId : chatId
				},
				success : function () {
				}					
			}); // end ajax	
	}
// chat login 삭제
	$.ajax({
			type : 'post',
			url : "chatlogout.do",
			data : {
				chatId : chatId,
				userId : userId
			},
			success : function (data) {
				ws.close();
				location.href="chatlist.do"
			}					
		}); // end ajax	
}

function changestatus(postId, status) {
	$.ajax({
		type : 'post',
		url : "upPostStatus.do",
		data : {
			postId : postId,
			status : status,
			chatId : chatId
		},
		success : function () {
			document.getElementById('st').innerText = status;
			if(status == '거래완료') {
				alert('거래 완료 되었습니다')
			}
		}					
	}); // end ajax		
}

function rep() {
	document.getElementById('rep').submit();
}