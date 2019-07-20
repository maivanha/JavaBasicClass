package basicOOP.exceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandling {
	int a, b, result;

	public static void main(String[] args) {
		InputHandling ih = new InputHandling();
		/*
		 * ih.input(); ih.sum();
		 */
		//ih.calculate();
		//ih.display();
		try {
			System.out.println(">>>>>> Run main function");
			ih.runSomeThing();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("\n>>>>>> Finish main function");
		} finally {
			System.out.println("van chay o day");
		}
	}
	
	public void runSomeThing() throws Exception {
		System.out.println("do something");
		try{
			display();
		}catch (Exception e) {
			throw e;
		}
	}
	
	public void display() {
		throw new RuntimeException();
	}
	
	public void calculate() {
		Exception ex = null;
		do {
			System.out.println("Nhap gia tri cho a va b:");
			ex = null;
			Scanner sc = new Scanner(System.in);
			try {
				System.out.print("a = ");
				a = sc.nextInt();

				System.out.print("b = ");
				b = sc.nextInt();
				
				result = a / b;
				System.out.println(result);
			} catch (ArithmeticException ae) {
				ex = ae;
				System.out.println("gap loi: phep chia cho 0; hay nhap b # 0");
			} catch (InputMismatchException ime) {
				ex = ime;
				System.out.println("Chi duoc nhap so nguyen cho a va b");
			} catch (Exception e) {
				ex = e;
				e.printStackTrace();
			}
		} while (ex != null);
	}

	public void input() {
		Exception ex = null;
		do {
			System.out.println("Nhap gia tri cho a va b:");
			ex = null;
			Scanner sc = new Scanner(System.in);
			try {
				System.out.print("a = ");
				a = sc.nextInt();

				System.out.print("b = ");
				b = sc.nextInt();
			} catch (InputMismatchException ime) {
				ex = ime;
				System.out.println("Chi duoc nhap so nguyen cho a va b");
			}
		} while (ex != null);
	}

	public void sum() {
		result = a + b;
		System.out.println("Result = " + a + " + " + b + " = " + result);
	}
}
