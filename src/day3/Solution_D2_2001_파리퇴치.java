package day3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D2_2001_파리퇴치 {
	static int N;
	static int M;
	static int[][] map;

	static int max = 0;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src\\day3\\2001_파리퇴치.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();

			map = new int[N][N];

			// map 넣기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum=0;
					
					for (int k=0; k<M; k++) {
						for(int l=0; l<M; l++) {
							sum+=map[i+k][j+l];
						}
					}

					if (sum > max)
						max = sum;
				}
			}

			System.out.println("#" + test_case + " " + max);

			max = 0;
		}
	}
}
