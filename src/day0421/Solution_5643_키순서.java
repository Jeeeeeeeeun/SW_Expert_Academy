package day0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {
	static boolean[][] adjM;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine()); // 학생 수
			adjM = new boolean[N][N];

			int M = Integer.parseInt(br.readLine());
			StringTokenizer st;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				adjM[s - 1][b - 1] = true;
			}

			int cnt = 0;

			for (int i = 0; i < N; i++) {
				boolean[] visitedB = new boolean[N];
				boolean[] visitedS = new boolean[N];

				bfsBig(i, visitedB);
				bfsSm(i, visitedS);

				int currCnt = 0;
				for (int j = 0; j < visitedS.length; j++) {
					if (visitedB[j] || visitedS[j])
						currCnt++;
				}

				if (currCnt == N)
					cnt++;
			}

			System.out.println("#" + tc + " " + cnt);
		}

	}

	private static void bfsSm(int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int i = 0; i < N; i++) {
				if (adjM[i][curr] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

	private static void bfsBig(int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int i = 0; i < N; i++) {
				if (adjM[curr][i] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
