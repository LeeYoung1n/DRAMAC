package com.dramac.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dramac.mapper.PhotoAttachMapper;
import com.dramac.mapper.PhotoMapper;
import com.dramac.model.CriteriaVO;
import com.dramac.model.PhotoAttachVO;
import com.dramac.model.PhotoBoardVO;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	PhotoMapper pm;	
	
	@Autowired
	PhotoAttachMapper pam;
	
	
	public void write(PhotoBoardVO pbvo) {
		System.out.println("service="+pbvo);
		pm.write(pbvo);
		pbvo.getPht_attach().forEach(pht_attach->{
			pht_attach.setPht_bno(pbvo.getPht_bno());
			pam.insert(pht_attach);
		});
	}
	

	public ArrayList<PhotoBoardVO> photoList() {
		return pm.photoList();
	}
	
	
	@Transactional
	public PhotoBoardVO photoDetail(PhotoBoardVO pbvo) {
		//pm.cntup(pbvo);
		return pm.photoDetail(pbvo);
	}
	
	public void photoModify(PhotoBoardVO pbvo) {
		pm.photoModify(pbvo);
	}
	
	public void photoRemove(PhotoBoardVO pbvo) {
		pm.photoRemove(pbvo);
	}
	
	public ArrayList<PhotoBoardVO> photoList(CriteriaVO cri){
		return pm.photoList(cri);
	}
	
	public int total(CriteriaVO cri) {
		return pm.total(cri);
	}
	

	public ArrayList<PhotoAttachVO> attachlist(int pht_bno){
		return pam.attachlist(pht_bno);
	}
}
