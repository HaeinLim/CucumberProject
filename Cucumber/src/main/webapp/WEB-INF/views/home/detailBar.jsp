<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.a1 {
	text-decoration: none;
	color: black;
	margin-bottom: 5px;
}

.a2 {
	text-decoration: none;
	color: white;
}

#d3 {
	margin-top: 10px;
}
</style>
</head>
<body>
	<nav class="navbar fixed-top" style="background-color: lightgreen;">
		<div class="container-fluid d-flex justify-content-end">
			<c:choose>
				<c:when test="${empty sesId and empty sesAd}">
					<a href="login.do" class="a1"><img alt="login"
						src="resources/img/login.png"></a>
					<span style="color: black;"> ㅣ </span>
					<a href="join.do" class="a1">회원가입</a>
				</c:when>
				<c:when test="${sesAd == 'admin' }">
					<a href="adminPage.do" class="a1">관리자페이지</a>
					<span style="color: white;"> ㅣ </span>
					<a href="logout.do" class="a1"><img alt="logout" src="resources/img/MainLogout.png"></a>
				</c:when>
				<c:otherwise>
					<a href="mypage.do" class="a1"><img alt="mypage"
						src="resources/img/MainMypage.png"></a>
					<span style="color: black;"> ㅣ </span>
					<a href="logout.do" class="a1"><img alt="logout"
						src="resources/img/MainLogout.png"></a>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="container-fluid d-flex justify-content-start" style="background-color:white;">
			<a class="navbar-brand" href="main.do"> 
			<img src="resources/img/cucumMain.png" alt="cucumber" width="50pt" height="50pt">
			</a> <span class="navbar-text"> 중고거래는 오이나라에서 </span>
		</div>
	</nav>
</body>
</html>