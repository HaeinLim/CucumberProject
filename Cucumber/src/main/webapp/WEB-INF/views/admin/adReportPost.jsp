<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시물 신고 조회</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/my/buyPost.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/admin/adReportPost.js"></script>

<jsp:include page="../admin/bar.jsp"/>
<br><br><br><br><br>

<div class="wrapper">
	<div class="col-5">
		<c:if test="${not empty getEveryReportPost}">
				<table class="table table-borderless table-light table-hover">
					<thead>
						<tr class="table-active">
							<th colspan="2">게시물 신고 조회</th>
						</tr>
					</thead>
						<c:forEach var="i" items="${getEveryReportPost }">
						<tbody class="table-group-divider">
							<tr>
								<td align="center">신고 게시글명 : ${i.getPostTitle() } </td>	<!-- 신고 게시글 아이디로 타이틀 찾아오기 -->
							</tr>
							<tr>
								<td align="center">신고자 : ${i.getReporterNick() }</td>	<!-- 신고자 아이디로 닉네임 찾아오기 -->
							</tr>
							<tr>
								<td align="center">신고 사유 : ${i.postReportContent }</td>
							</tr>
							<tr>
								<td align="center"><a href="detail.do?postId=${i.postId}" class="btn btn-outline-success btn-sm">게시물 보기</a>
								<button  class="btn btn-outline-danger  btn-sm" onclick="delPost(${i.postId})">게시물 삭제</button>
								<button  class="btn btn-outline-warning  btn-sm" onclick="delRepPost(${i.postReportId})">신고 삭제</button></td>
							</tr>
						</tbody>
						</c:forEach>
					
				</table>
			</c:if>
			<c:if test="${empty getEveryReportPost}"><br><div class="no">신고된 게시물이 없습니다</div></c:if>
		</div>
</div>

<div class="updiv">
	<a href="#"><img src="resources/img/up.png" class="upimg"></a>
</div>
</body>
</html>