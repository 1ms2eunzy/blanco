package com.hs.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.app.dto.Notice_Dto;
import com.hs.app.dto.Review_Dto;


@Repository
   public class Notice_Dao {

      @Autowired
      private SqlSession sqlSession;
      
      
      public List<Notice_Dto> notice_list() {
            return sqlSession.selectList("com.hs.notice_list");
         }

      public int insert(Map<String, Object> map) {
         return sqlSession.insert("com.hs.do_notice", map);
      }
      
      
      public Notice_Dto notice_read(int idx) {
         return sqlSession.selectOne("com.hs.notice_one", idx);
      }
      
      public int notice_update(Map<String, Object> map) {
         return sqlSession.update("com.hs.notice_update", map);
      }
      
      public int delete(Map<String, Object> map) {
            return sqlSession.delete("com.hs.notice_delete", map);
         }
      
      
      public int notice_hit(int idx) {
         return sqlSession.update("com.hs.notice_hit", idx);
      }
}