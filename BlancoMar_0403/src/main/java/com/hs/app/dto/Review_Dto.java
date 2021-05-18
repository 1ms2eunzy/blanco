package com.hs.app.dto;

public class Review_Dto {

   private int review_idx;
   private String user_id;
   private String review_title;
   private String review_content;
   private String review_credate;
   private int  review_viewcnt;
   private int review_good;
   
   public Review_Dto() {}
   
   
    /*  
      review_idx INT PRIMARY KEY AUTO_INCREMENT,  //글번호
      user_id VARCHAR(50) NOT NULL, // user id 가져옴
      review_title VARCHAR(50) NOT NULL, // 리뷰제목
      review_content TEXT NOT NULL, // 리뷰내용
      review_credate DATE NOT NULL, // 리뷰작성날짜
      review_viewcnt INT DEFAULT 0, // 조회수
      review_good INT DEFAULT 0 //좋아요
     */
   
   

   public Review_Dto(int review_idx, String user_id, String review_title, String review_content, String review_credate,
         int review_viewcnt, int review_good) {
      this.review_idx = review_idx;
      this.user_id = user_id;
      this.review_title = review_title;
      this.review_content = review_content;
      this.review_credate = review_credate;
      this.review_viewcnt = review_viewcnt;
      this.review_good = review_good;
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


   public String getReview_title() {
      return review_title;
   }


   public void setReview_title(String review_title) {
      this.review_title = review_title;
   }


   public String getReview_content() {
      return review_content;
   }


   public void setReview_content(String review_content) {
      this.review_content = review_content;
   }


   public String getReview_credate() {
      return review_credate;
   }


   public void setReview_credate(String review_credate) {
      this.review_credate = review_credate;
   }


   public int getReview_viewcnt() {
      return review_viewcnt;
   }


   public void setReview_viewcnt(int review_viewcnt) {
      this.review_viewcnt = review_viewcnt;
   }


   public int getReview_good() {
      return review_good;
   }


   public void setReview_good(int review_good) {
      this.review_good = review_good;
   }
   
}



   