package day6;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Test {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src\\day6\\SWEA1860.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int N, M, K;
		int[] people;
		boolean isPossible;

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			people = new int[N];

			for (int i = 0; i < N; i++)
				people[i] = sc.nextInt();

			Arrays.sort(people);

			// System.out.println(Arrays.toString(people));

			isPossible = true;
			for (int i = 0; i < N; i++) {
				if ((people[i] / M * K) < i + 1) {
					isPossible = false;
					break;
				}
			}

			// 출력
			System.out.println("#" + tc + " " + (isPossible == true ? "Possible" : "Impossible"));
		}
	}
}