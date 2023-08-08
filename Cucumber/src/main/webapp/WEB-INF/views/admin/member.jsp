<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원 조회</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/my/buyPost.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/admin/member.js"></script>

<jsp:include page="../admin/bar.jsp"/>
<br><br><br><br><br>

<div class="wrapper">
	<div class="col-7">
		<table class="table table-light table-hover">
			<thead>
				<tr class="table-active">
					<th colspan="7">멤버 조회</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th>#</th>
					<th>이메일</th>
					<th>별명</th>
					<th>전화번호</th>
					<th>포인트</th>
					<th>신고</th>
					<th></th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
			<c:forEach var="i" items="${marray}">
				<tr class="pp">
					<td align="center">${i.memId}</td>
					<td align="center">${i.email}</td>
		      		<td align="center">${i.nick}</td>
		      		<td align="center">${i.tel}</td>
		      		<td align="center">${i.memPoint }</td>
		      		<td align="center">${ireport }</td>
		      		<td><button type="button" class="btn btn-outline-danger btn-sm" onclick="delMem(${i.memId})">탈퇴</button></td>
		    	</tr>
		    	</c:forEach>
		  	</tbody>
		</table>
	</div>
</div>



<div class="updiv">
	<a href="#"><img src="resources/img/up.png" class="upimg"></a>
</div>

</body>
</html>