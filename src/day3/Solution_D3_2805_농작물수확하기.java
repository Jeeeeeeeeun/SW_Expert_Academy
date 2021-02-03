package day3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_2805_농작물수확하기 {
	static int N;
	static int[][] map;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src\\day3\\2805_농작물수확하기.txt"));
		Scanner sc = new Scanner(System.in);

//		Scanner sc = new Scanner("1\r\n" + "5\r\n" + "14054\r\n" + "44250\r\n" + "02032\r\n" + "51204\r\n" + "52212");
		int T;
		T = sc.nextInt();
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			sc.nextLine();

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			int k = N / 2;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = k; j < N - k; j++) {
					sum += map[i][j];
				}
				if (i < N / 2) {
					k--;
				} else {
					k++;
				}
			}

			System.out.println("#" + test_case + " " + sum);

		}
	}
}
