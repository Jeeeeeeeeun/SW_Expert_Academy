package day0215;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_6808_규영이와인영이의카드게임 {
	static int N = 9;
	static int[] kyu;
	static int[] in;
	static int[] input;
	static boolean[] isSelected, card;

	static int kyWin = 0, iyWin = 0;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src\\day0215\\SWEA6808.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			kyu = new int[9];
			input = new int[9];
			card = new boolean[19];

			for (int i = 0; i < 9; i++) {
				kyu[i] = sc.nextInt();
				card[kyu[i]] = true;
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!card[i]) {
					input[idx++] = i;
				}
			}

			in = new int[9];
			isSelected = new boolean[9];
			permutation(0);

			System.out.println("#" + test_case + " " + kyWin + " " + iyWin);

			kyWin = 0;
			iyWin = 0;
		}

		//
	}

	private static void permutation(int cnt) {
		if (cnt == 9) {
			int ky = 0, iy = 0;

			for (int i = 0; i < 9; i++) {
				if (kyu[i] < in[i]) {
					iy += kyu[i] + in[i];
				} else {
					ky += kyu[i] + in[i];
				}
			}

			if (ky > iy)
				kyWin++;
			else
				iyWin++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isSelected[i])
				continue;

			in[cnt] = input[i];
			isSelected[i] = true;

			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}
