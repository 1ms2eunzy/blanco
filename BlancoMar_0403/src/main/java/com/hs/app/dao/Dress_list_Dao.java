package com.hs.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.app.dto.Dress_list_Dto;
import com.hs.app.dto.File_upload_Dto;

@Repository
public class Dress_list_Dao {

	@Autowired
	private SqlSession sqlSession;
		
	
	public int insertlist(Map<String, Object> map) {
		return sqlSession.insert("com.hs.insertlist", map);
	}
	
	public int maxnum() {
		return sqlSession.selectOne("com.hs.maxnum");
	}
	
	public List<Dress_list_Dto> dresslist(){
		return sqlSession.selectList("com.hs.dresslist");
		
	}
	
	public List<Dress_list_Dto> sideall(){
		return sqlSession.selectList("com.hs.sideall");
		
	}
	public List<Dress_list_Dto> sideouter(){
		return sqlSession.selectList("com.hs.sideouter");
		
	}
	public List<Dress_list_Dto> sidetop(){
		return sqlSession.selectList("com.hs.sidetop");
		
	}
	public List<Dress_list_Dto> sidepants(){
		return sqlSession.selectList("com.hs.sidepants");
		
	}
	public List<File_upload_Dto> detailpage(int dress_num){
		return sqlSession.selectList("com.hs.detailpage",dress_num);
		
	}
	
	public Dress_list_Dto dressone(int dress_num) {
		return sqlSession.selectOne("com.hs.dressone", dress_num);
		
	}


	
}
