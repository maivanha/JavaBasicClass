package niit.java.mvcProject.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import niit.java.mvcProject.dao.PersonDao;
import niit.java.mvcProject.model.Person;

public class PersonDaoImpl extends DaoImpl implements PersonDao {

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Person getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person checkUserName(String userName) {
		String sql = "select * from persons where username =:username";
		SQLQuery sqlQuery = getSession().createSQLQuery(sql);
		
		sqlQuery.setParameter("username", userName);
		sqlQuery.addEntity(Person.class);
		
		List<Person> list = sqlQuery.list();
		
		return list.get(0);
	}

	@Override
	public void save(Person p) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	public List<Person> getAll() {
		// Native SQL
		/*
		 * String sql = "select * from persons"; SQLQuery sqlQuery =
		 * getSession().createSQLQuery(sql); sqlQuery.addEntity(Person.class);
		 */
		String sql = "FROM Person";
		Query sqlQuery = getSession().createQuery(sql);
		return sqlQuery.list();
	}
}
