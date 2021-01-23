package basic;

import java.util.Random;
import java.util.Scanner;

public class MangVaXuLyTrenMang {
	public static void main(String[] args) {
		int intAr[] = null;
		int n = 0;
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.println("1. Nhap vao kich thuoc cua mang n = ");
		n = sc.nextInt();

		intAr = new int[n];

		// Nhập phần tử cho mảng sử dụng Random:
		System.out.println("2. Khoi tao gia tri cho mang:");
		for (int i = 0; i < n; i++) {
			// System.out.println("intAr[" + i + "] = ");
			// intAr[i] = sc.nextInt();
			intAr[i] = rd.nextInt(100);
		}

		// In các phần tử của mảng ra màn hình
		System.out.println("3. In Mang da nhap ra man hinh:");
		for (int i : intAr) {
			System.out.print(i + "\t");
		}

		System.out.println("\n4. Tim phan tu Min, Max trong mang:");
		int max = intAr[0];
		int min = intAr[0];

		for (int a : intAr) {
			if (a > max) {
				max = a;
			} else if (a < min) {
				min = a;
			}
		}
		System.out.println("Gia tri lon nhat la: " + max);
		System.out.println("Gia tri nho nhat la: " + min);
		
		System.out.println("5. Tìm số nguyên tố:");
		int soNT[] = new int[n];
		int count = 0;
		for(int i = 0; i < n; i ++) {
			if(intAr[i] == 0) continue;
			
			int m = (int)Math.sqrt(intAr[i]);
			boolean isTrue = true;
			for( int j = 2; j <= m; j ++) {
				if(intAr[i] % j == 0) {
					isTrue = false;
					break;
				}
			}
			
			if(isTrue) {
				soNT[count] = intAr[i];
				count++;
			}
		}
		
		if(count == 0) System.out.println("Mang khong co so nguyen to");
		else {
			System.out.println("Cac so nguyen to trong mang:");
			for(int i = 0; i < count; i ++) {
				System.out.print(soNT[i] + "\t");
			}
		}
		
		for(int i = 0; i < n - 1; i ++) {
			for(int j = i + 1; j < n; j ++) {
				if(intAr[i] > intAr[j]) {
					int b = intAr[i];
					intAr[i] = intAr[j];
					intAr[j] = b;
				}
			}
		}
		
		System.out.println("\n6. Mang sap xep theo thu tu tang dan:");
		for (int i : intAr) {
			System.out.print(i + "\t");
		}
		System.out.println("\n7. Tim phan tu X trong mang: ");
		System.out.println("Nhap phan tu X can tim: ");
		int x = sc.nextInt();
		int l = 0;
		int r = intAr.length - 1;
		boolean b = false;
		while(l <= r) {
			int mid = (l + r) / 2;
			if (x == intAr[mid]) {
				System.out.println("X nam o vi tri thu: " + mid);
				b = true;
				break;
			}
			else if(x < intAr[mid]) {
				r = mid - 1;
			}
			else {
				l = mid + 1; 
			}
		}
		if (b == false) {
			System.out.println("Khong tim thay");
		}
	}
}
