package com.ni.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import tw.Evan.model.dto.GameDTO;

@Entity @Table(name = "gameItem")
@Component
public class GameItem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private String itemName;
	private int gameId;
	private String itemDesc;
	private String itemImg;
	private String itemGrade;
	private String itemType;
	private int status;
	private Date createTime;
	private Date updateTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GAMEID", insertable = false, updatable = false)
	private GameDTO gameDTO;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gameItem", cascade = CascadeType.ALL)
	private Set<OrderLog> orderLogs = new HashSet<>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gameItem", cascade = CascadeType.ALL)
	private Set<ItemLog> itemLogs = new HashSet<>(0);

	
	public GameItem() {
	}

	public GameItem(String itemName, int gameId, String itemDesc, String itemImg, String itemGrade, String itemType,
			int status, Date createTime) {
		this.itemName = itemName;
		this.gameId = gameId;
		this.itemDesc = itemDesc;
		this.itemImg = itemImg;
		this.itemGrade = itemGrade;
		this.itemType = itemType;
		this.status = status;
		this.createTime = createTime;
	}
	
	public GameItem(int itemId, String itemName, int gameId, String itemDesc, String itemGrade, String itemType,
			int status, Date updateTime, GameDTO gameDTO) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.gameId = gameId;
		this.itemDesc = itemDesc;
		this.itemGrade = itemGrade;
		this.itemType = itemType;
		this.status = status;
		this.updateTime = updateTime;
		this.gameDTO = gameDTO;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

	public String getItemGrade() {
		return itemGrade;
	}

	public void setItemGrade(String itemGrade) {
		this.itemGrade = itemGrade;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public GameDTO getGameDTO() {
		return gameDTO;
	}

	public void setGameDTO(GameDTO gameDTO) {
		this.gameDTO = gameDTO;
	}

	public Set<OrderLog> getOrderLogs() {
		return orderLogs;
	}

	public void setOrderLogs(Set<OrderLog> orderLogs) {
		this.orderLogs = orderLogs;
	}

	public Set<ItemLog> getItemLogs() {
		return itemLogs;
	}

	public void setItemLogs(Set<ItemLog> itemLogs) {
		this.itemLogs = itemLogs;
	}
	
	public String getGameName() {
        return gameDTO != null ? gameDTO.getGameName() : null;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GameItem [itemId=");
		builder.append(itemId);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", gameId=");
		builder.append(gameId);
		builder.append(", itemDesc=");
		builder.append(itemDesc);
		builder.append(", itemImg=");
		builder.append(itemImg);
		builder.append(", itemGrade=");
		builder.append(itemGrade);
		builder.append(", itemType=");
		builder.append(itemType);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", gameDTO=");
		builder.append(gameDTO);
		builder.append("]");
		return builder.toString();
	}
	
	
}
