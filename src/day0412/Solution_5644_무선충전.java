package day0412;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	static class BC {
		int x, y;
		int c, p;

		public BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("src\\day0412\\SWEA5644.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken()); // 총 이동 시간
			int A = Integer.parseInt(st.nextToken()); // BC 개수

			// 이동정보 입력
			int[] aMove = new int[M];
			int[] bMove = new int[M];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < aMove.length; i++) {
				aMove[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < aMove.length; i++) {
				bMove[i] = Integer.parseInt(st.nextToken());
			}

			// BC정보 입력
			BC[] bcs = new BC[A];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());

				bcs[i] = new BC(x, y, c, p);
			}

			// BC 영역 표시
			int map[][][] = new int[11][11][A];
			for (int i = 0; i < A; i++) {
				BC curr = bcs[i];

				for (int j = curr.x - curr.c; j <= curr.x + curr.c; j++) {
					for (int j2 = curr.y - curr.c; j2 <= curr.y + curr.c; j2++) {

						if (j < 1 || j2 < 1 || j > 10 || j2 > 10)
							continue;

						int distX = Math.abs(curr.x - j);
						int distY = Math.abs(curr.y - j2);

						if (distX + distY <= curr.c) {
							map[j][j2][i] = 1;
						}
					}
				}

			}

			// 이동 0, 1, 2, 3, 4
			int[] dx = { 0, 0, 1, 0, -1 };
			int[] dy = { 0, -1, 0, 1, 0 };

			// 초기 값
			int ax = 1;
			int ay = 1;
			int bx = 10;
			int by = 10;

			// 총 합
			int totalSum = 0;

			// 각 초마다 반복
			for (int i = -1; i < M; i++) {
				if (i != -1) {
					int ma = aMove[i];
					int mb = bMove[i];
					ax += dx[ma];
					ay += dy[ma];
					bx += dx[mb];
					by += dy[mb];
				}

				// 현재위치의 bc들
				int[] currA = map[ax][ay];
				int[] currB = map[bx][by];

				int max = 0;
				for (int a = 0; a < currA.length; a++) {
					for (int b = 0; b < currB.length; b++) {
						int sum = 0;

						if (currA[a] == 1)
							sum += bcs[a].p;
						if (currB[b] == 1)
							sum += bcs[b].p;

						//	 같으면 절반
						if (currA[a] == 1 && currB[b] == 1 && a == b)
							sum -= bcs[a].p;

						if (sum > max)
							max = sum;
					}
				}

				totalSum += max;
			}

			System.out.println("#" + testCase + " " + totalSum);
		}

	}
}
