package com.scxh.twoclass.servlet;


public class PageUtil {

	private int pageSize;// 每页多少条数据
	private int recordCount; // 总记录条数
	private int currentPage;// 当前页
	private int pageCount;// 总页数据 

	public PageUtil(int pageSize, int recordCount, int currentPage) {
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.setCurrentPage(currentPage);

	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * 
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		int activePage = currentPage <= 0 ? 1 : currentPage;
		activePage = activePage > getPageCount() ? getPageCount() : activePage;
		this.currentPage = activePage;
	}

	/**
	 * 
	 * @return
	 */
	public int getPageCount() {
		pageCount = recordCount / pageSize;
		int mod = recordCount % pageSize;
		if (mod != 0) {
			pageCount++;
		}
		return recordCount == 0 ? 1 : pageCount;
	}

	public int getFromIndex() {
		return (currentPage - 1) * pageSize;
	}

	public int getToIndex() {

		return Math.min(recordCount, currentPage * pageSize);
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
