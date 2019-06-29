package basicOOP.arrayAndString;

import java.util.Random;
import java.util.Scanner;

/**
 * Ma trận (mảng 02 chiều) và các bài tập liên quan
 * 
 * @author Ha
 *
 */
public class Matrix {
	private int a[][]; // mảng 2 chiều
	private int n; // số dòng
	private int m; // số cột

	private Scanner sc = new Scanner(System.in);

	/**
	 * Hàm thực thi chính của chương trình
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Matrix m = new Matrix();
		m.initMatrix();
		m.printMatrix();
		m.findMax();
		m.findRowMax2();
	}

	/**
	 * tìm phần tử lớn nhất trong ma trận
	 */
	public void findMax() {
		int max = a[0][0];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (max < a[i][j]) {
					max = a[i][j];
				}
			}
		}
		System.out.println("Max của matrix =" + max);

	}

	/**
	 * Khởi tạo giá trị cho man trận <code>matrix</code> :<br/>
	 * <ul>
	 * <li>Nhập vào số dòng <b><i>n</b></i>
	 * <li>Nhập vào số cột <b><i>m</b></i>
	 * <li>Nhập giá trị cho phần tử <b><i>matrix[i][j]</b></i>
	 * </ul>
	 */
	public void initMatrix() {
		System.out.print("nhap n");
		n = sc.nextInt();
		System.out.print("nhap m");
		m = sc.nextInt();

		a = new int[n][m];

		Random rd = new Random();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// System.out.print("a[" + i + "][" + j + "] = ");
				// a[ i ][ j ] = sc.nextInt();

				a[i][j] = rd.nextInt(100);
				System.out.print("a[" + i + "][" + j + "] = " + a[i][j] + "\t");
			}
		}
	}

	/**
	 * in các phần tử trong ma trận đã nhập ra màn hình
	 */
	public void printMatrix() {
		System.out.println("\nMa tran da nhap:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("");
		}
	}

	/**
	 * Tìm dòng có tổng lớn nhất
	 */
	public void findRowMax() {
		int sum[] = new int[n];

		for (int i = 0; i < n; i++) {
			sum[i] = 0;
			for (int j = 0; j < m; j++)
				sum[i] += a[i][j];
		}

		int max = sum[0], row = 0;

		for (int i = 1; i < n; i++) {
			if (max < sum[i]) {
				max = sum[i];
				row = i;
			}
		}

		System.out.print("\nDong " + (row) + " co tong lon nhat la: " + max);
	}

	/**
	 * Tìm dòng có tổng lớn nhất theo cách gộp code
	 */
	public void findRowMax2() {
		int sum[] = new int[n];
		int max = 0, row = 0;

		for (int i = 0; i < n; i++) {
			sum[i] = 0;
			for (int j = 0; j < m; j++) {
				sum[i] += a[i][j];
				if (i == 0) {
					max = sum[0];
				} else if (max < sum[i]) {
					max = sum[i];
					row = i;
				}
			}
		}

		System.out.print("\nDong " + (row) + " co tong lon nhat la: " + max);
	}
}
