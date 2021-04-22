package day0413;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {

	static int N, X;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src\\day0413\\swea4014.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			// 값 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			int map[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			// 가로 판단
			for (int i = 0; i < N; i++) {
				int[] curr = new int[N];
				for (int j = 0; j < N; j++) {
					curr[j] = map[i][j];
				}
				boolean isPossible = solve(curr);
				if (isPossible) {
					cnt++;
				}
			}

			// 세로 판단
			for (int i = 0; i < N; i++) {
				int[] curr = new int[N];
				for (int j = 0; j < N; j++) {
					curr[j] = map[j][i];
				}
				boolean isPossible = solve(curr);
				if (isPossible) {
					cnt++;
				}
			}

			System.out.println("#" + tc + " " + cnt);
		}

	}

	private static boolean solve(int[] curr) {
		boolean isPossible = true;
		boolean visited[] = new boolean[N];
		for (int j = 1; j < N; j++) {
			if (curr[j - 1] == curr[j])
				continue; // 앞에것과 높이가 같으면
			if (Math.abs(curr[j - 1] - curr[j]) >= 2) {
				isPossible = false;
				break; // 앞에것과 높이가 2 이상 차이나면 X
			}

			// 하나 높아진 경우
			if (curr[j - 1] + 1 == curr[j]) {
				// 놓을 수 있는지 여부
				for (int j2 = 1; j2 <= X; j2++) {
					if (j - j2 < 0) {
						isPossible = false;
						break;
					}
					if (curr[j - j2] != curr[j - 1] || visited[j - j2]) {
						isPossible = false;
						break;
					}
				}

				if (!isPossible)
					break;

				for (int i = j - X; i < j; i++) {
					visited[i] = true;
				}
			}

			// 하나 낮아진 경우
			else if (curr[j - 1] - 1 == curr[j]) {

				// 놓을 수 있는지 여부
				for (int j2 = 1; j2 < X; j2++) {
					if (j + j2 >= N) {
						isPossible = false;
						break;
					}
					if (curr[j + j2] != curr[j] || visited[j + j2]) {
						isPossible = false;
						break;
					}
				}

				if (!isPossible)
					break;

				// 경사로 놓음 표시
				for (int i = j; i < j + X; i++) {
					visited[i] = true;
				}
				j += X - 1;
			}

		}

		return isPossible;

	}

}
