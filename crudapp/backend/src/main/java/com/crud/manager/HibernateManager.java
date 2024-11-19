package com.crud.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.crud.entity.User;

public class HibernateManager {
	
	Session session = null;
	
	public HibernateManager() {
		session = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory().openSession();
	}
	
	public void addUser(User user) {
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
	}
	
	public List<User> getAllUser(){
		
		String hql = "from User";
		Query<User> query = session.createQuery(hql,User.class);
		return query.list();
	}
	
	public void deleteUser(int userId) {
		session.beginTransaction();
		User user = session.get(User.class, userId);
		
		if(user != null) {
			session.delete(user);
		}
		session.getTransaction().commit();
	}
	
	public void updateUser(User user) {
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}
	
	public void deleteAllUser() {
		session.beginTransaction();
		String hql = "DELETE FROM User";
		Query<User> query = session.createQuery(hql);
		query.executeUpdate();
		session.getTransaction().commit();
	}
}
