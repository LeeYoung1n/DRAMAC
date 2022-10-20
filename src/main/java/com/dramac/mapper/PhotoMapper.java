package com.dramac.mapper;

import java.util.ArrayList;

import com.dramac.model.CriteriaVO;
import com.dramac.model.PhotoBoardVO;

public interface PhotoMapper {
	
		public void write(PhotoBoardVO pbvo);
		
		public ArrayList<PhotoBoardVO> list();
		
		public PhotoBoardVO detail(PhotoBoardVO pbvo);
		
		public void modify(PhotoBoardVO pbvo);
		
		public void remove(PhotoBoardVO pbvo);
		
		public ArrayList<PhotoBoardVO> list(CriteriaVO cri);
		
		public int total();
		
		public void cntup(PhotoBoardVO pbvo);
		
		public int total(CriteriaVO cri);

}
