package com.ni.model;

import java.util.List;

import tw.Evan.model.dto.GameDTO;

public interface IGameItemDao {

	public List<GameItem> getAllData();
	public GameItem getDataById(int itemId);
	public List<GameItem> getDataByName(String itemName);
	public GameItem insert(GameItem item);
	public boolean delete(int itemId);
	public GameItem update(GameItem item);
	public List<GameDTO> getGame();
}
