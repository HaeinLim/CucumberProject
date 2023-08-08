<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/post/updatePost.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>

	function deleteCheck(){
		var postId = $('#postId').val();
		
		$.ajax({
	         type : 'post',
	         url : "deletePost.do",
	         data : {
	        	 postId : postId
	         },
	         success : function (result) {	
	        	 	if(result == 1){
	        	 		alert("삭제되었습니다.");
	        	 		location.href="myPost.do"
	        	 		
	        	 	}	
	         },
	         error : function() {
	        	 alert("에러");
	 		}   
	     });
	}
	
	

</script>



</head>

<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>


<% HttpSession session1 = request.getSession(); %>
<jsp:include page="../my/bar.jsp"/>
<br><br><br><br><br> 

	<!-- newPost.jsp -->
	
  <div class="wrapper">  
    <form class="good" action="updatePost.do" method="post" enctype="multipart/form-data" name="updatePost">
      <input type="hidden" id="postId" name="postId" value="${postvo.postId}">
      <br><br>
      <h2 align="center">상품 수정</h2>
      <br><br>
      <fieldset>
		<div class="btn-group dropdown">
	      <c:choose>
            <c:when test="${postvo.postState == '판매중' or postvo.postState == '숨김'}">
            <select class="form-select" id="postState"  name="postState" required>
                 <option value="판매중" <c:if test="${postvo.postState eq '판매중'}">selected</c:if>>판매중</option>
                 <option value="숨김" <c:if test="${postvo.postState eq '숨김'}">selected</c:if>>숨김</option>
               </select>
               </c:when>
               <c:otherwise>
               <select class="form-select" id="postState"  name="postState" required>
                    <option value="${postvo.postState}" selected>${postvo.postState}</option>
                  </select>
               </c:otherwise>
         </c:choose>
		</div>
        <div class="form-group">
	      <label class="col-form-label mt-4" for="inputDefault">상품 제목</label>
	      <input type="text" class="form-control" value="${postvo.postTitle}" id="postTitle" name="postTitle" required>
	    </div>
	    
	    <div class="form-group">
	      <fieldset>
            <label class="form-label mt-4" for="readOnlyInput">작성일</label><br>
            <c:set var="postDate" value="${postvo.postDate}" />
	        <input class="form-control" id="readOnlyInput" type="text" value="<fmt:formatDate value="${postDate}" pattern="yy-MM-dd" />" readonly>
	      </fieldset>
	    </div>
	    
	    <div class="form-group">
	      <fieldset>
            <label class="form-label mt-4" for="readOnlyInput">판매자 이름</label>
	        <input class="form-control" id="readOnlyInput" type="text" value="${nick }" readonly>
	      </fieldset>
	    </div>
	    
	    <div class="form-group">
	      <label for="exampleSelect1" class="form-label mt-4">카테고리 선택</label>
	      <select class="form-select" id="cateId"  name="cateId" required>
	        <option value="" selected="selected">--카테고리 선택--</option>
		      <c:forEach var="i" items="${carrary}">
		     	<option value="${i.cateId}" <c:if test="${i.cateId eq postvo.cateId}">selected</c:if>>${i.cateName}</option>
		      </c:forEach>
	      </select>
	    </div>
	    
  		<div class="form-group">
	      <label class="col-form-label mt-4" for="inputDefault">상품가격</label>
	      <input type="number" class="form-control" id="postPrice" name="postPrice" value="${postvo.postPrice}"  required>
	    </div>
  		
        <div class="form-group">
	      <label for="exampleTextarea" class="form-label mt-4">상품 내용</label>
	      <textarea class="form-control" id="postContent" name="postContent" rows="8" required>${postvo.postContent}</textarea>
	    </div>
	    <br><br>
	    <h3>이미지 수정</h3><br>
	    <div>
	      <label>수정 전 이미지</label><br>
	      <br>
		  <img src="resources/sang_img/${postvo.mainPipath }" class="img" onerror="this.style.display='none'"  
		  									onclick="window.open(this.src)">
	      <img src="resources/sang_img/${postvo.pipath2 }" class="img" onerror="this.style.display='none'"  
	      									onclick="window.open(this.src)">
		  <img src="resources/sang_img/${postvo.pipath3 }" class="img" onerror="this.style.display='none'"  
		  									onclick="window.open(this.src)">
	    </div>
	    
	    <input type="hidden" value="${postvo.mainPipath}" id="img1" name="img1">
	    <input type="hidden" value="${postvo.pipath2}" id="img2" name="img2">
	    <input type="hidden" value="${postvo.pipath3}" id="img3" name="img3">
	    

	    <div class="form-group">
	      <label for="formFile" class="form-label mt-4">메인 상품이미지</label>
	      <input class="form-control" type="file" id="upload" name="upload" required />
	    </div> 
	    
	    <div class="form-group">
	      <label for="formFile" class="form-label mt-4">상품이미지1</label>
	      <input class="form-control" type="file" id="upload" name="upload" required/>
	    </div>
	    
	    <div class="form-group">
	      <label for="formFile" class="form-label mt-4">상품이미지2</label>
	      <input class="form-control" type="file" id="upload" name="upload" required />
	    </div>
	    
	    
      </fieldset>
      <br><br>
  	  <div class="button1" align="center">
	      <button type="submit" class="btn btn-success" >&nbsp;&nbsp;입력&nbsp;&nbsp;</button>
	      <button type="button" class="btn btn-danger" id="btn1" onclick="deleteCheck()">&nbsp;&nbsp;삭제&nbsp;&nbsp;</button>
      </div>
      <br><br><br>
    </form>
   
  </div> 
  
  
  
</body>
</html>