package com.prepsa.movieinformation.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prepsa.movieinformation.model.User;
import com.prepsa.movieinformation.util.HibernateUtil;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUserInfo(User user) {
		HibernateUtil.getSession(sessionFactory).merge(user);
	}

	@Override
	public void updateUserInfo(User user) {
		HibernateUtil.getSession(sessionFactory).merge(user);
	}

	@Override
	public void deleteUserInfo(int id) {
		User user = getUserInfoById(id);
		if (user != null) {
			HibernateUtil.getSession(sessionFactory).delete(user);
		}
	}

	@Override
	public User getUserInfoById(int id) {
		return (User) HibernateUtil.getSession(sessionFactory).get(User.class, id);
	}

	@Override
	public List<User> getAllUsersInfo() {
		return HibernateUtil.getSession(sessionFactory).createCriteria(User.class).list();
	}

	@Override
	public int login(String userName, String password) {
//		Criteria criteria = HibernateUtil.getSession(sessionFactory).createCriteria(User.class);
//		User user = (User) criteria.add(Restrictions.eq("name", userName)).add(Restrictions.eq("password", password))
//				.uniqueResult();
//		if (user != null) {
//			return true;
//		} else {
//			return false;
//		}
		Criteria criteria = HibernateUtil.getSession(sessionFactory).createCriteria(User.class);
		User user = (User) criteria.add(Restrictions.eq("name", userName)).add(Restrictions.eq("password", password))
				.uniqueResult();
		if (user != null) {
			return user.getId();
		} else {
			return 0;
		}
	}

}
