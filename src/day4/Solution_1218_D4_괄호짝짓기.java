package day4;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

class Solution_1218_D4_괄호짝짓기 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src\\day4\\SWEA1218.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		Stack<Character> stack;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			String s = sc.next();
			stack = new Stack<>();
			
			for (int i = 0; i < N; i++) {
				if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '<') {
					stack.push(s.charAt(i));
				} else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == '>') {
					char pop = stack.pop();
					if ((s.charAt(i) == ')' && pop == '(') 
							|| (s.charAt(i) == '}' && pop == '{')
							|| (s.charAt(i) == ']' && pop == '[') 
							|| (s.charAt(i) == '>' && pop == '<')) {
						continue;
					} else {
						break;
					}
				}
			}

			int answer;
			if (stack.size() == 0)
				answer = 1;
			else
				answer = 0;

			System.out.println("#" + test_case + " " + answer);

		}
	}
}