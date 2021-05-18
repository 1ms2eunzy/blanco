package com.hs.app.dto;

public class Dress_sort_Dto {
	
	private int sort_num;
	private String sort_name;
	
	public Dress_sort_Dto() {}
	
	public Dress_sort_Dto(int sort_num, String sort_name) {
		
		this.sort_num = sort_num;
		this.sort_name = sort_name;
		
	}

	public int getSort_num() {
		return sort_num;
	}

	public void setSort_num(int sort_num) {
		this.sort_num = sort_num;
	}

	public String getSort_name() {
		return sort_name;
	}

	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	
	

}
