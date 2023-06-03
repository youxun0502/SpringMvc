package com.liu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDao mDao;

	public List<Member> selectAll() {
		return mDao.selectAll();
	}

	public List<Member> selectByName(String memberName) {
		return mDao.selectByName(memberName);
	}

	public Member getUpdateForm(int id) {
		return mDao.getUpdateForm(id);
	}

	public boolean update(Member member) {
		return mDao.update(member);
	}

	public boolean delete(int id) {
		return mDao.delete(id);
	}

	public boolean insert(Member member) {
		return mDao.insert(member);
	}

	public List<Member> isMember(String email, String memberPwd) {
		return mDao.isMember(email, memberPwd);
	}
}
