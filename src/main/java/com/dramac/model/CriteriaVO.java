package com.dramac.model;

public class CriteriaVO {
	
	private int prodnum;
    private int pageNum;
    private int amount;
    private String keyword;
    private String type;
    private String sep;
    private String subsep;
    
    public CriteriaVO() {
    	this(1,10);
    }
    
    public CriteriaVO(int pageNum, int amount) {
    	this.pageNum = pageNum;
    	this.amount = amount;
    }

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

	public String getSep() {
		return sep;
	}

	public void setSep(String sep) {
		this.sep = sep;
	}

	public String getSubsep() {
		return subsep;
	}

	public void setSubsep(String subsep) {
		this.subsep = subsep;
	}

	@Override
	public String toString() {
		return "CriteriaVO [prodnum=" + prodnum + ", pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword
				+ ", type=" + type + ", sep=" + sep + ", subsep=" + subsep + "]";
	}
    
    
    
    

}
