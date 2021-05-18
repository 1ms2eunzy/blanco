package com.hs.app.dto;

public class User_Dto {
	private int user_idx;
	private String user_id;
	private String user_password;
	private String user_addres;
	private String user_tel;
	private int  user_grade;
	private String user_name;
	
	public User_Dto() {}
	
//	
//	user_idx INT PRIMARY KEY AUTO_INCREMENT,//인덱스
//	user_id VARCHAR(50) NOT NULL, // 아이디
//	user_password VARCHAR(50) NOT NULL, //패스워드
//	user_name VARCHAR(50) NOT NULL, // 네임
//	user_addres VARCHAR (50) NOT NULL, //주소
//	user_tel VARCHAR(50) NOT NULL,  // 전화
//	user_grade INT NOT NULL DEFAULT 1  //등급
	
	public User_Dto(int user_idx, String user_id, String user_password,String user_name, String user_addres, String user_tel,
			int user_grade) {
		
		this.user_idx = user_idx;
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_addres = user_addres;
		this.user_tel = user_tel;
		this.user_grade = user_grade;
		this.user_name = user_name;
	}

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_addres() {
		return user_addres;
	}

	public void setUser_addres(String user_addres) {
		this.user_addres = user_addres;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public int getUser_grade() {
		return user_grade;
	}

	public void setUser_grade(int user_grade) {
		this.user_grade = user_grade;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
	
	
	
	
	
}
