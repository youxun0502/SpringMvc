package com.chen.model;


import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tw.Evan.model.dto.GameDTO;

@Entity @Table(name = "competition")
@Component
public class CompetitionBean {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int competitionId;
	private int gameId;
	private String name;
	private String mode;
	private String description;
	private String startDate;
	private String endDate;
	private String location;
	private int prize;
	private int quotaLimited;
	private String deadline;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GAMEID", insertable = false, updatable = false)
	private GameDTO gameDTO;
	
	
	public int getCompetitionId() {
		return competitionId;
	}
	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	public int getQuotaLimited() {
		return quotaLimited;
	}
	public void setQuotaLimited(int quotaLimited) {
		this.quotaLimited = quotaLimited;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public GameDTO getGameDTO() {
		return gameDTO;
	}
	public void setGameDTO(GameDTO gameDTO) {
		this.gameDTO = gameDTO;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompetitionBean [competitionId=");
		builder.append(competitionId);
		builder.append(", gameId=");
		builder.append(gameId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", mode=");
		builder.append(mode);
		builder.append(", description=");
		builder.append(description);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", location=");
		builder.append(location);
		builder.append(", prize=");
		builder.append(prize);
		builder.append(", quotaLimited=");
		builder.append(quotaLimited);
		builder.append(", deadline=");
		builder.append(deadline);
		builder.append(", gameDTO=");
		builder.append(gameDTO);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
