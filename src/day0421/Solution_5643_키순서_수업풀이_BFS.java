package day0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서_수업풀이_BFS {
	static boolean[][] adjM;
	static int N;

	static int gtCnt, ltCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine()); // 학생 수
			adjM = new boolean[N + 1][N + 1];

			int M = Integer.parseInt(br.readLine());
			StringTokenizer st;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				adjM[s][b] = true;
			}

			int ans = 0;
			for (int k = 1; k <= N; k++) {
				gtCnt = ltCnt = 0;
				gtBFS(k, new boolean[N + 1]);
				ltBFS(k, new boolean[N + 1]);

				if (gtCnt + ltCnt == N - 1)
					++ans;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void gtBFS(int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int k = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (adjM[i][k] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					gtCnt++;
				}
			}
		}
	}

	private static void ltBFS(int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int k = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (adjM[k][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					ltCnt++;
				}
			}
		}
	}

}
