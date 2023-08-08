<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/detail/detail.css">
<title>${pdetail.postTitle }</title>
<script>
	function qnaCheck() {
		if (document.qnaForm.qnaContent.value == "") {
			alert("문의가 입력되지 않았습니다")
			return false;
		}
		return true;
	}
	
	function replyCheck() {
		if (document.replyForm.qnaContent.value == "") {
			alert("답변이 입력되지 않았습니다")
			return false;
		}
		return true;
	}
	
	function reportCheck() {
		if (confirm('정말 신고하시겠습니까?') == true) {
			alert("신고되었습니다");
		} else {
			return false;
		}
	}
</script>
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/resources/js/detail/likey.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<%@include file="detailBar.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<!-- https://slowrecode.tistory.com/6 찜 참고 -->

	<article id="postContent">
		<div class="row">
			<div class="col"></div>
			<div class="col-6">
				<section id="postImg">
					<img alt="thumnail" src="resources/sang_img/${pdetail.mainPipath }"
						class="thumnail">
				</section>

				<section id="profile">
					<p class="h5"><a href="youpage.do?memId=${pdetail.memId }" class="goProfile">${findMem.nick }</a>
						<c:choose>
							<c:when test="${pdetail.postState eq '거래완료' }"></c:when>
							<c:when test="${sesId == pdetail.memId }"></c:when>
							<c:otherwise>
								<span><a href="insertChat.do?postId=${pdetail.postId }"><img src="resources/img/detChat.png"></a></span>
							</c:otherwise>
						</c:choose>
					</p>
					<p class="sub">${pdetail.postState }</p>
				</section>

				<section id="content">
					<c:choose>
						<c:when test="${sesId == pdetail.memId }">
							<div class="upre" align=right>
								<a class="btn btn-outline-success"
									href="goUpdatePost.do?postId=${pdetail.postId }" role="button">수정</a>
							</div>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${not empty rpvo }">
									<div class="upre" align=right>
										<button type="button" class="btn btn-danger" disabled>신고완료</button>
									</div>
								</c:when>
								<c:otherwise>
									<form action="reportPost.do?postId=${pdetail.postId }"
										method="post" onsubmit="return reportCheck()">
										<div class="upre" align=right>
											<button type="button" class="btn btn-outline-danger"
												data-bs-toggle="modal" data-bs-target="#reportModal"
												data-bs-whatever="postreport">신고하기</button>
										</div>
										<div class="modal fade" id="reportModal" tabindex="-1"
											aria-labelledby="reportModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h1 class="modal-title fs-5" id="reportModalLabel">신고하기</h1>
														<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" ></button>
													</div>
													<div class="modal-body">
														<form>
															<div class="mb-3">
																<label for="message-text" class="col-form-label">신고사유:</label>
																<textarea class="form-control" id="message-text" name="postReportContent"></textarea>
															</div>
														</form>
													</div>
													<div class="modal-footer">
														<button type="reset" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
														<input class="btn btn-outline-danger" type="submit" value="신고하기">
													</div>
												</div>
											</div>
										</div>
									</form>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>

					<p class="h5" id="postT">${pdetail.postTitle }</p>
					<p class="h5">${pdetail.postPrice }원</p>

					<img alt="content1" src="resources/sang_img/${pdetail.pipath2 }" class="imgcontent"
						onerror="this.style.display='none'" onclick="window.open(this.src)"> 
					<img alt="content2" src="resources/sang_img/${pdetail.pipath3 }" class="imgcontent"
						onerror="this.style.display='none'" onclick="window.open(this.src)"><br>

					<p class="written">${pdetail.postContent }</p>
					
					<p class="sub">찜 <span id="pl">${pdetail.likey }</span> * 조회수 ${pdetail.postView }</p>

					<p class="likes"> 
						<c:if test="${likey == 0 }">
							<p class="like">
								<img alt="likey1" src="resources/img/likey.svg" class="l1" id="likey1"  onclick="likey(${pdetail.postId})">
							</p>
						</c:if>
						<c:if test="${likey == 1 }">
							<p class="like">
								<img alt="likey2" src="resources/img/filledlikey.svg" class="l1" id="likey2"  onclick="likey(${pdetail.postId})">
							</p>
						</c:if>
					</p>
				</section>
				
				<section id="qna">
					<p class="h5" id="qnask">문의</p>
					<form action="insertQna.do" method="post" name="qnaForm" onsubmit="return qnaCheck()">
						<div class="input-group mb-3">
							<input type="text" class="form-control" name="qnaContent"
								placeholder="궁금한 걸 문의하세요" aria-label="Recipient's username"
								aria-describedby="button-addon2">
							<button class="btn btn-outline-success" type="submit"
								id="button-addon2">등록</button>
						</div>

						<input type="hidden" name="memId" value="${sesId }"> <input
							type="hidden" name="postId" value="${pdetail.postId}"> <input
							type="hidden" name="depth" value="0">
					</form>

					<br>
					
					<c:if test="${not empty qarray }">
						<div class="qnalist">
							<c:forEach var="i" items="${qarray }">
								<table class="table">
									<tr class="table-success">
										<td>
										<div class="row justify-content-between">
											<div class="col-11">
											문의드려요) ${i.qnaContent }
											<p class="nick">
												(${i.getNick() }(이)가 작성함,
												<fmt:formatDate value="${i.qnaDate}" pattern="yy.MM.dd H:mm"
													type="date" />
												)
												<a href="reportQna.do?qnaId=${i.qnaId }&postId=${i.postId}" class="reportQna" onclick="return reportCheck()"><img src="resources/img/QnaReport.png"></a>
											</p>
											</div>
    										<div class="col">
												<c:if test="${i.memId == sesId}"><button onclick="delQna(${i.qnaId}, ${pdetail.postId},0)" type="button" class="btn btn-outline-success btn-sm">X</button></c:if>
										    </div>
										</div>

												
										</td>
									</tr>
									<c:forEach var="j" items="${qrmap[i.bundleId] }">
										<tr>
											<td>
											<div class="row justify-content-between">
												<div class="col-11">
													<img alt="reply" src="resources/img/reply.png">&nbsp;
														${j.qnaContent }
														<p class="nick">
															(${j.getNick() }(이)가 작성함,
															<fmt:formatDate value="${j.qnaDate}" pattern="yy.MM.dd H:mm"
																type="date" />
															)
														</p>
														<a href="reportQna.do?qnaId=${j.qnaId }&postId=${j.postId}" class="reportQna"  onclick="return reportCheck()"><img src="resources/img/QnaReport.png"></a>	
												</div>
												<div class="col">
													<c:if test="${j.memId == sesId}"><button onclick="delQna(${j.qnaId}, ${pdetail.postId},1)" type="button" class="btn btn-outline-success btn-sm">X</button></c:if>
										    	</div>
											</div>
											</td>
										</tr>
									</c:forEach>
									<tr>
										<td>
											<form action="insertQnaReply.do" method="post" name="replyForm" onsubmit="return replyCheck()">
												<div class="input-group mb-3">
													<input type="text" class="form-control" name="qnaContent"
														placeholder="문의 내용에 답변을 달아보세요"
														aria-label="Recipient's username"
														aria-describedby="button-addon2">
													<button class="btn btn-outline-success" type="submit"
														id="button-addon2">등록</button>
												</div>
	
												<input type="hidden" name="memId" value="${sesId }">
												<input type="hidden" name="postId" value="${pdetail.postId }">
												<input type="hidden" name="depth" value="1"> 
												<input type="hidden" name="bundleId" value="${i.qnaId }">
											</form>
										</td>
									</tr>
								</table>
							</c:forEach>
						</div>
					</c:if>
					<c:if test="${empty qarray }">
						<div class="no">문의글이 없습니다 <br>첫 문의글을 작성해보세요</div>
					</c:if>
				</section>
			</div>
			<div class="col"></div>
		</div>
					<br><br>
	</article>
	<br>
</body>
</html>