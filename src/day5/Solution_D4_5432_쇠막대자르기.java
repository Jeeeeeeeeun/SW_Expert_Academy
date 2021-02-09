package day5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_5432_쇠막대자르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("src\\day5\\SWEA5432.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<>();

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			String s = br.readLine();
			st.push('(');
			int cnt = 0;
			
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					st.push(s.charAt(i));
				} else if (s.charAt(i) == ')') {
					st.pop();
					if (s.charAt(i - 1) == '(') // 레이저
						cnt += st.size();
					else if (s.charAt(i - 1) == ')') // 막대
						cnt += 1;
				}
			}

			System.out.println("#" + test + " " + cnt);
		}

	}
}
