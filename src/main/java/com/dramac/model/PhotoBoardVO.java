package com.dramac.model;

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
	private int count;
	//id
	private String user_id;
	
	
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	@Override
	public String toString() {
		return "PhotoBoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", regdate=" + regdate
				+ ", count=" + count + ", user_id=" + user_id + "]";
	}
	
	
	
	
}
