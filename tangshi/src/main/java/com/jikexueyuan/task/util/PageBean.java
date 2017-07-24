package com.jikexueyuan.task.util;

/**
 * 分页实体类类
 * 
 * @author
 *
 */
public class PageBean {

	private int currentPage=1; // 第几页
	private int pageSize; // 每页记录数
	private int total;// 总数
	private String targetUrl;// 目标地址
	private String params;// 附加参数
	public PageBean(int currentPage, int pageSize, int total, String targetUrl, String params) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.total = total;
		this.targetUrl = targetUrl;
		this.params = params;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		if (currentPage >= 1) {
			this.currentPage = currentPage;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
	public boolean isHasPrevious() {
		return this.currentPage > 1;
	}
	public boolean isHasnext() {
		return currentPage <getTotalPage();
	}
	public int getTotalPage() {
		return total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
	}
	public int getStart() {
		return (currentPage - 1) * this.pageSize;
	}

}
