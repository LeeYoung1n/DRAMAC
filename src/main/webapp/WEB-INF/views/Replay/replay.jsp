<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다시보기</title>
</head>
<body>

</body>
</html>

<!-- 상품리스트(페이징 및 검색) -->
	<select id="list" resultType="com.food.model.ShopVO">
	select*
	from(
	select @rownum :=@rownum+1 rownum,s.*
	from (select
	s.prodnum,NAME,discountprice,today,Concat(Replace(uploadpath,'\\','/'),'/',uuid,'-',filename)filename
	from tb_shop s inner join sh_appatch a
	on s.prodnum = a.prodnum
	
            order by s.prodnum desc
            )as s, (select @rownum:=0) as tmp) as
	shopProductlist
