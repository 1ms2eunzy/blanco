package com.hs.app.dto;

public class Notice_Dto {

   private int notice_idx; 
   private String user_id;
   private String notice_title; 
   private String notice_content;
   private String  notice_credate;
   private int notice_viewcnt;
   
   public Notice_Dto() {}
   
   
   public Notice_Dto(int notice_idx, String user_id, String notice_title, String notice_content, String notice_credate,
         int notice_viewcnt) {
      super();
      this.notice_idx = notice_idx;
      this.user_id = user_id;
      this.notice_title = notice_title;
      this.notice_content = notice_content;
      this.notice_credate = notice_credate;
      this.notice_viewcnt = notice_viewcnt;
   }
   
   public int getNotice_idx() {
      return notice_idx;
   }
   public void setNotice_idx(int notice_idx) {
      this.notice_idx = notice_idx;
   }
   public String getUser_id() {
      return user_id;
   }
   public void setUser_id(String user_id) {
      this.user_id = user_id;
   }
   public String getNotice_title() {
      return notice_title;
   }
   public void setNotice_title(String notice_title) {
      this.notice_title = notice_title;
   }
   public String getNotice_content() {
      return notice_content;
   }
   public void setNotice_content(String notice_content) {
      this.notice_content = notice_content;
   }
   public String getNotice_credate() {
      return notice_credate;
   }
   public void setNotice_credate(String notice_credate) {
      this.notice_credate = notice_credate;
   }
   public int getNotice_viewcnt() {
      return notice_viewcnt;
   }
   public void setNotice_viewcnt(int notice_viewcnt) {
      this.notice_viewcnt = notice_viewcnt;
   }
   
   
}