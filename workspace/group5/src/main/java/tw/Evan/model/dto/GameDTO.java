package tw.Evan.model.dto;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.chen.model.CompetitionBean;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity@Table(name = "game")
@Component
public class GameDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gameId;
	private String gameName;
	private float price;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	private String gameIntroduce;
	private String gamePicPath;
	private int buyerCount;
	private int status;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "gametypelist", 
		joinColumns = {@JoinColumn(name = "GAMEID")},
		inverseJoinColumns = {@JoinColumn(name = "TYPEID")})
	private Set<GameTypeDTO> games = new HashSet<>();
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "gameDTO",cascade = CascadeType.ALL)
	private Set<CompetitionBean> competitions = new HashSet<CompetitionBean>();
	
	public GameDTO() {}

	@Override
	public String toString() {
		return "GameDTO [gameId=" + gameId + ", gameName=" + gameName + ", price=" + price + ", createDate="
				+ createDate + ", gameIntroduce=" + gameIntroduce + ", gamePicPath=" + gamePicPath +
				", buyerCount=" + buyerCount + ", status=" + status + "]";
	}


	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getGameIntroduce() {
		return gameIntroduce;
	}
	public void setGameIntroduce(String gameIntroduce) {
		this.gameIntroduce = gameIntroduce;
	}
	public String getGamePicPath() {
		return gamePicPath;
	}
	public void setGamePicPath(String gamePicPath) {
		this.gamePicPath = gamePicPath;
	}
	public int getBuyerCount() {
		return buyerCount;
	}
	public void setBuyerCount(int buyerCount) {
		this.buyerCount = buyerCount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Set<CompetitionBean> getCompetitions() {
		return competitions;
	}
	public void setCompetitions(Set<CompetitionBean> competitions) {
		this.competitions = competitions;
	}
}
