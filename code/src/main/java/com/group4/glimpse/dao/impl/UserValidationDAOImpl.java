package com.group4.glimpse.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group4.glimpse.dao.UserValidationDAO;
import com.group4.glimpse.model.EmailValidation;
import com.group4.glimpse.model.Project;

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

}
