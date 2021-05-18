package com.hs.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.app.dto.Dress_sort_Dto;

@Repository
public class Dress_sort_Dao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Dress_sort_Dto> sortlist(){
		return sqlSession.selectList("com.hs.sortlist");
		
	}
	
	

}
