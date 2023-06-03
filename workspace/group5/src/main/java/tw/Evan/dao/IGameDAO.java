package tw.Evan.dao;

import java.util.List;

import tw.Evan.model.dto.GameDTO;

public interface IGameDAO {

	public List<GameDTO> getAllGameInfo();
	public GameDTO getGameInfoById(String id);
	public GameDTO insertGameInfo(GameDTO Data);
	public GameDTO updateGameInfo(GameDTO Data);
	public boolean deleteGame(int gameId);
	public boolean SearchUserByName(String userName);
	public List<GameDTO> SearchLikeName(String parameter);
	
}
