package genericAndCollection;

import java.io.IOException;
import java.util.List;

import ioExample.CSVReader;
import ioExample.Student;

public class GenericMethodExample {
	public <E> void printToScreen(E[] elementArray){
		for(E element : elementArray) {
			System.out.println(element);
		}
	}
	
	public static void main(String[] args) throws IOException {
		GenericMethodExample gme = new GenericMethodExample();
		
		String filePath = "students.csv";
		CSVReader csvReader = new CSVReader();
		List<Student> students = csvReader.csvLineBufferReader(filePath);
		gme.printToScreen(students.toArray());
	}
}
