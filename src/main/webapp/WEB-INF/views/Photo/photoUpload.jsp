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
<h3>그림을 업로드해봅시다~</h3>
	<form id="phtUp_form" action="/Photo/photoUpload" method="post">
	제목 : <input type="text" name="phtUp_title"><br>
	내용 : <input type="text" name="phtUp_content">
	<input type="button" id="phtUp_btn" value="등록"><br>
	<input type="file" name="phtUp_file" multiple><br>
	
	
	
	</form>
	<div id="phtUp_Result">
		<ul>
			
		</ul>
	</div>
</body>
</html>