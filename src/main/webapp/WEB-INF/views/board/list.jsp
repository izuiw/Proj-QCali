<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script>
		$(document).ready(function() {
			var listForm = $("#listForm");
			
			$(".pagination_button a").on("click", function(e) {
				e.preventDefault();
				
				listForm.find("input[name='pageNum']").val($(this).attr("href"));
				listForm.submit();
			});
		});
	</script>
<meta charset="UTF-8">

	<style>
		ul {
			list-style: none;
			width : 30%;
			display: inline-block;
		}
		
		li {
			float: left;
			margin-left : 5px;
		}
	</style>

<title>Insert title here</title>
</head>
<body>
	<h2>ㄱㄷ</h2>

	<table border="1">
		<tr>
			<th>보드seq</th>
			<th>보드제목</th>
			<th>닉네임</th>
			<th>보드 쓴 날짜</th>
			<th>보드 좋아요</th>
			<th>보드 카운트</th>


		</tr>
		<c:if test="${ empty list}">
			<tr>
				<td colspan="7">게시판에 저장된 글이 없습니다.</td>
			</tr>
		</c:if>

		<c:if test="${ !empty list}">
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.bSeq}</td>

					<td><a href="<c:url value='/board/detail/${list.bSeq }'/>">${list.bTitle}</a></td>

					<td>${list.mNickname}</td>
					<td>${list.bRegday}</td>
					<td>${list.bLike}</td>
					<td>${list.bCount}</td>
				</tr>

			</c:forEach>

		</c:if>
		<div>
			<ul class="pagination">
				<c:if test="${pageMaker.prev }">
					<li class="pagination_button">
						<a href="${pageMaker.startPage - 1 }">Previous</a>
					</li>
				</c:if>
				
				<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
					<li class="pagination_button">
						<a href="<c:url value='/board/list/${num }'/>">${num }</a>
					</li>
				</c:forEach>
				
				<c:if test="${pageMaker.next }">
					<li class="pagination_button">
						<a href="${pageMaker.endPage + 1 }">Next</a>
					</li>
				</c:if>
			</ul>
		</div>


	</table>
</body>
</html>