package ioExample;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CSVReader {
	private List<Student> data = new ArrayList<Student>();
	private Map<String, Student> studentMap = new Hashtable<String, Student>();
	private Set<Student> stdSet = new TreeSet<Student>();

	public Set<Student> readStudentIntoTreeSet(String filePath) throws IOException {
		File file = new File(filePath);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		int index = 0;
		String line;
		String[] lineData = null;
		Student student;
		while ((line = br.readLine()) != null) {
			lineData = line.split(",");
			student = new Student(lineData[0], lineData[1], lineData[2], lineData[3], lineData[4], lineData[5],
					lineData[6], lineData[7]);
			stdSet.add(student);
		}

		br.close();
		fr.close();

		System.out.println(">>>>>> Size of List:" + data.size());

		return stdSet;
	}

	public List<Student> csvLineBufferReader(String filePath) throws IOException {

		File file = new File(filePath);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		int index = 0;
		String line;
		String[] lineData = null;
		Student student;
		while ((line = br.readLine()) != null) {
			lineData = line.split(",");
			student = new Student(lineData[0], lineData[1], lineData[2], lineData[3], lineData[4], lineData[5],
					lineData[6], lineData[7]);
			data.add(student);
			studentMap.put(student.getStudentCode(), student);
		}

		br.close();
		fr.close();

		System.out.println(">>>>>> Size of List:" + data.size());

		return data;
	}

	public String[] csvFileBufferReader(String filePath) throws IOException {
		String[] data = null;

		File file = new File(filePath);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		StringBuilder dataSB = new StringBuilder();
		int c;
		while ((c = br.read()) != -1) {
			dataSB.append((char) c);
		}

		data = new String[] { dataSB.toString() };

		return data;
	}

	public String[] csvFileReader(String filePath) throws IOException {
		String[] data = null;

		File file = new File(filePath);
		FileReader fr = new FileReader(file);

		StringBuilder dataSB = new StringBuilder();
		int c;
		while ((c = fr.read()) != -1) {
			dataSB.append((char) c);
		}

		data = new String[] { dataSB.toString() };

		return data;
	}

	public String[] csvBufferReading(String filePath) throws IOException {
		String[] data = null;
		File file = new File(filePath);
		FileInputStream fin = new FileInputStream(file);

		BufferedInputStream bis = new BufferedInputStream(fin);

		StringBuilder dataSB = new StringBuilder();
		int c;
		while ((c = bis.read()) != -1) {
			dataSB.append((char) c);
		}

		data = new String[] { dataSB.toString() };
		return data;
	}

	public String[] csvReading(String filePath) throws IOException {
		File csvFile = new File(filePath);

		FileInputStream fis = new FileInputStream(csvFile);
		int data = 0;

		StringBuilder dataSB = new StringBuilder();

		while ((data = fis.read()) != -1) {
			dataSB.append((char) data);
		}

		fis.close();

		return new String[] { dataSB.toString() };
	}

	public void writeStringData(Student[] students) throws IOException {
		FileOutputStream fos = null;
		Date date;
		System.out.println(">>>>>> Start");
		for (Student s : students) {
			if (s != null) {
				System.out.println(s);

				date = new Date();
				fos = new FileOutputStream(new File(s.getStudentCode() + "_" + date.getTime() + ".txt"));
				fos.write(s.toString().getBytes());
				fos.flush();
				fos.close();
			} else {
				break;
			}
		}

		// System.out.println(data[0]);
		System.out.println(">>>>> finish");
	}

	public void writeObjectData(Student[] students) throws IOException {
		ObjectOutputStream oos = null;
		FileOutputStream fos;
		Date date;
		System.out.println(">>>>>> Start");
		for (Student s : students) {
			if (s != null) {
				System.out.println(s);

				date = new Date();
				fos = new FileOutputStream(new File(s.getStudentCode() + "_" + date.getTime() + ".data"));

				oos = new ObjectOutputStream(fos);
				oos.writeObject(s);

				oos.flush();
				oos.close();
			} else {
				break;
			}
		}

		System.out.println(">>>>> finish");
	}

	public Student readData(String fileName) throws IOException, ClassNotFoundException {
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student student = (Student) ois.readObject();

		return student;
	}

	public List<Student> getData() {
		return data;
	}

	public void setData(List<Student> data) {
		this.data = data;
	}

	public Map<String, Student> getStudentMap() {
		return studentMap;
	}

	public void setStudentMap(Map<String, Student> studentMap) {
		this.studentMap = studentMap;
	}

	public static void main(String[] args) {
		String filePath = "students.csv";
		CSVReader csvReader = new CSVReader();

		try {
			System.out.println(csvReader.readData("S1_1599290734643.data"));

			// Student[] students = csvReader.csvLineBufferReader(filePath);
			List<Student> students = csvReader.csvLineBufferReader(filePath);
			// csvReader.writeObjectData(students);
			// String data[] = csvReader.csvReading(filePath);
			// String data[] = csvReader.csvBufferReading(filePath);
			// String data[] = csvReader.csvFileReader(filePath);
			// String data[] = csvReader.csvFileBufferReader(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
}
