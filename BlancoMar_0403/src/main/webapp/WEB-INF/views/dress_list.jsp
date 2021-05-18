<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/inven.css">

</head>
<body>
	<div id="wrap">
		<header>
            <div id="top">
                <img class="logo" src="${path}/resources/mainimg/logo.png" onclick="location.href='main'">
            </div>
            <nav id="top_nav">
                <ul><!-- 로그인 로그아웃 부분 -->
                    <li><a href="listreg">재고등록</a></li>
                    <li><a href="readtest">회원관리</a></li>
                    <li><a href="dresslist">재고관리</a></li>
				    <li><a href="logout">로그아웃</a></li>
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
            <div id="boardlist">
            	<div class="listmain">
            		<h1 id="heder">재고 목록</h1><br>
            		<table class="invenlist">
            			<tr>
            				<th>물품번호</th>
							<th>물품코드</th>
							<th>물품이미지</th>
							<th>물품이름</th>
							<th>물품가격</th>
                            <th>물품색상</th>
							
      					</tr>
      					<c:forEach var="dress" items="${dresslist}">
						<tr onclick="location.href='invenlist?dress_num=${dress.dress_num}'" >
							<td>${dress.dress_num}</td>
         					<td>${dress.sort_num}</td>
         					<td>
                               <img id="imgs" src="resources/thumbnail/${dress.dress_file_name}">
	                       </td>
							<td>${dress.dress_name}</td>
							<td>${dress.dress_price}</td>
							<td>${dress.dress_color}</td>
      					</tr>
   					</c:forEach>
      				</table>
      				
      				<div class="buttons">
      					<input class="insertbutton" type="button" value="재고등록" onclick="location.href='listreg'">
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