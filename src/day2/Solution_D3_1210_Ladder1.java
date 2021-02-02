package day2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1210_Ladder1 {
	// 좌, 우, 상
//	static int[] dx = { 0, 0, -1 };
//	static int[] dy = { -1, 1, 0 };

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src\\day2\\input (1).txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		int[] dx = { 0, 0, -1 };
		int[] dy = { -1, 1, 0 };

		
		for (int test_case = 1; test_case <= T; test_case++) {
			int testNum = sc.nextInt();

			// map 완성
			int[][] map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 도착지점
			int currX = 99;
			int currY = 0; // 도착
			for (int i = 0; i < 100; i++) {
				if (map[99][i] == 2)
					currY = i;
				break;
			}

			while (true) {
				if (currX < 0 || currY < 0 || currX > 99 || currY > 99)
					break;

				// 좌

				if (currY != 0 && map[currX + dx[0]][currY + dy[0]] == 1) {
					while (currY!=0 && map[currX + dx[0]][currY + dy[0]] == 1) {
						currX += dx[0];
						currY += dy[0];
					}
					currX--;
					continue;
				}

				// 우
				if (currY != 99 && map[currX + dx[1]][currY + dy[1]] == 1) {
					while (currY!=99 && map[currX + dx[1]][currY + dy[1]] == 1) {
						currX += dx[1];
						currY += dy[1];
					}
					currX--;
					continue;
				}

				// 위
				currX--;
			}

			System.out.println("#" + test_case +" " +currY);
		}
	}
}
