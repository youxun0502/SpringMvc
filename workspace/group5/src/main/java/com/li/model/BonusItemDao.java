package com.li.model;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class BonusItemDao {
	
	@Autowired
	private SessionFactory sessionFactory;


	public List<BonusItem> SearchAll() {
		Session session = sessionFactory.openSession();
		String hql = "from BonusItem";
		System.out.println("session open");
		Query<BonusItem> query = session.createQuery(hql, BonusItem.class);
		List<BonusItem>list = query.list();
		session.close();
		return list;
	}

	public List<BonusItem> Search(String str) {
		String hql = "from BonusItem where bonusname like ?1 OR bonusdes like ?2";
		Session session = sessionFactory.openSession();
		Query<BonusItem> query = session.createQuery(hql, BonusItem.class);
		query.setParameter(1, "%" + str + "%");
		query.setParameter(2, "%" + str + "%");
		List<BonusItem> list = query.list();
		session.close();
		return list;


	}

	public BonusItem SearchOne(int id) {
		Session session = sessionFactory.openSession();
		BonusItem result = session.get(BonusItem.class, id);
		session.close();
		return result;
	}

	public void Update(int update,BonusItem bitem) {
		Session session = sessionFactory.openSession();
		BonusItem result = session.get(BonusItem.class,update);
		System.out.println(result);
		if (result != null) {
			result.setBonusname(bitem.getBonusname());
			result.setBonusdes(bitem.getBonusdes());
			result.setBonusprice(bitem.getBonusprice());
			result.setBonusimg(bitem.getBonusimg());
			System.out.println(result);
			session.flush();
			session.close();
		} else {
			
		}
	}

	public void Delete(int id) {
		Session session = sessionFactory.openSession();
		BonusItem result = session.get(BonusItem.class, id);
		if (result != null) {
			session.remove(result);
			session.flush();
			session.close();
			
		} else {
			session.close();
			
		}
	}

	public void Insert(BonusItem bitem) {
		Session session = sessionFactory.openSession();
	
		BonusItem resultBean = session.get(BonusItem.class, bitem.getBonusid());
		if(resultBean==null) {
			session.persist(bitem);
			session.flush();
			session.close();
		}
		session.close();
	}
}
