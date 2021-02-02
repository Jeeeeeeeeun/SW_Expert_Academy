package day1;

import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		String testcase = "3\r\n" + "0011\r\n" + "100\r\n" + "100011010001";

		Scanner sc = new Scanner(testcase);
		int testCnt = sc.nextInt();

		sc.nextLine();

		for (int i = 0; i < testCnt; i++) {
			String memory = sc.nextLine();
			int cnt = 0;
			int index1 = 0;
			int index2 = 0;

			if (memory.charAt(0) == '1')
				cnt++;

			while (true) {
				if (memory.charAt(index1) == memory.charAt(index2)) {
					index2++;
				} else {
					cnt++;
					index1 = index2;
					index2 = index1 + 1;
				}

				if (index1 >= memory.length() || index2 >= memory.length())
					break;
			}

			System.out.println("#" + (i + 1) + " " + cnt);
		}

	}
}
