package niit.java.mvcProject;

import java.util.List;
import java.util.Set;

import niit.java.mvcProject.dao.PersonDao;
import niit.java.mvcProject.dao.impl.PersonDaoImpl;
import niit.java.mvcProject.model.Orders;
import niit.java.mvcProject.model.Person;

public class MainTest {
	public static void main(String[] args) {
		PersonDao perDao = new PersonDaoImpl();
		
		Person per = perDao.checkUserName("productOwner");
		System.out.println("Tai khoan \"productOwner\" " + 
											((per != null)?"da ton tai": "chua co trong db"));
		
		List<Person> perList = perDao.getAll();
		
		for(Person p : perList) {
			System.out.println("\n\n\n\n>>>>>> Person: " + p);
			System.out.println("\t\t>>> Cac don hang da mua:");
			Set<Orders> ordSet = p.getOrders();
			System.out.println("\t\t>>> So luong don hang da mua:" + ordSet.size());
			for(Orders o : ordSet) {
				System.out.println("\tOrderId:" + o.getId());
				System.out.println("\tTotalPrice:" + o.getTotalPrice());
			}
			System.out.println("---------------------------------------------------------");
		}
		
		return ;
	}
}
