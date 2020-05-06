package basicWeb.model;

public class Person {
	private int personId;
	private String lastName;
	private String firstName;
	private String address;
	private String city;
	private String username;
	private String password;
	private String phone;
	
	public Person(String lastName, String firstName, String address, String city, String username, String password,
			String phone) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.city = city;
		this.username = username;
		this.password = password;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("id:")
				.append(this.getPersonId()).append(";");
		sb.append("id:").append(this.getPersonId()).append(";");
		sb.append("username:").append(this.getUsername()).append(";");
		sb.append("Phone:").append(this.getPhone()).append(";");
		return sb.toString();
	}
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
