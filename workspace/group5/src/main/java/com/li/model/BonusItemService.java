package com.li.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BonusItemService {

	@Autowired
	private BonusItemDao bDao;

	public List<BonusItem> SearchAll() {
		return bDao.SearchAll();
	}

	public List<BonusItem> Search(String str) {
		return bDao.Search(str);
	}

	public BonusItem SearchOne(int id) {
		return bDao.SearchOne(id);
	}

	public void Update(int update,BonusItem bitem) {
		bDao.Update(update,bitem);
	}

	public void Delete(int id) {
		bDao.Delete(id);
	}

	public void Insert(BonusItem member) {
		bDao.Insert(member);
	}

}
