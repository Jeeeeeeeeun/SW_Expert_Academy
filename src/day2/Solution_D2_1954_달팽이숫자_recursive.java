package day2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자_recursive {
	// 우 하 좌 상
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int dir = 0;
	static int x = 0, y = 0;

	static int N;
	static int[][] map;
	static int cnt;

	public static void main(String[] args) {

//		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new int[N][N];

			// 첫줄 N개
			for (int i = 0; i < N; i++) {
				map[0][i] = i + 1;
			}

			x = 0;
			y = N - 1;
			cnt = N + 1;
			dir = 0;

			snail_recur(N - 1);

			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println("");
			}
		}
	}

	private static void snail_recur(int n) {
		if (n < 1)
			return;

		for (int i = 0; i < 2; i++) {
			dir = (dir + 1) % 4;// 방향전환

			for (int j = 0; j < n; j++) {
				x += dx[dir];
				y += dy[dir];
				map[x][y] = cnt++;
			}
		}

		snail_recur(n - 1);

	}
}
