package tw.Evan.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.Evan.dao.IGameDAO;
import tw.Evan.model.dto.GameDTO;

@Repository
@Transactional
public class GameDAO implements IGameDAO{

	@Autowired
	private SessionFactory factory;
	@Transactional
	public List<GameDTO> getAllGameInfo() {
		Session session =factory.getCurrentSession();
		Query<GameDTO> query = session.createQuery("from GameDTO",GameDTO.class);
		return query.list();
	}
	@Transactional
	public GameDTO getGameInfoById(String id) {
		Session session =factory.getCurrentSession();
		return session.get(GameDTO.class, id);
	}
	@Transactional
	public GameDTO insertGameInfo(GameDTO Data) {
		Session session =factory.getCurrentSession();
		System.out.println(Data);
		GameDTO resultBean = session.get(GameDTO.class, Data.getGameId());
		System.out.println(resultBean);
		if(resultBean == null) {
			System.out.println(Data);
			session.persist(Data);
			session.flush();
			return Data;
		}
		return null;
	}
	@Transactional
	public GameDTO updateGameInfo(GameDTO Data) {
		Session session =factory.getCurrentSession();
		GameDTO resultBean = session.get(GameDTO.class, Data.getGameId());
		if(resultBean != null) {
			resultBean.setGameName(Data.getGameName());
			resultBean.setBuyerCount(Data.getBuyerCount());
			resultBean.setCreateDate(Data.getCreateDate());
			resultBean.setGameIntroduce(Data.getGameIntroduce());
			resultBean.setGamePicPath(Data.getGamePicPath());
			resultBean.setPrice(Data.getPrice());
			resultBean.setStatus(Data.getStatus());
			session.merge(resultBean);
			session.flush();
		}
		return resultBean;
	}
	@Transactional
	public boolean deleteGame(int gameId) {
		Session session =factory.getCurrentSession();
		GameDTO resultBean = session.get(GameDTO.class, gameId);
		if(resultBean != null) {
			session.remove(resultBean);
			return true;
		}
		return false;
	}
	@Transactional
	public boolean SearchUserByName(String userName) {
		Session session =factory.getCurrentSession();
		String hql = "SELECT COUNT(*) FROM GameDTO WHERE gameName = :gameName";
		Query<Long> query = session.createQuery(hql, Long.class);
		query.setParameter("gameName", userName);
		Long count = query.getSingleResult();
		return count>0;
	}
	@Transactional
	public List<GameDTO> SearchLikeName(String parameter) {
		Session session =factory.getCurrentSession();
		String hql = "FROM GameDTO WHERE gameName LIKE :gameName";
		Query<GameDTO> query = session.createQuery(hql,GameDTO.class); 
		query.setParameter("gameName","%"+parameter+"%" );
		return query.list();
		
	}

}
