package day4;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_암호생성기_Answer {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/com/ssafy/day04/ws/input.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			Queue<Integer> l = new LinkedList<>();
			for (int k = 0; k < 8; k++)
				l.offer(sc.nextInt());

			int minus = 1;
			while (true) {
				int v = l.poll() - minus;
				if (v <= 0) {
					v = 0;
					l.offer(v);
					break;
				}

				l.offer(v);

				minus++;
				if (minus == 6)
					minus = 1;
			}
			System.out.println("#" + t + " " + l.toString().replaceAll("[\\[\\,\\]]", ""));
		}
	}
}
