package day0225;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859_백만장자프로젝트 {
	static int[] price;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src\\day0225\\SWEA1859.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			price = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			long profit = 0;

			int start = 0;

			while (true) {
				if (start >= N)
					break;

				int maxIdx = findMax(start, N - 1);

				if (maxIdx == start || maxIdx == -1) {
					start = maxIdx + 1;
					continue;
				}

				for (int i = start; i < maxIdx; i++) {
					if (price[maxIdx] > price[i]) {
						profit += price[maxIdx] - price[i];
					}
				}

				start = maxIdx + 1;
			}

			System.out.println("#" + test_case + " " + profit);

		}
	}

	private static int findMax(int start, int end) {
		int maxIdx = -1;
		int max = 0;

		for (int i = start; i <= end; i++) {
			if (price[i] > max) {
				maxIdx = i;
				max = price[i];
			}
		}

		return maxIdx;
	}
}
