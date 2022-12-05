<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    
<script>
$(document).ready(function(){
	
	var pht_bno=$("input[name='pht_bno']").val();

	console.log(pht_bno)
	
	$.getJSON("/photo_attachlist",{pht_bno:pht_bno},function(photo_attachlist){
		console.log(photo_attachlist);
		
		var str="";
		$(photo_attachlist).each(function(i, attach){
			console.log(attach);

				var filePath=encodeURIComponent(attach.pht_uploadPath+"/s_"+attach.pht_uuid+"_"+attach.pht_fileName)
				console.log(filePath)
				str+="<img src='/photoDisplay?pht_fileName="+filePath+"'>"
			})
		
			$(".imgUrl td").html(str);
		})
		
	}) 

</script>


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
	

	<table border="1">
		<tr>
			<th>번호</th>
			<!-- <th>rownum</th> -->
			<th>제목</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>아이디</th>
			<th>사진</th>
		</tr>
		<!-- for문 시작 -->
		<c:forEach items="${photoList}" var="photoList">
		<tr>
			<td><input type="text" readonly name="pht_bno" value="${photoList.pht_bno}"></td>
			<!-- <td>${photoList.pht_rownum}</td>-->
			<td><a href="/photo/Detail?pht_bno=${photoList.pht_bno}">${photoList.pht_title}</a></td>
			<td>${photoList.pht_regdate}</td>
			<td>${photoList.pht_cnt}</td>
			<td>${photoList.user_id}</td>
			<td class="imgUrl">
				<!-- <input type="hidden" value="${photoList.pht_fileName}"> -->
				<!-- <img class="imgUrl" src="/photoDisplay?pht_fileName=${photoList.pht_fileName }" width="100px" height="100px"> -->
				<!--  <img class="imgUrl" width="100px" height="100px">-->
			</td>
		</tr>
		</c:forEach>
	</table>
	<div id="pht_limage">
		<ul>
		
		</ul>
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