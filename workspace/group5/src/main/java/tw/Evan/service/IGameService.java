package tw.Evan.service;

import java.util.List;

import tw.Evan.model.dto.GameDTO;

public interface IGameService {

	public List<GameDTO> getAllGameInfo();
	public GameDTO getGameInfoById(String id);
	public GameDTO insertGameInfo(GameDTO Data);
	public GameDTO updateGameInfo(GameDTO Data);
	public boolean deleteGame(int gameId);
	public List<GameDTO> SearchLikeName(String string);
	public boolean SearchUserByName(String userName);
	
}
