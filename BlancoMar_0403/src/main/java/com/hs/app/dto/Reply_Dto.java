package com.hs.app.dto;

public class Reply_Dto {
   
      private int comment_idx;
      private int review_idx;
      private String user_id;
      private String comment_content;
      private String comment_credate;
   
      
      public Reply_Dto() {}
      
      
   public Reply_Dto(int comment_idx, int review_idx, String user_id, String comment_content, String comment_credate) {
      
      this.comment_idx = comment_idx;
      this.review_idx = review_idx;
      this.user_id = user_id;
      this.comment_content = comment_content;
      this.comment_credate = comment_credate;
   }
   public int getComment_idx() {
      return comment_idx;
   }
   public void setComment_idx(int comment_idx) {
      this.comment_idx = comment_idx;
   }
   public int getReview_idx() {
      return review_idx;
   }
   public void setReview_idx(int review_idx) {
      this.review_idx = review_idx;
   }
   public String getUser_id() {
      return user_id;
   }
   public void setUser_id(String user_id) {
      this.user_id = user_id;
   }
   public String getComment_content() {
      return comment_content;
   }
   public void setComment_content(String comment_content) {
      this.comment_content = comment_content;
   }
   public String getComment_credate() {
      return comment_credate;
   }
   public void setComment_credate(String comment_credate) {
      this.comment_credate = comment_credate;
   }

    
      
}