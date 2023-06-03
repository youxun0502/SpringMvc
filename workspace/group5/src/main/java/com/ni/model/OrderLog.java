package com.ni.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.liu.model.Member;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "orderLog")
@Component
public class OrderLog {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int logId;
	private int itemId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUYER")
	private Member buyer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SELLER")
	private Member seller;
//	private int seller;
	private int amount;
	private float price;
	private Date createTime;
	private int status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEMID", insertable = false, updatable = false)
	private GameItem gameItem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SELLER", insertable = false, updatable = false)
	private Member member;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "orderLog", cascade = CascadeType.ALL)
	private ItemLog itemLog;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public Member getBuyer() {
		return buyer;
	}

	public void setBuyer(Member buyer) {
		this.buyer = buyer;
	}

//	public Member getSeller() {
//		return seller;
//	}
//
//	public void setSeller(Member seller) {
//		this.seller = seller;
//	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public GameItem getGameItem() {
		return gameItem;
	}

	public void setGameItem(GameItem gameItem) {
		this.gameItem = gameItem;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public ItemLog getItemLog() {
		return itemLog;
	}

	public void setItemLog(ItemLog itemLog) {
		this.itemLog = itemLog;
	}
	
	
}
