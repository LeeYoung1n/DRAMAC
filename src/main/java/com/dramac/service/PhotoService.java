package com.dramac.service;

import java.util.ArrayList;

import com.dramac.model.CriteriaVO;
import com.dramac.model.PhotoAttachVO;
import com.dramac.model.PhotoBoardVO;

public interface PhotoService {
	
	public void write(PhotoBoardVO pbvo); 
	
	public ArrayList<PhotoBoardVO> list();
	
	public PhotoBoardVO detail(PhotoBoardVO pbvo);
	
	public void modify(PhotoBoardVO pbvo);
	
	public void remove(PhotoBoardVO pbvo);
	
	public ArrayList<PhotoBoardVO> list(CriteriaVO cri);

	public int total(CriteriaVO cri);


	public ArrayList<PhotoAttachVO> attachlist(int bno);

}
