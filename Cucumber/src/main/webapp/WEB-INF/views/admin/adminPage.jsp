<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>관리자페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/profile/mypage.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<jsp:include page="../admin/bar.jsp"/>
<br><br><br><br><br><br><br>

<div class="wrapper">
	<div class="col-4">
		<div class="card">
			<div class="card-header">
				<span><b>관리자페이지</b></span>
			</div>
  			<div class="card-body">
				<div class="row justify-content-between">
					<div class="col"><b class="nick">${mvo.nick}</b> <span class="nim">님 페이지</span></div>
					<div class="col-4"><a href="memCheck.do" type="button" class="btn btn-light btn-sm">회원 정보 수정</a></div>
				</div><br>
				<br>
				<table class="table table-hover" id="table">
	  				<thead>
	    				<tr><th>관리자 메뉴</th></tr>
	    			</thead>
	  				<tbody class="table-group-divider"> <!-- 아래 페이지들로 이동 -->
	   	 				<tr><td><a href="member.do" type="button">회원관리</a></td></tr>
	   	 				<tr><td><a href="getEveryReportPost.do" type="button">게시물 관리</a></td></tr>
	   	 				<tr><td><a href="getEveryReportQna.do" type="button">문의글 관리</a></td></tr>
	   	 				<tr><td><a href="chatRep.do" type="button">채팅 관리</a></td></tr>
	   	 				<tr><td><a href="getAllRevRep.do" type="button">리뷰 관리</a></td></tr>
	  				</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

</body>
</html>