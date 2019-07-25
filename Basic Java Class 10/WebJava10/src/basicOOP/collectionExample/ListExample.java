package basicOOP.collectionExample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import ioExample.CSVReader;
import ioExample.Student;

public class ListExample {
	List<Student> studentList = new ArrayList<Student>();
	Map<String, Student> studentMap = new HashMap<String, Student>();
	
	public ListExample() {
		CSVReader cr = new CSVReader();
		studentList.addAll(cr.getStudentList());
		/*
		 * for(Student st : studentList) { System.out.println(st); }
		 */
		
		for(int i = 0; i < studentList.size(); i ++) {
			System.out.println(studentList.get(i));
			studentMap.put(studentList.get(i).getStudentCode(), studentList.get(i));
		}
	}
	
	public static void main(String[] args) {
		ListExample le = new ListExample();
		System.out.println("\n\n\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Danh sach student da sort theo Name:");
		for(Student s : le.addSortedSetStudent(le.studentList)) {
			System.out.println(s);
		}
		System.out.println("\n\n\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Danh sach student da sort theo huy chuong:");
		Collections.sort(le.studentList, le.new SortStudent());
		for(Student st : le.studentList) {
			System.out.println(st);
		}
		
		System.out.println("\n\n\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Danh sach student da sort theo nam sinh:");
		Collections.sort(le.studentList, le.new SortByYear());
		for(Student st : le.studentList) {
			System.out.println(st);
		}
		
		System.out.println("\n\n\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Scanner sc = new Scanner(System.in);
		System.out.print("tim sinh vien voi Student-Code:");
		String code = sc.next();
		System.out.println("Ket qua tim kiem: ");
		System.out.println(le.studentMap.get(code));
	}
	
	class SortByYear implements Comparator<Student>{
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return o2.getYear().compareTo(o1.getYear());
		}
		
	}
	
	class SortStudent implements Comparator<Student>{
		public int compare(Student st1, Student st2) {
			int compare = st2.getGold() - st1.getGold();
			if(compare == 0) {
				compare = st2.getSilver() - st1.getSilver();
				if(compare == 0) {
					compare = st2.getBronze() - st1.getBronze();
				} else {
					compare = st2.getYear().compareTo(st1.getYear());
				}
			}
			return compare;
		}
	}
	
	public Set<Student> addSortedSetStudent(Collection<Student> sCol){
		Set studentSet = new TreeSet<Student>();
		studentSet.addAll(sCol);
		return studentSet;
	}
}
