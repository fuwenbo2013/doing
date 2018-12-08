package com.tarena.vo;

import java.io.Serializable;
import java.util.List;

import com.tarena.entity.Role;

public class Page implements Serializable{
	private int currentPage;
	private String roleKW;
	private int previousPage;
	private int nextPage;
	private int totalCount;
	private int totalPages;
	private int begin;
	private List<Integer> nums;
	private List<Role> roles;
	private int pageSize;
	private int showNum;
	public int getShowNum() {
		return showNum;
	}
	public void setShowNum(int showNum) {
		this.showNum = showNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getRoleKW() {
		return roleKW;
	}
	public void setRoleKW(String roleKW) {
		this.roleKW = roleKW;
	}
	public int getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getBegin() {
		return begin=(currentPage-1)*pageSize;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public List<Integer> getNums() {
		return nums;
	}
	public void setNums(List<Integer> nums) {
		this.nums = nums;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", roleKW=" + roleKW + ", previousPage=" + previousPage
				+ ", nextPage=" + nextPage + ", totalCount=" + totalCount + ", totalPages=" + totalPages + ", begin="
				+ begin + ", nums=" + nums + ", roles=" + roles + ", pageSize=" + pageSize + ", showNum=" + showNum
				+ "]";
	}
	

}
