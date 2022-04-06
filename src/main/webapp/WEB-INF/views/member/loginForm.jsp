<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	text-align: center;
}

table {
	margin: auto;
	width: 50%;
	height: 150px;
}
</style>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<form:form commandName="loginMemberData">
		<table border="1">
			<tr>
				<td>아이디 : </td>
				<td><form:input path="mId" placeholder="필수입력"/>
				<form:errors path="mId"/></td>
			</tr>

			<tr>
				<td>비밀번호 : </td>
				<td><form:input path="mPassword" type="password" placeholder="필수입력"/>
				<form:errors path="mPassword"/></td>
			</tr>
		
		</table>
		<br>
		${msg}<br><br>
		<input type="submit" value="로그인" />

	</form:form>


		

</body>
</html>