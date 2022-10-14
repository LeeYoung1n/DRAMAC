package com.dramac.service;

import javax.servlet.http.HttpSession;

import com.dramac.model.MainVO;

public interface MainService {
	
	public boolean login(MainVO mainVO, HttpSession session);

}
