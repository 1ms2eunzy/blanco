package com.hs.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.app.dto.Dress_inven_Dto;


@Repository
public class Dress_inven_Dao {

	@Autowired
	private SqlSession sqlSession;
		
	
	public int insertinven(Map<String, Object> map) {
		return sqlSession.insert("com.hs.insertinven", map);
	}
	
	public List<Dress_inven_Dto> dresslist(int dress_num){
		return sqlSession.selectList("com.hs.dressinvenlist", dress_num);
		
	}
	
	public int invenallcnt(Map<String, Object> map) {
		
		return sqlSession.selectOne("com.hs.dressallcnt", map);
		
	}
	
	
	
}
