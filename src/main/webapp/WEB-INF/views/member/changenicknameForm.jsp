<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
	<script type="text/javascript">

	  function nickCheck() {
	        $.ajax({
	            url : "/exam/member/nicknameDup",
	            type : "POST",
	            dataType :"JSON",
	            data : {"memberNickname" : $("#memberNickname").val()},
	            success : function (data) {
	                if(data == 1) {
	                	
	                	document.getElementById('nickSame').innerHTML='사용할 수 없는 닉네임 입니다.';
				        document.getElementById('nickSame').style.color='red';
	                } else if (data == 0) {
	                    document.getElementById('nickSame').innerHTML='사용 가능한 닉네임 입니다.';
			            document.getElementById('nickSame').style.color='blue';
	                }
	                
	 
	                $("#insertData").prop("disabled", false);
	            }

	        })
	    }


	</script>
<body>


<h3>닉네임 변경</h3> 

현재 닉네임 : ${memberLogin.memberNickname} <br>
<form action="${pageContext.request.contextPath}/member/mypage/changeNickname" method="POST" >

<table border="1">

		<tr>
			<th>닉네임</th><td><input type="text" name="memberNickname" id="memberNickname"
				required maxlength="10" size="20" />
						<button type="button" onclick="nickCheck()">중복확인</button>
				<br>
			<label for="memberNickname">변경할 닉네임을 10자 이내로 작성해주세요.</label>
			
	

			<span id="nickSame"></span>
			</td>
		</tr>

	</table>
	
	<br>
	<input type="submit" value="닉네임 변경하기" id="insertData" disabled>
</form>




</body>
</html>