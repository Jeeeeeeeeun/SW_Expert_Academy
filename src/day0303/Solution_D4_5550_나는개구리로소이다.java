package day0303;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_D4_5550_나는개구리로소이다 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\day0303\\swea5550.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());
		String croak = "croak";

		for (int test_case = 1; test_case <= T; test_case++) {
			String sound = br.readLine();

			// c=0, r=1, o=2, a=3, k=4
			List<Integer> frogs = new ArrayList<>(); // 각 개구리의 현재까지 부른 소리 담는 배열

			// 첫번재 글자가 c가 아니면 틀림
			if (sound.charAt(0) != 'c') {
				System.out.println("#" + test_case + " -1");
				continue;
			}

			frogs.add(0); // 첫번째 개구리 add

			boolean isFailed = false;
			outer: for (int i = 1; i < sound.length(); i++) {
				char ch = sound.charAt(i); // ch = 현재 sound

				for (int j = 0; j < frogs.size(); j++) {
					// 개구리 다음글자가 ch면 그 개구리에 다음글자 저장 & outer for문으로 빠져나감
					if (croak.charAt((frogs.get(j) + 1) % 5) == ch) {
						frogs.set(j, (frogs.get(j) + 1) % 5);
						continue outer;
					}
				}

				// 현재까지 있는 개구리가 부르지 못하는 글자 = 새 개구리 추가
				if (ch == 'c') {
					frogs.add(0); // 개구리 추가
				} else {
					// 새 개구리가 부르는 글자 첫글자가 c가 아니면 fail
					isFailed = true;
					break;
				}
			}

			if (isFailed) {
				System.out.println("#" + test_case + " -1");
			} else {
				boolean check = true;

				// 모든 개구리의 숫자가 4(k)여야 성공
				for (int i = 0; i < frogs.size(); i++) {
					if (frogs.get(i) != 4) {
						check = false;
						break;
					}
				}

				// 모든 개구리 숫자가 4(k)가 아닌 경우
				if (!check) {
					System.out.println("#" + test_case + " -1");
				} else { // 모든 개구리 숫자가 4인 경우
					System.out.println("#" + test_case + " " + frogs.size()); // frogs배열 길이 출력
				}
			}
		}
	}
}
