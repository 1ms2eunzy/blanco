package com.hs.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.app.dto.Reply_Dto;
import com.hs.app.dto.Review_Dto;

@Repository
public class Reply_Dao {

   @Autowired
   private SqlSession sqlSession;
   
   public List<Reply_Dto> read(int idx) {
      return sqlSession.selectList("com.hs.reply_list",idx);
   }
   
   public int insert(Map<String, Object> map) {
      return sqlSession.insert("com.hs.do_reply", map);
   }
   
   public int commentcnt(int idx) {
	   return sqlSession.selectOne("com.hs.commentcnt", idx);
   }
   
   public int reply_update(Map<String, Object> map) {
	   return sqlSession.update("com.hs.doupdate_Reply", map);
   }

   public int deletereply(Map<String, Object> map) {
	   return sqlSession.delete("com.hs.reply_delete", map);
   }
   
}