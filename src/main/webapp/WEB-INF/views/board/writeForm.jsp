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

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js">
var ckeditor_config = {

	      resize_enaleb : false,

	      enterMode : CKEDITOR.ENTER_BR,

	      shiftEnterMode : CKEDITOR.ENTER_P,

	      filebrowserUploadUrl : "/board/ckUpload"

	      };



	출처: https://ninedc.tistory.com/54 [기록하고 나누는 행복]
</script>
</head>
<body>



	<form:form commandName="boardData">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><form:input path="boardTitle" placeholder="8자리 숫자 입력" /> 
				<form:errors path="boardTitle" /></td>

			</tr>
			<tr>
				<td>내용</td>
				<td><form:textarea path="boardContent" /> 
				<script type="text/javascript">
					CKEDITOR.replace("boardContent", ckeditor_config);
				</script>
				
				<form:errors path="boardContent" /></td>

			</tr>
		</table>

		<input type="hidden" name="questionSeq" value="${questionSeq}" />
		<input type="submit" value="글쓰기" />
	</form:form>

</body>
</html>