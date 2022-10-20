package com.dramac.model;

import java.util.ArrayList;

public class PhotoBoardVO {

	//게시판 번호
	private int bno;
	//제목
	private String title;
	//내용
	private String content;
	//작성일자
	private String regdate;
	//조회수
	private int cnt;
	//id
	private String user_id;
	
	
	private ArrayList<PhotoAttachVO> attach;


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public ArrayList<PhotoAttachVO> getAttach() {
		return attach;
	}


	public void setAttach(ArrayList<PhotoAttachVO> attach) {
		this.attach = attach;
	}


	@Override
	public String toString() {
		return "PhotoBoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", regdate=" + regdate
				+ ", cnt=" + cnt + ", user_id=" + user_id + ", attach=" + attach + "]";
	}
	
	
	
	
	
}
