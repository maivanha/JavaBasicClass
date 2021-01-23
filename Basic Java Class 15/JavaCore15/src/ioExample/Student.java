package ioExample;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student> {
	private String StudentCode,Name,email,phone,year,gold,silver,bronze;
	
	@Override
	public int compareTo(Student student) {
		return this.getStudentCode().compareTo(student.getStudentCode());
	}
	
	public Student(String studentCode, String name, String email, String phone, 
			String year, String gold, String silver, String bronze) {
		StudentCode = studentCode;
		Name = name;
		this.email = email;
		this.phone = phone;
		this.year = year;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("StudentCode:\t").append(this.getStudentCode()).append("\n");
		sb.append("Name:\t").append(this.getName()).append("\n");
		sb.append("email:\t").append(this.getEmail()).append("\n");
		sb.append("phone:\t").append(this.getPhone()).append("\n");
		sb.append("year:\t").append(this.getYear()).append("\n");
		sb.append("gold:\t").append(this.getGold()).append("\n");
		sb.append("silver:\t").append(this.getSilver()).append("\n");
		sb.append("bronze:\t").append(this.getBronze()).append("\n");
		
		return sb.toString();
	}

	public String getStudentCode() {
		return StudentCode;
	}

	public void setStudentCode(String studentCode) {
		StudentCode = studentCode;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGold() {
		return gold;
	}

	public void setGold(String gold) {
		this.gold = gold;
	}

	public String getSilver() {
		return silver;
	}

	public void setSilver(String silver) {
		this.silver = silver;
	}

	public String getBronze() {
		return bronze;
	}

	public void setBronze(String bronze) {
		this.bronze = bronze;
	}
}
