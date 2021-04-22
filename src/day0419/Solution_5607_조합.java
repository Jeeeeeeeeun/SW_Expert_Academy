package day0419;

import java.util.Scanner;

public class Solution_5607_조합 {
	static long P = 1234567891;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int R = sc.nextInt();

			long factorial[] = new long[N + 1];
			factorial[0] = 1;
			for (int i = 1; i <= N; i++) {
				factorial[i] = (factorial[i - 1] * i) % P;
			}

			long a = (factorial[R] * factorial[N - R]);
			long n = power(a, P - 2);

			long result = factorial[N] * n % P;

			System.out.println("#" + tc + " " + result);
		}

	}

	static long power(long x, long y) {
		long res = 1L;
		x = x % P;

		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % P;
			y = y / 2;
			x = (x * x) % P;
		}

		return res;

	}
}
