package day0209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_D4_사칙연산유효성검사 {
	static int N;
	static String[] nodes;
	static boolean flag = true;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\day0209\\SWEA1223.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int test = 1;
		while (s != null) {
			N = Integer.parseInt(s);
			nodes = new String[N + 1];

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				nodes[i] = st.nextToken();
			}

			dfs(1);

			System.out.println("#" + test + " " + (flag ? "1" : "0"));
			test++;
			flag = true;

			s = br.readLine();
		}
	}

	private static void dfs(int current) {
		if (current >= N || flag == false) {
			return;
		}

		dfs(current * 2);
		dfs(current * 2 + 1);

		if (current * 2 > N) {
			return;
		}

		String left = nodes[current * 2];
		String right = nodes[current * 2 + 1];

		if (!left.equals("*") && !left.equals("/") && !left.equals("+") && !left.equals("-") && !right.equals("*")
				&& !right.equals("/") && !right.equals("+") && !right.equals("-")) {
			if (nodes[current].equals("*") || nodes[current].equals("/") || nodes[current].equals("+")
					|| nodes[current].equals("-")) {
				nodes[current] = "num";
			} else {
				flag = false;
			}
		} else {
			flag = false;
		}
	}
}
