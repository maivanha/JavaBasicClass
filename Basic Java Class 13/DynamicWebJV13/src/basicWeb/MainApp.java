package basicWeb;

import java.sql.SQLException;
import java.util.List;

import basicWeb.dao.PersonDao;
import basicWeb.model.Person;

public class MainApp {
	public static void main(String[] args) 
			throws InstantiationException, IllegalAccessException, 
			ClassNotFoundException, SQLException {
		PersonDao perDao = new PersonDao();
		/*
		 * Person p = new Person("Bùi Văn", "G", "Ba Đình", "Hà Nội", "userName3",
		 * "123456", "0125412036"); 
		 * perDao.save(p);
		 */
		
		List<Person> pers = perDao.getAll();
		for(Person per : pers) {
			System.out.println(per.toString());
		}
	}
}
