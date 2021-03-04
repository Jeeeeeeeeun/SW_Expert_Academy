package day0218;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D5_1247_최적경로 {
	static int[] office, home;
	static int[][] customer;
	static int N;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src\\day0218\\SWEA1247.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();

			office = new int[] { sc.nextInt(), sc.nextInt() };
			home = new int[] { sc.nextInt(), sc.nextInt() };

			customer = new int[N][];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				customer[i] = new int[] { sc.nextInt(), sc.nextInt() };
			}

			dfs(0, office[0], office[1], 0);

			System.out.println("#" + test_case + " " + min);

			min = Integer.MAX_VALUE;
		}
	}

	private static void dfs(int cnt, int x, int y, int sum) {
		if (min < sum) {
			return;
		}

		if (cnt == N) {
			int dist = Math.abs(x - home[0]) + Math.abs(y - home[1]);
			sum += dist;
			if (min > sum) {
				min = sum;
			}
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;

				int dist = Math.abs(x - customer[i][0]) + Math.abs(y - customer[i][1]);
				dfs(cnt + 1, customer[i][0], customer[i][1], sum + dist);
				visited[i] = false;
			}
		}
	}
}
