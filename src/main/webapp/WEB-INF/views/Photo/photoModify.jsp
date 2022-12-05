<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<form action="/photo/Modify" method="post">


<a href="/photo/List">목록</a>


<table border="1">
	<tr>
		<th>제목</th>
		<td>
			<input type="text" name="pht_title" value="${photoModify.pht_title}">
			<input type="text" name="pht_bno" value="${photoModify.pht_bno}">
			<input type="text" name="user_id" value="${photoDetail.user_id}">
		</td>
	</tr>
	<tr>
		<th>작성일자</th><td>${photoDetail.pht_regdate}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="pht_content">${photoModify.pht_content}</textarea></td>
	</tr>
	<tr><td colspan="2">
		<input type="submit" value="수정" >
		<input type="button" value="취소" onclick="location.href='/photo/Detail?pht_bno=${photoModify.pht_bno}'">
		</td>
	</tr>

</table>

</form>

	<div id="uploadResult">
		<ul>
		
		</ul>
	</div>
	<!-- 댓글 작성 버튼 - html에 직접적으로 드러남 
	<div><label>댓글</label></div>
	<div>
	<textarea rows="5" cols="50" id="reply"></textarea>
	</div>
	<div>
	<input type="button" value="댓글쓰기" id="add">
	</div>
	<div id="chat">
		<ul id="replyUL">
		</ul>
	</div>-->
</body>

<script type="text/javascript" src="/resources/JS/Photo_JS/photoAttach.js"></script>
</html>