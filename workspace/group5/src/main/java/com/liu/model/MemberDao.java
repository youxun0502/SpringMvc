package com.liu.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class MemberDao {
	
	@Autowired
	private SessionFactory sessionFactory;


	public List<Member> selectAll() {
		Session session = sessionFactory.openSession();
		String hql = "from Member";
		System.out.println("session open");
		Query<Member> query = session.createQuery(hql, Member.class);
		List<Member>list = query.list();
		session.close();
		return list;
	}

	public List<Member> selectByName(String memberName) {
		String hql = "from Member where memberName like ?1";
		Session session = sessionFactory.openSession();
		Query<Member> query = session.createQuery(hql, Member.class);
		query.setParameter(1, "%" + memberName + "%");
		List<Member> list = query.list();
		session.close();
		return list;


	}

	public Member getUpdateForm(int id) {
		Session session = sessionFactory.openSession();
		Member result = session.get(Member.class, id);
		session.close();
		return result;
	}

	public boolean update(Member member) {
		Session session = sessionFactory.openSession();
		Member result = session.get(Member.class, member.getId());
		if (result != null) {
			result.setMemberPwd(member.getMemberPwd());
			result.setMemberName(member.getMemberName());
			result.setBirthday(member.getBirthday());
			result.setGender(member.getGender());
			result.setPhone(member.getPhone());
			result.setLevelId(member.getLevelId());
			result.setAccount(member.getAccount());
			session.flush();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(int id) {
		Session session = sessionFactory.openSession();
		Member result = session.get(Member.class, id);
		if (result != null) {
			session.remove(result);
			session.flush();
			session.close();
			return true;
		} else {
			session.close();
			return false;
		}
	}

	public boolean insert(Member member) {
		Session session = sessionFactory.openSession();
		String hql = "from Member where email =:email OR phone =:phone ";
		Query<Member> query = session.createQuery(hql, Member.class);
		query.setParameter("email", member.getEmail());
		query.setParameter("phone", member.getPhone());
		if (query.list().isEmpty() == true) {
			Level level=session.get(Level.class, 1);
			Set<Member> members = new HashSet<>();
			members.add(member);
			level.setMember(members);
			member.setLevel(level);
			session.persist(level);
			session.flush();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	public List<Member> isMember(String email, String memberPwd) {
		String hql = "from Member where email =:email And memberPwd =:memberPwd ";
		Session session = sessionFactory.openSession();
		Query<Member> query = session.createQuery(hql, Member.class);
		query.setParameter("email", email);
		query.setParameter("memberPwd", memberPwd);
		List<Member> list = query.list();
		session.close();
		return list;

	}
}
