package com.group4.glimpse.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group4.glimpse.dao.InvitationDAO;
import com.group4.glimpse.model.Invitations;

@Repository
public class InvitationDAOImpl implements InvitationDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Invitations create(Invitations invitations) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{
			session.save(invitations);
			tx.commit();
		}
		catch(HibernateException h){
			tx.rollback();
		}finally{
			session.close();
		}
		return invitations;
	}

	@Override
	public Invitations read(long invitation_id) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Invitations invitation = null;
		try{
			invitation = (Invitations)session.get(Invitations.class,invitation_id);
		tx.commit();
		}
		catch(HibernateException h){
		tx.rollback();
		}finally{
		session.close();
		}
		return invitation;
	}

	@Override
	public Invitations update(Invitations invitations) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{
			session.update(invitations);
			tx.commit();
		}
		catch(Exception h){
			tx.rollback();
			invitations=null;
		}finally{
			session.close();
		}
		return invitations;
		
	}

	@Override
	public Invitations delete(Invitations invitations) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{			
			session.delete(invitations);
			tx.commit();
		}
		catch(HibernateException h){
			h.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		return invitations;
	}

}
