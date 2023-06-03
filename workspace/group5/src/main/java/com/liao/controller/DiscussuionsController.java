package com.liao.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.liao.model.DiscussionBean;
import com.liao.model.DiscussionsService;

@Controller
public class DiscussuionsController {
	@Autowired
	private DiscussionsService dService;
	
  @GetMapping("/discussionmain")
	public String getDiscussionMain() {
		return "DiscussionsMain";
	}
  
  @GetMapping("/getinsertdata")
	public String Getinsertdata() {
		return "Discussioninsertfinal";
	}

  @PostMapping("/getAllDiscussions")
  public String getAllDiscussions(Model model) throws SQLException {
          List<DiscussionBean> discussions = dService.getAllDiscussions();
          model.addAttribute("discussions", discussions);
          return "GetAllDiscussion";
  }
  
  @RequestMapping(value = "/deleteDiscussionfinal", method = {RequestMethod.GET, RequestMethod.POST})
  //@PostMapping
  public String deleteDiscussion(@RequestParam("articleId") int articleId, Model model) {
      boolean rowsDeleted = dService.deleteDiscussion(articleId);
      model.addAttribute("rowsDeleted", rowsDeleted);

      try {
          List<DiscussionBean> discussions = dService.getAllDiscussions();
          model.addAttribute("discussions", discussions);
          return "GetAllDiscussion"; 
      } catch (SQLException e) {
          e.printStackTrace();
      }
      
      return "error"; // Return the name of the view for error handling
  }
  
  @RequestMapping(value = "/GetDiscussion", method = { RequestMethod.GET, RequestMethod.POST })
  //@PostMapping
  public String selectById(@RequestParam("articleId") int articleId, Model model) {

      try {
          DiscussionBean discussion = dService.getDiscussionById(articleId);
          model.addAttribute("discussion", discussion);

          return "updateDiscussionData";
      } catch (SQLException e) {
          e.printStackTrace();
      }

      return "error"; // Return the name of the view for error handling
  }
  
  @RequestMapping(value = "/GetDiscussionSelectUserName2", method = { RequestMethod.GET, RequestMethod.POST })
  public String getByUserName(@RequestParam("userName") String userName, Model model) {
  	List<DiscussionBean> discussions = dService.getDiscussionByUsername(userName);

      model.addAttribute("discussions", discussions);

      return "GetDiscussionSelectUserNamenew";
  }
  
  @RequestMapping(value = "/insertdiscussionfinal", method = {RequestMethod.GET, RequestMethod.POST})
  public String insertDiscussion(
          @RequestParam("memberId") String memberId,
          @RequestParam("userName") String userName,
          @RequestParam("gameName") String gameName,
          @RequestParam("title") String title,
          @RequestParam("content") String content,
          @RequestParam("lastReplyTime") String lastReplyTime,
          @RequestParam("d_views") String d_views,
          @RequestParam("created_at") String created_at,
          @RequestParam("likes") String likes,
          Model model) {

      DiscussionBean discussion = new DiscussionBean();
      discussion.setMemberId(memberId);
      discussion.setUserName(userName);
      discussion.setGameName(gameName);
      discussion.setTitle(title);
      discussion.setContent(content);
      discussion.setLastReplyTime(lastReplyTime);
      discussion.setD_views(d_views);
      discussion.setCreated_at(created_at);
      discussion.setLikes(likes);

      dService.insertDiscussionBean(discussion);

      try {
          List<DiscussionBean> discussions = dService.getAllDiscussions();
          model.addAttribute("discussions", discussions);
          return "GetAllDiscussion"; 
      } catch (SQLException e) {
          e.printStackTrace();
      }
      
      return "error"; // Return the name of the view for error handling
  }
  @RequestMapping(value = "/updateDiscussionfinal", method = { RequestMethod.GET, RequestMethod.POST })
  //@PostMapping
  public String updateDiscussion(
          @RequestParam("articleId") int articleId,
          @RequestParam("memberId") String memberId,
          @RequestParam("userName") String userName,
          @RequestParam("gameName") String gameName,
          @RequestParam("title") String title,
          @RequestParam("content") String content,
          @RequestParam("lastReplyTime") String lastReplyTime,
          @RequestParam("d_views") String d_views,
          @RequestParam("created_at") String created_at,
          @RequestParam("likes") String likes,
          Model model) {

      try {
          DiscussionBean discussion = new DiscussionBean();
          discussion.setArticleId(articleId);
          discussion.setMemberId(memberId);
          discussion.setUserName(userName);
          discussion.setGameName(gameName);
          discussion.setTitle(title);
          discussion.setContent(content);
          discussion.setLastReplyTime(lastReplyTime);
          discussion.setD_views(d_views);
          discussion.setCreated_at(created_at);
          discussion.setLikes(likes);

          dService.updateDiscussionBean(discussion);

          List<DiscussionBean> discussions = dService.getAllDiscussions();
          model.addAttribute("discussions", discussions);

          return "GetAllDiscussion";
      } catch (SQLException e) {
          e.printStackTrace();
      }

      return "error"; // Return the name of the view for error handling
  }
}

