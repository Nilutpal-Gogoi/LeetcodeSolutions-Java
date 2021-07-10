// https://leetcode.com/problems/palindromic-substrings/
package medium;

import java.util.*;

public class PalindromicSubstrings {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String str = sc.nextLine();
		System.out.print(countSubstring(str));
	}
	
	public static int countSubstring(String str) {
		int count = 0;
		int n = str.length();
		for(int i=0; i<n ;i++) {
			for(int j=i; j<n; j++) {
				if(isPalindrome(str, i, j)) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static boolean isPalindrome(String str, int i, int j) {
		while(i<j) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
