package day0210;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1274_D2_스도쿠검증 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\day0210\\SWEA1274.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int[][] puzzle = new int[9][9];

			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 9; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[] isSelected = new boolean[10];
			boolean result = true;

			// 가로
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (!isSelected[puzzle[i][j]]) {
						isSelected[puzzle[i][j]] = true;
					} else { // 중복
						result = false;
						break;
					}
				}

				if (!result) {
					break;
				}

				for (int j = 0; j < 10; j++) {
					isSelected[j] = false;
				}
			}

			if (!result) {
				System.out.println("#" + t + " " + "0");
				continue;
			}

			// 세로
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (!isSelected[puzzle[j][i]]) {
						isSelected[puzzle[j][i]] = true;
					} else { // 중복
						result = false;
						break;
					}
				}

				if (!result) {
					break;
				}

				for (int j = 0; j < 10; j++) {
					isSelected[j] = false;
				}
			}

			if (!result) {
				System.out.println("#" + t + " " + "0");
				continue;
			}

			// 3x3
			for (int i = 0; i < 9; i = i + 3) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
//						System.out.println("x y" + (j+i) + (k+i));
						if (!isSelected[puzzle[j + i][k + i]]) {
							isSelected[puzzle[j + i][k + i]] = true;
						} else {
							result = false;
						}
					}
					if (!result)
						break;
				}
				if (!result)
					break;
				for (int j = 0; j < 10; j++) {
					isSelected[j] = false;
				}
			}

			if (!result) {
				System.out.println("#" + t + " " + "0");
				continue;
			}

			System.out.println("#" + t + " " + "1");

		}
	}
}
