package day3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1873_상호의배틀필드 {
	static int H, W;
	static char[][] map;

	// 현재 위치
	static int row = 0;
	static int col = 0;
	static int dir = 0; // 현재 방향

	// 상 하 좌 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static char up = '^';
	static char down = 'v';
	static char right = '>';
	static char left = '<';

	static char field = '.';
	static char brick = '*';
	static char steel = '#';
	static char water = '-';

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src\\day3\\1873_상호의배틀_input.txt"));
		Scanner sc = new Scanner(System.in);

//		Scanner sc = new Scanner("1\r\n" + "3 7\r\n" + "***....\r\n" + "*-..#**\r\n" + "#<.****\r\n" + "23\r\n"
//				+ "SURSSSSUSLSRSSSURRDSRDS");
		int T;
		T = sc.nextInt();
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {
			H = sc.nextInt();
			W = sc.nextInt();
			sc.nextLine();

			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == up || map[i][j] == down || map[i][j] == right || map[i][j] == left) {
						// 현재위치
						switch (map[i][j]) {
						case '^':
							dir = 0;
							break;
						case 'v':
							dir = 1;
							break;
						case '<':
							dir = 2;
							break;
						case '>':
							dir = 3;
							break;
						}

						row = i;
						col = j;
					}
				}
			}

			int moveCnt = sc.nextInt();
			sc.nextLine();
			String keys = sc.nextLine();

			for (int m = 0; m < moveCnt; m++) {
				char move = keys.charAt(m);

				switch (move) {
				case 'U':
					map[row][col] = up;
					dir = 0;
					changeLocation();

					break;
				case 'D':
					map[row][col] = down;
					dir = 1;
					changeLocation();
					break;
				case 'L':
					map[row][col] = left;
					dir = 2;
					changeLocation();
					break;
				case 'R':
					map[row][col] = right;
					dir = 3;
					changeLocation();
					break;
				case 'S':
					shoot();
					break;
				}

			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println("");
			}

		}
	}

	private static void changeLocation() {
		if (row + dx[dir] < 0 || col + dy[dir] < 0 || row + dx[dir] >= H || col + dy[dir] >= W) {
			return;
		}

		if (map[row + dx[dir]][col + dy[dir]] == field) {
			map[row + dx[dir]][col + dy[dir]] = map[row][col];
			map[row][col] = field;

			row += dx[dir];
			col += dy[dir];
		}
	}

	private static void shoot() {
		int bulletX = row + dx[dir];
		int bulletY = col + dy[dir];

		while (true) {
			if (bulletX < 0 || bulletY < 0 || bulletX >= H || bulletY >= W)
				break;

			if (map[bulletX][bulletY] == brick) {
				map[bulletX][bulletY] = field;
				break;
			} else if (map[bulletX][bulletY] == steel) {
				break;
			} else if (map[bulletX][bulletY] == field || map[bulletX][bulletY] == water) {
				bulletX += dx[dir];
				bulletY += dy[dir];
				continue;
			}
		}
	}
}
