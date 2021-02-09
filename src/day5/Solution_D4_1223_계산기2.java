package day5;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1223_계산기2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\day5\\SWEA1223.txt"));

		Scanner sc = new Scanner(System.in);

//		Scanner sc = new Scanner("13\r\n" + "9*5/3+7/2/8-4\r\n");

		int testCase = 1;
		
		while (sc.hasNext()) {
			int N = sc.nextInt();
			sc.nextLine();

			String s = sc.nextLine();
			Stack<Character> stack = new Stack<>();

			StringBuffer sb = new StringBuffer(); // 문자열

			// 후위표현식으로
			for (int i = 0; i < s.length(); i++) {
				
				if (s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '/' && s.charAt(i) != '*') { //숫자
					sb.append(s.charAt(i));
				} else { // 연산자
					char curr = s.charAt(i);
					if (!stack.isEmpty()) {

						if ((curr != '*' && curr != '/') || (stack.peek() != '+' && stack.peek() != '-')) {
							while (!stack.isEmpty()) {
								sb.append(stack.pop());
							}
						}
					}
					stack.push(curr);
				}
			}
			sb.append(stack.pop());
			

			String postfix = sb.toString();
			System.out.println(postfix);
			
			
			stack.clear();
			int result = 0;
			
			for(int i=0; i<postfix.length(); i++) {
				if (postfix.charAt(i) != '+' && postfix.charAt(i) != '-' && postfix.charAt(i) != '/' && postfix.charAt(i) != '*') {
					stack.push(postfix.charAt(i));
				} else { // 연산자
					char curr = postfix.charAt(i);
					int num2 = stack.pop() - '0';
					int num1 = stack.pop() - '0';
					
					
					switch(curr) {
					case '+' :
						result = num1 + num2;
						break;
					case '-' :
						result = num1 - num2;
						break;
					case '*' :
						result = num1 * num2;
						break;
					case '/' :
						result = num1 / num2;
						break;
					}
					
					stack.push((char)(result + '0'));
				}
				
			}
			
			System.out.println("#" + testCase + " " + result);
			
			testCase++;
		}
	}
}
