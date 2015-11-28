package com.group4.glimpse.dao.impl;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group4.glimpse.dao.ProjectDAO;
import com.group4.glimpse.model.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO {


	@Autowired
	SessionFactory sessionFactory;
	/**
	 * Create new project DAO implementation
	 */
	public Project create(Project project) {
		
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{
			session.save(project);
			tx.commit();
		}
		catch(HibernateException h){
			tx.rollback();
		}finally{
			session.close();
		}
		return project;
	}
	
	
	@Transactional
	public Project read(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Project project = null;
		try{
		project = (Project)session.get(Project.class,id);
		tx.commit();
		}
		catch(HibernateException h){
		tx.rollback();
		}finally{
		session.close();
		}
		return project;
		}
	
	/**
	 * Update project DAO implementation
	 */
	public Project update(Project project) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{
			session.update(project);
			tx.commit();
		}
		catch(Exception h){
			tx.rollback();
			project=null;
		}finally{
			session.close();
		}
		return project;
	}
	
	/**
	 * Delete project DAO implementation
	 */
	public Project delete(Project project) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{			
			session.delete(project);
			tx.commit();
		}
		catch(HibernateException h){
			h.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		return project;
	}
}
