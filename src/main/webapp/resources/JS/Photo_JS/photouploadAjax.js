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
	
	
	$("#photouploadBtn").on("click", function(){
		alert("연결확인용");
	
		var formData = new FormData();
		
		var inputFile = $("input[name='photouploadFile']");
		
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
			processData:false
		})
	})
})
