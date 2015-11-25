package com.group4.glimpse.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group4.glimpse.dao.UserDAO;
import com.group4.glimpse.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
    SessionFactory sessionFactory;
	
	/**
	 * DAO implementation of creating a new user
	 */
	public User create(User user) {
		
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{
			session.save(user);
			tx.commit();
		} catch(HibernateException h) {
			tx.rollback();
		} finally {
			session.close();
		}
		return user;
	}

	public User readEmail(String email) {
		
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		User user = null;
		try{
			user = (User) session.get(User.class, email);
			tx.commit();
		} catch(HibernateException h) {
			tx.rollback();
		} finally {
			session.close();
		}
		return user;
	}

		
}
