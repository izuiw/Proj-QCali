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

	function pwCheck() {

	    if(document.getElementById('mPassword').value!='' && document.getElementById('mPasswordCheck').value!='') {
	        if(document.getElementById('mPassword').value==document.getElementById('mPasswordCheck').value) {
	            document.getElementById('pwSame').innerHTML='비밀번호가 일치합니다.';
	            document.getElementById('pwSame').style.color='blue';
	        }
	        else {
	            document.getElementById('pwSame').innerHTML='비밀번호가 일치하지 않습니다.';
	            document.getElementById('pwSame').style.color='red';
	        }
	    }
	}

	
/* 	  function fn_idDup() {
	        $.ajax({
	            url : "/exam/member/idDup",
	            type : "POST",
	            dataType :"JSON",
	            data : {"mId" : $("#mId").val()},
	            success : function (data) {
	                if(data == 1) {
	                    alert("중복된 이메일입니다.");
	                } else if (data == 0) {
	                    $("#idDup").attr("value", "Y");
	                    alert("사용 가능한 이메일입니다.")
	                }
	            }

	        })
	    } */

		function idCheck() {
			var str = document.getElementById('mId').value;
			var pattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
		  	  if(!pattern.test(str)) {
			  		document.getElementById('idSame').innerHTML='형식에 맞게 입력하세요.';
			  	      document.getElementById('idSame').style.color='red';
			  	  } else{
			  		  document.getElementById('idSame').innerHTML='';
						$.ajax({
				            url : "/exam/member/idDup",
				            type : "POST",
				            dataType :"JSON",
				            data : {"mId" : $("#mId").val()},
				            success : function (data) {
				                if(data == 1) {
				                	document.getElementById('idSame').innerHTML='사용할 수 없는 이메일 입니다.';
							        document.getElementById('idSame').style.color='red';
				                } else if (data == 0) {		           
						            document.getElementById('idSame').innerHTML='사용 가능한 이메일 입니다.';
						            document.getElementById('idSame').style.color='blue';
				                }
				            }

				        })
			  	  }    	
			

		   
		}

	    
	  
	  function nickCheck() {
	        $.ajax({
	            url : "/exam/member/nicknameDup",
	            type : "POST",
	            dataType :"JSON",
	            data : {"mNickname" : $("#mNickname").val()},
	            success : function (data) {
	                if(data == 1) {
	                	document.getElementById('nickSame').innerHTML='사용할 수 없는 닉네임 입니다.';
				        document.getElementById('nickSame').style.color='red';
	                } else if (data == 0) {
	                    document.getElementById('nickSame').innerHTML='사용 가능한 닉네임 입니다.';
			            document.getElementById('nickSame').style.color='blue';
	                }
	            }

	        })
	    }

	  function dateCheck(){
	  var str = document.getElementById('mBirthday').value;
	  var pattern = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/;
	  if(!pattern.test(str)) {
		document.getElementById('date').innerHTML='형식에 맞게 입력하세요.';
	      document.getElementById('date').style.color='red';
	  } else{
		  document.getElementById('date').innerHTML='';
	  }
	  }
	</script>
<body>


회원가입 양식
<form:form commandName="InsertCommand" action="${pageContext.request.contextPath}/member/insert" id="insertForm" >

<table border="1">
		<tr>
			<th>이메일</th><td><form:input path="mId" id="mId" placeholder="이메일 입력  "/><form:errors path="mId"/>
				<button type="button" onclick="idCheck()">아이디 중복확인</button>
				<span id="idSame"></span>
				</td>
		</tr>
		<tr>
			<th>비밀번호</th><td><form:password path="mPassword" id="mPassword"/><form:errors path="mPassword"/></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th><td><form:password path="mPasswordCheck" id="mPasswordCheck"/><form:errors path="mPasswordCheck"/>
			<button type="button" onclick="pwCheck()"> 비밀번호 확인 </button>
			<span id="pwSame"></span>
		</td>
		</tr>
		<tr>
			<th>닉네임</th><td><form:input path="mNickname" id="mNickname"/><form:errors path="mNickname"/>
			<button type="button" onclick="nickCheck()"> 닉네임 중복확인 </button>
			<span id="nickSame"></span>
			</td>
		</tr>
		<tr>
			<th>생년월일</th><td><form:input path="mBirthday" id="mBirthday" placeholder="yyyy-mm-dd" onchange="dateCheck()"/><form:errors path="mBirthday"/>
			
			<span id="date"></span>
			</td>
		</tr>
		
	</table>
	<br>
	<input type="submit" value="회원가입" >
</form:form>

</body>
</html>