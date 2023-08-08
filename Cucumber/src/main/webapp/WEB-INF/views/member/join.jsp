<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/join.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/member/join.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<div class="wrapper">
	<div class="col-5">
		<div class="card">
  			<div class="card-body">
				<a href="login.do" type="button" class="btn btn-light btn-sm"> <b>< Back</b> </a>
				<br><br>
				<form action="insertMem.do" method="post" id="join">
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

					<div class="input-group" id="echeck">
						<input type="text" id="checkInput" class="form-control" placeholder="인증번호 입력" onchange="emailRan(this.value)" disabled required="required">
						<button type="button" class="btn btn-outline-success" onclick="emailnum()">이메일 인증</button>
					</div>
						
					<div id="emailnum">
						인증 미완료
					</div>
					<br>
					
					<div class="row">
						<label for="inputPassword" class="col-sm-3 col-form-label">비밀번호</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" name="pw" id="pw" onchange="regpassword(this.value)" required="required">
						</div>
					</div>
					
					<div id="regpass">
						비밀번호는 6~10자 사이, 영어대소문자,숫자,특수문자를 모두 포함해야 합니다
					</div>
					<br>
						
					<div class="row">
						<label for="inputPasswordCheck" class="col-sm-3 col-form-label">비밀번호 재확인</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" id="passwordCheck" onchange="passCheck(this.value)"  required="required">
						</div>
					</div>
						
					<div id="checkpw">
						비밀번호 미일치
					</div>
					<br>
						
					<div class="input-group" id="ncheck">
						<input type="text" class="form-control" name="nick" id="nick" value="${'cucumber'}${num}"  required="required">
						<button type="button" class="btn btn-outline-success" onclick="ncheck()">닉네임 중복 체크</button>
					</div>
					
					<div id="checknick">
						닉네임 중복 미확인
					</div>
					<br>
						
					<div class="input-group">
						<label for="inputTel" class="col-sm-2 col-form-label">전화번호</label>
						<input type="number" class="col-md-1 form-control" name="Ftel" id="telF" min='0'  required="required"> <span class="input-group-text">-</span> <input type="number" class="col-md-1 form-control" name="Mtel" id="telM" min='0'  required="required"> <span class="input-group-text">-</span> <input type="number" class="col-md-1 form-control" name="Ltel" id="telL" min='0'  required="required">
					</div>
					<br>
					
					<div class="input-group" id="pcheck">
						<input type="text" id="pInput" class="form-control" placeholder="인증번호 입력" onchange="pRan(this.value)" disabled  required="required">
						<button type="button" class="btn btn-outline-success" onclick="pnum()">핸드폰 인증</button>
					</div>
						
					<div id="pnum">
						인증 미완료
					</div>
					<br>
						
					<div class="subbtn">
						<button type="button" class="btn btn-success" onclick="formcheck()">가입 하기</button>
					</div>
				
				</form>
			</div>
		</div>
	</div>
</div>

</body>
</html>