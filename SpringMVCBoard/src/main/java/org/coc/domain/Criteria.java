package org.coc.domain;

public class Criteria {
	private int page;
	private int perPageNum;
	
	public Criteria() {
		//디폴트 기준 강제 부여 
		this.page= 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <=0) {
			this.page =1;
			return;
		}
		this.page = page;
	}

	public int getPageStart() {
		//limit 구문에서시작 위치를 지정할 때 사용 
		
		return (this.page-1)*perPageNum;
	}
	
	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
}
