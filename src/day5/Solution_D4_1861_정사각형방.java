package day5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방 {
	static int[][] map;
	static int N;
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int cnt = 1;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src\\day5\\SWEA1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= 1; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			int count = 0;
			int start = 0;

			// 행렬 완성
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}

			System.out.println(Arrays.deepToString(map));

			int max = 1;
			int maxRoomNo = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					findRoom(i, j);

					if (cnt > max) {
						max = cnt;
					}
					cnt = 1;
				}
			}

			System.out.println("#" + test_case + " " + max);
			cnt = 1;
		}
	}

	private static void findRoom(int x, int y) {
		int nx, ny;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;

			if (map[nx][ny] == map[x][y] + 1) {
				cnt++;
				findRoom(nx, ny);
			}
		}
	}
}
