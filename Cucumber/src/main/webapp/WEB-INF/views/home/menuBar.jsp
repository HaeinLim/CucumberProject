<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<style>
.a1:hover, .a1:visited, .a1:active, .a1:link {
		text-decoration : none;
		color : black;
		margin-bottom:5px;
}
.a2:hover, .a2:visited, .a2:active, .a2:link {
		text-decoration : none;
		color : white;
}
#d3 {
	margin-top: 10px;
}
</style>
<script>
	function searchCheck() {
		if (document.searchForm.keyword.value == "") {
			alert("검색어가 입력되지 않았습니다")
			return false;
		}
		return true;
	}
</script>
</head>
<body>

	<nav class="navbar fixed-top" style="background-color: lightgreen;">
		<div class="container-fluid d-flex justify-content-end">
			<c:choose>
				<c:when test="${empty sesId}">
					<a href="login.do" class="a1"><img alt="login" src="resources/img/login.png"></a>
					<span style="color: black;"> ㅣ </span>
					<a href="join.do" class="a1">회원가입</a>
				</c:when>
				<c:when test="${sesAd == 'admin'}">
					<a href="adminPage.do" class="a1">관리자페이지</a>
					<span style="color: white;"> ㅣ </span>
					<a href="logout.do" class="a1"><img alt="logout" src="resources/img/MainLogout.png"></a>
				</c:when>
				<c:otherwise>
					<a href="mypage.do" class="a1"><img alt="mypage" src="resources/img/MainMypage.png"></a>
					<span style="color: black;"> ㅣ </span>
					<a href="logout.do" class="a1"><img alt="logout" src="resources/img/MainLogout.png"></a>
				</c:otherwise>
			</c:choose>
		</div>

		<div class="container-fluid d-flex justify-content-start"
			style="background-color: white;">
			<a class="navbar-brand" href="main.do"> <img
				src="resources/img/cucumMain.png" alt="cucumber" width="50pt"
				height="50pt">
			</a> <span class="navbar-text"> 중고거래는 오이나라에서 </span>
		</div>
		<div class="container-fluid" id="d3">
		<div class="d-flex justify-content-start">
			<div class="btn-group">
				<button type="button" class="btn btn-success"
					style="background-color: white; color: black;">
					<c:choose>
						<c:when test="${cri.cateId == 0}">카테고리</c:when>
						<c:otherwise>
							<c:forEach var="i" items="${carray }">
								<c:if test="${cri.cateId == i.cateId}">${i.cateName}</c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</button>
				<button type="button"
					class="btn btn-success dropdown-toggle dropdown-toggle-split"
					data-bs-toggle="dropdown" aria-expanded="false"
					style="background-color: green;">
					<span class="visually-hidden">Toggle Dropdown</span>
				</button>
				<ul class="dropdown-menu">
					<c:forEach var="i" items="${carray }">
						<li><a class="dropdown-item"
							href="main.do?cateId=${i.cateId }">${i.cateName }</a></li>
					</c:forEach>
				</ul>
			</div>
			&nbsp;&nbsp;
			<div id="radiobtn" class="btn-group" role="group" aria-label="Basic radio toggle button group">
				<input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" ${cri.order == 'new'? 'disabled': ''}> 
					<label class="btn btn-success" for="btnradio1"><a class="a2" href="main.do?pageNum=${cri.pageNum }&cateId=${cri.cateId }&keyword=${cri.keyword}&order=${'new'}&ch=${'ch1' }">최신순</a></label> 
				<input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off" ${cri.order == 'hot'? 'disabled': ''}> 
					<label class="btn btn-success" for="btnradio2"><a class="a2" href="main.do?pageNum=${cri.pageNum }&cateId=${cri.cateId }&keyword=${cri.keyword}&order=${'hot'}&ch=${'ch2' }">인기순</a></label>
			</div> 
			</div>
				<form action="main.do" class="d-flex" role="search"
					name="searchForm" onsubmit="return searchCheck()">
					 <c:choose>
						<c:when test="${cri.keyword != null and cri.keyword !='' }">
							<input class="form-control me-2" type="search" name="keyword"
								value="${cri.keyword }" maxlength="30" aria-label="Search">
						 </c:when>
						<c:otherwise>
							<input class="form-control me-2" type="search" name="keyword"
								placeholder="오늘의 검색" maxlength="30" aria-label="Search">
						</c:otherwise>
					</c:choose> 
					<input type="hidden" name="pageNum" value="${cri.pageNum }">
					<input type="hidden" name="cateId" value="${cri.cateId }">
					<input type="hidden" name="order" value="${cri.order }">
					<button class="btn btn-outline-success" type="submit">search</button>
				</form>
			</div>
	</nav>
</body>
</html>