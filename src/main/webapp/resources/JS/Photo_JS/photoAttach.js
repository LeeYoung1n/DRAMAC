/**
 * 첨부파일 관련 js
 */

$(document).ready(function(){
	// detail.jsp가 시작되자마자(ready 이벤트) bno값 가져오기
	// input과 name 사이를 띄우면 안됨!! 
	var pht_bno=$("input[name='pht_bno']").val();

	//												콜백
	$.getJSON("/photo_attachlist",{pht_bno:pht_bno},function(photo_attachlist){
		console.log(photo_attachlist);
		
		var str="";
		$(photo_attachlist).each(function(i, attach){
			console.log(attach);
			// 만약 image 결과가 true면
			if(attach.pht_image){
				var filePath=encodeURIComponent(attach.pht_uploadPath+"/s_"+attach.pht_uuid+"_"+attach.pht_fileName)
				console.log(filePath)
				str+="<li><img src='/photoDisplay?pht_fileName="+filePath+"'>"+attach.pht_fileName+"</li>"
			}else{// 그렇지 않으면
				var filePath=encodeURIComponent(attach.pht_uploadPath+"/"+attach.pht_uuid+"_"+attach.pht_fileName)
				str+="<li><a href='/download?pht_fileName="+filePath+"'>"+attach.pht_fileName+"</a></li>"
			}
		})
		$("#uploadResult ul").html(str);
		

	})
}) 


