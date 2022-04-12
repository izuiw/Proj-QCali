<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<style>
ul {
	list-style: none;
	width: 30%;
	display: inline-block;
}

li {
	float: left;
	margin-left: 5px;
}
</style>

<title>Insert title here</title>
</head>
<body>

	<c:if test="${!empty memberLogin}">
		<h2>로그인 성공</h2>
		<table border="1">
			<tr>
				<th>회원 번호</th>
				<th>회원 ID</th>
				<th>회원 닉네임</th>
				<th>회원 생일</th>
				<th>회원 가입 날짜</th>
				<th>회원 인증 여부</th>
				<th>회원 레벨</th>
			</tr>
			<tr>
				<td>${memberLogin.mSeq}</td>
				<td>${memberLogin.mId}</td>
				<td>${memberLogin.mNickname}</td>
				<td>${memberLogin.mBirthday}</td>
				<td>${memberLogin.mRegday}</td>
				<td>${memberLogin.mAuth}</td>
				<td>${memberLogin.mLevel}</td>

			</tr>
		</table>
		<a href="<c:url value='/member/logout'/>"><button>로그아웃</button></a>
		<a href="<c:url value='/board/write/${question.qSeq }'/>"><button>글쓰기</button></a>
		<a href="<c:url value='/board/mylist?mSeq=${memberLogin.mSeq}'/>"><button>내가 쓴 글 모아보기</button></a>
		

	</c:if>
	

	
	<table border="1">
		<tr >
			<td>${question.qContent}</td>
			<td>${question.qSeq}</td>
		</tr>
	</table>
	
	
	
	<c:if test="${empty memberLogin}">
		<a href="<c:url value='/member/login'/>"><button>로그인</button></a>
	</c:if>


	<table border="1">
		<tr>s
			<th>보드seq</th>
			<th>보드제목</th>
			<th>닉네임</th>
			<th>보드 쓴 날짜</th>
			<th>보드 좋아요</th>
			<th>보드 카운트</th>
			<th>멤버seq</th>


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

					<td><a href="<c:url value='/board/detail?bSeq=${list.bSeq}'/>">${list.bTitle}</a>
					
					</td>
					

					<td>${list.mNickname}</td>
					<td>${list.bRegday}</td>
					<td>${list.bLike}</td>
					<td>${list.bCount}</td>
					<td>${list.mSeq}</td>
					
				</tr>

			</c:forEach>

		</c:if>
		<div>
			<ul class="pagination">
				<c:if test="${pageMaker.prev }">
					<li class="pagination_button"><a
						href="<c:url value='/board/list?currentPage=${pageMaker.startPage - 1 }'/>">Previous</a>
					</li>
				</c:if>

				<c:forEach var="currentPage" begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }">
					<li class="pagination_button"><a
						href="<c:url value='/board/list?currentPage=${currentPage }'/>">${currentPage }</a></li>
				</c:forEach>

				<c:if test="${pageMaker.next }">
					<li class="pagination_button"><a
						href="<c:url value='/board/list?currentPage=${pageMaker.endPage + 1 }'/>">Next</a>
					</li>
				</c:if>
			</ul>
		</div>


	</table>
</body>
</html>