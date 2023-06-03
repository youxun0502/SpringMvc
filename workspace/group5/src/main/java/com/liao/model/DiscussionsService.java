package com.liao.model;

import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DiscussionsService {

	@Autowired
	private DiscussionDao discussionDao;
	
	public DiscussionBean insertDiscussionBean(DiscussionBean discussions) {
		return discussionDao.insertDiscussionBean(discussions);
	}

	public List<DiscussionBean> getAllDiscussions() throws SQLException {
		return discussionDao.getAllDiscussions();
	}

	public DiscussionBean getDiscussionById(int articleId) throws SQLException {
		return discussionDao.getDiscussionById(articleId);
		}

	public DiscussionBean updateDiscussionBean(DiscussionBean discussions) {
		return discussionDao.updateDiscussionBean(discussions);
	}

	public boolean deleteDiscussion(int articleId) {
		return discussionDao.deleteDiscussion(articleId);
	}

	public List<DiscussionBean> getDiscussionByUsername(String username) {
		return discussionDao.getDiscussionByUsername(username);
	}
	
}
