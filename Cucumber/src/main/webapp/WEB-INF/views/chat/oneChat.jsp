<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>채팅</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/chat/oneChat.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<br><br>
<input type="hidden" id="chatId" value="${chatId}">
<input type="hidden" id="userId" value="${sesId}">
<c:if test="${empty marray}"><input type="hidden" id="check" value="0"></c:if>
<c:if test="${not empty marray}"><input type="hidden" id="check" value="1"></c:if>
<div class="wrapper">
	<div class="col-6">
		<div class="card">
  			<div class="card-header">
  				<form action="chatReport.do" method="post" id="rep">
  					<img id="report" class="card-img-top" src="resources/img/report.png" onclick="rep()">
  					<input type="hidden" name="memId" value="${nick.memId}">
  					<input type="hidden" name="chatId" value="${chatId}">
  				</form>
  				<button type="button" class="btn btn-light btn-sm" onclick="endchat()"> <b>< 채팅방 </b> </button>
    			<c:if test="${not empty pvo}">
	    			<c:if test="${pvo.memId == sesId}">
		    			<div class="btn-group dropdown">
		  					<button type="button" class="btn btn-outline-success dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" id="st">
							    ${pvo.postState}
							</button>
							<ul class="dropdown-menu">
								<li><button class="dropdown-item" type="button" onclick="changestatus(${pvo.postId},'판매중')">판매중</button></li>
							    <li><button class="dropdown-item" type="button" onclick="changestatus(${pvo.postId},'거래중')">거래중</button></li>
							    <li><button class="dropdown-item" type="button" onclick="changestatus(${pvo.postId},'거래완료')">거래완료</button></li>
							</ul>
						</div>
					</c:if>
					<c:if test="${pvo.memId != sesId}">${pvo.postState}</c:if>
	    			<c:if test="${not empty pvo.mainPipath}"><img id="postImg" src="resources/sang_img/${pvo.mainPipath}"></c:if>  ${pvo.postTitle} (${pvo.postPrice} 원)
	  			</c:if>
	  			<c:if test="${empty pvo}"> 해당 게시글이 삭제 되었습니다. </c:if>
  			</div>
  			<div class="card-body" id="chatbody">
  				<c:if test="${not empty marray}">
	  				<c:forEach var="i" items="${marray}">
	  					<c:if test="${i.msgWriter != sesId}">
				  			<div class="you">
				  				<a href="youpage.do?memId=${nick.memId}" type="button" class="btn btn-light btn-sm">${nick.nick}</a>
				  				<div class="otherMsg">
				  				${i.msgContent}
				  				</div>
				  				<br>
				  				<span class="otherTime"><fmt:formatDate value="${i.msgDate}" pattern="yy.MM.dd H:mm" type="date"/></span>
				  				<br>
				  			</div>
			  			</c:if>
			  			<c:if test="${i.msgWriter == sesId}">
				  			<div class="my">
				  				<div class="mybox">
				  					<span class="num"><c:if test="${i.msgRead == 1}">1</c:if></span>		  				
					  				<div class="myMsg">
					  					${i.msgContent}
					  				</div>
					  				<div class="myTime"><fmt:formatDate value="${i.msgDate}" pattern="yy.MM.dd H:mm" type="date"/></div>
				  				</div>
				  			</div>
			  			</c:if> 
		  			</c:forEach>
	  			</c:if> 		
	  		</div> 
	  						
  			
  			<div class="card-footer">
  				<div class="input-group mb-3">
				  	<input type="text" class="form-control" placeholder="메시지를 입력하세요" id="msg" aria-label="Recipient's username" aria-describedby="button-addon2">
				  	<button class="btn btn-success" type="button" id="button-addon2" onclick="sendMsg()">전송</button>
				</div>
  			</div>
		</div>
	</div>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/chat/onechat.js"></script>
</html>