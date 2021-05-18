package com.hs.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.app.*;
import com.hs.app.dto.Review_Dto;

@Repository
public class Review_Dao {
	
   @Autowired
   private SqlSession sqlSession;
   
   public List<Review_Dto> review_list() {
      return sqlSession.selectList("com.hs.review_list");
   }
   
   public int insert(Map<String, Object> map) {
	   return sqlSession.insert("com.hs.do_review", map);
	}
   
   public Review_Dto read(int idx) {
	   return sqlSession.selectOne("com.hs.review_one", idx);
   }

   public int review_update(Map<String, Object> map) {
	   return sqlSession.update("com.hs.doupdate_Review", map);
   }

   public int delete(Map<String, Object> map) {
	      return sqlSession.delete("com.hs.delete", map);
	      }
   
   public int updateHit(int idx) {
	   return sqlSession.update("com.hs.update_hit", idx);
   }
   

}