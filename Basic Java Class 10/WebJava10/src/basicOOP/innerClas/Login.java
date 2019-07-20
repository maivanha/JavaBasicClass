package basicOOP.innerClas;

public class Login {
	private String username;
	private String password;
	private static String creditCard;
	
	
	public Login(String us, String pw) {
		this.username = us;
		this.password = pw;
	}
	
	public static void main(String[] args) {
		Login login = new Login("Admin", "123456@NIIT");
		ValidateCredentials validate = login.new ValidateCredentials();
		validate.validate();
		
		ValidateCreditCard vc = new ValidateCreditCard();
		vc.validate();
		
		login.methodInnerClass();
	}
	

	public void methodInnerClass() {
		class InnerClass{
			void print() {
				System.out.println("Day la mot innerClass trong mot method");
			}
		}
		
		InnerClass iC = new InnerClass();
		iC.print();
	}
	
	class ValidateCredentials {
		public void validate() {
			System.out.println(username);
		}
	}
	
	static class ValidateCreditCard{
		static {
			creditCard = "12345678900";
		}
		
		public void validate() {
			System.out.println(creditCard);
		}
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
	
	
}
