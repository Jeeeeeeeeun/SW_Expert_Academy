package day3;

import java.util.Scanner;

public class Solution_D2_1961_숫자배열회전 {
	static int N;
	static int[][] matrix;
	static int[][] m90;
	static int[][] m180;
	static int[][] m270;

	public static void main(String args[]) throws Exception {

		// System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			matrix = new int[N][N];
			m90 = new int[N][N];
			m180 = new int[N][N];
			m270 = new int[N][N];

			// map
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}

			rotate90();
			rotate180();
			rotate270();

			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(m90[i][j]);
				}
				System.out.print(" ");

				for (int j = 0; j < N; j++) {
					System.out.print(m180[i][j]);
				}

				System.out.print(" ");

				for (int j = 0; j < N; j++) {
					System.out.print(m270[i][j]);
				}

				System.out.println("");
			}

		}
	}

	private static void rotate90() {
		for (int i = 0; i < N; i++) { // i=행
			for (int j = 0; j < N; j++) { // j=열
				m90[j][N - i - 1] = matrix[i][j];
			}
		}
	}

	private static void rotate180() {
		for (int i = 0; i < N; i++) { // i=행
			for (int j = 0; j < N; j++) { // j=열
				m180[N - i - 1][N - j - 1] = matrix[i][j];
			}
		}
	}

	private static void rotate270() {
		for (int i = 0; i < N; i++) { // i=행
			for (int j = 0; j < N; j++) { // j=열
				m270[N - j - 1][i] = matrix[i][j];
			}
		}
	}
}
