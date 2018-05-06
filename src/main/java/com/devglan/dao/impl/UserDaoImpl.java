package com.devglan.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devglan.dao.UserDao;
import com.devglan.model.UserDetails;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<UserDetails> getUserDetails() {
		Criteria criteria = sessionFactory.openSession().createCriteria(UserDetails.class);
		return criteria.list();
	}

	public Integer add(UserDetails userDetails) {
		Session session = sessionFactory.openSession();
		return (Integer) session.save(userDetails);
	}

	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		UserDetails userDetails = session.get(UserDetails.class, id);
		session.delete(userDetails);
	}
}
