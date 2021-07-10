package easy;

import java.util.Scanner;

public class LongPressedName {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String name = sc.nextLine();
		String typed = sc.nextLine();
		
		System.out.println(longpressed(name, typed));
	}
	
	public static boolean longpressed(String name, String typed) {
		int m = name.length(),n = typed.length();
		if(n<m)
			return false;
		int i = 0, j=0;
		while(i<n && j<n) {
			char namedChar = name.charAt(i);
			char typedChar = typed.charAt(j);
			if(namedChar != typedChar)
				return false;
			int namedIndex = i+1;
			int typedIndex = j+1;
			while(namedIndex < m && name.charAt(namedIndex) == namedChar) {
				namedIndex++;
			}
			while(typedIndex < n && typed.charAt(typedIndex) == typedChar) {
				typedIndex++;
			}
			if((typedIndex-j) < (namedIndex-i)) {
				return false;
			}
			
			i = namedIndex;
			j = typedIndex;
		}
		
		return (i >= m && j >= n);
	}

}
