package day0219;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1493_수의새로운연산 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src\\day0219\\SWEA1493.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int p = sc.nextInt();
			int q = sc.nextInt();

			int[] pLocation = andOp(p);
			int[] qLocation = andOp(q);
			int[] plusRes = plusOp(pLocation, qLocation);
			int answer = sharpOp(plusRes);

			System.out.println("#" + test_case + " " + answer);
		}
	}

	// #(x,y) -> x,y의 값 리턴
	private static int sharpOp(int[] plusRes) {
		int n = plusRes[0] + plusRes[1] - 2;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}

		return sum + plusRes[1];
	}

	// 더하기
	private static int[] plusOp(int[] pLocation, int[] qLocation) {
		int x = pLocation[0] + qLocation[0];
		int y = pLocation[1] + qLocation[1];

		return new int[] { x, y };
	}

	// &(1) => 1의 좌표값 리턴
	private static int[] andOp(int p) {

		int n = 1, sum = 1;
		while (p > sum) {
			sum += (++n);
		}

		int x = 1 + (sum - p);
		int y = n - (sum - p);

		return new int[] { x, y };
	}
}
