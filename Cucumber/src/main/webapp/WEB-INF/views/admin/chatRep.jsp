<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>채팅 신고 조회</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/chatRep.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/admin/chatRep.js"></script>

<jsp:include page="../admin/bar.jsp"/>
<br><br><br><br><br>

<div class="wrapper">
	<div class="col-5">
		<table class="table table-light table-hover">
			<thead>
				<tr class="table-active">
					<th colspan="3">채팅 신고</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
			<c:if test="${not empty carray}">
			<c:forEach var="i" items="${carray}">
				<tr class="pp">
					<td align="center" rowspan="2"><img class="sangImg" src="resources/chat_report/${i.chatReportPipath}"></td>
		      		<td align="center"><b>신고내용</b><br>${i.chatReportContent}</td>
		      	</tr>
		      	<tr>
		      		<td align="center" class="table-active"> 
		      			<button  class="btn btn-danger btn-sm" onclick="repMem(${i.chatReported})">회원 경고</button>
						<button  class="btn btn-warning btn-sm" onclick="delRepChat(${i.chatReportId})">신고 삭제</button>
					</td>		      		
		    	</tr>
		    	</c:forEach>
		    	</c:if>
		  	</tbody>
		</table>
		<c:if test="${empty carray}"><br><div class="no">채팅 신고가 없습니다</div></c:if>
	</div>
</div>



<div class="updiv">
	<a href="#"><img src="resources/img/up.png" class="upimg"></a>
</div>

</body>
</html>