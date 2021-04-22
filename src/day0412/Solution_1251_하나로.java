package day0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {
	private static int N;
	private static long[][] adjMatrix;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(in.readLine());

			// 각 섬의 x좌표
			int x[] = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < x.length; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}

			// 각 섬의 x좌표
			int y[] = new int[N];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < x.length; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}

			// 인접행렬 구성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j] = adjMatrix[i][j] = getDistance(x[i], x[j], y[i], y[j]);
				}
			}
			double E = Double.parseDouble(in.readLine());
			System.out.println("#" + t + " " + Math.round(makeMST() * E));

		}
	}

	private static long makeMST() {
		long[] minEdge = new long[N];
		boolean[] visited = new boolean[N];

		// 무한으로 출발
		Arrays.fill(minEdge, Long.MAX_VALUE);

		// 임의의 정점을 시작점으로 만듦
		minEdge[0] = 0;

		long result = 0; // 최소신장트리 비용
		int cnt = 0; // 정점 개수 카운트

		while (true) {
			// 신장트리에 포함되지 않은 정점 중 최소 간선 비용의 정점 선택
			long min = Long.MAX_VALUE;
			int minNo = 0;
			for (int i = 0; i < N; i++) {
				if (!visited[i] && min > minEdge[i]) { // 신장트리에 포함 X, 그 정점으로의 간선 비용이 최소값보다 작으면
					minNo = i;
					min = minEdge[i];
				}
			}

			// 신장트리에 포함
			visited[minNo] = true;
			result += min;

			if (++cnt == N)
				break; // 정점 다 뽑으면 끝

			// 나머지 정점들의 최소 거리 갱신 (minNo~정점 까지 거리가 더 작으면 갱신)
			for (int i = 0; i < N; i++) {
				if (!visited[i] && minEdge[i] > adjMatrix[minNo][i]) {
					minEdge[i] = adjMatrix[minNo][i];
				}
			}

		}

		return result;
	}

	static long getDistance(int x1, int x2, int y1, int y2) {
		return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}
