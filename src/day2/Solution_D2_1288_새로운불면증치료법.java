package day2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D2_1288_새로운불면증치료법 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("src\\\\day2\\\\sample_input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int k = 0; // k번째
			boolean[] numbers = new boolean[10];

			while (true) {
				boolean done = true;
				for (int i = 0; i < 10; i++) {
					if (numbers[i] == false) {
						done = false;
						break;
					}
				}

				if (done)
					break;

				k++;
				int sheep = k * N;

				String stringN = Integer.toString(sheep);

				for (int i = 0; i < stringN.length(); i++) {
					int idx = stringN.charAt(i) - '0';
					numbers[idx] = true;
				}
			}

			System.out.println("#" + test_case + " " + k * N);
		}
	}
}
