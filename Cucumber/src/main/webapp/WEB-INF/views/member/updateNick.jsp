<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>닉네임 수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/updateNick.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/member/updateNick.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<div class="wrapper">
	<div class="col-5">
		<div class="card">
  			<div class="card-body">
  				<a href="backUpdate.do" type="button" class="btn btn-light btn-sm"> <b>< Back</b> </a>
				<br><br>
	
				<form action="nickUpdate.do" method="post" id="update">			
 				<div class="input-group" id="ncheck">
					<input type="text" class="form-control" name="nick" id="nick" value="${mvo.nick}"  required="required">
					<button type="button" class="btn btn-outline-success" onclick="ncheck()">닉네임 중복 체크</button>
				</div>
				</form>
				<br>
					
				<div id="checknick">
					닉네임 중복 미확인
				</div>
				<br>
				
				<div class="row justify-content-center">
					<div class="col-3">
						<button class="btn btn-success" onclick="formcheck()">닉네임 변경</button>
					</div>
				</div>
				<br>
				
  			</div>
  		</div>
  	</div>
  </div>

</body>
</html>