package basicOOP.collectionExample;

import java.util.ArrayList;
import java.util.List;

import ioExample.CSVReader;
import ioExample.Student;

public class ListExample {
	List<Student> studentList = new ArrayList<Student>();
	
	public ListExample() {
		CSVReader cr = new CSVReader();
		studentList.addAll(cr.getStudentList());
		/*
		 * for(Student st : studentList) { System.out.println(st); }
		 */
		
		for(int i = 0; i < studentList.size(); i ++) {
			System.out.println(studentList.get(i));
		}
	}
	
	public static void main(String[] args) {
		ListExample le = new ListExample();
		
	}
}
