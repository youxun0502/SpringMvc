package tw.Evan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.Evan.dao.IGameDAO;
import tw.Evan.model.dto.GameDTO;
import tw.Evan.service.IGameService;

@Service
@Transactional
public class GameService implements IGameService{
	
	@Autowired
	private IGameDAO gDAO;
	
	public List<GameDTO> getAllGameInfo() {
		return gDAO.getAllGameInfo();
	}

	public GameDTO getGameInfoById(String id) {
		return gDAO.getGameInfoById(id);
	}

	public GameDTO insertGameInfo(GameDTO Data) {
		return gDAO.insertGameInfo(Data);
	}

	public GameDTO updateGameInfo(GameDTO Data) {
		return gDAO.updateGameInfo(Data);
	}

	public boolean deleteGame(int gameId) {
		return gDAO.deleteGame(gameId);
	}

	public boolean SearchUserByName(String userName) {
		return gDAO.SearchUserByName(userName);
	}

	public List<GameDTO> SearchLikeName(String parameter) {
		return gDAO.SearchLikeName(parameter);
	}

}
