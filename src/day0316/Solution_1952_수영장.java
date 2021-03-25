package day0316;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {
	public static void main(String[] args) throws Exception, IOException {
		System.setIn(new FileInputStream("src\\day0316\\SWEA1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int day = Integer.parseInt(st.nextToken());
			int month1 = Integer.parseInt(st.nextToken());
			int month3 = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			int[] plan = new int[13];
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			// 각 달별 최소 비용
			int[] minMonth = new int[13];
			for (int i = 1; i <= 12; i++) {
				minMonth[i] = Math.min(day * plan[i], month1); // 일일vs한달 중 싼거
			}

			// 최소 누적 합
			int[] min = new int[13];
			min[1] = minMonth[1];
			min[2] = min[1] + minMonth[2];

			// 3달 계산
			for (int i = 3; i <= 12; i++) {
				min[i] = Math.min(min[i - 1] + minMonth[i], min[i - 3] + month3); // 전달까지 최소비용+이번달 비용 vs 3달전까지 최소비용+3달
			}

			int answer = Math.min(min[12], year);
			System.out.println("#" + testCase + " " + answer);
		}

	}
}
