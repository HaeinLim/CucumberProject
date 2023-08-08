<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>비밀번호 찾기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/findPw.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/member/findPw.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<div class="wrapper">
	<div class="col-5">
		<div class="card">
  			<div class="card-body">
  				<a href="login.do" type="button" class="btn btn-light btn-sm"> <b>< Back</b> </a>
				<br><br>
				
				<div class="input-group">
					<label for="staticEmail" class="col-sm-2 col-form-label">이메일</label>
					<input type="text" class="form-control" aria-label="Username" name="Femail" id="userEmail" required="required">
					<span class="input-group-text">@</span>
					<input type="text" class="form-control" id="emailinput" name="Lemail" required="required">
					<select class="form-select" aria-label="Default select example" onchange="emailname(this.value)">
						<option selected="selected" value="">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="nate.com">nate.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="daum.net">daum.net</option>
					</select>
				</div>
				<br>
						
				<div class="row justify-content-center">
					<div class="col-3">
						<button class="btn btn-success" onclick="emailnum()">비밀번호 받기</button>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>

</body>
</html>