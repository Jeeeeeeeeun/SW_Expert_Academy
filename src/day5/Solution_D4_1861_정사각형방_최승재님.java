package day5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_최승재님 {
	static int n;
	static int[][] dp;
	static int[][] input;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { 1, -1, 0, 0 };

	static int dfs(int y, int x) {
		if (dp[y][x] != 0)
			return dp[y][x];
		int result = 1; // result = 현재 길이 , 시작하면 길이는 1이니 1로 초기화
		for (int i = 0; i < 4; i++) {
			int ny, nx;
			ny = y + dy[i];
			nx = x + dx[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && input[y][x] + 1 == input[ny][nx]) { // 4방향 탐색
				result = Math.max(result, dfs(ny, nx) + 1); // 조건문이 true라면 길이를 1 늘려야하니 때문에 dfs(ny,nx)+1 // result값을 늘리지
															// 않는건 여러 방향으로 갈수 있기 때문에 각각의 루트에서 길이를 탐색해야한다.
			}
		}
		dp[y][x] = result;
		return result;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\day5\\SWEA1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			dp = new int[n][n];
			input = new int[n][n];
			for (int i = 0; i < n; i++) { // 입력받기
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int resultPos = 0; // 결과 : 시작 값
			int resultValue = 0; // 결과 : 최대 길이
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int temp = dfs(i, j);
					if (temp > resultValue) {
						resultPos = input[i][j];
						resultValue = temp;
					} else if (temp == resultValue && resultPos > input[i][j]) { // 최대 길이가 같을 때 시작값이 제일 작은 값 찾는 코드
						resultPos = input[i][j];
					}
				}

			}
			System.out.println("#" + t + " " + resultPos + " " + resultValue);
		}
	}
}
