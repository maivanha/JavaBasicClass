package collectionExample;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import ioExample.CSVReader;
import ioExample.Student;

public class CollectionExample {
	public static class CompareStudentByResult implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			if(Integer.parseInt(o1.getGold()) - Integer.parseInt(o2.getGold()) != 0) 
				return Integer.parseInt(o1.getGold()) - Integer.parseInt(o2.getGold());
			else if(Integer.parseInt(o1.getSilver()) - Integer.parseInt(o2.getSilver()) != 0) 
				return Integer.parseInt(o1.getSilver()) - Integer.parseInt(o2.getSilver());
			else if(Integer.parseInt(o1.getBronze()) - Integer.parseInt(o2.getBronze()) != 0) 
				return Integer.parseInt(o1.getBronze()) - Integer.parseInt(o2.getBronze());
			else return o1.getName().compareTo(o2.getName());
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		String filePath = "students.csv";
		CSVReader csvReader = new CSVReader();
		System.out.println("List view:");
		List<Student> students = 
				csvReader.csvLineBufferReader(filePath);
		for(Student std : students) {
			System.out.println(std);
		}
		
		System.out.println("List view sort by result:");
		students.remove(0);
		students.sort(new CompareStudentByResult());
		for(Student std : students) {
			System.out.println(std);
		}
		
		System.out.println("TreeSet view sort by name:");
		for(Student std : 
			csvReader.readStudentIntoTreeSet(
					filePath)) {
			System.out.println(std);
		}
		
	}
}
