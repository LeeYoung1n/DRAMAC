<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/JS/Photo_JS/photoList.js"></script>
</head>
<body>

<h1>사진 목록</h1>

	<a href="/photo/Write"><button>글쓰기</button></a>
	

	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>아이디</th>
		</tr>
		<!-- for문 시작 -->
		<c:forEach items="${photoList}" var="photoList">
		<tr>
			<td>${photoList.pht_bno}</td>
			<td><a href="/photo/Detail?pht_bno=${photoList.pht_bno}">${photoList.pht_title}</a></td>
			<td>${photoList.pht_content}</td>
			<td>${photoList.pht_regdate}</td>
			<td>${photoList.pht_cnt}</td>
			<td>${photoList.user_id}</td>
		</tr>
		</c:forEach>
	</table>
	
	

	<c:if test="${paging.prev}">
		<a href="/photo/List?pageNum=${paging.startPage-1}&amount=${paging.cri.amount}">이전</a>
	</c:if>
	
	<!-- begin(1)이 end(10)될 동안 반복(1이 10이 될 동안 반복) -->
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
	<a href="/photo/List?pageNum=${num}&amount=${paging.cri.amount}">${num}</a>
	</c:forEach>
	<!-- a태그와 주소를 같이 맞추려면 둘이 같아야함 -->
	
	<!-- next(다음)이 true이면 다음버튼 활성화 -->
	<c:if test="${paging.next}">
	<a href="/photo/List?pageNum=${paging.endPage+1}&amount=${paging.cri.amount}">다음</a>
	</c:if>


</body>
</html>