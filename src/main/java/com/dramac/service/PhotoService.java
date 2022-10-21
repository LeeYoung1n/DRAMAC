package com.dramac.service;

import java.util.ArrayList;

import com.dramac.model.CriteriaVO;
import com.dramac.model.PhotoAttachVO;
import com.dramac.model.PhotoBoardVO;

public interface PhotoService {
	
	public void write(PhotoBoardVO pbvo); 
	
	public ArrayList<PhotoBoardVO> photoList();
	
	public PhotoBoardVO photoDetail(PhotoBoardVO pbvo);
	
	public void photoModify(PhotoBoardVO pbvo);
	
	public void photoRemove(PhotoBoardVO pbvo);
	
	public ArrayList<PhotoBoardVO> photoList(CriteriaVO cri);

	public int total(CriteriaVO cri);


	public ArrayList<PhotoAttachVO> attachlist(int pht_bno);

}
