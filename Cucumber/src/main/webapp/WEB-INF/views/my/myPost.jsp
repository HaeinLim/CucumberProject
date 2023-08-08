<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>내 후기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/my/myPost.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/my/myPost.js"></script>

<jsp:include page="../my/bar.jsp"/>
<br><br><br><br><br>

<div class="wrapper">
	<div class="col-7">
		<table class="table table-light table-hover">
			<thead>
				<tr class="table-active">
					<th colspan="6">내 게시물 보기</th>
				</tr>
				<tr>
					<th colspan="5">
						<div class="btn-group" role="group" aria-label="Basic radio toggle button group">
  							<input type="radio" class="btn-check" name="revRad" id="btnradio1" autocomplete="off" onclick="myPost('판매중')" ${postRad == '판매중' ? 'checked': ''}>
  							<label class="btn btn-outline-success" for="btnradio1">판매중</label>

  							<input type="radio" class="btn-check" name="revRad" id="btnradio2" autocomplete="off" onclick="myPost('거래완료')" ${postRad == '거래완료' ? 'checked': ''}>
  							<label class="btn btn-outline-success" for="btnradio2">거래완료</label>
  							
   							<input type="radio" class="btn-check" name="revRad" id="btnradio3" autocomplete="off" onclick="myPost('숨김')" ${postRad == '숨김' ? 'checked': ''}>
  							<label class="btn btn-outline-success" for="btnradio3">숨김</label>
						</div>
					</th>
					<th><a href="goNewPost.do" type="button" class="btn btn-outline-success">게시물 작성</a></th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
			<c:if test="${not empty parray}">
			<c:forEach var="i" items="${parray}">
				<tr>
					<td align="center"><img class="sangImg" src="resources/sang_img/${i.mainPipath}"></td>
					<td align="center"><span class="badge bg-secondary">${i.postState}</span> ${i.postTitle }</td>
		      		<td align="center">${i.postPrice}원</td>
					<td align="center"><img class="likeyImg" src="resources/img/jjim.png">${i.likey}</td>
		      		<td align="center"><img class="viewImg" src="resources/img/view.png">${i.postView}</td>
		      		<td align="center"><a href="goUpdatePost.do?postId=${i.postId}" type="button" class="btn btn-light btn-sm"> 수정 </a></td>
		    	</tr>
		    	</c:forEach>
		    </c:if>
		  	</tbody>
		</table>
		<c:if test="${empty parray}"><br><div class="no">해당 게시물이 없습니다</div></c:if>
	</div>
</div>

<div class="updiv">
	<a href="#"><img src="resources/img/up.png" class="upimg"></a>
</div>

</body>
</html>