<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>구매한 게시물</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/my/rev.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<jsp:include page="../my/bar.jsp"/>
<br><br><br><br><br>

<div class="wrapper">
	<div class="col-4">
	<div class="card">
<form action="inRev.do" method="post">
<input type="hidden" name="revReceiver" value="${receiver}">
<input type="hidden" name="buyId" value="${buyId}">
<div class="card-header"><span class="nick">To. ${nick}</span></div>

<div class="card-body">
<input name="revPoint" value="2" class="form-check-input" type="radio" id="flexRadioDefault1" checked="checked">&nbsp;<img class="face" src="resources/img/2rev.png">
&nbsp;&nbsp;
<input  name="revPoint" value="1" class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">&nbsp;<img class="face" src="resources/img/1rev.png">
&nbsp;&nbsp;
<input  name="revPoint" value="0" class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">&nbsp;<img class="face" src="resources/img/0rev.png">
<br><br>
<textarea name="revContent" class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="후기글을 입력해 주세요"></textarea>

<br>
<div class="sub">
<button type="submit" class="btn btn-outline-success">입력</button>
</div>
<br>
</div>
</form>
</div>

</div>
</div>

</body>
</html>