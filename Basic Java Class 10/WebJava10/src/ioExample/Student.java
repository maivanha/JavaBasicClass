package ioExample;

public class Student implements Comparable<Student>{
	private String StudentCode,Name,email,phone,year;
	private int gold,silver,bronze;

	public Student(String studentCode, String name, String email, String phone, String year) {
		StudentCode = studentCode;
		Name = name;
		this.email = email;
		this.phone = phone;
		this.year = year;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("\nStudent's info:\n");
		sb.append("StudentCode=").append(StudentCode);
		sb.append("\nName=").append(Name);
		sb.append("\nemail=").append(email);
		sb.append("\nphone=").append(phone);
		sb.append("\nyear = ").append(year);
		sb.append("\ngold = ").append(gold);
		sb.append("\nsilver = ").append(silver);
		sb.append("\nbronze = ").append(bronze);
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

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(int silver) {
		this.silver = silver;
	}

	public int getBronze() {
		return bronze;
	}

	public void setBronze(int bronze) {
		this.bronze = bronze;
	}

	@Override
	public int compareTo(Student s) {
		return this.getName().compareTo(s.getName());
	}
	
	
}
