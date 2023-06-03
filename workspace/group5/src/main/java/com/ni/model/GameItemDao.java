package com.ni.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.Evan.model.dto.GameDTO;

@Repository
@Transactional
public class GameItemDao implements IGameItemDao {
	
	@Autowired
	private SessionFactory factory;
	
	@Override
	@Transactional
	public List<GameItem> getAllData() {
		Session session = factory.getCurrentSession();
		Query<GameItem> query = session.createQuery("FROM GameItem", GameItem.class);
		System.out.println("daoGetAll: " + query.list());
		return query.list();
	}

	@Override
//	@Transactional
	public GameItem getDataById(int itemId) {
		Session session = factory.openSession();
		return session.get(GameItem.class, itemId);
	}

	@Override
	@Transactional
	public List<GameItem> getDataByName(String itemName) {
		Session session = factory.getCurrentSession();
		Query<GameItem> query = session.createQuery("FROM GameItem WHERE itemName LIKE:name", GameItem.class);
		query.setParameter("name", "%"+ itemName +"%");
		System.out.println("daoByName: " + query.list());
		return query.list();
	}

	@Override
	@Transactional
	public GameItem insert(GameItem item) {
		Session session = factory.getCurrentSession();
		GameItem resultBean = session.get(GameItem.class, item.getItemId());
		if(resultBean == null) {
			session.persist(item);
			System.out.println("daoInsert: "+ item);
			return item;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean delete(int itemId) {
		Session session = factory.getCurrentSession();
		GameItem resultBean = session.get(GameItem.class, itemId);
		if(resultBean != null) {
			session.remove(resultBean);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public GameItem update(GameItem item) {
		Session session = factory.getCurrentSession();
		GameItem resultBean = session.get(GameItem.class, item.getItemId());
		if(resultBean != null) {
			resultBean.setItemName(item.getItemName());
			resultBean.setGameId(item.getGameId());
			resultBean.setItemDesc(item.getItemDesc());
			resultBean.setItemImg(item.getItemImg());
			resultBean.setItemGrade(item.getItemGrade());
			resultBean.setItemType(item.getItemType());
			resultBean.setStatus(item.getStatus());
			resultBean.setUpdateTime(item.getUpdateTime());
			resultBean.setGameDTO(item.getGameDTO());
			session.flush();
		}
		return resultBean;
	}

	@Override
	@Transactional
	public List<GameDTO> getGame() {
		Session session = factory.getCurrentSession();
		Query<GameDTO> query = session.createQuery("FROM GameDTO", GameDTO.class);
		return query.list();
	}

}
