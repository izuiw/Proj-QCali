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
		<a href="<c:url value='/board/write'/>"><button>글쓰기</button></a>


	</c:if>

	<table border="1">
		<tr>
			<th>보드seq</th>
			<th>보드제목</th>
			<th>보드내용</th>
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

					<td>${list.bTitle}</td>
					<td>${list.bContent}</td>

					<td>${list.mNickname}</td>
					<td>${list.bRegday}</td>
					<td>${list.bLike}</td>
					<td>${list.bCount}</td>
				</tr>

				<div style="text-align: right;">
					<a class="text-dark heart" style="text-decoration-line: none;">
					
					<button id="heart" >좋아요</button>
					<img id="heart" src="">
					</a>
				</div>




				<c:if test="${!empty my}">

					<a href="<c:url value='/board/edit?bSeq=${list.bSeq}'/>"><button>글
							수정</button></a>

					<input type="button" value="글 삭제"
						onclick="window:location='<c:url value='/board/delete?bSeq=${list.bSeq}'/>'" />

				</c:if>
			</c:forEach>



		</c:if>


	</table>
	
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
    $(document).ready(function () {

        var heartval = ${heart};

        if(heartval>0) {
            console.log(heartval);
           // $("#heart").prop("src", "static/images/like2.png");
            $(".heart").prop('name',heartval)
        }
        else {
            console.log(heartval);
            //$("#heart").prop("src", "static/images/like1.png");
            $(".heart").prop('name',heartval)
        }

        $(".heart").on("click", function () {

            var that = $(".heart");

            var sendData = {'bSeq' : '${bSeq}','heart' : that.prop('name')};
            $.ajax({
                url :'/board/heart',
                type :'POST',
                data : sendData,
                success : function(data){
                    that.prop('name',data);
                    if(data==1) {
                      //  $('#heart').prop("src","/images/like2.png");
                    }
                    else{
                       // $('#heart').prop("src","/images/like1.png");
                    }


                }
            });
        });
    });
</script>
</body>
</html>