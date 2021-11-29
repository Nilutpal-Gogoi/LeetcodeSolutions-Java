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
		if(name.length() > typed.length()) {
			return false;
		}
		
		int i = 0;       // name string
		int j = 0;       // typed string
		
		while(i<name.length() && j<typed.length()) {
			if(name.charAt(i) == typed.charAt(j)) {
				i++;
				j++;
			} else if(0 <= i-1 && name.charAt(i-1) == typed.charAt(j)) {
				j++;
			} else {
				return false;
			}
		}

		while(j < typed.length()) {
			if(typed.charAt(j) != name.charAt(i-1)) {
				return false;
			}
            j++;
		}
		
		return i < name.length() ? false : true;
	}

}
