package com.dramac.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dramac.model.CriteriaVO;
import com.dramac.model.PhotoAttachVO;
import com.dramac.model.PhotoBoardVO;
import com.dramac.model.PhotoPageVO;
import com.dramac.service.PhotoService;

@Controller
public class PhotoController {
	
	
		@Autowired
		PhotoService ps; 
		
		
		@RequestMapping(value="/Photo/photoUpload", method = RequestMethod.GET)
		public String write() {
			return "/Photo/photoUpload";
		}
		
		
		@RequestMapping(value="/Photo/photoUpload", method = RequestMethod.POST)
		public String writePost(PhotoBoardVO pbvo) {
			System.out.println("service??"+pbvo);
			ps.write(pbvo);
			return "redirect:/Photo/photoList";
		}
		
		
		
		@RequestMapping(value="/photo/List", method = RequestMethod.GET)
		public String list(Model model, CriteriaVO cri) {
			model.addAttribute("list", ps.list(cri));
			int total = ps.total(cri);
			model.addAttribute("paging", new PhotoPageVO(cri, total));
			return "Photo/photoList";
		}
		
		
		@RequestMapping(value = "/photo/Detail", method = RequestMethod.GET)
	    public String detail(PhotoBoardVO pbvo, Model model) {
			System.out.println(pbvo);
			model.addAttribute("detail", ps.detail(pbvo));
	    	return "Photo/photoDetail";
	    }

		
		@RequestMapping(value = "/photo/Modify", method = RequestMethod.POST)
	    public String modify(PhotoBoardVO pbvo, RedirectAttributes rttr) {
	    	ps.modify(pbvo);
	    	rttr.addAttribute("bno", pbvo.getPht_bno());
	    	return "redirect:/Photo/photoList";
	    }
		
		@RequestMapping(value = "/photo/Remove", method = RequestMethod.POST)
		public String remove (PhotoBoardVO pbvo) {
			ps.remove(pbvo);
			return "redirect:/Photo/photoList";
		}
		
		
		@RequestMapping(value = "/attachlist", method = RequestMethod.GET)
		public ResponseEntity<ArrayList<PhotoAttachVO>> uploadAjaxPost(int bno){
			return new ResponseEntity<>(ps.attachlist(bno),HttpStatus.OK);
		}

}
