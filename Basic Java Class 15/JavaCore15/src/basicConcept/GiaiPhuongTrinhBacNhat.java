package basicConcept;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Giai phuong trinh bac nhat co dang: ax + b = 0 <br/>
 * - Nhap vao a va b tu ban phim <br/>
 * - Tinh gia tri cua x:<br/>
 * <ul>
 * <li>a = 0 va b != 0 --> phuong trinh vo nghiem</li>
 * <li>a = b = 0 --> phuong trinh vo so nghiem</li>
 * <li>a != 0 va b != 0 --> phuong trinh co nghiem duy nhat x = -b/ a</li>
 * </ul>
 * 
 * @author Ha
 *
 */
public class GiaiPhuongTrinhBacNhat {
	public static class MyInputException extends Exception {
		String varName = null;
		public MyInputException(String varName) {
			this.varName = varName;
		}
		public String getMessage() {
			return "Gia tri cua " + varName + "phai la mot so nguyen \n"
					+ "Moi ban nhap lai gia tri cho " + varName + ":";
		};
		public void printStackTrace() {
			System.out.println("Gia tri cua " + varName + " phai la mot so nguyen \n"
					+ "Moi ban nhap lai gia tri cho " + varName + ":");
		};
	}
	Scanner scanner = null;
	public int setValue(String varName) throws MyInputException {
		int a = 0;
		scanner = new Scanner(System.in);
		System.out.print("nhap vao " + varName + ": ");
		try {
			String input = scanner.nextLine();
			Integer wInt = Integer.parseInt(input);
			a = wInt;
			return a;
		} catch (InputMismatchException ime) {
			throw new MyInputException(varName);
		}
	}
	public static void main(String[] args) {
		int a = 0, b = 0;
		System.out.println("Giai phuong trinh bac 01: ax + b = 0");
		
		GiaiPhuongTrinhBacNhat gptbn = new GiaiPhuongTrinhBacNhat();
		
		MyInputException mie = new GiaiPhuongTrinhBacNhat.MyInputException("a");
		
		boolean isValid = false;
		do {
			try {
				a = gptbn.setValue("a");
				isValid = true;
			} catch (InputMismatchException ime) {
				System.out.println(ime.getMessage());
			} catch (MyInputException ex) {
				ex.printStackTrace();
			} finally {
				System.out.println("Gia tri a trong ham bac 1: ax + b = 0");
			}
		} while (isValid == false);
		isValid = false;
		do {
			try {
				b = gptbn.setValue("b");
				isValid = true;
			} catch (InputMismatchException ime) {
				System.out.println(ime.getMessage());
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			} finally {
				System.out.println("Gia tri b trong ham bac 1: ax + b = 0");
			}
		} while (isValid == false);

		System.out.println("Phuong trinh \"bac 01\" da tao:\n\t" + a + "*x + " + b + " = 0");

		if (a == 0 && b == 0)
			System.out.println("vo so nghiem");
		else if (a == 0)
			System.out.println("Vo nghiem");
		else {

			float x = (float) -b / a;
			System.out.println("x = " + x);
		}
	}

}
