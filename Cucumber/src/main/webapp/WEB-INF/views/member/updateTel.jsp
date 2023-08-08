<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>전화번호 수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/updateTel.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/member/updateTel.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<div class="wrapper">
	<div class="col-5">
		<div class="card">
  			<div class="card-body">
  				<a href="backUpdate.do" type="button" class="btn btn-light btn-sm"> <b>< Back</b> </a>
				<br><br>
				
				<form action="telUpdate.do" method="post" id="update">
				<div class="input-group">
					<label for="inputTel" class="col-sm-2 col-form-label">전화번호</label>
					<input type="number" class="col-md-1 form-control" name="Ftel" id="telF" min='0' value="${tel[0]}" required="required"> <span class="input-group-text">-</span> <input type="number" class="col-md-1 form-control" name="Mtel" id="telM" min='0' value="${tel[1]}"  required="required"> <span class="input-group-text">-</span> <input type="number" class="col-md-1 form-control" name="Ltel" id="telL" min='0' value="${tel[2]}"  required="required">
				</div>
				</form>
				<br>	
							
 				<div class="input-group" id="pcheck">
					<input type="text" id="pInput" class="form-control"  onchange="pRan(this.value)"  placeholder="인증번호 입력" disabled>
					<button type="button" class="btn btn-outline-success">핸드폰 인증</button>
				</div>
				<br>
				
				<div id="pnum">
					인증 미완료
				</div>
				<br><br>
				
				<div class="row justify-content-center">
					<div class="col-3">
						<button class="btn btn-success" onclick="formcheck()">전화번호 변경</button>
					</div>
				</div>
				<br>
				
  			</div>
  		</div>
  	</div>
  </div>

</body>
</html>