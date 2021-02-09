package day6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_D3_햄버거다이어트 {
	static int N;
	static int L;
	static int[] tastes;
	static int[] kalories;
	static boolean[] isSelected;
	static int max = 0;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src\\day6\\SWEA5215.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");

			N = Integer.parseInt(st.nextToken()); // 재료 수
			L = Integer.parseInt(st.nextToken()); // 칼로리

			tastes = new int[N];
			kalories = new int[N];
			isSelected = new boolean[N];

			for (int i = 0; i < N; i++) {
				String s2 = br.readLine();
				StringTokenizer st2 = new StringTokenizer(s2, " ");
				tastes[i] = Integer.parseInt(st2.nextToken());
				kalories[i] = Integer.parseInt(st2.nextToken());
			}

			subset(0, 0);

			System.out.println("#" + test_case + " " + max);
			max = 0;
		}
	}

	private static void subset(int cnt, int k) {
		if (cnt == N) {
			int tSum = 0, kSum = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					tSum += tastes[i];
					kSum += kalories[i];
				}
			}
			if (tSum > max) {
				max = tSum;
			}

			return;
		}
		
		if (k + kalories[cnt] <= L) {
			isSelected[cnt] = true;
			subset(cnt + 1, k + kalories[cnt]);			
		}

		isSelected[cnt] = false;
		subset(cnt + 1, k);

	}
}
