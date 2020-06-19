package niit.java.mvcProject.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import niit.java.mvcProject.config.HibernateUtil;

public class DaoImpl {
	private SessionFactory sessionFactory;
	private Session session;
	
	public Session getSession() {
		sessionFactory = HibernateUtil.getSessionFactory();
		try{
			session = sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	
}
