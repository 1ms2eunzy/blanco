package com.hs.app.dto;


//create table blancomarimg_file(
//		   file_idx int PRIMARY KEY AUTO_INCREMENT,
//		   dress_num int not null,
//		   sort_num int not null,
//		   file_name text not null,
//		   file_path text not null
//		)default character set utf8 collate UTF8_GENERAL_CI;

public class File_upload_Dto {
	private int file_idx;
	private int dress_num;
	private int sort_num;
	private String file_name;
	private String file_path;
	
	public File_upload_Dto() {}
	
	public File_upload_Dto(int file_idx, int dress_num, int sort_num, String file_name, String file_path) {
		super();
		this.file_idx = file_idx;
		this.dress_num = dress_num;
		this.sort_num = sort_num;
		this.file_name = file_name;
		this.file_path = file_path;
	}

	public int getFile_idx() {
		return file_idx;
	}
	public void setFile_idx(int file_idx) {
		this.file_idx = file_idx;
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
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	
}
