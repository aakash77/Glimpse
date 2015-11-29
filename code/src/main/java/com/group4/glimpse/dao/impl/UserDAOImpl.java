package com.group4.glimpse.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group4.glimpse.dao.UserDAO;
import com.group4.glimpse.model.Project;
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

	/**
	 * DAO Implementation to get user by reading email
	 */
	public User readEmail(String email) {

		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		User user = null;
		List<User> users;
		try{
			String hql = "FROM com.group4.glimpse.model.User as user WHERE user.email = :email";
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

	/**
	 * DAO implementation of updating a user
	 */
	public User update(User user) {

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
	public List<Project> getProjects(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		List<Project> projects = null;
		try{
			System.out.println("before query");
			String hql = "FROM com.group4.glimpse.model.Project as project WHERE project.team.user = :user";
			Query query = session.createQuery(hql);
			query.setEntity("user", id);
			projects = query.list();
			System.out.println(projects);
			tx.commit();
		} catch(HibernateException h) {
			tx.rollback();
		} finally {
			session.close();
		}
		return projects;
	}

}
