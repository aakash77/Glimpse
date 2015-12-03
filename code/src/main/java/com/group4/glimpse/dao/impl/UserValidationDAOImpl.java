package com.group4.glimpse.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group4.glimpse.dao.UserValidationDAO;
import com.group4.glimpse.model.EmailValidation;
import com.group4.glimpse.model.Project;
import com.group4.glimpse.model.User;

@Repository
public class UserValidationDAOImpl implements UserValidationDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public EmailValidation create(EmailValidation user) {
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

	@Override
	public EmailValidation update(EmailValidation user) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{
			session.update(user);
			tx.commit();
		} catch(HibernateException h) {
			tx.rollback();
		} finally {
			session.close();
		}
		return user;	
	}

	@Override
	public EmailValidation read(long idEmailValidation) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		EmailValidation emailValidation = null;
		try{
			emailValidation = (EmailValidation)session.get(EmailValidation.class,idEmailValidation);
		tx.commit();
		}
		catch(HibernateException h){
		tx.rollback();
		}finally{
		session.close();
		}
		return emailValidation;
	}
	
	/**
	 * DAO Implementation to get user by reading email
	 */
	public EmailValidation readEmail(String email) {

		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		EmailValidation user = null;
		List<EmailValidation> users;
		try{
			String hql = "FROM com.group4.glimpse.model.EmailValidation as user WHERE user.email = :email";
			Query query = session.createQuery(hql);
			query.setString("email", email);
			query.setMaxResults(1);
			users = query.list();
			if(users.size()!=0)
				user = users.get(0);
			tx.commit();
		} catch(HibernateException h) {
			tx.rollback();
		} finally {
			session.close();
		}
		return user;
	}

}
