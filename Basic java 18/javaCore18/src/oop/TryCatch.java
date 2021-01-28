package oop;

import java.util.Scanner;

public class TryCatch {
	class MyException extends Exception {
		private static final long serialVersionUID = 1L;
		private double amount = 1;
		public MyException(double amount) {
			// TODO Auto-generated constructor stub
			this.setAmount(amount);
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
	}
	
	public double calculate(double a, double b) throws MyException {
		if( b == 0 ) throw new MyException(10);
		return a/ b;
	}
	
	public static void main(String[] args) {
		TryCatch tc = new TryCatch();
		Scanner sc = new Scanner(System.in);
		boolean isCon = true; 
		String s = null;
		do {
			System.out.println(" a = ");
			double a = sc.nextDouble();
			System.out.println("b = ");
			double b = sc.nextDouble();
			
			try {
				double c = tc.calculate(a, b);
				System.out.println(a + " / " + b + " = " + c);
			} catch (MyException e) {
				System.out.println("b phải khác 0");
			} finally {
				System.out.println("Thực hiện phép chia hai số");
			}
			
			System.out.println("Bạn muốn tiếp tục không? \n (nhập Y hoặc N) ");
			s = sc.next();
			if(s.equals("Y")) isCon = true;
			else isCon = false;
		}while(isCon);
	}
}
