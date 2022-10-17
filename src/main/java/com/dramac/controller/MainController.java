package com.dramac.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dramac.model.MainVO;
import com.dramac.service.MainService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	
	@Autowired
	MainService ms;
	
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	//홈화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Main() {
		return "Main/home";
	}
	
	// 회원가입 
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join() {
    	return "Main/join";
    }
    
	//회원가입(insert 이루어짐)
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String joinPost(MainVO mainVO) {
    	ms.join(mainVO);
    	return "redirect:/login";
    }
	
	
	
	// 로그인
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(MainVO mainVO) {
		return "Main/login";
    }
    
	// 로그인 기능
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(MainVO mainVO, HttpSession session, RedirectAttributes rttr) {
    	
        boolean result = ms.login(mainVO, session);
        
        if(result) {
         session.setAttribute("user_id", mainVO.getUser_id());
         session.setAttribute("user_pw", mainVO.getUser_pw());
         rttr.addAttribute("loginsuccess");
         
         return "redirect:/";
        }else {
         rttr.addAttribute("loginfail");
         return "redirect:/login";
        }
    }
    
    
    
  //로그아웃
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, RedirectAttributes rttr) {
		session.invalidate();
		rttr.addAttribute("logout");
		return "redirect:/";
	}
    
    
    

    // 아이디 중복 검사
 	@RequestMapping(value = "/joinIdChk", method = RequestMethod.POST)
 	@ResponseBody
 	public String joinIdChkPOST(String user_id) throws Exception{
 		System.out.println("user_id="+user_id);
 		int result = ms.idCheck(user_id);
		logger.info("아이디 = " + result);
		if(result != 0) {
			return "fail";	// 중복 아이디가 존재
		} else {
			return "success";	// 중복 아이디 x
		}	
 	} 
 	
 	
	// 폰번호 중복 검사
  	@RequestMapping(value = "/joinphoneChk", method = RequestMethod.POST)
  	@ResponseBody
  	public String joinphoneChkPOST(String user_phone) throws Exception{
  		int result = ms.phoneCheck(user_phone);
 		logger.info("결과값 = " + result);
 		if(result != 0) {			
 			return "fail";	// 중복 번호가 존재		
 		} else {		
 			return "success";	// 중복 번호 x			
 		}	
	}
  	
  	// 이메일 인증
// 	@RequestMapping(value="/emailCheck", method=RequestMethod.GET)
// 	@ResponseBody
// 	public String emailCheckGET(String user_email) throws Exception{
//
// 		/* 뷰(View)로부터 넘어온 데이터 확인 */
// 		logger.info("이메일 데이터 전송 확인");
// 		logger.info("인증번호 : " + user_email);
// 		
// 		/* 인증번호(난수) 생성 */
//         Random random = new Random();
//         int checkAuthKey = random.nextInt(888888) + 111111;
//         logger.info("인증번호 " + checkAuthKey);
//         
//         /* 이메일 보내기 */
//         String setFrom = "ssnow000@daum.net";
//         String toMail = user_email;
//         String title =  "[푸렌즈] 회원가입 인증 이메일 입니다.";
//         String content = 
//         		 "홈페이지를 방문해주셔서 감사합니다." +
//         	     "<br><br>" + 
//         	     "인증 번호는 " + checkAuthKey + "입니다." + 
//         	     "<br>" + 
//         	     "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
//         
//         try {
//             
//             MimeMessage message = mailSender.createMimeMessage();
//             MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
//             helper.setFrom(setFrom);
//             helper.setTo(toMail);
//             helper.setSubject(title);
//             helper.setText(content,true);
//             mailSender.send(message);
//             
//         }catch(Exception e) {
//             e.printStackTrace();
//         }
//         
//         String AuthKey = Integer.toString(checkAuthKey);
//         
//         return AuthKey;
// 	}
  	
	
}
