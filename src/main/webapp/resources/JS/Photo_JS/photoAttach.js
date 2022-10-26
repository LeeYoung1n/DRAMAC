/**
 * 첨부파일 관련 js
 */

$(document).ready(function(){
	// detail.jsp가 시작되자마자(ready 이벤트) bno값 가져오기
	// input과 name 사이를 띄우면 안됨!! 
	var pht_bno=$("input[name='pht_bno']").val();

	//									콜백
	$.getJSON("/photo_attachlist",{pht_bno:pht_bno},function(photo_attachlist){
		console.log(photo_attachlist);
		
		var str="";
		
		$(photo_attachlist).each(function(i, obj){
			// 만약 image 결과가 true면
			if(obj.image){pht_attach
				var pht_filePath=encodeURIComponent(obj.pht_uploadPath+"/s_"+obj.pht_uuid+"_"+obj.pht_fileName)
				str+="<li><img src='/photoDisplay?pht_fileName="+pht_filePath+"'>"+obj.pht_fileName+"</a></li>"
			}else{// 그렇지 않으면
				var filePath=encodeURIComponent(obj.pht_uploadPath+"/"+obj.pht_uuid+"_"+obj.pht_fileName)
				str+="<li><a href='/download?pht_fileName="+pht_filePath+"'>"+obj.pht_fileName+"</a></li>"
			}
		})
		$("#uploadResult ul").html(str);
		

	})
}) 


