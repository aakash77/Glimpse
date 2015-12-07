package com.group4.glimpse.dao.impl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group4.glimpse.dao.ProjectDAO;
import com.group4.glimpse.model.Project;
import com.group4.glimpse.model.Task;

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

	/**
	 * DAO Implementation to read a project
	 */
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

	/**
	 * DAO Implementation to get all tasks of a project
	 */
	@Override
	public List<Task> getAllTasks(long project_id) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		List<Task> tasks = null;
		try{			
			String hql = "FROM com.group4.glimpse.model.Task as t where t.project_id = :project_id";
			Query query = session.createQuery(hql);
			query.setLong("project_id", project_id);
			tasks = query.list();
			tx.commit();
		}
		catch(HibernateException h){
			h.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		return tasks;
	}
}
