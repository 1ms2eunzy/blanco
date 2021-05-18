package com.hs.app;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hs.app.dao.Dress_inven_Dao;
import com.hs.app.dao.Dress_list_Dao;
import com.hs.app.dao.Dress_sort_Dao;
import com.hs.app.dao.File_upload_Dao;
import com.hs.app.dao.Notice_Dao;
import com.hs.app.dao.Reply_Dao;
import com.hs.app.dao.Review_Dao;
import com.hs.app.dao.User_Dao;
import com.hs.app.dto.Dress_list_Dto;
import com.hs.app.dto.File_upload_Dto;
import com.mysql.cj.xdevapi.JsonArray;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	User_Dao udao;
	
	@Autowired
	Dress_list_Dao dldao;
	
	@Autowired
	Review_Dao rdao;
	
	@Autowired
	Dress_inven_Dao didao;
	
	@Autowired
	Reply_Dao rpdao;
	
	@Autowired
	Dress_sort_Dao dsdao;
	
	@Autowired
	Notice_Dao ndao;
	
	@Autowired
	File_upload_Dao iudao;
	
	@Autowired
	private ServletContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main";
	}
	
	/*
	 * 
	 * 민욱님 로그인 부분 
	 * 
	 * 
	 * */
	
	@RequestMapping("/login")
	public String login() {
		System.out.println("로그인");
		return "login";
	}
	
	@RequestMapping("/logindo")
	   public String logindo(String user_id,String user_password, HttpSession session, Model model){
	      Map<String, Object> map = new HashMap<String, Object>();
	      map.put("user_id", user_id);
	      map.put("user_password", user_password);
	      int grede = udao.admintest(user_id);
	      
	      
	      int res = udao.logindo(map);
	      if(res==1) {
	    	  //로그인 세션부분
	    	  if(grede >= 6) {
	    		  session.setAttribute("loginid", user_id);
	    		  session.setAttribute("loginidgrade", grede);
	    		  
	    		  return "main";
	    	  }else {
	    		  session.setAttribute("loginid", user_id);
	    		  return "main";
	    	  }
	      }else {
	    	 return "login";
	      }
		
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, String user_id ) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		session.removeAttribute("loginidgrade");
		session.removeAttribute("loginid");
		return "main";
		
	}
	
	//로그인 에이젝스 겨우 성공 ^^~
	@SuppressWarnings("unchecked")
	@RequestMapping("/loginchk")
	public void loginchk(HttpServletResponse respose, String user_id, 
			String user_password) throws IOException {
		 
		Map<String, Object> map = new HashMap<String, Object>();
	      map.put("user_id", user_id);
	      map.put("user_password", user_password);
	      
		int test = udao.logindo(map);
		JSONObject json = new JSONObject();
		if(test == 0) {
			json.put("result", "아이디 혹은 비밀번호가 틀렸습니다");
			respose.getWriter().print(json.toString());
		}else {
			json.put("result", "성공");
			respose.getWriter().print(json.toString());
		}
	}
	
	//ajax 회원가입 중복 체크
    @SuppressWarnings("unchecked")
   @RequestMapping( "/log_upchk")
    public void  log_upchk(String user_id, HttpServletResponse respose) throws IOException {
       String str="이미 존재하는 아이디 입니다.";
       System.out.println(user_id);
      
       int log_upchk = udao.log_upchk(user_id); //로그체크 dao 연결
       
       System.out.println("ddddddd"+log_upchk);
       
       JSONObject json = new JSONObject();  //제이슨 객체 선언
       
       if(log_upchk==0) {
          str="사용 가능합니다.";
          
       }
       System.out.println(str);
       json.put("result", str);
       respose.getWriter().print(json.toString());
       
    }

	
	@RequestMapping("/log_up")
	public String regmem() {
	
		return "log_up";
	}
	
	
	@RequestMapping("/insertlogin")
	public String insertlogin(String user_id, String user_password, String user_name, String user_tel, String user_addres ) {
		System.out.println("회원가입");
		//insert into user_list values (null, #{user_id}, #{user_password}, #{user_addres}, #{user_tel},default, #{user_name}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("user_password", user_password);
		map.put("user_name", user_name);
		map.put("user_tel", user_tel);
		map.put("user_addres", user_addres);
		
		udao.insertlogin(map);
		
		return "redirect:/";
	}
		
	
	/*
	 * 
	 * 재승님 재고 부분 
	 * 
	 * 
	 * */
	
	@RequestMapping("/listreg")
	public String listreg(Model model) {
		model.addAttribute("result", dsdao.sortlist());
		return "list_reg";
		
	}
	
	
	
	@RequestMapping("/insertlist")
	public String insertlist(int sort_num, String dress_name, int dress_price, String dress_color, String dress_content, 
								MultipartHttpServletRequest mrequest) {
		System.out.println("재고등록 성공");
		//insert into dress_list values(null, #{sort_num}, #{dress_name},#{dress_price},#{dress_color},#{dress_content},#{dress_file_name})
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(sort_num);
		//넘어온 파일에서 이름 뽑아내기 - filename
		MultipartFile file = mrequest.getFile("dress_file_name");
		String dress_file_name = file.getOriginalFilename();
		
		//넘어온 name 가져오기 - name
		String name=mrequest.getParameter("name");
		
		//넘어온 mrequest를 가지고 파일업로드 처리
		String root_path=context.getRealPath("/");
		String attach_path="resources/thumbnail/";
		
		//파일업로드 메서드
		//file.transferTo(new File("위치를 포함한 파일명"));
		try {
			file.transferTo(new File(root_path+attach_path+dress_file_name));
			System.out.println(dress_file_name+"파일 업로드 완료!");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.put("sort_num", sort_num);
		map.put("dress_name", dress_name);
		map.put("dress_price", dress_price);
		map.put("dress_color", dress_color);
		map.put("dress_content", dress_content);
		map.put("dress_file_name", dress_file_name);
		
		
		dldao.insertlist(map);
		
		
		return "redirect:/dresslist";
	}
	
	
	
	//이미지 파일 업로드!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	@RequestMapping("/insertfile")
	public String insertfile(int dress_num,  int sort_num, String file_path,
								MultipartHttpServletRequest mrequest) {
		
		System.out.println("재고등록 성공");
		//insert into dress_list values(null, #{dress_num}, #{sort_num},#{file_name},#{file_path})
		Map<String, Object> map = new HashMap<String, Object>();
	
		
		
		
		
		//넘어온 파일에서 이름 뽑아내기 - filename
		
		MultipartFile file = mrequest.getFile("file_name");
		String file_name = file.getOriginalFilename();

		//넘어온 name 가져오기 - name
		String name=mrequest.getParameter("name");
//		System.out.println(file_name+":"+name);
		
		//넘어온 mrequest를 가지고 파일업로드 처리		
		String root_path=context.getRealPath("/");
		String attach_path="resources/"+file_path+"/";
		
		//파일업로드 메서드
		//file.transferTo(new File("위치를 포함한 파일명"));
		try {
			file.transferTo(new File(root_path+attach_path+file_name));
			System.out.println(file_name+"파일 업로드 완료!");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.put("dress_num", dress_num);
		map.put("sort_num", sort_num);
		map.put("file_name", file_name);
		map.put("file_path", file_path);
		
		iudao.insertfile(map);
		
		return "redirect:/";
	}
	
	
	
	@RequestMapping("/insertinven")
	public String insertinven(int dress_num, String[] dress_size, int[] dress_stock) {
		System.out.println("재고등록 성공");
		//insert into dress_list values(null, #{sort_num}, #{dress_name},#{dress_price},#{dress_color},#{dress_content},#{dress_file_name})
		for(int i=0;i<dress_size.length;i++) {
			Map<String, Object> map = new HashMap<String, Object>();			
			map.put("dress_num", dress_num);
			map.put("dress_size", dress_size[i]);
			map.put("dress_stock", dress_stock[i]);
			didao.insertinven(map);			
		}
		
		return "redirect:/invenlist?dress_num="+dress_num;
	}
	
	@RequestMapping("/dresslist")
	public String dresslist(Model model) {
		
		model.addAttribute("dresslist",dldao.dresslist());
		return "dress_list";
		
	}
	//재고 상세페이지 보이는 부분
	@RequestMapping("/invenlist")
	public String inveninsert(int dress_num, Model model, HttpSession session) {
		model.addAttribute("dressinven",didao.dresslist(dress_num));
		model.addAttribute("dressone", dldao.dressone(dress_num));
		model.addAttribute("fileimg", dldao.detailpage(dress_num));
		model.addAttribute("sort", dsdao.sortlist());
		return "inven_insert";
		
	}
	
	
	
	/*
	 * 
	 * 
	 * 은지님 게시판 부분 
	 * 
	 * 
	 * */
	
	
	
	@RequestMapping("/review_list")
	   public String review(HttpSession session, Model model, String user_id) {
	      model.addAttribute("result", rdao.review_list());
	      return "review_list";
	   }
	
	   @RequestMapping("/review")
	   public String reviews(HttpSession session, String user_id) {
		   session.setAttribute("loginid", user_id);
	      return "review_insert";
	   }
	   
	   @RequestMapping("do_review")
	   public String doreview(String review_title, String user_id, String review_content) {
	      Map<String, Object> map = new HashMap<String, Object>();
	      map.put("user_id", user_id);
	      map.put("review_title", review_title);
	      map.put("review_content", review_content);
	      
	      rdao.insert(map);
	      return "redirect:/review_list";
	   }
	   
	   @RequestMapping("/review_read")
	   public String read(int idx, Model model, HttpSession session) {
	      //rdao.updateHit(idx);
	      model.addAttribute("result", rdao.read(idx));
	      model.addAttribute("result2", rpdao.read(idx)); //댓글
	      rdao.updateHit(idx); //조회수
	      
	      
	      int commtcnt = rpdao.commentcnt(idx);
	      session.setAttribute("commtcnt", commtcnt);
	      
	      return "review_read";
	   }
	   
	   @RequestMapping("/review_update")
	   public String review_update(int idx, Model model) {
	      //rdao.updateHit(idx);
	      model.addAttribute("result", rdao.read(idx));
	      
	      return "review_update";
	   }
	   
	   @RequestMapping("do_update")
	   public String updates(int review_idx, String review_title, String review_content) {
		   
	         Map<String, Object> map = new HashMap<String, Object>();
	         
	         map.put("review_title", review_title);
	         map.put("review_content", review_content);
	         map.put("review_idx", review_idx);
	         
	         rdao.review_update(map);
	         
	         return "redirect:/review_list";
	         
	      }
	   
	   @RequestMapping("/delete")
	   public String deletdo(int review_idx) {
	      Map<String, Object> map = new HashMap<String, Object>();
	      map.put("review_idx", review_idx);
	      rdao.delete(map);
	      
	      
	      
	      return "redirect:/review_list";

	   }
	   
	   @RequestMapping("replyProc")
	   public String replyProc(int review_idx, String user_id, String comment_content) {
	      Map<String, Object> map = new HashMap<String, Object>();

	      map.put("review_idx", review_idx);
	      map.put("user_id", user_id);
	      map.put("comment_content", comment_content);

	      rpdao.insert(map);
	      
	      
	      return "redirect:/review_read?idx="+review_idx;

	   }
	   
	   //공지
	   
	   @RequestMapping("/notice_list")
	   public String notice_list(HttpSession session, Model model, String user_id) {
	         model.addAttribute("result", ndao.notice_list());
	      return "notice_list";
	      
	   }
	   
	   @RequestMapping("/notice_insert")
	   public String notice_insert() {
	      
	      return "notice_insert";
	      
	   }
	   
	      @RequestMapping("do_notice")
	      public String donotice(String user_id, String notice_title, String notice_content) {
	         Map<String, Object> map = new HashMap<String, Object>();
	         map.put("user_id", user_id);
	         map.put("notice_title", notice_title);
	         map.put("notice_content", notice_content);
	         
	         ndao.insert(map);
	         return "redirect:/notice_list";
	      }
	      
	      @RequestMapping("/notice_read")
	      public String notice_read(int idx, Model model) {
	   
	         model.addAttribute("result", ndao.notice_read(idx));
	        
	         ndao.notice_hit(idx); //조회수
	         
	         
	         return "notice_read";
	      }
	      
	      @RequestMapping("/notice_update")
	      public String notice_update(int idx, Model model) {
	         model.addAttribute("result", ndao.notice_read(idx));
	         
	         return "notice_update";
	      }
	      
	      @RequestMapping("doupdate_notice")
	      public String notice_doupdate(int notice_idx, String notice_title, String notice_content) {
	         
	            Map<String, Object> map = new HashMap<String, Object>();
	            
	            map.put("notice_title", notice_title);
	            map.put("notice_content", notice_content);
	            map.put("notice_idx", notice_idx);
	            
	            ndao.notice_update(map);
	            
	            return "redirect:/notice_list";
	            
	    }
	      
	      @RequestMapping("/notice_delete")
	      public String notice_deletdo(int notice_idx) {
	         Map<String, Object> map = new HashMap<String, Object>();
	         map.put("notice_idx", notice_idx);
	         ndao.delete(map);
	         
	         return "redirect:/notice_list";

	      }
	
	
	
	
	
	/*
	 * 
	 * 기능 달기 전 
	 * 
	 * 
	 * */
	
	  	@RequestMapping("/sideAll")
		public String sideAll(Model model) {
			
			List<Dress_list_Dto> result = dldao.sideall();
			model.addAttribute("result",result );
			
			return "side_all";
			
		}
		
		@RequestMapping("/sideOuter")
		public String sideOuter(Model model) {
			
			List<Dress_list_Dto> result = dldao.sideouter();
			model.addAttribute("result",result );
			
			return "side_Outer";
			
		}
		
		@RequestMapping("/sidePants")
		public String sidePants(Model model) {
			
			List<Dress_list_Dto> result = dldao.sidepants();
			model.addAttribute("result",result );
			
			return "side_Pants";
		}
		
		@RequestMapping("/sideTop")
		public String sideTop(Model model) {
			
			List<Dress_list_Dto> result = dldao.sidetop();
			model.addAttribute("result",result );
			
			return "side_Top";
			
		}
		
		@RequestMapping("/detailpage")
		public String detailpage(String dress_num,Model model) {
			System.out.println("옷의 넘버: "+dress_num);
			
			List<File_upload_Dto> result = dldao.detailpage(Integer.parseInt(dress_num));
			model.addAttribute("result", result );
			
			return "detail_page";
			
		}
	
		 
		@RequestMapping("/updatereply") // 댓글수정
		public String updatereply(int review_idx, Model model, int comment_idx, String comment_content) {

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("review_idx", review_idx);
			map.put("comment_idx", comment_idx);
			map.put("comment_content", comment_content);

			model.addAttribute("result", rpdao.reply_update(map));

			return "redirect:/review_read?idx="+review_idx;

		}
		
		
		@RequestMapping("/deletereply") //댓글삭제
		public String deletereply(int review_idx, int comment_idx) {
			Map<String, Object> map = new HashMap<String, Object>();
		    map.put("comment_idx", comment_idx);
		    rpdao.deletereply(map);
			
			return "redirect:/review_read?idx="+review_idx;
		}
		
}
