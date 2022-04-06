<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${!empty member}">
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
				<td>${member.mSeq}</td>
				<td>${member.mId}</td>
				<td>${member.mNickname}</td>
				<td>${member.mBirthday}</td>
				<td>${member.mRegday}</td>
				<td>${member.mAuth}</td>
				<td>${member.mLevel}</td>

			</tr>
		</table>
		<a href="<c:url value='/member/logout'/>"><button>로그아웃</button></a>
	</c:if>
	<form:form commandName="boardEditData">
		<table border="1">
			<tr>
				<td><form:label path="bTitle">제목</form:label></td>
				
				<td><form:input path="bTitle"/> 
				<form:errors path="bTitle" /></td>

			</tr>
			<tr>
				<td>내용</td>
				<td><form:input path="bContent" label="${ bContent}"/> 
				<form:errors path="bContent" /></td>

			</tr>
		</table>

		
		<input type="submit" value="글쓰기" />
	</form:form>

</body>
</html>