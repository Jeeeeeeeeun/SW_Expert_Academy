package day2;

import java.util.Scanner;

public class Solution_D4_1210_Ladder1_Answer {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] ladder = new int[100][100];
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			int r = 0, c = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
					if (i == 99 && ladder[i][j] == 2) {
						r = i;
						c = j;
					}
				}
			}
			while (true) {
				r--;
				// System.out.println(r + "," + c);
				if (r == 0)
					break;
				int left = c - 1;
				int right = c + 1;
				if (left >= 0 && ladder[r][left] == 1) {
					while (true) {
						if (c - 1 >= 0 && ladder[r][c - 1] == 1) {
							c--;
						} else
							break;
					}
					continue;
				} else if (right < 100 && ladder[r][right] == 1) {
					while (true) {
						if (c + 1 < 100 && ladder[r][c + 1] == 1) {
							c++;
						} else
							break;
					}
					continue;
				}
			}
			System.out.println("#" + tc + " " + c);
		}
		sc.close();
	}
}
