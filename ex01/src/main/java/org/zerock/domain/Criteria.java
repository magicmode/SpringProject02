package org.zerock.domain;

public class Criteria {

	private int page;
	private int prePageNum;
	
	public Criteria() {
		this.page = 1;
		this.prePageNum = 10;
	}
		
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		
		if (page < 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}
	
	public int getPrePageNum() {
		return prePageNum;
	}
	
	public void setPrePageNum(int prePageNum) {
		
		if (prePageNum <= 0 || prePageNum > 100) {
			this.prePageNum = 10;
			return;
		}
		
		this.prePageNum = prePageNum;
	}
	
	public int getPageStart() {
		return (this.page - 1) * prePageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", prePageNum=" + prePageNum + "]";
	}
	
}
