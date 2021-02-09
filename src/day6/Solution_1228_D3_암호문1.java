package day6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_D3_암호문1 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\day6\\SWEA1228.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N;
		String tmp;
		int testCase = 1;
		while ((tmp = br.readLine()) != null) {
			LinkedList<String> list = new LinkedList<>();
			N = Integer.parseInt(tmp);
			String original = br.readLine();
			StringTokenizer st = new StringTokenizer(original, " ");

			for (int i = 0; i < N; i++) {
				list.addLast(st.nextToken());
			}

			int orderCnt = Integer.parseInt(br.readLine());
			String orders = br.readLine();
			StringTokenizer st2 = new StringTokenizer(orders, "I");

			for (int i = 0; i < orderCnt; i++) {
				String order = st2.nextToken();
				StringTokenizer st3 = new StringTokenizer(order, " ");

				int x = Integer.parseInt(st3.nextToken());
				int y = Integer.parseInt(st3.nextToken());


				for (int j = 0; j < y; j++) {
					list.add(x + j, st3.nextToken());
				}
			}

			System.out.print("#" + testCase + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println("");

			testCase++;
		}

	}
}
