<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/main.css">

</head>
<body>
	<div id="wrap">
	<!-- 로그인 로그아웃 부분 -->
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
								<li><a href="listreg">재고등록</a></li>
								<li><a href="readtest">회원관리</a></li>
                    			<li><a href="dresslist">재고관리</a></li>
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
	    <!-- 사이드 메뉴바 부분 -->
	    <div id="content">
	    	<div id="left_side">
	    		<ul class="category">
	    			<li><a href="sideAll">All</a></li>
	    			<li ><a href="sideOuter">Outer</a></li>
	    			<li ><a href="sideTop">Top</a></li>
	    			<li ><a href="sidePants">Pants</a></li>
	    			<li><!-- warp div 끝나는 부분 --></li>
	    			<li ><a href="notice_list">Notice</a></li>
	    			<li ><a href="#">Q&A</a></li>
	    			<li ><a href="review_list">Review</a></li>
				</ul>
            </div>
            <!--main-->
			<div id="main">
				<div class="wrapper">
					<div class="detaileddescription">
						<div id= "detaileddescription_text">
							<br>
							- 큰 카라, 어깨의 퍼프가 포인트인 셔츠입니다.<br>
							<br>
							- 과하지 않은 어깨퍼프로 밋밋한 코디에 포인트가
							<br> 될 수 있습니다.
							<br>
							<br>
							- 면 100% 제품으로 피부가 예민하신 분들도
							<br> 이너 없이 셔츠만 입으셔도 거부감 없이 부드러운
							<br>촉감을 느끼실 수 있습니다.
							<br>
							<br>
							ㅡ<br>
							SIZE - ONE(단면기준/CM)<br>
							어깨 43/ 가슴 55/ 소매길이 53/ 총장 64<br>
							(측정 방식에 따라 1~3 cm 오차가<br>
							존재할 수 있습니다.)
							<br>
							<br>
							ㅡ<br>
							MODEL SIZE<br>
							Height 164cm/ top S,M/ buttom 26/ Shoe 235mm<br>
							<br>
							ㅡ<br>
							MATERIALS<br>
							COTTON 100%
						</div>
                	</div>
                   	<div class="detailpurchase">
                   		<div id= "detailpurchaseinform">
                   			<p id="informp"> PUFF SHIRT(Sky-Blue)<br>
                   			250,000 KRW<br> </p>
                   			<br>
                   			<br>
                   			<hr>
                   			<select class="select">
	                   			<option> [필수]&nbsp;&nbsp; CHOOSE A COLOR &nbsp;&nbsp;&nbsp;</option>
	                   			<option value="**" disabled link_image="">------------------------------------</option>
	                   			<option>Sky-Blue</option>
                            </select> 
                            <br>
                            <select class="select">
                            	<option> [필수]&nbsp;&nbsp; SELECT A SIZE &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
                                <option value="**" disabled link_image="">------------------------------------</option>
                                <option>One Size (free)</option>
                            </select>
                            <br>
                            <br>
                            <br>
                            <br>
                            TOTAL : 0 KRW (0개)
                            <br>
                            <br>
                            <hr>
                            <br>
                            <br>
                            <input class="button" type="button" value="ADD TO CART">
                            <br>
                            <input class="buttony" type="button" value="BUY NOW">
                        </div>
                    </div>
                    <div class="detailimage">
                    	<img class="detailimg" src="sh1.jpg" alt="">
                    	<img class="detailimg" src="sh2.jpg" alt="">
                    </div>
                </div>
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
	
	<!-- 스크립트  -->
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript"></script>
</body>
</html>