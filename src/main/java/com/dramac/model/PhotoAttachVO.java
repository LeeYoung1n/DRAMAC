package com.dramac.model;

public class PhotoAttachVO {
	
	//파일 저장 경로
	private String uploadPath;
	//파일명
	private String filename;
	//uuid
	private String uuid;
	//이미지 파일 판별 여부
	private boolean image;
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
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
	
	@Override
	public String toString() {
		return "PhotoAttachVO [uploadPath=" + uploadPath + ", filename=" + filename + ", uuid=" + uuid + ", image="
				+ image + "]";
	}	
	
	

}
