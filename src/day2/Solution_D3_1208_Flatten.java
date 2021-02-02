package day2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution_D3_1208_Flatten {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src\\day2\\input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int dump = sc.nextInt();
			int[] box = new int[100];
			int result = 0;

			// 배열 만들기
			for (int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
			}

			for (int i = 0; i < dump; i++) {
				Arrays.sort(box);
				result = box[99] - box[0];
				box[99]--;
				box[0]++;
			}

			System.out.println("#" + test_case + " " + result);

		}
	}
}