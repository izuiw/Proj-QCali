<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>

	alert("id : ${id}  /  level : ${level}");
	document.location.href="<c:url value='/board/list'/>";
</script>