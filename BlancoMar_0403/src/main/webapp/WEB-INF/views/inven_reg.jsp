<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="insertinven" method="post">
		<div class="sort_box">
			<input type="text" name="dress_size" id="dress_size">
			<input type="text" name="dress_stock" id="dress_stock">
			<input type="button" id="btnAdd" value="Add">
			<br>
		</div>
		<input type="hidden" name="dress_num" value="${result}">
		<input type="submit" value="재고 등록 완료">
	</form>
	
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="//code.jquery.com/jquery.min.js"></script>
    <script>            
        $(document).ready (function () {                
            $('#btnAdd').click (function () {
            	alert("성공");
            	 $('.sort_box').append(                        
                    '<input type="text" name="dress_size" id="dress_size"><input type="text" name="dress_stock" id="dress_stock"><input type="button" class="btnRemove" value="Remove"><br>'                    
                ); // end append
                
                $('.btnRemove').on('click', function () { 
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