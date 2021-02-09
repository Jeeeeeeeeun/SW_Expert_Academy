package day4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1959_D2_두개의숫자열 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src\\day4\\SWEA1959.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int N, M, b, s;
		int[] arrN, arrM, big, small;
		for (int test_case = 1; test_case <= T; test_case++) {
			int max = 0;
			N = sc.nextInt();
			M = sc.nextInt();

			arrN = new int[N];
			arrM = new int[M];

			for (int i = 0; i < N; i++) {
				arrN[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				arrM[i] = sc.nextInt();
			}

			if (N > M) {
				big = arrN; b = N;
				small = arrM; s = M;
			} else {
				big = arrM; b = M;
				small = arrN; s = N;
			}

			for (int i = 0; i < b - s + 1; i++) {
				int sum = 0;
				for (int j = 0; j < s; j++) {
					sum += (small[j] * big[i + j]);
				}
				if (sum > max) {
					max = sum;
				}

			}

			System.out.println("#" + test_case + " " + max);

		}
	}
}
