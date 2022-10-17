<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<link rel="stylesheet" href="../../../resources/CSS/Main_CSS/join.css">


<div id="findpw_homelogo">
		<a class="findpw_a" href="/"><img class="login_img" src="../../../resources/image/HeaderImg/푸렌드2.png"></a>	
</div>


<div class="join_border">

	<form action="/join" method ="post" name="join_form"  id="join_form">
		
		<div class="join_top">
			<h2 class="join_h2">회원가입</h2>
		</div>
	
		<div class="join_wrap">
		
			<div class="join_inWrap">
		
				
				<div id="join_name"><br>
					<div>
						<h4>이름</h4><br>
					</div>
					<br>
					<div>
						<input type="text" id="user_name" class="join_inputext" name="user_name">
					</div>
					<br>
					<div>
						<span class="join_nameNone">이름을 입력하세요.</span>
					</div>
					<br>
					<div>
						<span class="join_nameFalse">이름에는 한글과 영문 대소문자만을 사용하세요.</span>
					</div>
					<br>
					<div>
						<span class="join_nameTrue">사용 가능한 이름입니다.</span>
					</div>
					<br>
				</div><br>
				
				<div id="join_id"><br>
					<div>
						<h4>아이디</h4><br>
					</div>
					<br>
					<div>
						<input type="text" id="user_id" class="join_inputext" name="user_id">
					</div>
					<br>
					<div>
						<span class="join_idNone">아이디를 입력하세요.</span>
					</div>
					<br>
					<div>
						<span class="join_idHave">아이디가 이미 존재합니다.</span>
					</div>
					<br>
					<div>
						<span class="join_idFalse">아이디로는 영문과 숫자가 혼합된 8~16자만 허용합니다.</span>
					</div>
					<br>
					<div>
						<span class="join_idTrue">사용 가능한 아이디입니다.</span>
					</div>
					<br>
				</div><br>
				
				
				<div id="join_pw"><br>
					<div>
						<h4>비밀번호</h4><br>
					</div>
					<br>
					<div>
						<input type="text" id="user_pw" class="join_inputext" name="user_pw">
					</div>
					<br>
					<div>
						<span class="join_pwNone">비밀번호를 입력하세요.</span>
					</div>
					<br>
					<div>
						<span class="join_pwFalse">8~16자의 영문자에 대문자, 특수기호, 숫자 중 하나 이상을 사용하세요.</span>
					</div>
					<br>
					<div>
						<span class="join_pwTrue">사용 가능한 비밀번호입니다.</span>
					</div>
					<br>
				</div><br>
				

				<div id="join_pwcheck"><br>
					<div>
						<h4>비밀번호 확인</h4><br>
					</div>
					<br>
					<div>
						<input type="text" id="user_repw" class="join_inputext">
					</div>
					<br>
					<div>
						<span class="join_repwNone">비밀번호 중복 확인을 하세요.</span>
					</div>
					<br>
					<div>
						<span class="join_repwFalse">비밀번호가 일치하지 않습니다.</span>
					</div>
					<div>
						<span class="join_repwTrue">비밀번호 중복 확인을 완료했습니다.</span>
					</div>
					<br>
				</div><br>
				
				<div id="join_email">
					<div class="join_h4">
						<h4>이메일</h4><br>
					</div>
					<div class="email_check_wrap">
						<input type="text" id="user_email" class="join_inputext" name="user_email" placeholder="이메일을 입력하세요.">
					</div><br>
					<div id="join_emailNumber_box">
						<input type="text" id="join_emailNumber" class="join_inputext" disabled="disabled" placeholder="인증번호를 입력하세요.">
					</div>
					<br>
					<div>
						<button type="button" id="join_emailbtn" class="join_add">인증번호 받기</button>
					</div>
					<br>
					<div>
						<span class="join_emailNone">이메일을 입력하세요.</span>
					</div>
					<br>
					<div>
						<span class="join_emailHave">이메일이 이미 존재합니다.</span>
					</div>
					<br>
					<div>
						<span class="join_emailFalse">이메일 양식을 다시 확인하세요.</span>
					</div>
					<br>
					<div>
						<span class="join_emailTrue">사용 가능한 이메일입니다.</span>
					</div>
					<div>
						<span class="join_emailNumber_TF"></span>
					</div>
				</div><br>
				
				
				<div id="join_phone"><br>
					<div>
						<h4>휴대폰 번호</h4><br>
					</div>
					<div>
						<input type="text" id="user_phone" class="join_inputext" name="user_phone" placeholder=" "-" 없이 숫자만 입력해주세요. 예)01012345678"><br><br>
					</div>
					<br>
					<div>
						<span class="join_phoneNone">휴대폰 번호를 입력하세요.</span>
					</div>
					<div>
						<span class="join_phoneHave">번호가 이미 존재합니다.</span>
					</div>
					<div>
						<span class="join_phoneFalse">휴대폰 번호에는 숫자와 하이픈(-)만을 입력해주세요.</span>
					</div>
					<div>
						<span class="join_phoneTrue">사용 가능한 휴대폰 번호입니다.</span>
					</div>
				</div><br>
				
				
				
				<!-- 동의사항 함수 -->
				<script type="text/javascript">
					$(document).ready(function() {
						$("#join_allAgree").click(function() {
							if($("#join_allAgree").is(":checked")) $("input[class=join_agreeChk]").prop("checked", true);
							else $("input[class=join_agreeChk]").prop("checked", false);
						});
						
						$("input[class=join_agreeChk]").click(function() {
							var total = $("input[class=join_agreeChk]").length;
							var checked = $("input[class=join_agreeChk]:checked").length;
							
							if(total != checked) $("#join_allAgree").prop("checked", false);
							else $("#join_allAgree").prop("checked", true); 
						});
					});
				</script>
				
				<div class="join_agree_border">
					<div>
						<h4>동의사항</h4>
					</div>
					<table class="join_agreeZone">
							<tr>
								<td><input type="checkbox" id="join_allAgree" /></td>
								<td>전체 동의</td>
							</tr>
							<tr>
								<td><input type="checkbox" name="join_agree" class="join_agreeChk"></td>
								<td>(필수)본인은 만 14세 이상입니다</td>
							</tr>
							<tr>
								<td><input type="checkbox" name="join_agree" class="join_agreeChk"></td>
								<td>(필수)이용 약관 동의</td>
							</tr>
							<tr>
								<td><input type="checkbox" name="join_agree" class="join_agreeChk"></td>
								<td>(필수)개인정보 수집 및 이용 동의</td>
							</tr>
							<tr>
								<td><input type="checkbox" class="join_agreeChk"></td>
								<td>(선택)개인정보 마케팅 활용 동의</td>
							</tr>
							<tr>
								<td><input type="checkbox" class="join_agreeChk"></td>
								<td>(선택)이메일으로 혜택 및 정보 수신</td>
							</tr>
							<tr>
								<td><input type="checkbox" class="join_agreeChk"></td>
								<td>(선택)휴대폰으로 혜택 및 정보 수신</td>
							</tr>
					</table>
					<table class="join_agreeLink">
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><a href="">약관</a></td>
						</tr>
						<tr>
							<td><a href="">약관</a></td>
						</tr>
						<tr>
							<td><a href="">약관</a></td>
						</tr>
						<tr>
							<td><a href="">약관</a></td>
						</tr>
						<tr>
							<td><a href="">약관</a></td>
						</tr>
					</table>
					<span class="join_agreeNone">동의사항을 확인하세요.</span>
				</div>
				<br>
				<br>
				<br>
				
				<div id="join_submit" class="join_submit"><br>
					<input type="button" id = "join_join" value="가입하기">
				</div><br>
		
			</div>			
		</div>
		
	
	</form>
</div>


<script src="/resources/JS/Main_JS/join.js"></script>