<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>      
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>재고등록 페이지</title>
<link rel="stylesheet" href="${path}/resources/css/inven.css?ver=1">
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
            		<h1 id="insertheder">재고 등록</h1>
    				<form action="insertlist" method="post" enctype="multipart/form-data">
   						<table class="inserttable">
                             <tr>
                                <td>
                                    <select  class="insertinput" id="sort_num" name="sort_num">
                                       <option value="">선택</option>
                                        <c:forEach var="sort" items="${result}">
										<option value="${sort.sort_num}">${sort.sort_name}</option>
										</c:forEach>
                                    </select>
                                </td>
                             </tr>
                             <tr>
         						<td>
         						<input type="text" class="insertinput" name="dress_name" placeholder="물품명을 입력하세요"></td>
      						</tr>
      						<tr>
         						<td>
         						<input type="text" class="insertinput" name="dress_price" placeholder="가격을 등록하세요"></td>
      						</tr>
      						<tr>
         						<td>
         						<input type="text" class="insertinput" name="dress_color" placeholder="색상을 입력하세요"></td>
      						</tr>
      						<tr>
         						<td><textarea class="insertaddr" name="dress_content" placeholder="상세 설명 입력하세요"></textarea></td>
      						</tr>
      						<tr>
         						<td><input class="insertinput" type="file" name="dress_file_name"></td>
      						</tr>
   						</table>
   						<div class="buttons">
	        				<input class="backbutton" type="button" value="취소" onclick = "location.href = 'dresslist'">
	        				<input class="insertbutton" type="submit" value="재고등록">  
	      				</div>
   					</form>
      				
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
	<!-- warp div 끝나는 부분 -->
   <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script src="//code.jquery.com/jquery.min.js"></script>
</body>
