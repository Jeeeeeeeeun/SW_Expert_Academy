package day4;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225_D3_암호생성기 {
	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src\\day4\\SWEA1225.txt"));
		Scanner sc = new Scanner(System.in);

		Queue<Integer> queue = new LinkedList<>();

		while (sc.hasNextInt()) {
			int testCase = sc.nextInt();

			for (int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}

			int minus = 1;

			while (true) {
				int a = queue.poll();
				a -= minus;
				if (a <= 0) {
					queue.offer(0);
					break;
				}
				queue.offer(a);

				minus = (minus) % 5 + 1;
			}

			System.out.print("#" + testCase + " ");

			for (int i = 0; i < 8; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println("");

			queue.clear();
		}

	}
}
