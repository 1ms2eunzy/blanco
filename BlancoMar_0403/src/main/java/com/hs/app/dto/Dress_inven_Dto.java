package com.hs.app.dto;


/*create table dress_inven(

		   dress_num INT NOT NULL, 
		   dress_size VARCHAR(50) NOT NULL, 
		   dress_stock INT NOT NULL
		   
		)default character set utf8 collate UTF8_GENERAL_CI;*/

public class Dress_inven_Dto {
	private int dress_num;
	private String dress_size;
	private int dress_stock;
	
	public Dress_inven_Dto() {}
	
	public Dress_inven_Dto(int dress_num, String dress_size, int dress_stock) {
		super();
		this.dress_num = dress_num;
		this.dress_size = dress_size;
		this.dress_stock = dress_stock;
	}
	public int getDress_num() {
		return dress_num;
	}
	public void setDress_num(int dress_num) {
		this.dress_num = dress_num;
	}
	public String getDress_size() {
		return dress_size;
	}
	public void setDress_size(String dress_size) {
		this.dress_size = dress_size;
	}
	public int getDress_stock() {
		return dress_stock;
	}
	public void setDress_stock(int dress_stock) {
		this.dress_stock = dress_stock;
	}
	
	
}
