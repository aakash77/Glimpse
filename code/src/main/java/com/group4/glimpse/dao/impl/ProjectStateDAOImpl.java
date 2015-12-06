package com.group4.glimpse.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group4.glimpse.dao.ProjectStateDAO;
import com.group4.glimpse.model.Project_State;

@Repository
public class ProjectStateDAOImpl implements ProjectStateDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Project_State read(String project_state) {
		
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Project_State project_State = null;
		try{
			String hql = "FROM com.group4.glimpse.model.Project_State as ps where ps.value = :value";
			Query query = session.createQuery(hql);
			query.setString("value", project_state);
			project_State = (Project_State) query.list().get(0);
			tx.commit();
		}
		catch(HibernateException h){
			tx.rollback();
		}finally{
			session.close();
		}
		return project_State;
	}

}
