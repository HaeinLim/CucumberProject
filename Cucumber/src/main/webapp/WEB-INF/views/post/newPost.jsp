<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/post/newPost.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">

<title>newPost</title>

</head>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
 
  <% HttpSession session1 = request.getSession(); %>
<jsp:include page="../my/bar.jsp"/>
<br><br><br><br><br>  

	<!-- newPost.jsp -->
	
  <div class="wrapper">  
    <form class="good" action="insertPost.do" method="post" enctype="multipart/form-data" name="insertPost">
      <br><br>
      <h2 align="center">상품 등록</h2>
      <fieldset>
        <div class="form-group">
	      <label class="col-form-label mt-4" for="inputDefault">상품 제목</label>
	      <input type="text" class="form-control" placeholder="상품 제목을 입력해주세요" id="postTitle" name="postTitle" required>
	    </div>
	    
	    <div class="form-group">
	      <fieldset>
            <label class="form-label mt-4" for="readOnlyInput">작성일</label><br>
	        <c:set var="postDate" value="<%=new java.util.Date()%>" />
	        <input class="form-control" id="readOnlyInput" type="text" placeholder="<fmt:formatDate value="${postDate}" pattern="yy-MM-dd" />" readonly>
	      </fieldset>
	    </div>
	    <%-- <%=session1.getAttribute("sesId")%> --%>
	    <div class="form-group">
	      <fieldset>
            <label class="form-label mt-4" for="readOnlyInput">판매자 이름</label>
	        <input class="form-control" id="readOnlyInput" type="text" placeholder="${nick }" readonly>
	      </fieldset>
	    </div>
	    
	    <div class="form-group">
	      <label for="exampleSelect1" class="form-label mt-4">카테고리 선택</label>
	      <select class="form-select" id="cateId"  name="cateId" required>
	        <option value="" selected="selected">--카테고리 선택--</option>
		      <c:forEach var="i" items="${carrary}">
		     	<option value="${i.cateId}">${i.cateName}</option>
		      </c:forEach>
	      </select>
	    </div>
	    
  		<div class="form-group">
	      <label class="col-form-label mt-4" for="inputDefault">상품가격</label>
	      <input type="number" class="form-control" id="postPrice" name="postPrice" placeholder="상품가격을 입력해주세요"  required>
	    </div>
  		
        <div class="form-group">
	      <label for="exampleTextarea" class="form-label mt-4">상품 내용</label>
	      <textarea class="form-control" id="postContent" name="postContent" rows="8" required></textarea>
	    </div>
	    
	    <div class="form-group">
	      <label for="formFile" class="form-label mt-4">메인 상품이미지</label>
	      <input class="form-control" type="file" id="upload" name="upload" required/>
	    </div> 
	    
	    <div class="form-group">
	      <label for="formFile" class="form-label mt-4">상품이미지</label>
	      <input class="form-control" type="file" id="upload" name="upload"  required/>
	    </div>
	    
	    <div class="form-group">
	      <label for="formFile" class="form-label mt-4">상품이미지</label>
	      <input class="form-control" type="file" id="upload" name="upload"  required/>
	    </div>
	    
      </fieldset>
      <br><br>
  	  <div class="button1" align="center">
	      <button type="submit" class="btn btn-success" >&nbsp;&nbsp;입력&nbsp;&nbsp;</button>
	      <button type="reset" class="btn btn-success">&nbsp;&nbsp;취소&nbsp;&nbsp;</button>  
      </div>
      <br><br>
    </form>
  </div> 
 
	
	
	

</body>
</html>