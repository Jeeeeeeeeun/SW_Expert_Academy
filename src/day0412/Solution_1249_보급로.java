package day0412;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1249_보급로 {

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src\\day0412\\SWEA1249.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine()); // 지도 크기

			// 지도 정보
			int[][] map = new int[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}

			}

			boolean[][] visited = new boolean[N][N];
			visited[0][0] = true;
			min = Integer.MAX_VALUE;

			System.out.println("#" + tc + " " + dfs(N, map, visited));

		}
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static class Road {
		int x, y;

		public Road(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	private static int dfs(int N, int[][] map, boolean[][] visited) {
		Stack<Road> stack = new Stack<>();

		int[][] answer = new int[N][N];

		stack.push(new Road(0, 0));
		visited[0][0] = true;
		answer[0][0] = 0;

		while (!stack.isEmpty()) {
			Road curr = stack.pop();

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				if (!visited[nx][ny] || answer[nx][ny] > answer[curr.x][curr.y] + map[nx][ny]) {
					stack.push(new Road(nx, ny));
					visited[nx][ny] = true;
					answer[nx][ny] = answer[curr.x][curr.y] + map[nx][ny];
				}
			}
		}

		return answer[N - 1][N - 1];
	}

}
