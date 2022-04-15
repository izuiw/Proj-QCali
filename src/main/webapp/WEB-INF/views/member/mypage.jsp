<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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


	<a href="<c:url value='/member/mypage/changePwd?mSeq=${memberLogin.mSeq}'/>"><button>비밀번호 변경하기</button></a>
	<a href="<c:url value='/member/mypage/changeNickname?mSeq=${memberLogin.mSeq}'/>"><button>닉네임 변경하기</button></a>
	<a href="<c:url value='/board/mylist?mSeq=${memberLogin.mSeq}'/>"><button>내가 쓴 글 모아보기</button></a>
	
	<a href="<c:url value='/member/logout'/>"><button>로그아웃</button></a>
	
	<a href="<c:url value='/member/mypage/delete?mSeq=${memberLogin.mSeq }'/>" ><button>회원탈퇴</button></a>
	

	

	</c:if>
	<c:if test="${empty memberLogin}">
		<script>
	alert("로그인 정보가 없습니다.");
	document.location.href="<c:url value='/member/login'/>";
</script>
	</c:if>

	
</body>
</html>