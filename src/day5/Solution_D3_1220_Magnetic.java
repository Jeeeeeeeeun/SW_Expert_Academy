package day5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D3_1220_Magnetic {
	static int[][] table;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src\\day5\\SWEA1220.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			table = new int[100][100];

			StringTokenizer st;
			
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for (int j = 0; j < 100; j++) {
				boolean red = false;
				for (int i = 0; i < 100; i++) {

					if (table[i][j] == 1) { // 빨
						red = true;
					} else if (table[i][j] == 2) { // 파
						if (red == true) {
							cnt++;
							red = false;
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + cnt);
		}

	}
}
