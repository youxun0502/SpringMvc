package tw.Evan.model.dto;

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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity@Table(name = "gameType")
@Component
public class GameTypeDTO {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeId;
	private String typeName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "gametypeList",
			joinColumns = {@JoinColumn(name = "TYPEID")},
			inverseJoinColumns= {@JoinColumn(name = "GAMEID")})
	private Set<GameDTO> games = new HashSet<>();
	
	public GameTypeDTO() {}

	public GameTypeDTO(String typeName, Set<GameDTO> games) {
		super();
		this.typeName = typeName;
		this.games = games;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set<GameDTO> getGames() {
		return games;
	}

	public void setGames(Set<GameDTO> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "GameTypeDTO [typeId=" + typeId + ", typeName=" + typeName + ", games=" + games + "]";
	}
	
}
