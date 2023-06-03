package com.chen.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.Evan.model.dto.GameDTO;

@Repository
@Transactional
public class CompetitionDao {
	
	@Autowired
	private SessionFactory factory;

	// 新增資料
	public void addData(CompetitionBean cptb){
		Session session = factory.getCurrentSession();
		
		CompetitionBean resultBean = session.get(CompetitionBean.class, cptb.getCompetitionId());
		if(resultBean == null) {
			GameDTO games = session.get(GameDTO.class, cptb.getGameId());
			Set<CompetitionBean> cpts = new HashSet<>();
			cpts.add(cptb);
			games.setCompetitions(cpts);
			cptb.setGameDTO(games);
			session.persist(games);
		}
	}

	// 查詢資料(透過id查詢)
	public CompetitionBean findDataById(int competitionId){
		Session session = factory.getCurrentSession();
		return session.get(CompetitionBean.class, competitionId);
	}
	
	// 查詢資料(透過遊戲名稱查詢)
	public List<CompetitionBean> findDataByName(String name){
		Session session = factory.getCurrentSession();
		String hql = "FROM CompetitionBean WHERE name LIKE :name";
		Query<CompetitionBean> query = session.createQuery(hql,CompetitionBean.class);
		query.setParameter("name", "%"+name+"%");
		return query.list();
	}
	
	// 查詢全部資料
	public List<CompetitionBean> findAllData() {
		Session session = factory.getCurrentSession();
		Query<CompetitionBean> query = session.createQuery("from CompetitionBean",CompetitionBean.class);
		return query.list();
	}
	
	// 修改資料(透過id改任一欄位的值)
	public void updateData(CompetitionBean cptb){
		Session session = factory.getCurrentSession();
		CompetitionBean resultBean = session.get(CompetitionBean.class, cptb.getCompetitionId());
		if(resultBean != null) {
			resultBean.setName(cptb.getName());
			resultBean.setMode(cptb.getMode());
			resultBean.setDescription(cptb.getDescription());
			resultBean.setStartDate(cptb.getStartDate());
			resultBean.setEndDate(cptb.getEndDate());
			resultBean.setLocation(cptb.getLocation());
			resultBean.setPrize(cptb.getPrize());
			resultBean.setQuotaLimited(cptb.getQuotaLimited());
			resultBean.setDeadline(cptb.getDeadline());
		}
	}

	// 刪除資料(透過id刪資料)
	public void deleteData(int competitionId){
		Session session = factory.getCurrentSession();
		CompetitionBean resultBean = session.get(CompetitionBean.class, competitionId);
		if(resultBean != null) {
			session.remove(resultBean);
		}
	}
	
	//查詢遊戲ID及名稱
	public List<GameDTO> findAllGame(){
		Session session = factory.getCurrentSession();
		Query<GameDTO> query = session.createQuery("from GameDTO",GameDTO.class);
		return query.list();
	}
	
}
