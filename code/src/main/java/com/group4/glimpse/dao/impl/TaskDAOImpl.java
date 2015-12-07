package com.group4.glimpse.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group4.glimpse.dao.TaskDAO;
import com.group4.glimpse.model.Task;

@Repository
public class TaskDAOImpl implements TaskDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * Create new task DAO implementation
	 */
	public Task create(Task task) {
		
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{
			//person.setFriends(friends);
			session.save(task);
			tx.commit();
		}
		catch(HibernateException h){
			tx.rollback();
		}finally{
			session.close();
		}
		return task;
	}
	
	/**
	 * DAO Implementation to read a task
	 */
	@Transactional
	public Task read(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Task task = null;
		try{
		task = (Task)session.get(Task.class,id);
		tx.commit();
		}
		catch(HibernateException h){
		tx.rollback();
		}finally{
		session.close();
		}
		return task;
		}
	
	/**
	 * Update task DAO implementation
	 */
	public Task update(Task task) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{
			session.update(task);
			tx.commit();
		}
		catch(Exception h){
			tx.rollback();
			task=null;
		}finally{
			session.close();
		}
		return task;
	}
	
	/**
	 * Delete task DAO implementation
	 */
	public Task delete(Task task) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{			
			session.delete(task);
			tx.commit();
		}
		catch(HibernateException h){
			h.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		return task;
	}
}
