<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	alert("에러 발생 \n 다시 시도해 주세요.");
	document.location.href="<c:url value='/main'/>";
</script>