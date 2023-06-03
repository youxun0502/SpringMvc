package com.liu.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="[level]")
public class Level {
	@Id @Column(name="LEVELID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int levelId;
	@Column(name="[DESC]")
	private String desc;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "level", cascade = CascadeType.ALL)
	private Set<Member> member;
	
	
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Set<Member> getMember() {
		return member;
	}
	public void setMember(Set<Member> member) {
		this.member = member;
	}
}
