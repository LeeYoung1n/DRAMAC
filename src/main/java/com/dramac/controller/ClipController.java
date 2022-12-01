package com.dramac.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dramac.mapper.ClipMapper;

@Controller
public class ClipController {
	
	private static final ServletRequest req = null;
	//DAO객체 생성
	private ClipMapper cm=new ClipMapper();
	
//	public CipController() {
//		System.out.println("-----MediaCont() 객체 생성 됨");
//	}//MediaCont end
//------------------- 파일 등록 --------------------------------------------------------------------------------	
	//결과 확인 http://localhost:8090/mymelon/media/create.do
	// get 방식
	@RequestMapping(value = "/photo/ClipList", method = RequestMethod.GET)
	public String createForm() {
		return "/Video/clipWrite";
	}//createForm() end


	//post 방식
	@RequestMapping(value = "/photo/ClipList", method = RequestMethod.POST)
	public ModelAndView createForm(MediaDTO dto, HttpServletRequest req) {
		//1) pom.xml → 파일 업로드 / 다운로드 관련 의존성 추가
		//2) MediaDTO → postMF, filenameMF 필드 추가 후 getter, setter 함수 생성
		//3) servlet-context.xml에 스프링빈 등록
		ModelAndView mav=new ModelAndView();
		mav.setViewName("media/msgView");  //화면에 보일 view 단 (.jsp)
		mav.addObject("root", Utility.getRoot());  //utility 안에 있는 root : mymelon
//-------------------------------------------------------------------------------------------------------			
//	전송된 파일 처리
//  → 실제 파일은 /media/storage 폴더에 저장
//  → 저장된 파일 관련 정보는 media테이블에 저장
		String basePath=req.getRealPath("/media/storage");  //realpath 사용하지 말라고 하지만 그냥 진행
		
		//1) createForm.jsp의 <input type='file' name='posterMF' size='50'>
		//dto로 받아오기 위해서 getter, setter추가
		MultipartFile posterMF = dto.getPosterMF();
		
		//파일 저장하고 리네임된 파일명 반환 (똑같은 파일명을 가진 파일이 있 수도 있기 때문에 똑같은 파일명이 있을 경우 리네임 시켜줘야함)
		//posterMF 라는 파일 값을 경로에서 찾아보고 있으면 리네임
		//net.utility.Utility.UploadSaveManger.saveFileSpring30은 static 함수라서 이렇게 빨리 쓸 수 있음, 리턴값이 String 이라서 String poster.
		String poster=UploadSaveManager.saveFileSpring30(posterMF, basePath); //(파일명, 경로)
		
		//리네임된 파일명을 dto 객체에 담기
		dto.setPoster(poster);
		
		//2) createForm.jsp의 <input type='file' name='filenameMF' size='50'>
		//파일이름 뿐만 아니라 파일 사이즈도 가져와야 하기 때무넹 filenameMF의 size()도 챙기기
		MultipartFile filenameMF=dto.getFilenameMF();
		String filename=UploadSaveManager.saveFileSpring30(filenameMF, basePath);
		dto.setFilename(filename);
		dto.setFilesize(filenameMF.getSize());
//-------------------------------------------------------------------------------------------------------
		int cnt=dao.create(dto);
		if(cnt==0) {
			mav.addObject("msg1", "<p>음원등록 실패T.T</p>");
			mav.addObject("img", "<img src='../images/fail.png'>");
			mav.addObject("link1", "<input type='button' value='목록으로' onclick='location.href=\"list.do\"'>");
			mav.addObject("link2", "<input type='button' value='다시시도' onclick='javascript:history.back()'>");
		}else {
			mav.addObject("msg1", "<p>음원등록 성공!</p>");
			mav.addObject("img", "<img src='../images/sound.png'>");
			mav.addObject("link1", "<input type='button' value='목록으로' onclick='location.href=\"list.do\"'>");
		
		}//if end
		return mav;
	}//createForm() end


}


//https://www.youtube.com/watch?v=50P-2N6uex4