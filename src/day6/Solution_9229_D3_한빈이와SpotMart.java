package day6;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_9229_D3_한빈이와SpotMart {
	static int[] snacks;
	static int N, M; // 무게 합
	static int max = -1;
	static int[] pick = new int[2];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\day6\\SWEA9229.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test = 1; test <= T; test++) {
			N = sc.nextInt(); // 봉지 개수
			M = sc.nextInt(); // 무게 합

			snacks = new int[N];
			for (int i = 0; i < N; i++) {
				snacks[i] = sc.nextInt();
			}

			combination(0, 0);
			System.out.println("#" + test + " " + max);
			max = -1;

		}
	}

	private static void combination(int cnt, int start) {
		if (cnt == 2) {
			int weight = 0;
			for (int i = 0; i < 2; i++) {
				weight += pick[i];
			}

			if (weight > M)
				return;

			if (max < weight)
				max = weight;
			return;
		}

		for (int i = start; i < N; i++) {
			pick[cnt] = snacks[i];
			combination(cnt + 1, i + 1);
		}
	}
}
