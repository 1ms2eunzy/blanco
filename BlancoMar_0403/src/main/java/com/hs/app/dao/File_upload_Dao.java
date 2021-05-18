package com.hs.app.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class File_upload_Dao {

	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertfile(Map<String, Object> map){
		return sqlSession.insert("com.hs.insertfile",map);
		
	}
	
}
