package day0415;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	static class Loc {
		int x, y;
		int shape;
		int time;

		public Loc(int x, int y, int shape, int time) {
			this.x = x;
			this.y = y;
			this.shape = shape;
			this.time = time;
		}
	}

	static int[][] map;
	static int N, M, L;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\day0415\\swea1953.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 터널 지도 세로
			M = Integer.parseInt(st.nextToken()); // 터널 지도 가로
			int R = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 세로
			int C = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 가로
			L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간

			// 지도 정보
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = bfs(R, C);

			System.out.println("#" + tc + " " + answer);
		}
	}

	// 위, 오른쪽, 아래, 왼쪽
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static boolean isConnected(int dir, int shape) { // 방향 & 모양
		boolean flag = false;

		switch (dir) {
		case 0: // 상
			if (shape == 1 || shape == 2 || shape == 5 || shape == 6)
				flag = true;
			break;

		case 1: // 우
			if (shape == 1 || shape == 3 || shape == 6 || shape == 7)
				flag = true;
			break;

		case 2: // 하
			if (shape == 1 || shape == 2 || shape == 4 || shape == 7)
				flag = true;
			break;

		case 3: // 좌
			if (shape == 1 || shape == 3 || shape == 4 || shape == 5)
				flag = true;
			break;
		}

		return flag;
	}

	private static void visit(Loc curr, int dir, boolean[][] visited, Queue<Loc> queue) {
		int x = curr.x + dx[dir];
		int y = curr.y + dy[dir];

		// 범위 밖
		if (x < 0 || y < 0 || x >= N || y >= M)
			return;

		// 이어지는 모양 X
		if (!isConnected(dir, map[x][y]))
			return;

		if (!visited[x][y] && map[x][y] != 0) { // 방문X, 길 존재
			queue.add(new Loc(x, y, map[x][y], curr.time + 1));
			visited[x][y] = true;
		}
	}

	private static int bfs(int r, int c) {
		int cnt = 0;

		Queue<Loc> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		queue.add(new Loc(r, c, map[r][c], 1)); // x, y, shape, time
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			Loc curr = queue.poll();

			if (curr.time >= L)
				break;

			switch (curr.shape) {
			case 1: // 십자가 : 사방
				for (int i = 0; i < 4; i++) {
					visit(curr, i, visited, queue);
				}
				break;

			case 2: // 상하
				for (int i = 0; i <= 2; i += 2) {
					visit(curr, i, visited, queue);
				}
				break;

			case 3: // 좌우
				for (int i = 1; i <= 3; i += 2) {
					visit(curr, i, visited, queue);
				}
				break;

			case 4: // 상 우
				for (int i = 0; i < 2; i++) {
					visit(curr, i, visited, queue);
				}
				break;

			case 5: // 우 하
				for (int i = 1; i <= 2; i++) {
					visit(curr, i, visited, queue);
				}
				break;

			case 6:
				// 하 좌
				for (int i = 2; i <= 3; i++) {
					visit(curr, i, visited, queue);
				}
				break;

			case 7: // 상 좌
				for (int i = 0; i < 4; i += 3) {
					visit(curr, i, visited, queue);
				}
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					cnt++;
			}
		}

		return cnt;
	}
}
