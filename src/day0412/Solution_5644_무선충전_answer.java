package day0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644_무선충전_answer {
	static int M, bcCnt;
	static int[] pathA, pathB, playerA, playerB;
	static int[][] bc;

	static int dx[] = { 0, 0, 1, 0, -1 };
	static int dy[] = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(in.readLine());

		playerA = new int[2]; // 사용자 A의 위치
		playerB = new int[2]; // 사용자 B의 위치

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			bcCnt = Integer.parseInt(st.nextToken());

			playerA[0] = playerA[1] = 1;
			playerB[0] = playerB[1] = 10;

			pathA = new int[M + 1];
			pathB = new int[M + 1];
			bc = new int[bcCnt][4];

			StringTokenizer stA = new StringTokenizer(in.readLine(), " ");
			StringTokenizer stB = new StringTokenizer(in.readLine(), " ");

			for (int i = 1; i <= M; i++) {
				pathA[i] = Integer.parseInt(stA.nextToken());
				pathB[i] = Integer.parseInt(stA.nextToken());
			}

			for (int i = 0; i < bcCnt; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				bc[i][0] = Integer.parseInt(st.nextToken()); // x
				bc[i][1] = Integer.parseInt(st.nextToken()); // y
				bc[i][2] = Integer.parseInt(st.nextToken()); // 거리
				bc[i][3] = Integer.parseInt(st.nextToken()); // 충전량
			}

			System.out.println("#" + tc + " " + move());

		}
	}

	private static int move() {
		// 매 시간마다 각 위치에서 두 플레이어의 최대 충전량 계싼하여 합산
		int totalSum = 0;

		for (int t = 0; t <= M; t++) {
			// 두 플레이어 이동
			playerA[0] += dx[pathA[t]];
			playerA[0] += dy[pathA[t]];
			playerB[0] += dx[pathB[t]];
			playerB[0] += dy[pathB[t]];

			// 현 위치에서 최대 충전량 계산
			totalSum += getMaxCharge();
		}

		return 0;
	}

	private static int check(int a, int x, int y) {
		return Math.abs(bc[a][0] - x) + Math.abs(bc[a][1] - y) <= bc[a][2] ? bc[a][3] : 0;
	}

	private static int getMaxCharge() {
		int max = 0;

		for (int a = 0; a < bcCnt; a++) { // player a가 선택한 bc
			for (int b = 0; b < bcCnt; b++) {
				int sum = 0;
				int amountA = check(a, playerA[0], playerA[1]);
				int amountB = check(b, playerB[0], playerB[1]);

				if (a != b)
					sum = amountA + amountB;
				else
					sum = Math.max(amountA, amountB);

				if (max < sum)
					max = sum;

			}
		}

		return max;
	}
}
