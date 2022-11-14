/**
 * 
 */

$(document).ready(function(){
	
	var reg = new RegExp("(.*?)\.(exe|zip|alz|js)$")
	
	var maxSize=5243880; // 5MB
	
	function checkExtension(pht_fileName, fileSize){
		
		if(fileSize > maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		if(reg.test(pht_fileName)){
			alert("해당 종류의 파일은 업로드 할 수 없습니다.");
			return false;
		}
		return true;
	}
	
	
	$("#pht_btn").on("click", function(){
//		e.preventDefault();
		alert("연결확인용");
	
		var formData = new FormData();
		
		var inputFile = $("input[name='pht_file']");
		
		var files = inputFile[0].files;
		console.log(files);
		
		for(var i=0; i<files.length; i++){
			if(!checkExtension(files[i].name, files[i].size)){
				return false;
			}
			formData.append("uploadFile", files[i]);
		}
		
		$.ajax({
			type:"post",
			url:"/photoUploadAction",
			data:formData,
			contentType:false,
			processData:false,
			dataType:"json",
			success:function(result){
				console.log(result)
				
				var str="";
				var input="";
					
				$(result).each(function(i,obj){
					
					input+="<input type='text' name='pht_attach[" + i + "].pht_fileName' value='"+obj.pht_fileName+"'><br>";
					input+="<input type='text' name='pht_attach[" + i + "].pht_uuid' value='"+obj.pht_uuid+"'><br>";
					input+="<input type='text' name='pht_attach[" + i + "].pht_uploadPath' value='"+obj.pht_uploadPath+"'><br>";
					input+="<input type='text' name='pht_attach[" + i + "].pht_image' value='"+obj.pht_image+"'><br>";
					
					if(obj.image){
						var filePath = encodeURIComponent(obj.pht_uploadPath+"/s_"+obj.pht_uuid+"_"+obj.pht_fileName)
						console.log(filePath)
						str+="<li><img src='/photoDisplay?pht_fileName="+filePath+"'>"+obj.pht_fileName+"</li>"
					}else{
						var filePath = encodeURIComponent(obj.pht_uploadPath+obj.pht_uuid+"_"+obj.pht_fileName)
						str+="<li><a href='/download?pht_fileName="+filePath+"'>"+obj.pht_fileName+"</a></li>"
					}
				})
				$("#pht_Result ul").html(str);
				$("#pht_form").append(input).submit();
			}
		})
	})
})
