package com.li.model;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "bonusitem")
public class BonusItem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bonusid;
	
	@Column(name = "BONUSNAME")
	private String bonusname;
	
	@Column(name = "BONUSPRICE")
	private int bonusprice;
	
	@Column(name = "BONUSDES")
	private String bonusdes;
	
	@Column(name = "BONUSIMG")
	private String bonusimg;
	public int getBonusid() {
		return bonusid;
	}
	public void setBonusid(int bonusid) {
		this.bonusid = bonusid;
	}
	public String getBonusname() {
		return bonusname;
	}
	public void setBonusname(String bonusname) {
		this.bonusname = bonusname;
	}
	public int getBonusprice() {
		return bonusprice;
	}
	public void setBonusprice(int bonusprice) {
		this.bonusprice = bonusprice;
	}
	public String getBonusdes() {
		return bonusdes;
	}
	public void setBonusdes(String bonusdes) {
		this.bonusdes = bonusdes;
	}
	public String getBonusimg() {
		return bonusimg;
	}
	public void setBonusimg(String bonusimg) {
		this.bonusimg = bonusimg;
	}

}
