package com.ni.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.Evan.model.dto.GameDTO;

@Service
@Transactional
public class GameItemService implements IGameItemService {

	@Autowired
	@Qualifier(value = "gameItemDao")
	private IGameItemDao itemDao;
	
	@Override
	public List<GameItem> getAllData() {
		return itemDao.getAllData();
	}

	@Override
	public GameItem getDataById(int itemId) {
		return itemDao.getDataById(itemId);
	}

	@Override
	public List<GameItem> getDataByName(String itemName) {
		return itemDao.getDataByName(itemName);
	}

	@Override
	public GameItem insert(GameItem item) {
		return itemDao.insert(item);
	}

	@Override
	public boolean delete(int itemId) {
		return itemDao.delete(itemId);
	}

	@Override
	public GameItem update(GameItem item) {
		return itemDao.update(item);
	}
	
	@Override
	public List<GameDTO> getGame() {
		return itemDao.getGame();
	}

}
