<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<h1>사진 목록</h1>

	<a href="/photo/Write"><button>글쓰기</button></a>
	<form id="pht_searchForm" action="/photo/List">
		<select name="type">
			<option value="T">제목</option>
			<option value="C">내용</option>
			<option value="TC">제목+내용</option>
			<option value="W">작성자(user_id)</option>
		</select>
		<input type="text" name="keyword">
		<input type="hidden" name="pageNum" value="${paging.cri.pageNum}">
		<input type="hidden" name="amount" value="${paging.cri.amount}"> 
		<input type="button" value="검색">
	</form>
	

	<div>
		<c:forEach items="${photoList}" var="photoList">
			<a href="/photo/Detail?pht_bno=${photoList.pht_bno}">
				<ul>
					<li>
						<input type="text" readonly name="pht_bno" value="${photoList.pht_bno}">
					</li>
					<li>
						${photoList.pht_rownum}
					</li>
					<li>
						<a href="/photo/Detail?pht_bno=${photoList.pht_bno}">${photoList.pht_title}</a>
					</li>
					<li>
						${photoList.pht_regdate}
					</li>
					<li>
						${photoList.pht_cnt}
					</li>
					<li>
						${photoList.user_id}
					</li>
					<li>
						${photoList.pht_fileName}
					</li>
					<li class="">
						<div class="">
							<div class="imgUrl" data-name="${photoList.pht_fileName}" data-filename="${photoList.pht_fileName}">
                         	  <img>
                       	    </div>
						 </div>	
		
						
						
						
						
						<a href="/photo/Detail?pht_bno=${photoList.pht_bno}">
							<img>
						</a>
					</li>
				</ul>
			</a>
		</c:forEach>
	</div>

	<c:if test="${paging.prev}">
		<a href="/photo/List?type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${paging.startPage-1}&amount=${paging.cri.amount}">이전</a>
	</c:if>
	
	<!-- begin(1)이 end(10)될 동안 반복(1이 10이 될 동안 반복) -->
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
		<a href="/photo/List?type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${num}&amount=${paging.cri.amount}">${num}</a>
	</c:forEach>
	<!-- a태그와 주소를 같이 맞추려면 둘이 같아야함 -->
	
	<!-- next(다음)이 true이면 다음버튼 활성화 -->
	<c:if test="${paging.next}">
		<a href="/photo/List?type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${paging.endPage+1}&amount=${paging.cri.amount}">다음</a>
	</c:if>


</body>
<script type="text/javascript" src="/resources/JS/Photo_JS/photoList.js"></script>
</html>