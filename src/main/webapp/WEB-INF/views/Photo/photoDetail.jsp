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
<form method="post">


<a href="/photo/List">목록</a>


<!--<table border="1">
	<tr>
		<th>제목</th>
		<td><input type="text" name="pht_title" value="${photoDetail.pht_title}">
			<input type="hidden" name="pht_bno" value="${photoDetail.pht_bno}">
			<input type="hidden" name="user_id" value="${photoDetail.user_id}">
			|조회수${photoDetail.pht_cnt}</td>
	</tr>
	<tr>
		<th>작성일자</th><td>${photoDetail.pht_regdate}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="pht_content">${photoDetail.pht_content}</textarea></td>
	</tr>
	<tr><td colspan="2">
		<input type="submit" value="수정" formaction="/photo/Modify">
		<input type="submit" value="삭제" formaction="/photo/Delete">
		</td>
	</tr>

</table>-->


<div>${photoDetail.pht_title}</div>
<div>${photoDetail.pht_bno}</div>
<div>${photoDetail.pht_cnt}</div>
<div>${photoDetail.pht_regdate}</div>
<div>${photoDetail.pht_content}</div>
<div>${photoDetail.user_id}</div>


<input type="button" value="수정" class="" onclick="location.href='/photo/Modify?pht_bno=${photoDetail.pht_bno}'">
	<input type="submit" value="삭제" class="" formaction="/photo/Delete">
	<input type="hidden" value="${photoDetail.pht_bno}" name="pht_bno">


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