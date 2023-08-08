<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원 정보 수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/update.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/member/update.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<div class="wrapper">
	<div class="col-5">
		<div class="card">
  			<div class="card-body">
				<a href="mypage.do" type="button" class="btn btn-light btn-sm"> <b>< Back</b> </a>
				<br><br>
				<form action="updateMem.do" method="post" id="update">
					<div class="row">
						<label for="staticEmail" class="col-sm-2 col-form-label">이메일</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" aria-label="Username" name="email" id="email" value="${mvo.email}" readonly="readonly">
						</div>
					</div>
					<br>
					
					<div class="row">
						<label for="inputPassword" class="col-sm-3 col-form-label">비밀번호</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" name="pw" id="pw" onchange="regpassword(this.value)">
						</div>
					</div>
					
					<div id="regpass">
						비밀번호는 6~10자 사이, 영어대소문자,숫자,특수문자를 모두 포함해야 합니다
					</div>
					<br>
						
					<div class="row">
						<label for="inputPasswordCheck" class="col-sm-3 col-form-label">비밀번호 재확인</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" id="passwordCheck" onchange="passCheck(this.value)">
						</div>
					</div>
						
					<div id="checkpw">
						비밀번호 미일치
					</div>
					<br>
					
					<div class="input-group" id="ncheck">
						<label for="nick" class="col-sm-3 col-form-label">닉네임</label>
						<input type="text" class="form-control" name="nick" id="nick" value="${mvo.nick}"  readonly="readonly">
						<a type="button" href="nickUpdateForm.do?nick=${mvo.nick}" class="btn btn-outline-success">닉네임 변경</a>
					</div>
					<br>
					
					<div class="input-group" id="tel">
						<label for="inputTel" class="col-sm-3 col-form-label">전화번호</label>
						<input type="text" class="col-md-1 form-control" name="Ftel" id="telF" value="${tel[0]}" readonly> <span class="input-group-text">-</span> <input type="text" class="col-md-1 form-control" name="Mtel" id="telM" value="${tel[1]}" readonly> <span class="input-group-text">-</span> <input type="text" class="col-md-1 form-control" name="Ltel" id="telL" value="${tel[2]}" readonly>
						<a type="button" href="telUpdateForm.do" class="btn btn-outline-success">번호 변경</a>
					</div>
					<br><br>
						
					<div class="subbtn">
						<button type="button" class="btn btn-success" onclick="formcheck()">회원 정보 수정 하기</button>
					</div>
					<br>
				
				</form>
				<button id="del" type="button" class="btn btn-light" onclick="del()">탈퇴하기</button>
			</div>
		</div>
	</div>
</div>

</body>
</html>