package com.dramac.model;

import java.util.ArrayList;

public class PhotoBoardVO {

	//게시판 번호
	private int pht_bno;
	//제목
	private String pht_title;
	//내용
	private String pht_content;
	//작성일자
	private String pht_regdate;
	//조회수
	private int pht_cnt;
	//id
	private String user_id;
	//rownum
	private int pht_rownum;
	//이미지 파일명
	private String pht_fileName;
	
	
	private ArrayList<PhotoAttachVO> pht_attach;


	public int getPht_bno() {
		return pht_bno;
	}


	public void setPht_bno(int pht_bno) {
		this.pht_bno = pht_bno;
	}


	public String getPht_title() {
		return pht_title;
	}


	public void setPht_title(String pht_title) {
		this.pht_title = pht_title;
	}


	public String getPht_content() {
		return pht_content;
	}


	public void setPht_content(String pht_content) {
		this.pht_content = pht_content;
	}


	public String getPht_regdate() {
		return pht_regdate;
	}


	public void setPht_regdate(String pht_regdate) {
		this.pht_regdate = pht_regdate;
	}


	public int getPht_cnt() {
		return pht_cnt;
	}


	public void setPht_cnt(int pht_cnt) {
		this.pht_cnt = pht_cnt;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public ArrayList<PhotoAttachVO> getPht_attach() {
		return pht_attach;
	}


	public void setPht_attach(ArrayList<PhotoAttachVO> pht_attach) {
		this.pht_attach = pht_attach;
	}
	
	
	


	public int getPht_rownum() {
		return pht_rownum;
	}


	public void setPht_rownum(int pht_rownum) {
		this.pht_rownum = pht_rownum;
	}


	public String getPht_fileName() {
		return pht_fileName;
	}


	public void setPht_fileName(String pht_fileName) {
		this.pht_fileName = pht_fileName;
	}


	@Override
	public String toString() {
		return "PhotoBoardVO [pht_bno=" + pht_bno + ", pht_title=" + pht_title + ", pht_content=" + pht_content
				+ ", pht_regdate=" + pht_regdate + ", pht_cnt=" + pht_cnt + ", user_id=" + user_id + ", pht_rownum="
				+ pht_rownum + ", pht_fileName=" + pht_fileName + ", pht_attach=" + pht_attach + "]";
	}

	
	


	
	
	
	
	
}
