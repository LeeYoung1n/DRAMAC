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
	
	public void photoDelete(PhotoBoardVO pbvo);
	
	// 글 목록 리스트 설계
	public ArrayList<PhotoBoardVO> photoList(CriteriaVO cri);

	public int total(CriteriaVO cri);


	public ArrayList<PhotoAttachVO> photo_attachlist(int pht_bno);

}