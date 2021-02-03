package day2;

import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자_Answer_Pattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int snail[][] = new int[N][N];

			int cnt = 0, change = 1, x = 0, y = -1, k = N;

			while (true) {
				for (int j = 1; j <= k; j++) {
					y += change;
					snail[x][y] = ++cnt;
				}
				k--;
				if (k == 0)
					break;

				for (int j = 1; j <= k; j++) {
					x += change;
					snail[x][y] = ++cnt;
				}
				change *= -1;
			}

			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();

	}
}
