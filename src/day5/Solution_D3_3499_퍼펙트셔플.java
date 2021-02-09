package day5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼펙트셔플 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src\\day5\\SWEA3499.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			System.out.print("#" + testCase + " ");

			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();

			int M = N % 2 == 0 ? N / 2 : N / 2 + 1;

			for (int i = 0; i < M; i++) {
				q1.offer(st.nextToken());
			}
			for (int i = 0; i < N / 2; i++) {
				q2.offer(st.nextToken());
			}

			while (!q1.isEmpty()) {
				System.out.print(q1.poll() + " ");

				if (!q2.isEmpty()) {
					System.out.print(q2.poll() + " ");
				}
			}
			System.out.println("");
		}
	}
}
