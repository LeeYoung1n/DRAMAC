package com.dramac.model;

public class PhotoAttachVO {
	
	//uuid
	private String pht_uuid;
	//파일 저장 경로
	private String pht_uploadPath;
	//파일명
	private String pht_fileName;
	//이미지 파일 판별 여부
	private boolean pht_image;
	//게시물 번호
	private int pht_bno;
	
	
	public String getPht_uuid() {
		return pht_uuid;
	}
	public void setPht_uuid(String pht_uuid) {
		this.pht_uuid = pht_uuid;
	}
	public String getPht_uploadPath() {
		return pht_uploadPath;
	}
	public void setPht_uploadPath(String pht_uploadPath) {
		this.pht_uploadPath = pht_uploadPath;
	}
	public String getPht_fileName() {
		return pht_fileName;
	}
	public void setPht_fileName(String pht_fileName) {
		this.pht_fileName = pht_fileName;
	}
	public boolean isPht_image() {
		return pht_image;
	}
	public void setPht_image(boolean pht_image) {
		this.pht_image = pht_image;
	}
	public int getPht_bno() {
		return pht_bno;
	}
	public void setPht_bno(int pht_bno) {
		this.pht_bno = pht_bno;
	}
	
	@Override
	public String toString() {
		return "PhotoAttachVO [pht_uuid=" + pht_uuid + ", pht_uploadPath=" + pht_uploadPath + ", pht_fileName="
				+ pht_fileName + ", pht_image=" + pht_image + ", pht_bno=" + pht_bno + "]";
	}
	
	
	

}
