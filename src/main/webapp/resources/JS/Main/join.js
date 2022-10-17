$(document).ready(function(){
	
	//회원가입 버튼
	$("#join_join").click(function(){
		
		var user_name = $("#user_name").val();	
		var user_id = $("#user_id").val(); 			
		var user_pw = $("#user_pw").val();				
		var user_repw = $("#user_repw").val();					
		var user_email = $("#user_email").val();	
		var user_phone = $("#user_phone").val();
//		var user_term_1 = $("#user_term_1").val();
//		var user_term_2 = $("#user_term_2").val();
//		var user_term_3 = $("#user_term_3").val();
		
		
		/* 이름 유효성 검사 */
		if(user_name == ""){
			$(".join_nameNone").css("display","block");
			nameCheck = false;
		}else{
			$(".join_nameNone").css("display", "none");
			nameCheck = true;
		}

		/* 아이디 유효성검사 */
		if(user_id == ""){
			$(".join_idNone").css("display","block");
			idCheck = false;
		}else{
			idCheck = true;
		}
		
		/* 비밀번호 유효성 검사 */
		if(user_pw == ""){
			$(".join_pwNone").css("display","block");
			pwCheck = false;
		}else{
			$(".join_pwNone").css("display", "none");
			pwCheck = true;
		}
		
		/* 비밀번호 확인 유효성 검사 */
		if(user_repw == ""){
			$(".join_repwNone").css("display","block");
			repwCheck = false;
			
		}else{
			$(".join_repwNone").css("display", "none");
			repwCheck = true;
		}
		
		/* 이메일 유효성 검사 */
		if(user_email == ""){
			$(".join_emailNone").css("display","block");
			emailCheck = false;
		}else{
			$(".join_emailTrue").css("display", "block");
			emailCheck = true;
		}
		
		/*휴대폰 검사*/
		if(user_phone == ""){
			$(".join_phoneNone").css("display","block");
			phoneCheck = false;
		}else{
			$(".join_phoneNone").css("display", "none");
			phoneCheck = true;
		}
		
//		if($("input[name=join_agree]:checkbox:checked").length < 3){
//			$(".join_agreeNone").css("display","block");
//			agreeCheck = false;
//		}else{
//			$(".join_agreeNone").css("display", "none");
//			agreeCheck = true;
//		}
//		
		/* 최종 유효성 검사 */
		if(nameCheck && idCheck && pwCheck && repwCheck && emailCheck && phoneCheck ){
			$("#join_form").attr("action", "/join");
			$("#join_form").submit();		
			
		}
		

		return false;
	});
		
});