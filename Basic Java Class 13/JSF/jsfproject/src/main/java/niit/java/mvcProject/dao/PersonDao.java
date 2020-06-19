package niit.java.mvcProject.dao;

import java.util.List;

import niit.java.mvcProject.model.Person;

public interface PersonDao {

	public void delete(int id);

	public Person getById(int id);

	public Person checkUserName(String userName);

	public void save(Person p);

	public List<Person> getAll();
}
