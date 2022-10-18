<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/resources/JS/Photo_JS/photouploadAjax.js"></script>
</head>
<body>
<h3>업로드 Ajax를 해봅시다</h3>
<div>
	<input type="file" name="photouploadFile" multiple>
</div>
<div>
	<input type="submit" id="photouploadBtn" value="파일 전송">
</div>
<div>
	<ul>
		<li><img src="/resources/img/"></li>
	</ul>
</div>
</body>
</html>