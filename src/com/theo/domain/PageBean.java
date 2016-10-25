package com.theo.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;


//分页的bean
@Component
public class PageBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pageNow;
	private int pageSize;
	private int rowCount;
	private int pageCount;
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public PageBean(int pageNow, int pageSize, int rowCount, int pageCount) {
		super();
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.pageCount = pageCount;
	}
	public PageBean() {
		super();
	}
	
}
