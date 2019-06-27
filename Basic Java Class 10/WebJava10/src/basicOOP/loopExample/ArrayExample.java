package basicOOP.loopExample;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
	int ar[] = { 10, 5, 25, 36, 29 }; // mảng 01 chiều ban đầu
	int n; // kích cỡ của mảng, do người dùng nhập vào từ bàn phím
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample ae = new ArrayExample();
		ae.initArray();
		ae.printArray();
		ae.findMinNumber();
		ae.findPrime();
		ae.findMinOdd();
		// ae.printArrayUsingIndex();
	}

	/**
	 * Tìm số lẻ nhỏ nhất của mảng
	 */
	public void findMinOdd() {
		int minodd = 0, i = 0;
		for (; i < ar.length; i++) {
			if (ar[i] % 2 != 0) {
				minodd = ar[i];
				break;
			}
		}
		if (i == ar.length) {
			System.out.println("Khong co so le");
		} else {
			for (int a = i; a < ar.length; a++) {
				if (ar[a] % 2 != 0 && minodd > ar[a])
					minodd = ar[a];
			}
			System.out.println("Min Odd = " + minodd);
		}
	}

	/**
	 * tìm các số nguyên tố trong mảng và in ra màn hình.
	 */
	public void findPrime() {
		boolean check = false;
		for (int a : ar) {
			if (checkPrime(a)) {
				if (check == false)
					System.out.print("So nguyen to: ");
				System.out.print(a + ";\t");
				check = true;
			}
		}
		if (check == false)
			System.out.println("Khong co so nguyen to");
	}

	/**
	 * Kiểm tra số <code>n</code> có phải là số nguyên tố hay không</br>
	 * lấy n chia cho từ 2 đến căn bậc 2 của n, nếu có phép chia hết thì n không
	 * phải số nguyên tố.
	 * 
	 * @param n
	 *            số cần kiểm tra
	 * @return <b>true</b> nếu n là số nguyên tố<br/>
	 *         <b>false</b> nếu n không phải số nguyên tố
	 */
	public boolean checkPrime(int n) {
		if (n == 0 || n == 1)
			return false;
		double max = Math.sqrt(n);
		for (int i = 2; i <= max; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * Tìm số nhỏ nhất của mảng
	 */
	public void findMinNumber() {
		int min = ar[0];
		for (int i = 1; i < ar.length; i++) {
			if (min > ar[i])
				min = ar[i];
		}
		System.out.println(" min: " + min);
	}

	/**
	 * Hàm khởi tạo giá trị cho mảng, công việc thực hiện: <br/>
	 * 1. Nhập vào giá trị n từ bản phím<br/>
	 * 2. Nhập vào phần tử từ ar[0] đến ar[n-1] <br/>
	 * <b><i>Hệ thống tự động sinh giá trị cho phần tử ar[i]</i></b>
	 */
	public void initArray() {
		System.out.print("Nhap n = ");
		n = sc.nextInt();
		ar = new int[n];
		Random rd = new Random();

		for (int i = 0; i < n; i++) {
			ar[i] = rd.nextInt(100);
			System.out.println("Nhap a[" + i + "] = " + ar[i]);
		}
		/*
		 * for(int i=0; i<n; i++) { System.out.print("Nhap a["+i+"] = "); ar[i] =
		 * sc.nextInt(); }
		 */
	}

	/**
	 * in mảng ra màn hình; sử dụng lệnh for-each
	 */
	public void printArray() {
		for (int a : ar) {
			System.out.print(a + ", ");
		}
		System.out.println("\n\n");
	}

	/**
	 * in mảng ra màn hình thông qua truy cập index, dạng ar[i]
	 */
	public void printArrayUsingIndex() {
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i] + ", ");
		}
	}
}
