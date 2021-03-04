package day0302;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_11545_D4_틱택톰 {
	static char[][] map = new char[4][4];;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\day0302\\SWEA11545.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			// map 완성
			for (int i = 0; i < 4; i++) {
				String s = br.readLine();
				for (int j = 0; j < 4; j++) {
					map[i][j] = s.charAt(j);
				}
			}

			int res = isBingo();
			switch (res) {
			case 1:
				System.out.println("#" + test_case + " X won");
				break;
			case 2:
				System.out.println("#" + test_case + " O won");
				break;
			case 3:
				System.out.println("#" + test_case + " Draw");
				break;
			case 4:
				System.out.println("#" + test_case + " Game has not completed");
				break;
			}
			br.readLine();
		}
	}

	// 1:X, 2:O, 3:Draw, 4:notComplemeted
	private static int isBingo() {
		// 가로
		for (int i = 0; i < 4; i++) {
			boolean bingo = true;
			char c = map[i][0];
			if (c == 'T') c = map[i][1];
			if (c == '.') continue;
			for (int j = 1; j < 4; j++) {
				if (c == map[i][j] || map[i][j] == 'T') continue;
				else bingo = false;
			}
			if (bingo) return c == 'X' ? 1 : 2;
		}

		// 세로
		for (int i = 0; i < 4; i++) {
			boolean bingo = true;
			char c = map[0][i];
			if (c == 'T') c = map[1][i];
			if (c == '.') continue;
			for (int j = 1; j < 4; j++) {
				if (c == map[j][i] || map[j][i] == 'T') continue;
				else bingo = false;
			}
			if (bingo) return c == 'X' ? 1 : 2;
		}

		// 대각선1
		boolean bingo = true;
		char c = map[0][0];
		if (c == 'T') c = map[1][1];
		if (c != '.') {
			for (int i = 1; i < 4; i++) {
				if (c == map[i][i] || map[i][i] == 'T') continue;
				else bingo = false;
			}
			if (bingo) return c == 'X' ? 1 : 2;
		}

		// 대각선2
		bingo = true;
		c = map[0][3];
		if (c == 'T') c = map[1][2];
		if (c != '.') {
			for (int i = 1; i < 4; i++) {
				if (c == map[i][3 - i] || map[i][3 - i] == 'T') continue;
				else bingo = false;
			}
			if (bingo) return c == 'X' ? 1 : 2;
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == '.') { // 게임 안 끝난 경우
					return 4;
				}
			}
		}
		return 3; // 비긴 경우 
	}
}
