package day3;

import java.util.Arrays;

public class 순열조합 {
	static int[] numbers;
	static int N=4, R=3; //NCR
	
	
	public static void main(String[] args) {
		
		
		// 중복되지 않은 순열
		numbers = new int[N];		
		perm1();
		
		// 중복되지 않은 조합
		numbers = new int[R];
		comb1(0,1);
	}
	
	private static void perm1(int cnt) {
		
	}
	
	private static void comb1(int cnt, int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i=start; i<=N; i++) {
			numbers[cnt] = i;
			comb1(cnt+1, i+1);
		}
	}

}
