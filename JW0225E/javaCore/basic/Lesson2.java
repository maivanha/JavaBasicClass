package javaCore.basic;

import java.util.Random;
import java.util.Scanner;

public class Lesson2 {
	public static Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	public static int n;
	public static int[] aInt;
	
	public void compareAandB(int a, int b) {
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		if(a == b) System.out.println("a = b");
		else if(a > b) System.err.println("a > b");
		else System.out.println("a < b");
		
	}
	
	public void switchExample() {
		int month = 2;
		int year = 2025;
		int day = 19;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		case 2:
			if(year % 400 == 0 ||
				(
						(year % 4 == 0) && year % 100 != 0
				)
			)
				day = 29;
			else day = 28;
			break;
		}
		
		System.out.println("Day:" + day);
	}
	
	public double tinhGiaiThua(int n) {
		if(n < 0) {
			System.out.println("Ban can nhap vao n >= 0");
			return -1;
		}
		
		double result = 1;
		
		while (n > 0) {
			result *= n;
			n --;
		}
		
		return result;
	}
	
	public double tinhGiaiThua2(int n) {
		double result = 1;
		
		int i = 1;
		do {
			result *= i;
			i ++;
		} while (i <= n);
		
		return result;
	}
	
	public double tinhGiaiThuaVoiFor(int n) {
		double result = 1;
		
		for(int i = 1; i <= n; i ++) {
			result *= i;
		}
		
		return result;
	}
	
	public void printNumberExcep5(int n) {
		for ( int i = 0; i < n; i ++ ) {
			if( i == 5) continue;
			if( i == 8) break;
			System.out.print(i + ";");
		}
		System.out.println();
	}
	
	public void khoiTaoMang(int n) {
		aInt = new int[n];
		
		for(int i = 0; i < n; i ++ ) {
			aInt[i] = rd.nextInt(5);
		}
		
		System.out.println("mang vua duoc khoi tao:");
		for(int i = 0; i < n; i ++) 
			System.out.println("aInt[" + i + "] = " + aInt[i]);
	}
	
	// Tim so lan lap lai cua 01  phan tu trong mang
	public int demSoLanLapLai() {
		int count = 0;
		
		System.out.print("so can dem m = ");
		int m = sc.nextInt();
		// dung for
//		for(int i = 0; i < aInt.length; i ++ ) {
//			if(aInt[i] == m) count ++;
//		}
		
		// dung foreach
		for (int i : aInt) {
			if (i == m) count ++;
		}
		
		return count;
	}
	// 1 2 3 4 5 --> 5 4 3 2 1
	public int[] daoNguocMang() {
		// do phuc tap = O(n)
//		int[] newArray = new int[aInt.length];
//		int j = 0;
//		for(int i = aInt.length - 1; i >= 0; i --) {
//			newArray[j ++] = aInt[i];
//		}
		
		// do phuc tap = O(n/2)
		int[] newArray = aInt.clone();
		int m = aInt.length / 2;
		for(int i = 0; i < m; i ++) {
			int d = newArray[newArray.length - 1 - i];
			newArray[newArray.length - 1 - i] = newArray[i];
			newArray[i] = d;
		}
		
		return newArray;
	}
	
	public static void main(String[] args) {
		Lesson2 cab = new Lesson2();

		System.out.print("n = ");
		n = sc.nextInt();
		
		cab.khoiTaoMang(n);
		for (int i : cab.daoNguocMang()) {
			System.out.print(i + "; ");
		}
//		int count = cab.demSoLanLapLai();
//		System.out.println("so lan lap lai: " + count);
		
//		cab.printNumberExcep5(n);
//		
//		double result = cab.tinhGiaiThua(n);
//		System.out.println(n + "! = " + result);
//		System.out.println(n + "! = " + cab.tinhGiaiThua2(n));
//		System.out.println(n + "! = " + cab.tinhGiaiThuaVoiFor(n));
		
//		cab.switchExample();
		
//		int a = cab.rd.nextInt();
//		int b = cab.rd.nextInt();
//		
//		cab.compareAandB(a, b);
//		
//		System.out.println("Nhap gia tri a & b de so sanh:");
//		System.out.print("a = ");
//		a = sc.nextInt();
//		System.out.print("b = ");
//		b = sc.nextInt();
//		
//		cab.compareAandB(a, b);
		
		sc.close();
	}
}
