package com.dramac.mapper;

import java.util.ArrayList;

import com.dramac.model.PhotoAttachVO;

public interface PhotoAttachMapper {
	
	
		public void insert(PhotoAttachVO pavo);
		
		public ArrayList<PhotoAttachVO> attachlist(int pht_bno);

}
