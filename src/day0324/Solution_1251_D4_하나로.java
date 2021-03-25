package day0324;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1251_D4_하나로 {

	static int N; // 섬 개수

	static int[] islandX, islandY;
	static double tax;
	static double[][] adjMatrix;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src\\day0324\\SWEA1251.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			islandX = new int[N];
			islandY = new int[N];
			adjMatrix = new double[N][N];

			for (int i = 0; i < N; i++) {
				islandX[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				islandY[i] = sc.nextInt();
			}

			tax = sc.nextDouble();

			// 인접행렬 완성
			for (int i = 0; i < N; i++) {
				// 시작정점
				int sx = islandX[i];
				int sy = islandY[i];

				for (int j = i + 1; j < N; j++) {
					int ex = islandX[j];
					int ey = islandY[j];

					double len = Math.sqrt(Math.pow(Math.abs(sx - ex), 2) + Math.pow(Math.abs(sy - ey), 2));
					adjMatrix[i][j] = len;
					adjMatrix[j][i] = len;
				}
			}

			double result = 0;
			boolean[] visited = new boolean[N];
			double[] minEdge = new double[N];
			for (int i = 0; i < minEdge.length; i++) {
				minEdge[i] = Integer.MAX_VALUE;
			}
			minEdge[0] = 0; // 0부터 시작

			for (int v = 0; v < N; v++) {
				double min = Double.MAX_VALUE;
				int minVertex = 0;

				// 가장 작은 minEdge 찾기
				for (int i = 0; i < N; i++) {
					if (!visited[i] && minEdge[i] < min) {
						min = minEdge[i];
						minVertex = i;
					}
				}

				// 찾은 결과 방문처리
				result += min * min;
				visited[minVertex] = true;

				// minEdge 값 갱신
				for (int i = 0; i < N; i++) {
					if (!visited[i] && adjMatrix[minVertex][i] != 0 && adjMatrix[minVertex][i] < minEdge[i]) {
						minEdge[i] = adjMatrix[minVertex][i];
					}
				}

			}

			result *= tax;
			System.out.print("#" + test_case + " ");
			System.out.printf("%.0f\n", result);
		}
	}
}
