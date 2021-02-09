package day5;

import java.util.Scanner;

public class Solution_D4_1861_정사각형방_Answer {

	static int[][] map;
	static int N;
	// 각 좌표에서의 이동 카운트
	static int cnt = 1;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static String data = "2\n" + "2\n" + "1 2\n" + "3 4\n" + "3\n" + "9 3 4\n" + "6 1 5\n" + "7 8 2";

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 최대 이동 카운트가 동일한 여러개의 좌표가 있을때 가장 번호가 작은 방의 번호
			int maxMoveCnt = 1;
			int maxRoomNo = 987654321;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					solve(i, j);

					if (cnt > maxMoveCnt) {
						maxMoveCnt = cnt;
						maxRoomNo = map[i][j];
					} else if (cnt == maxMoveCnt && map[i][j] < maxRoomNo) {
						maxRoomNo = map[i][j];
					}
					cnt = 1;
				}
			}
			System.out.println("#" + t + " " + maxRoomNo + " " + maxMoveCnt);
		}

		sc.close();
	}

	private static void solve(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (ny >= 0 && nx >= 0 && ny < N && nx < N && map[nx][ny] == map[x][y] + 1) {
				cnt++;
				solve(nx, ny);
			}
		}
	}
}
