package basic;

import java.util.Scanner;

public class Bai01 {
	static Scanner sc = new Scanner(System.in);
	static int arg1;
	static int arg2;

	public static void tinhTongNGiaiThua() {
		System.out.print("Nhap vao gia tri cua n: ");
		int n = sc.nextInt();

		System.out.println("Gia tri n da nhap:" + n);
		double sum = 0;
		double gt = 1;
		for (int i = 1; i <= n; i++) {
			gt *= i;
			sum += gt;
			System.out.println(i + "! = " + gt + "\t sum = " + sum);
		}
		System.out.println("1! + 2! + ... + " + n + "! = " + sum);
	}

	public static int tong(int a, int b) {
		a -= 1;
		b -= 1;
		return a + b;
	}

	public static void tinhTongThamTri() {
		System.out.print("Nhap vao gia tri cua a: ");
		int a = sc.nextInt();
		System.out.print("Nhap vao gia tri cua b: ");
		int b = sc.nextInt();

		int tong = tong(a, b);
		System.out.println("tong =  " + tong);
		System.out.println("a = " + a + "\tb = " + b);
	}

	public static int tongSuDungThamChieu(Bai01 obj) {
		obj.arg1 -= 1;
		obj.arg2 -= 1;

		return obj.arg1 + obj.arg2;
	}

	public static void tinhTongThamChieu() {
		Bai01 obj = new Bai01();
		System.out.print("Nhap vao gia tri cua arq1: ");
		obj.arg1 = sc.nextInt();
		System.out.print("Nhap vao gia tri cua arq2: ");
		obj.arg2 = sc.nextInt();
		int tong = tongSuDungThamChieu(obj);
		System.out.println("tong: " + tong);
		System.out.println("obj.arg1 = " + obj.arg1 + "\tobj.arg2 = " + obj.arg2);
	}

	public static void phepToanTienToHauTo() {
		int a = 1;
		int b = a++;
		int c = ++a;

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	
	public static void toanTuBaNgoi() {
		System.out.print("Nhap vao gia tri cua a: ");
		int a = sc.nextInt();
		System.out.print("Nhap vao gia tri cua b: ");
		int b = sc.nextInt();

		if (a > b)
			System.out.println("a > b");
		else
			System.out.println("a <= b");

		String message = (a > b) ? "a > b" : "a <= b";
		System.out.println(message);
	}
	
	public static boolean kiemTra( int a) {
		System.out.println("Kiem tra bien truyen vao:" + a);
		return a > 5;
	}

	public static void main(String[] args) {
		System.out.println("Hello World !");
		System.out.println("My name is \"Ha\"");

		/*
		 * tinhTongNGiaiThua(); 
		 * tinhTongThamTri(); 
		 * tinhTongThamChieu();
		 * phepToanTienToHauTo();
		 * toanTuBaNgoi();
		 */
		System.out.print("Nhap vao gia tri cua a: ");
		int a = 5;//sc.nextInt();
		System.out.print("Nhap vao gia tri cua b: ");
		int b = 6; //sc.nextInt();
		
		System.out.println("Condition voi mot dau &");
		if (kiemTra(a) & kiemTra(b)) System.out.println("Thoa man dieu  kien");
		System.out.println("Condition voi hai dau &");
		if (kiemTra(a) && kiemTra(b)) System.out.println("Thoa man dieu  kien");
	}

}
