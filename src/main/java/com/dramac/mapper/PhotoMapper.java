package com.dramac.mapper;

import java.util.ArrayList;

import com.dramac.model.CriteriaVO;
import com.dramac.model.PhotoBoardVO;

public interface PhotoMapper {
	
		public void write(PhotoBoardVO pbvo);
		
		public ArrayList<PhotoBoardVO> photoList();
		
		public PhotoBoardVO photoDetail(PhotoBoardVO pbvo);
		
		public void photoModify(PhotoBoardVO pbvo);
		
		public void photoDelete(PhotoBoardVO pbvo);
		
		// 글 목록 리스트 설계
		public ArrayList<PhotoBoardVO> photoList(CriteriaVO cri);
		
		//public int total();
		
		public void photoCnt(PhotoBoardVO pbvo);
		
		public int total(CriteriaVO cri);

}
