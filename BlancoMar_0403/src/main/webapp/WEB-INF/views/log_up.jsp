<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/userInsert.css">

</head>
<body>

<!-- 

create table user_list( 

//	user_idx INT PRIMARY KEY AUTO_INCREMENT,//인덱스
//	user_id VARCHAR(50) NOT NULL, // 아이디
//	user_password VARCHAR(50) NOT NULL, //패스워드
//	user_name VARCHAR(50) NOT NULL, // 네임
//	user_addres VARCHAR (50) NOT NULL, //주소
//	user_tel VARCHAR(50) NOT NULL,  // 전화
//	user_grade INT NOT NULL DEFAULT 1  //등급
   
)default character set utf8 collate UTF8_GENERAL_CI;


 -->
 <div id="wrap">
	    <header>
            <div id="top">
                <img class="logo" src="${path}/resources/mainimg/logo.png" onclick="location.href='main'">
            </div>
            <nav id="top_nav">
                <ul><!-- 로그인 로그아웃 부분 -->
                	<c:choose>
                		
              
						<c:when test="${sessionScope.loginid ne null}">
							<c:if test="${sessionScope.loginidgrade eq 6}">
								${sessionScope.loginid}님 관리자 로그인을 하셨습니다!
								<li><a href="#">회원관리</a></li>
                    			<li><a href="#">재고관리</a></li>
                    			<li><a href="#">방문자통계</a></li>
							</c:if>
							
							
							<c:if test="${sessionScope.loginidgrade ne 6}">
								${sessionScope.loginid}님 반갑습니다.
								<li><a href="#">ORDER</a></li>
                    			<li><a href="#">MY ACCOUNT</a></li>
                    			<li><a href="#">CART</a></li>
							</c:if>
							 <li><a href="logout">로그아웃</a></li>
						</c:when>
						
						
						<c:otherwise>
							 <li><a href="login">로그인</a></li>
							 <li><a href="#">ORDER</a></li>
                    		<li><a href="#">MY ACCOUNT</a></li>
                   	 		<li><a href="#">CART</a></li>
						</c:otherwise>	
					</c:choose>
                  <!-- 끝나는 부분 -->
                </ul>
            </nav>
	    </header>
        <div id="userinsert">
	
	<div class="contact-us">
		<h1>회원가입</h1>
		<br>
		<form action="insertlogin" method="post">
			<label for="userID">ID</label>
	    	<input id="userID" name="user_id" required type="text" />
	    	<span id="log_upchk"></span>
	    
	    	<label for="userPassword">Password</label>
	    	<input id="userPassword" required type="password" name="user_password" />
	    
	    	<label for="userPassword2">Confirm Password</label>
	    	<input id="userPassword2" required type="password"/>
	    
	    	<label for="userName">Name</label>
	    	<input id="userName" name="user_name" type="text" />
	    
	    	<label for="user_tel">Phone Nember</label>
	    	<input id="user_tel" name="user_tel" type="text" />
	    
	    	<label for="user_addres">Address</label>
	    	<input id="user_addres" name="user_addres" type="text" />
	    
	     	<h3>Please provide all the information about your issue you can.</h3>
	    	<br>
	      	<div class="buttons">
	        	<input class="insertbutton" type="submit" value="회원가입">
	        	<input class="insertbutton" type="button" value="취소" onclick="location.href='login'">  
	      </div>
	  </form>
	</div>
	</div>
        <footer>
            <div id="footer_wrap">
                <div id="footer_address">
                    <pre>
                    KIM EUN JI | 96rladmswl@naver.com | 1111-2222
                    부산광역시 사하구
                    블란코마르 170-06-*****
                    </pre>
                </div>
            </div>
        </footer>
	</div><!-- warp div 끝나는 부분 -->
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
   // 아이디 유효성 검사(1 = 중복 / 0 != 중복)

        $(document).ready(function() {
         $("#userID").keyup(function() {
           
         var user_id = "user_id="+$('#userID').val();
         
      $.ajax({
                type : "POST",
                url: "log_upchk",
                data: user_id,
                dataType: "json",
               success:function(args){
               $("#ss").text(args.result);
            }    
            }) ;
        });
      });
        
      //비밀번호 체크 영어 숫자 특수문자 포함    
   $(function(){
         $('#userPassword').blur(function(){
            var pw = $("#userPassword").val()
            var num = pw.search(/[0-9]/g);
            var eng = pw.search(/[a-z]/ig);
            var spe = pw.search(/[`~!@@#$%^&*|/?]/gi);

            if($("#userPassword").val().length < 6 || $("#userPassword").val().length > 20){
             alert("6자리 ~ 20자리 이내로 입력해주세요.");
             return false;
            }else if(pw.search(/\s/) != -1){
             alert("비밀번호는 공백 없이 입력해주세요.");
             return false;
            }else if(num < 0 || eng < 0 || spe < 0 ){
             alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
             return false;
            }else {
              console.log("통과"); 
               return true;
            }
         })
      });
   
 $(function(){
       //비밀번호 확인
          $('#userPassword2').blur(function(){
             if($('#userPassword').val() != $('#userPassword2').val()){
                 if($('#userPassword2').val()!=''){
                 alert("비밀번호가 일치하지 않습니다.");
                     $('#userPassword2').val('');
                    $('#userPassword2').focus();
                 }
              }
          })        
       });   
   
   
   
   
   </script>
</body>
</html>