/**
 * 
 */

$(document).ready(function(){
	
	var reg = new RegExp("(.*?)\.(exe|zip|alz|js)$")
	
	var maxSize=5243880; // 5MB
	
	function checkExtension(fileName, fileSize){
		
		if(fileSize > maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		if(reg.test(fileName)){
			alert("해당 종류의 파일은 업로드 할 수 없습니다.");
			return false;
		}
		return true;
	}
	
	
	$("#phtUp_btn").on("click", function(){
//		e.preventDefault();
		alert("연결확인용");
	
		var formData = new FormData();
		
		var inputFile = $("input[name='phtUp_file']");
		
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
					
					input+="<input type='text' name='attach[" + i + "].fileName' value='"+obj.fileName+"'><br>";
					input+="<input type='text' name='attach[" + i + "].uuid' value='"+obj.uuid+"'><br>";
					input+="<input type='text' name='attach[" + i + "].uploadPath' value='"+obj.uploadPath+"'><br>";
					input+="<input type='text' name='attach[" + i + "].image' value='"+obj.image+"'><br>";
					
					if(obj.image){
						var filePath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName)
						console.log(filePath)
						str+="<li><img src='/photoDisplay?fileName="+filePath+"'>"+obj.fileName+"</li>"
					}else{
						var filePath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName)
						str+="<li><a href='/download?fileName="+filePath+"'>"+obj.fileName+"</a></li>"
					}
				})
				$("#phtUp_Result ul").html(str);
				$("#phtUp_form").append(input);
			}
		})
	})
})
