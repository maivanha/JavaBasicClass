package basicOOP.collectionExample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
		System.out.println("\n\n\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Danh sach student da sort theo Name:");
		for(Student s : le.addSortedSetStudent(le.studentList)) {
			System.out.println(s);
		}
	}
	
	public Set<Student> addSortedSetStudent(Collection<Student> sCol){
		Set studentSet = new TreeSet<Student>();
		studentSet.addAll(sCol);
		return studentSet;
	}
}
