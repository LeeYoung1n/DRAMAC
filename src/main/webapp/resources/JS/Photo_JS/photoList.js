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
	
	
	
//	//썸네일 관련
//	$(".imgUrl").each(function(i, obj){
//		
//		const bobj = $(obj)
//		
//		if(bobj.data("name")){
//
//			const pht_fileName = bobj.data("filename");
//			
//			//const listPath=encodeURIComponent(attach.pht_uploadPath+"/s_"+attach.pht_uuid+"_"+attach.pht_fileName)
//			const listPath = encodeURIComponent(pht_fileName)
//			
//			
//			
//			$(this).find("img").attr('src', '/photoDisplay?pht_fileName=' + listPath);
//		} 
//		
//	});
//	
//	
//	$('.imgUrl img').each(function (i, obj) {
//	    
//		const pht_fileName = bobj.data("")
//		
//	    $(item).addClass('li_0' + index);
//
//	    // item 과 this는 같아서 일반적으로 this를 많이 사용합니다.
//	    // $(this).addClass('li_0' + index);
//	});
	
	
	//썸네일 관련(문제 : 새로 등록한 하나로만 나옴 each 어떻게 적용하는지 ㅗㅁ르겠음)
	var pht_bno=$("input[name='pht_bno']").val();
	console.log(pht_bno)
		
	$.getJSON("/photo_attachlist",{pht_bno:pht_bno},function(photo_attachlist){
	console.log(photo_attachlist);
			
	var str="";
	$(photo_attachlist).each(function(i, attach){
		console.log(attach);
				
		filePath=encodeURIComponent(attach.pht_uploadPath+"/s_"+attach.pht_uuid+"_"+attach.pht_fileName)
		console.log(filePath)
					
		str+="<img src='/photoDisplay?pht_fileName="+filePath+"'>"
					
		})
				
	$(".toto").attr("src", "/photoDisplay?pht_fileName="+filePath);
	})
			
		 
	
})

