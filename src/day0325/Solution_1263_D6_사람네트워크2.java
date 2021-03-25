package day0325;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_D6_사람네트워크2 {
	static int N, network[][];
	static final int INF = 9999999;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src\\day0325\\SWEA1263.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			network = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					network[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && network[i][j] == 0) {
						network[i][j] = INF;
					}

				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k)
						continue;

					for (int j = 0; j < N; j++) {
						if (j == k || j == i)
							continue;

						if (network[i][j] > network[i][k] + network[k][j]) {
							network[i][j] = network[i][k] + network[k][j];
						}

					}
				}
			}

			int[] CC = new int[N];
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					CC[i] += network[i][j];
				}

				if (CC[i] < min) {
					min = CC[i];
				}
			}

			System.out.println("#" + test_case + " " + min);
		}
	}

}
