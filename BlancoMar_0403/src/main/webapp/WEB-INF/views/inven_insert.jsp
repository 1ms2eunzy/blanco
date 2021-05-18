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
            <div id="readlist">
                <div class="readmain">
                	<div class="read">
                        <div class="readheader">
                       		<h4 class="commentcnt">${dressone.dress_name} ${dressone.sort_num} ${dressone.dress_color} ${dressone.dress_price}</h4>
                       		
                       		<br>
                    	</div>
                    	<br>
                    	<div class="readcontent">${dressone.dress_content}</div>
                      
                      <h4 class="commentcnt">상세페이지 이미지 </h4>   
                       <div class="imgbox">
                       <c:forEach var="fileimg" items="${fileimg}">
                           <img id="imgs" src="resources/${fileimg.file_path}/${fileimg.file_name}">
                       </c:forEach>    
                       </div>
                       <br>
                       
                       <h4 class="commentcnt">사이즈/재고 확인 </h4>
                       <div>
                           <table class="invenlists">
                                <tr>
                                    <th>사이즈</th>
                                    <th>수량</th>
                                </tr>
                                <c:forEach var="dressinven" items="${dressinven}">
                                <tr>
                                    <td>${dressinven.dress_size}</td>
                                    <td>${dressinven.dress_stock}</td>
                                </tr>
    							</c:forEach>
                            </table>
                       </div>
                       <br>
                       
                       <!-- 제품 설명 부분 끝 -->
                        <h4 class="commentcnt">사이즈/ 재고 등록 </h4>
                        <!-- 댓글 보여지는 부분 -->
                        <div class="comment">
                        	<div class="commentlist">
                        	    <form action="insertinven" method="post">
                                    <div class="inven_box">
                                        <input type="text" class="inveninput" name="dress_size" id="dress_size" placeholder="사이즈를 입력하세요">
                                        <input type="text" class="inveninput" name="dress_stock" id="dress_stock" placeholder="재고 수량">
                                        <input type="button" id="invenAdd" value="추가">
                                        <br>
                                    </div>
                                    <input type="hidden" name="dress_num" value="${dressone.dress_num}">
                                    <div class="smbuttons">
                                        <input class="smbutton" type="submit" value="재고 등록">
	        				        </div>
                                </form>
                        	</div>
                        	<br>
                        	 <h4 class="commentcnt">상세페이지 이미지 등록 </h4>
                        	<div class="commentlist">
                              <form action="insertfile" method="post" enctype="multipart/form-data">
                                    <div class="file_box">
                                        <input type="file" class="inveninput" name="file_name"><br>
                                        <select  class="inveninput" id="file_path" name="file_path">
                                       		<option value="">선택</option>
                                        	<c:forEach var="sort" items="${sort}">
											<option value="${sort.sort_name}">${sort.sort_name}</option>
											</c:forEach>
                                    	</select>
                                        <input type="button" id="fileAdd" value="추가">
                                        <br>
                                    </div>
                                    <input type="hidden" name="dress_num" value="${dressone.dress_num}">
                                    <input type="hidden" name="sort_num" value="${dressone.sort_num}">
                                    <div class="smbuttons">
                                        <input class="smbutton" type="submit" value="이미지 등록">
	        				        </div>
                                    
                                </form>
                            </div>
                       <h4 class="commentcnt"></h4>
                    	</div>
                    	<br>
                    	<div class="readbuttons">
	        				<input class="backbutton" type="button" value="목록" onclick = "location.href = 'dresslist'">
	        				<c:choose>
	        				<c:when test="${sessionScope.loginid eq result.user_id or sessionScope.loginidgrade eq 6}">
	        				<input type="button" class="insertbutton" value="삭제" id="delete" onclick="location.href='delete?review_idx=${result.review_idx}'">
	        				<input class="insertbutton" type="button" value="수정" onclick = "location.href = 'review_update?idx=${result.review_idx}'">
	        				</c:when>
	        				</c:choose>
	      				</div>
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
	<script src="//code.jquery.com/jquery.min.js"></script>
    <script>            
        $(document).ready (function () {                
            $('#invenAdd').click (function () {
            	 $('.inven_box').append(                        
                    '<input type="text" class="inveninput" name="dress_size" id="dress_size" placeholder="사이즈를 입력하세요"><input type="text" class="inveninput" name="dress_stock" id="dress_stock" placeholder="재고 수량"><input type="button" class="invenRemove" value="삭제"><br>'                    
                ); // end append
                
                $('.invenRemove').on('click', function () { 
                    $(this).prev().remove ();
                    $(this).prev().remove (); // remove the textbox
                    $(this).next ().remove (); // remove the <br>
                    $(this).remove (); // remove the button
                });                                        
               
            }); // end click
            
            $('#fileAdd').click (function () {
            	 $('.file_box').append(                        
                    '<input type="file" class="inveninput" name="file_name"><select  class="inveninput" id="file_path" name="file_path"><option value="">선택</option><c:forEach var="sort" items="${sort}"><option value="${sort.sort_name}">${sort.sort_name}</option></c:forEach></select><input type="button" class="fileRemove" value="삭제"><br>'                    
                ); // end append
                
                $('.fileRemove').on('click', function () { 
                    $(this).prev().remove ();
                    $(this).prev().remove (); // remove the textbox
                    $(this).next ().remove (); // remove the <br>
                    $(this).remove (); // remove the button
                });                                        
               
            }); // end click
            
        }); // end ready        
    </script>
</body>
</html>