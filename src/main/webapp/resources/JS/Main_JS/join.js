// 유효성 검사 체크용
var nameCheck = false;			// 이름
var idCheck = false;			// 아이디
var idckCheck = false;			// 아이디 중복 검사
var pwCheck = false;			// 비밀번호
var repwCheck = false;			// 비밀번호 중복
var repwckCheck = false;		// 비밀번호 중복 일치 
var emailCheck = false;			// 이메일 
var emailckCheck = false;		// 이메일 중복 
var emailNumberCheck = false;	// 이메일 인증 
var phoneCheck = false; 		// 휴대폰
var phoneckCheck = false;		// 휴대폰 중복 
var agreeCheck = false; 		// 약관동의


//정규식 모음
//이름
function nameFormCheck(user_name){
	var nameForm = /^[가-힣a-zA-Z0-9]/gi;
	return nameForm.test(user_name);
}

//아이디
function idFormCheck(user_id){
	var idForm =  /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;
	return idForm.test(user_id);
}

//비밀번호
function pwFormCheck(user_pw){
	var pwForm = /^[A-Za-z0-9`\-=\\\[\];',\./~!@#\$%\^&\*\(\)_\+|\{\}:"<>\?]{8,16}$/;
	return pwForm.test(user_pw);		
}

//이메일
function emailFormCheck(user_email){
	var emailForm = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return emailForm.test(user_email);
}

//전화번호
function phoneFormCheck(user_phone){
	var phoneForm = /^((01[1|6|7|8|9])[1-9][0-9]{6,7})$|(010[1-9][0-9]{7})$/;;
	return phoneForm.test(user_phone);
}



$(document).ready(function(){
	
	//회원가입 버튼
	$("#join_join").click(function(){
		
		var user_name = $("#user_name").val();	
		var user_id = $("#user_id").val(); 			
		var user_pw = $("#user_pw").val();				
		var user_repw = $("#user_repw").val();					
		var user_email = $("#user_email").val();	
		var user_phone = $("#user_phone").val();
		var user_term_1 = $("#user_term_1").val();
		var user_term_2 = $("#user_term_2").val();
		var user_term_3 = $("#user_term_3").val();
		
		
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
			$(".join_idNone").css("display","none");
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
		
		/*동의사항 검사*/
		if($("input[name=join_agree]:checkbox:checked").length < 3){
			$(".join_agreeNone").css("display","block");
			agreeCheck = false;
		}else{
			$(".join_agreeNone").css("display", "none");
			agreeCheck = true;
		}
		
		/* 최종 유효성 검사 */
		if(nameCheck && idCheck && pwCheck && repwCheck && emailCheck && phoneCheck && agreeCheck){
			$("#join_form").attr("action", "/join");
			$("#join_form").submit();		
			
		}
		

		return false;
	});
		
});



$("#user_name").on("blur", function(){
	
	var user_name = $("#user_name").val();
	
	if(nameFormCheck(user_name)){
		$('.join_nameTrue').css('display','block');
		$('.join_nameNone').css('display','none');
		$('.join_nameFalse').css('display','none');
		nameCheck = true;
	}else{
		$('.join_nameTrue').css('display','none');
		$('.join_nameNone').css('display','none');
		$('.join_nameFalse').css('display','block');
		nameCheck = false;
	}
});


$("#user_id").on("blur", function(){

	var user_id = $("#user_id").val();			// .id_input에 입력되는 값
	var data = {user_id : user_id}				// "컨트롤에 넘길 데이터 이름" : "데이터(.id_input에 입력되는 값)"
	var idwarnMsg = $(".join_idMs");

	$.ajax({
		type : "post",
		url : "/joinIdChk",
		data : data,
		success : function(result){
			// 중복되지 않고 아이디 형식도 맞을 때
			if(result != "fail" && idFormCheck(user_id)){
				$(".join_idTrue").css("display","inline-block");
				$(".join_idNone").css("display","none");
				$(".join_idHave").css("display","none");
				$(".join_idFalse").css("display","none");
				idckCheck = true;
			// 중복되지 않으나 아이디 형식이 틀렸을 때
			}else if(result != "fail" && !idFormCheck(user_id)){
				$(".join_idTrue").css("display","none");
				$(".join_idNone").css("display","none");
				$(".join_idHave").css("display","none");
				$(".join_idFalse").css("display","inline-block");
				idckCheck = false;
			// 아이디 형식은 맞으나 중복될 때		
			}else if(result == "fail" && idFormCheck(user_id)){
				$(".join_idTrue").css("display","none");
				$(".join_idNone").css("display","none");
				$(".join_idHave").css("display","inline-block");
				$(".join_idFalse").css("display","none");
				idckCheck = false;
			// 둘 다 틀렸을 때	
			}else{
				$(".join_idTrue").css("display","none");
				$(".join_idNone").css("display","none");
				$(".join_idHave").css("display","inline-block");
				$(".join_idFalse").css("display","inline-block");
				idckCheck = false;
			}
		}
	}); // ajax 종료
	
});


//비밀번호 일치 및 형식 검사
$("#user_repw").on("blur", function(){

	var user_pw = $("#user_pw").val();
	var user_repw = $("#user_repw").val();
	
	
	//비밀번호 형식이 맞음
	if(pwFormCheck(user_pw)){
		//그리고 일치함
		if(user_pw == user_repw){
			$('.join_pwNone').css('display', 'none');
			$('.join_pwFalse').css('display', 'none');
			$('.join_pwTrue').css('display','block');
			$('.join_repwNone').css('display','none');
			$('.join_repwFalse').css('display','none');
			//회원가입 가능
			repwckCheck = true;
		//그러나 일치하지 않음
		}else if(user_pw != user_repw){
			$('.join_pwNone').css('display', 'none');
			$('.join_pwFalse').css('display', 'none');
			$('.join_pwTrue').css('display','none');
			$('.join_repwNone').css('display','none');
			$('.join_repwFalse').css('display','block');
			//회원가입 불가
			repwckCheck = false;
		//혹은 비밀번호 확인을 하지 않음
		}else if(user_repw == ""){
			$('.join_pwNone').css('display', 'none');
			$('.join_pwFalse').css('display', 'none');
			$('.join_pwTrue').css('display','none');
			$('.join_repwNone').css('display','block');
			$('.join_repwFalse').css('display','none');
			//회원가입 불가
			repwckCheck = false;
		}
	//비밀번호 형식이 틀림
	}else if(!pwFormCheck(user_pw)){
		//일치하든 일치하지 않든 입력 불가
		$('.join_pwNone').css('display', 'none');
		$('.join_pwFalse').css('display', 'block');
		$('.join_pwTrue').css('display','none');
		$('.join_repwNone').css('display','none');
		$('.join_repwFalse').css('display','none');
		repwckCheck = false;
	}	
});

//형식 검사
$("#user_phone").on("blur", function(){

	var user_phone = $("#user_phone").val();			
	var data = {user_phone : user_phone}			
	var warnMsg = $(".phoneMs");    
	
	$.ajax({
		type : "post",
		url : "/joinphoneChk",
		data : data,
		success : function(result){
			// 중복되지 않고 휴대폰 형식도 맞을 때
			if(result != "fail" && phoneFormCheck(user_phone)){
				$(".join_phoneTrue").css("display","inline-block");
				$(".join_phoneNone").css("display","none");
				$(".join_phoneHave").css("display","none");
				$(".join_phoneFalse").css("display","none");
				phoneckCheck = true;
			// 중복되지 않으나 휴대폰 형식이 틀렸을 때
			}else if(result != "fail" && !phoneFormCheck(user_phone)){
				$(".join_phoneTrue").css("display","none");
				$(".join_phoneNone").css("display","none");
				$(".join_phoneHave").css("display","none");
				$(".join_phoneFalse").css("display","inline-block");
				phoneckCheck = false;
			// 휴대폰 형식은 맞으나 중복될 때		
			}else if(result == "fail" && phoneFormCheck(user_phone)){
				$(".join_phoneTrue").css("display","none");
				$(".join_phoneNone").css("display","none");
				$(".join_phoneHave").css("display","inline-block");
				$(".join_phoneFalse").css("display","none");
				phoneckCheck = false;
			// 둘 다 틀렸을 때	
			}else{
				$(".join_phoneTrue").css("display","none");
				$(".join_phoneNone").css("display","none");
				$(".join_phoneHave").css("display","inline-block");
				$(".join_phoneFalse").css("display","inline-block");
				phoneckCheck = false;
			}
		}
	}); // ajax 종료
	
});



$("#user_email").on("blur", function(){
	
	var user_email = $("#user_email").val();
	
	if(emailFormCheck(user_email)){
		$('.join_emailTrue').css('display','block');
		$('.join_emailNone').css('display','none');
		$('.join_emailFalse').css('display','none');
		emailckCheck = true;
	}else{
		$('.join_emailTrue').css('display','none');
		$('.join_emailNone').css('display','none');
		$('.join_emailFalse').css('display','block');
		emailckCheck = false;
	}
});





/*이메일 인증 번호*/
var code = "";                //이메일전송 인증번호 저장위한 코드


/* 인증번호 이메일 전송 */
$("#join_emailbtn").click(function(){
	
	var user_email = $("#user_email").val();		// 입력한 이메일
	var email_checkBox = $("#join_emailNumber");        // 인증번호 입력란
    var boxWrap = $("#join_emailNumber_box");    // 인증번호 입력란 박스
	
	$.ajax({
		
		type:"GET",
		url:"emailCheck?user_email=" + user_email,
		success:function(data){
			
			//console.log("data : " + data);
			email_checkBox.attr("disabled",false);
			boxWrap.attr("id", "email_check_input_box_true");
			code = data;         
        }
					
	});	
});


/* 인증번호 비교 */
$("#join_emailNumber").blur(function(){
    
	var inputCode = $("#join_emailNumber").val();        // 입력코드    
    var checkResult = $(".join_emailNumber_TF");    // 비교 결과  
    
    if(inputCode == code){                            // 일치할 경우
        checkResult.html("인증번호가 일치합니다. 회원가입을 진행해주세요.");
        checkResult.attr("class", "correct");   
        emailNumberCheck = true;
    } else {                                            // 일치하지 않을 경우
        checkResult.html("인증번호를 다시 확인해주세요.");
        checkResult.attr("class", "incorrect");
        emailNumberCheck = false;
    }    

});
