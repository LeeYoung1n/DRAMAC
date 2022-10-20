<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/resources/JS/Photo_JS/photoUpload.js"></script>
</head>
<body>

<a href="/">홈링크</a>

<h3>그림을 업로드해봅시다~</h3>
	<form id="pht_form" action="/Photo/photoUpload" method="post">
	
	제목 : <input type="text" name="pht_title"><br>
	내용 : <input type="text" name="pht_content">
	
	<input type="file" name="pht_file" multiple><br>
	<input type="button" id="pht_btn" value="등록"><br>
	
	
	
	</form>
	<div id="pht_Result">
		<ul>
			
		</ul>
	</div>
</body>
</html>