package com.liao.model;

import org.springframework.stereotype.Component;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "discussions")
@Component
public class DiscussionBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int articleId;
	private String memberId;
	private String userName;
	private String gameName;
	private String title;
	private String content;
	private String lastReplyTime;
	private String d_views;
	private String created_at;
	private String likes;
	
	
	public String getMemberId() {
		return memberId;
	}
	public String getUserName() {
		return userName;
	}
	public String getGameName() {
		return gameName;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getLastReplyTime() {
		return lastReplyTime;
	}
	public String getD_views() {
		return d_views;
	}
	public String getCreated_at() {
		return created_at;
	}
	public String getLikes() {
		return likes;
	}
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setLastReplyTime(String lastReplyTime) {
		this.lastReplyTime = lastReplyTime;
	}
	public void setD_views(String d_views) {
		this.d_views = d_views;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	
	
	
	
}