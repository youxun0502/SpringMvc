package com.liao.model;


import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class DiscussionDao {

	@Autowired
	private SessionFactory sessionFactory;

	public DiscussionDao() {

	}

	public DiscussionBean insertDiscussionBean(DiscussionBean discussions) {
//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		DiscussionBean resultBean = session.get(DiscussionBean.class, discussions.getArticleId());

		if (resultBean == null) {
			session.persist(discussions);
			session.flush();
			session.close();
			return discussions;
		}

		return null;
	}

	public List<DiscussionBean> getAllDiscussions() throws SQLException {
		//Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		Query<DiscussionBean> query = session.createQuery("from DiscussionBean", DiscussionBean.class);
		List<DiscussionBean> discussions = query.list();
	    session.close();
	    return discussions;
	}

	public DiscussionBean getDiscussionById(int articleId) throws SQLException {
		//Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		DiscussionBean discussion = session.get(DiscussionBean.class, articleId);
	    session.close();
	    return discussion;
	}

	public DiscussionBean updateDiscussionBean(DiscussionBean discussions) {
		//Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		DiscussionBean resultBean = session.get(DiscussionBean.class, discussions.getArticleId());
		System.out.println(resultBean);
		if (resultBean != null) {
			resultBean.setMemberId(discussions.getMemberId());
			resultBean.setUserName(discussions.getUserName());
			resultBean.setGameName(discussions.getGameName());
			resultBean.setTitle(discussions.getTitle());
			resultBean.setContent(discussions.getContent());
			resultBean.setLastReplyTime(discussions.getLastReplyTime());
			resultBean.setD_views(discussions.getD_views());
			resultBean.setCreated_at(discussions.getCreated_at());
			resultBean.setLikes(discussions.getLikes());

			session.merge(resultBean);
			session.flush();
		}
		session.close();
		return resultBean;
	}

	public boolean deleteDiscussion(int articleId) {
		//Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		DiscussionBean resultBean = session.get(DiscussionBean.class, articleId);
		if (resultBean != null) {
			session.remove(resultBean);
			session.flush();
			session.close();
			return true;
		}
		return false;
	}

	public List<DiscussionBean> getDiscussionByUsername(String username) {
//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		String hql = "FROM DiscussionBean WHERE userName Like :username";
		Query<DiscussionBean> query = session.createQuery(hql, DiscussionBean.class);
		query.setParameter("username", "%" + username + "%");
		List<DiscussionBean> discussions = query.getResultList();
		System.out.println(discussions);
		session.close();
		return discussions;
	}
}