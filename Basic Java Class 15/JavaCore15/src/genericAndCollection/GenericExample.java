package genericAndCollection;

import java.io.IOException;

import ioExample.CSVReader;
import ioExample.Student;

public class GenericExample <T> {
	private T student;
	
	public GenericExample(T student) {
		this.student = student;
	}
	
	public void setStudent(T student) {
		this.student = student;
	}
	
	public void printToScreen() {
		System.out.println(student.toString());
	}
	
	public static void main(String[] args) throws IOException {
		String filePath = "students.csv";
		CSVReader csvReader = new CSVReader();
		GenericExample<Student> genStudent;
		for(Student st : csvReader.csvLineBufferReader(filePath)) {
			if(st == null) break;
			genStudent = new GenericExample<Student>(st);
			//genStudent.setStudent(st);
			System.out.println(">>>>>> Generic Student's Information:");
			genStudent.printToScreen();
		}
		
		String[] studentNames = new String[] {"A", "B", "C"};
		GenericExample<String> genString;
		for(String str : studentNames) {
			genString = new GenericExample<String>(str);
			//genString.setStudent(str);
			genString.printToScreen();
		}
	}
}
