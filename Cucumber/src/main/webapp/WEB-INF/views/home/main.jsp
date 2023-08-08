<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<title>오이나라</title>
<style>
#postTb {
	border:1px;
	border-style: solid;
	border-color: #dcdcdc;
	
}

#cuth {
	text-align:center;
}

.tdthum {
	text-align:center;
}

.thumnail {
	width:300px;
	height:200px;
}

.title {
	font-weight:bold;
}

.livi {
	color: gray;
	font-size: 8pt;
}
	.no{
		margin-left : 20%;
		margin-right : 20%;
		padding : 5%;
		background-color: lightgray;
		border-radius : 0.5rem;
		text-align: center;
		font-size: 170%;
		color: #2f4f4f;
	}
</style>
<script>
window.onload = function logalert(){
	   var state = document.getElementById('alarm').value;
	   if(state == 'logout')
	   alert("로그아웃 되었습니다");
	   else if(state == 'badmem')
	   alert("로그인을 해주세요");
	   else if(state == 'noPost')
		alert('게시물이 존재하지 않습니다');
	   else
	   return false;
	}	
</script>
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

	<%@include file="menuBar.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<input type="hidden" id="alarm" value="${alarm}">

	
	<c:if test="${not empty cri.plist }">
		
		<div class="row">
			<div class="col"></div>
			<div class="col-6">
				<table class="table" id="postTb">
				<thead>
				<tr>
					<th colspan=2 scope="col" class="table-success" id="cuth">오이나라 거래장터</th>
				</tr>
				</thead>
				<c:if test="${not empty cri.plist}">
				<c:forEach var="i" items="${cri.plist }">
					<c:choose>
						<c:when test="${i.postState != '숨김' }">
							<tr>
								<td rowspan="5" class="tdthum">
									<img src="resources/sang_img/${i.mainPipath }" class="thumnail" alt="img">
								</td>
								<td class="title">
									${i.postTitle }
								</td>
							</tr>
							<tr>
								<td>
									${i.postPrice }원
								</td>
							</tr>
							<tr>
								<td>
									${i.postState }
								</td>
							</tr>
							<tr>
								<td class="livi">
									찜 ${i.likey } * 조회수 ${i.postView }
								</td>
							</tr>
							<tr>
								<td align="right">
									<a href="detail.do?postId=${i.postId}" class="btn btn-outline-success" type="button">둘러보기</a>
								</td>
							</tr>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</c:forEach>
				</c:if>
				</table>
			</div>
			<div class="col"></div>
		</div>
	</c:if>
		
	<c:if test="${empty cri.plist}"><div class="no">찾으시는 게시물이 없습니다</div></c:if>
	<br><br>

	<div>
		<ul id="pageInfo" class="pagination justify-content-center">
			<c:if test="${cri.pageNum == 1}">
				<li class="page-item disabled"><a class="page-link">&laquo;</a></li>
			</c:if>
			<c:if test="${cri.pageNum != 1 }">
				<li class="page-item"><a
					href="main.do?pageNum=${cri.pageNum - 1 }
					&cateId=${cri.cateId}&keyword=${cri.keyword }&order=${cri.order }"
					class="page-link">&laquo;</a></li>
			</c:if>
			<c:forEach var="i" items="${cri.pagelist }">
				<c:choose>
					<c:when test="${i == cri.pageNum }">
						<li class="page-item active"><a class="page-link" href="#">${i }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
						<a href="main.do?pageNum=${i }&cateId=${cri.cateId }&keyword=${cri.keyword}&order=${cri.order}" class="page-link">${i }</a>			
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${cri.pageNum == cri.endpage }">
				<li class="page-item disabled"><a class="page-link">&raquo;</a>
			</c:if>
			<c:if test="${cri.pageNum != cri.endpage}">
				<li class="page-item"><a class="page-link"
					href="main.do?pageNum=${cri.pageNum + 1 }
					&cateId=${cri.cateId}&keyword=${cri.keyword }&order=${cri.order }">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
	
 	<c:if test="${not empty sesId }">
 		<div style="position: fixed; bottom: 5px; right: 5px">
			<a href="<c:url value='goNewPost.do' />"><img src="resources/img/newpost.png"></a>
		</div>
 	</c:if>
</body>
</html>