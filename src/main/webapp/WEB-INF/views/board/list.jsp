<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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


	</table>
</body>
</html>