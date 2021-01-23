package basic;

import java.util.Scanner;

public class ChuyenThapPhanSangNhiPhan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap vao mot so bat ki: ");
		int number = sc.nextInt(); 
		String value = "";
		while(number>0) {
			value = number % 2 + value;
			number = number/2;  
		}
		System.out.print("So Nhi Phan: " + value);
		
	}
}
