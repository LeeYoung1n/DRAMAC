package com.dramac.model;

public class PhotoAttachVO {
	
	//파일 저장 경로
	private String uploadPath;
	//파일명
	private String fileName;
	//uuid
	private String uuid;
	//이미지 파일 판별 여부
	private boolean image;
	//게시물 번호
	private int bno;
	
	
	
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean isImage() {
		return image;
	}
	public void setImage(boolean image) {
		this.image = image;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	
	@Override
	public String toString() {
		return "PhotoAttachVO [uploadPath=" + uploadPath + ", fileName=" + fileName + ", uuid=" + uuid + ", image="
				+ image + ", bno=" + bno + "]";
	}
	
	
	
	

}
