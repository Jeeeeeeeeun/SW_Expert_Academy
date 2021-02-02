package day1;

import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기_Answer {
	public static void main(String[] args) {
		String testcase = "3\r\n" + "0011\r\n" + "100\r\n" + "100011010001";
		
		Scanner sc = new Scanner(testcase);
		
		int t= sc.nextInt();
		for (int i=1; i<=t; i++) {
			char c = '0';
			String d = sc.next();
			int ans=0;
			for(int k=0; k<d.length(); k++) {
				if( c!=d.charAt(k)) {
					ans++;
					c = d.charAt(k);
				}
			}
			
			System.out.println("#" + i + " " + ans);
		}
		sc.close();
	} 
}
