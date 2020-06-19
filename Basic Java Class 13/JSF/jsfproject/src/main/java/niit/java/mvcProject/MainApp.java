package niit.java.mvcProject;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import niit.java.mvcProject.dao.PersonDao;
import niit.java.mvcProject.dao.impl.PersonDaoImpl;
import niit.java.mvcProject.model.Person;

@ManagedBean(name = "mainApp", eager = true)
@RequestScoped
public class MainApp {
	private List<Person> perList = new ArrayList<Person>();
	private PersonDao perDao = new PersonDaoImpl();
	
	public MainApp() {
		int size = getPerList().size();
		System.out.println("\n\n\n\n>>>>>> size:" + size);
	}
	
	public List<Person> getPerList() {
		try {
			perList = perDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			perList = new ArrayList<Person>();
		}
		return perList;
	}
	public void setPerList(List<Person> perList) {
		this.perList = perList;
	}
	public PersonDao getPerDao() {
		return perDao;
	}
	public void setPerDao(PersonDao perDao) {
		this.perDao = perDao;
	}
	
	
}
