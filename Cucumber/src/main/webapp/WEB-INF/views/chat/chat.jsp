<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>채팅 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/chat/chat.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/chat/chat.js"></script>

<jsp:include page="../my/bar.jsp"/>
<br><br><br><br><br>

<div class="wrapper">
<div class="col-6">
<c:if test="${not empty carray}">
<table class="table table-light table-hover">
  <thead>
    <tr class="table-active">
      <th scope="col" colspan="5">나의 채팅</th>
    </tr>
  </thead>
  <tbody class="table-group-divider">
  <c:forEach var="i" items="${carray}">
    <tr>
    	<td><a href="youpage.do?memId=${nickmap[i.chatId].memId}" type="button" class="btn btn-light btn-sm">${nickmap[i.chatId].nick}</a></td>
      <td><c:if test="${not empty pmap[i.postId]}"><img class="sangImg" src="resources/sang_img/${pmap[i.postId]}"></c:if></td>
      <td>${i.chatContent} <c:if test="${cntmap[i.chatId] != 0}"><span class="badge rounded-pill text-bg-success">${cntmap[i.chatId]}</span></c:if></td>
      <td><a href="findChat.do?chatId=${i.chatId}" type="button" class="btn btn-outline-success btn-sm">보기</a></td>
      <td>
      	<button onclick="deletechat(${i.chatId})" type="button" class="btn btn-light btn-sm">X</button>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</c:if>
<c:if test="${empty carray}"><br><div class="no">채팅이 없습니다<br>다른 사람과 거래를 시작해 보세요</div></c:if>
</div>
</div>

<div class="updiv">
	<a href="#"><img src="resources/img/up.png" class="upimg"></a>
</div>

</body>
</html>