package com.dramac.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Main(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "Main/home";
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
	
}
