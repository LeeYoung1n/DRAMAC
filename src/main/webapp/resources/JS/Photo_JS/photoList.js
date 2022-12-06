/**
 * 
 */



$(document).ready(function(){
	
	//페이징 관련
	$("input[type='button']").on("click", function(){
		//alert("aaa");
		// pageNum에 1을 초기화
		$("input[name='pageNum']").val("1");
		// form태그를 submit
		$("#pht_searchForm").submit();
	})
	
	
	
	//썸네일 관련
	$("#imgUrl").each(function(i, obj){
		
		const bobj = $(obj)
		
		if(bobj.data("name")){

			const pht_fileName = bobj.data("pht_filename");
			
			//const listPath=encodeURIComponent(attach.pht_uploadPath+"/s_"+attach.pht_uuid+"_"+attach.pht_fileName)
			const listPath = encodeURIComponent(pht_fileName)
			
			$(this).find("img").attr('src', '/photoDisplay?pht_fileName=' + listPath);
		} 
		
	});
	
	
//	//썸네일 관련(흠)
//	var pht_bno=$("input[name='pht_bno']").val();
//
//	$.getJSON("/photo_attachlist",{pht_bno:pht_bno},function(photo_attachlist){
//		console.log(photo_attachlist);
//		
//		var str="";
//		$(photo_attachlist).each(function(i, attach){
//			console.log(attach);
//
//				var listPath=encodeURIComponent(attach.pht_uploadPath+"/s_"+attach.pht_uuid+"_"+attach.pht_fileName)
//				console.log(listPath)
//				//str+="<img src='/photoDisplay?pht_fileName="+listPath+"'>"
//				//str+="<li><img src='/photoDisplay?pht_fileName="+listPath+"</li>"	
//				$(this).find("img").attr('src', '/photoDisplay?pht_fileName='+listPath);
//		})
//		
//		//$(".imgUrl li").html(str);
//		//$(this).find("img").attr('src', '/photoDisplay?pht_fileName='+listPath);
//	})
	
})

