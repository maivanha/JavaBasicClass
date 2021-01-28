package oop;

public class WrapperAndInnerClass {
	public class ValidateAccount {
		String eMail = "maivanha1610@gmail.com";
		public boolean isExistedAccount(String email) {
			if (email.equals(eMail)) return true;
			return false;
		}
	}
	
	public static void main(String[] args) {
		Integer i = 1;
		Integer i2 = new Integer(1);
		
		String str = "100";
		Long l = Long.parseLong(str);
		
		String myEmail = "maivanha1610@gmail.com";
		WrapperAndInnerClass wac = new WrapperAndInnerClass();
		ValidateAccount va = wac.new ValidateAccount();
		
		if(va.isExistedAccount(myEmail))
			System.out.println("Account này đã tồn tại ");
		else 
			System.out.println("Account hợp lệ");
	}
}
