<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시물</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/my/otherPost.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<jsp:include page="../my/bar.jsp"/>
<br><br><br><br><br>

<div class="wrapper">
	<div class="col-7">
		<table class="table table-light table-hover">
			<thead>
				<tr class="table-active">
					<th colspan="6">게시물</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
			<c:if test="${not empty parray}">
			<c:forEach var="i" items="${parray}">
				<tr class="pp">
					<td align="center"><img class="sangImg" src="resources/sang_img/${i.mainPipath}"></td>
					<td align="center">
						<span class="badge bg-secondary">${i.postState}</span> ${i.postTitle }
		      		</td>
		      		<td align="center">${i.postPrice}원</td>
		      		<td align="center"><img class="likeyImg" src="resources/img/jjim.png">${i.likey}</td>
		      		<td align="center"><img class="viewImg" src="resources/img/view.png">${i.postView}</td>
		      		<td align="center"><a href="detail.do?postId=${i.postId}" type="button" class="btn btn-light btn-sm"> <b> > </b> </a></td>
		    	</tr>
		    	</c:forEach>
		    	</c:if>
		  	</tbody>
		</table>
		<c:if test="${empty parray}"><br><div class="no">회원의 판매중 게시물이 없습니다</div></c:if>
	</div>
</div>

<div class="updiv">
	<a href="#"><img src="resources/img/up.png" class="upimg"></a>
</div>

</body>
</html>