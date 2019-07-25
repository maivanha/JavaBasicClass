package ioExample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	private String filePath = "/media/maivanha/01D32B0929AA6810/" + 
			"My Projects/JavaBasicClass/JavaBasicClass/"
			+ "Basic Java Class 10/WebJava10/src/" 
			+ "students.csv";

	public static void main(String[] args) {
		CSVReader cr = new CSVReader();
		try {
			cr.printFileContent();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Student> getStudentList(){
		List<Student> sList = new ArrayList<Student>();
		
		String lineData;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			int count = 0;
			String StudentCode,Name,email,phone,year;
			String[] aString = null;
			Student st;
			while ((lineData = br.readLine()) != null) {
				if(0 == count ++){
					continue;
				}
				aString = lineData.split(",");
				
				if(aString.length < 5) continue;
				
				StudentCode = aString[0];
				Name  = aString[1];
				email = aString[2];
				phone = aString[3];
				year  = aString[4];
				st = new Student(StudentCode, Name, email, phone, year);
				
				sList.add(st);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return sList;
	}

	public void printFileContent() throws FileNotFoundException, IOException {
		String lineData;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			int count = 0;
			String StudentCode,Name,email,phone,year;
			String[] aString = null;
			while ((lineData = br.readLine()) != null) {
				if(0 == count ++){
					continue;
				}
				aString = lineData.split(",");
				
				if(aString.length < 5) continue;
				
				StudentCode = aString[0];
				Name  = aString[1];
				email = aString[2];
				phone = aString[3];
				year  = aString[4];
				Student st = new Student(StudentCode, Name, email, phone, year);
				
				System.out.println(lineData);
				System.out.println(st);
			}
		} catch (FileNotFoundException fnfe) {
			throw fnfe;
		} catch (IOException ie) {
			throw ie;
		} finally {
			try {
				br.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
