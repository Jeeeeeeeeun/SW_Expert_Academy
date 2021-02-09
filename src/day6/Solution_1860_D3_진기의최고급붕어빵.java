package day6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1860_D3_진기의최고급붕어빵 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\day6\\SWEA1860.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken()); // N명 손님
			int M = Integer.parseInt(st.nextToken()); // 붕어빵 M초동안
			int K = Integer.parseInt(st.nextToken()); // K개

			int[] customers = new int[N];

			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				customers[i] = Integer.parseInt(st2.nextToken());
			}

			Arrays.sort(customers);
			boolean isSuccess = true;

			int custIdx = 0;
			int time = 0;
			int bunguh = 0;
			while (custIdx < N) {
				while (custIdx < N && customers[custIdx] < time + M) {
					if (bunguh <= 0) {
						isSuccess = false;
						break;
					} else {
						bunguh--;
						custIdx++;
					}
				}

				if (isSuccess == false)
					break;

				time += M;
				bunguh += K;
			}

			System.out.println("#" + test + " " + (isSuccess ? "Possible" : "Impossible"));

		}
	}
}
