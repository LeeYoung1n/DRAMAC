package com.dramac.model;

public class CriteriaVO {
	
	private int prodnum;
    private int pageNum;
    private int amount;
    private String keyword;
    private String type;
    
    
    
	public int getProdnum() {
		return prodnum;
	}
	public void setProdnum(int prodnum) {
		this.prodnum = prodnum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	@Override
	public String toString() {
		return "CriteriaVO [prodnum=" + prodnum + ", pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword
				+ ", type=" + type + "]";
	}
	

}
