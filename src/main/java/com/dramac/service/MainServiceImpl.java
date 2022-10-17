package com.dramac.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dramac.mapper.MainMapper;
import com.dramac.model.MainVO;

@Service
public class MainServiceImpl implements MainService{
	
	 @Autowired 
	 MainMapper mm;
	 
	 public void join(MainVO mainVO) {
	        mm.join(mainVO);
	    }
	 
	 public boolean login(MainVO mainVO, HttpSession session) {
	      	MainVO login=mm.login(mainVO);
	      	boolean result=false;
	      	if(login!=null) {
	      		session.setAttribute("login", login);
	      		result=true;
	      	}
	      	return result;
	    }
	 
	 public int idCheck(String user_id) throws Exception {
			
		 return mm.idCheck(user_id);
	 }
	    
	 public int phoneCheck(String user_phone) throws Exception {
			
		 return mm.phoneCheck(user_phone);

	 }

}
