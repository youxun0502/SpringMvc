package com.ni.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.liu.model.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "itemLog")
@Component
public class ItemLog {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	private int ordId;
	private int itemId;
	private int memberId;
	private int itemAmount;
	private Date time;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBERID", insertable = false, updatable = false)
	private Member member;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEMID", insertable = false, updatable = false)
	private GameItem gameItem;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDID", insertable = false, updatable = false)
	private OrderLog orderLog;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getOrdId() {
		return ordId;
	}

	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public GameItem getGameItem() {
		return gameItem;
	}

	public void setGameItem(GameItem gameItem) {
		this.gameItem = gameItem;
	}

	public OrderLog getOrderLog() {
		return orderLog;
	}

	public void setOrderLog(OrderLog orderLog) {
		this.orderLog = orderLog;
	}
	
}
