<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>비밀번호 확인</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/login.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/member/memCheck.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<input type="hidden" id="noses" value="${noses}">

<div class="wrapper">
	<div class="col-4">
		<div class="card">
  			<div class="card-body">
  				<a href="#" type="button" class="btn btn-light btn-sm"> <b>< Back</b> </a>
				<br><br>
				
				<form action="memUpdateForm.do" id="memCheck" method="post">
				<div class="row">
					<label for="staticEmail" class="col-sm-3 col-form-label">이메일</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="email" id="email" value="${sesEmail}" readonly="readonly">
					</div>
				</div>
				<br>
						
				<div class="row">
					<label for="inputPassword" class="col-sm-3 col-form-label">비밀번호</label>
					<div class="col-sm-9">
						<input type="password" class="form-control" name="pw" id="pw" required="required">
					</div>
				</div>
				<br>
				

				<div class="subbtn">
					<button type="button" class="btn btn-success" onclick="formcheck()">회원 인증</button>
				</div>
				<br>
				
				</form>
			</div>
		</div>
	</div>
</div>

</body>
</html>