package day0419;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8382_방향전환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src\\day0419\\swea8382.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x = Math.abs(x1 - x2);
			int y = Math.abs(y1 - y2);

			int b = (x > y ? x : y);
			int s = (x < y ? x : y);

			System.out.println("#" + tc + " " + ((b * 2) + ((b - s) % 2 == 0 ? 0 : -1)));
		}

	}
}
