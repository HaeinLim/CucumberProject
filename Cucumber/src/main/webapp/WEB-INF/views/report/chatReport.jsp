<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>채팅 신고</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/report/chatRep.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function rep() {
		if(window.confirm('신고하시겠습니까?'))
			document.getElementById('inse').submit()
		else return false;
	}
</script>

<div class="wrapper">
	<div class="col-4">
		<div class="card">
  			<div class="card-header">
  				<a href="findChat.do?chatId=${chatId}" type="button" class="btn btn-light btn-sm"> <b>< 채팅 </b> </a>
  			</div>
  			<form action="insertChatRep.do" method="post" enctype="multipart/form-data" id="inse">
	  			<div class="card-body">
	  				신고 대상 : ${mvo.nick}
	  				<br><br>
					<input class="form-control" type="file" id="formFile" name="upload">
					<br>
					<textarea name="chatReportContent" rows="5" class="form-control" aria-label="With textarea" placeholder="신고 내용을 입력해 주세요"></textarea>
	  				<br>
	  				<div class="sub"><button type="button" class="btn btn-success" onclick="rep()">신고</button></div>
	  				<input type="hidden" name="chatReported" value="${mvo.memId}">
	  				<input type="hidden" name="chatId" value="${chatId}">
	  			</div>
  			</form>
  		</div>
  	</div>
</div>


</body>
</html>