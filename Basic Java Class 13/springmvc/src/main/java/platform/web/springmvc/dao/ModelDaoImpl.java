package platform.web.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ModelDaoImpl {
	@Autowired
	protected SessionFactory sessionFactory;
	

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(Object entity) {
		getSession().persist(entity);
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}
}