package day2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {
	public static void main(String args[]) throws Exception {

//		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		// 우 하 좌 상
		int dx[] = { 0, 1, 0, -1 };
		int dy[] = { 1, 0, -1, 0 };

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			int[][] map = new int[N][N];
			boolean[][] visited = new boolean[N][N];

			int x = 0;
			int y = 0;
			int dir = 0;

			for (int i = 0; i < N * N; i++) {
				map[x][y] = i + 1;
				visited[x][y] = true;
				x += dx[dir];
				y += dy[dir];

				if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y]) {
					x -= dx[dir];
					y -= dy[dir];

					dir = (++dir) % 4; // 방향전환
					x += dx[dir];
					y += dy[dir];
				}
			}
			
			System.out.println("#" + test_case);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println("");
			}

		}
	}
}
