package com.hs.app.dto;

import org.springframework.stereotype.Repository;

/*create table dress_list(

		   dress_num int PRIMARY KEY AUTO_INCREMENT,
		   sort_num INT NOT NULL,
		   dress_name varchar(50) NOT NULL,
		   dress_price INT NOT NULL,
		   dress_color varchar(50) NOT NULL,
		   dress_content TEXT NOT NULL,
		   dress_file_name TEXT NOT NULL
		   
		   
		)default character set utf8 collate UTF8_GENERAL_CI;*/

@Repository
public class Dress_list_Dto {
	private int dress_num;
	private int sort_num;
	private String dress_name;
	private int dress_price;
	private String dress_color;
	private String dress_content;
	private String dress_file_name;
	
	public Dress_list_Dto() {}
	
	public Dress_list_Dto(int dress_num, int sort_num, String dress_name, int dress_price, String dress_color,
			String dress_content, String dress_file_name) {
		super();
		this.dress_num = dress_num;
		this.sort_num = sort_num;
		this.dress_name = dress_name;
		this.dress_price = dress_price;
		this.dress_color = dress_color;
		this.dress_content = dress_content;
		this.dress_file_name = dress_file_name;
	}
	
	
	
	
	
	public int getDress_num() {
		return dress_num;
	}
	public void setDress_num(int dress_num) {
		this.dress_num = dress_num;
	}
	public int getSort_num() {
		return sort_num;
	}
	public void setSort_num(int sort_num) {
		this.sort_num = sort_num;
	}
	public String getDress_name() {
		return dress_name;
	}
	public void setDress_name(String dress_name) {
		this.dress_name = dress_name;
	}
	public int getDress_price() {
		return dress_price;
	}
	public void setDress_price(int dress_price) {
		this.dress_price = dress_price;
	}
	public String getDress_color() {
		return dress_color;
	}
	public void setDress_color(String dress_color) {
		this.dress_color = dress_color;
	}
	public String getDress_content() {
		return dress_content;
	}
	public void setDress_content(String dress_content) {
		this.dress_content = dress_content;
	}
	public String getDress_file_name() {
		return dress_file_name;
	}
	public void setDress_file_name(String dress_file_name) {
		this.dress_file_name = dress_file_name;
	}
}
